package com.seu.film.mapper;

import com.seu.film.pojo.User_tab;

import java.util.List;

public interface User_tabMapper {
    //查询用户标签
    List<User_tab> findUser_tab(int user_id);

    //修改用户标签
    int modifyUser_tab(User_tab user_tab);
}
