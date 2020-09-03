package com.seu.film.mapper;

import com.seu.film.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询用户信息
    List<User> findUserInfo(User user);

    //DML insert update delete
    //添加用户信息
    int addUserInfo(User user);

    //修改用户信息（余额/头像）
    int modifyUserInfo(User user);

    //登录
    List<User> login(User user);
}
