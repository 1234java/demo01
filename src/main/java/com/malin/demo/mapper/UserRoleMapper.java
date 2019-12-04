package com.malin.demo.mapper;

import com.malin.demo.model.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}