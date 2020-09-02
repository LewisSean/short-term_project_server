package com.seu.film.service;

import com.seu.film.pojo.ResultDTO;
import com.seu.film.pojo.User;

public interface UserService {
    ResultDTO<User> findUserInfo(User user);
    ResultDTO<User> addUserInfo(User user);
    ResultDTO<User> modifyUserInfo(User user);
}
