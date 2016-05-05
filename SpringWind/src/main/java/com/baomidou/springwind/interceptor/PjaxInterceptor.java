package com.baomidou.springwind.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PjaxInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PjaxInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
    	System.err.println(request.getHeader("X-PJAX"));
        LOGGER.debug(String.format("interceptor: uri=%s", request.getRequestURI()));
        if (request.getHeader("X-PJAX") == null && request.getParameter("pjax") == null) {
            LOGGER.debug(String.format("interceptor: redirect=%s", request.getContextPath()));
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}