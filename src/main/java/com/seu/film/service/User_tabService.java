package com.seu.film.service;

import com.seu.film.pojo.ResultDTO;
import com.seu.film.pojo.User_tab;

public interface User_tabService {
    ResultDTO<User_tab> findUser_tab(User_tab user_tab);
    ResultDTO<User_tab> modifyUser_tab(User_tab user_tab);
}
