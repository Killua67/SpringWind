package com.baomidou.springwind.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.baomidou.springwind.entity.Permission;
import com.baomidou.springwind.entity.vo.MenuVO;

/**
 *
 * Permission 表数据库控制层接口
 *
 */
public interface PermissionMapper extends AutoMapper<Permission> {

	List<MenuVO> selectMenuByUserId(@Param("userId") Long userId, @Param("pid") Long pid);

}