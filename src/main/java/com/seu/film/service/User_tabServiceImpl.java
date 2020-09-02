package com.seu.film.service;

import com.seu.film.mapper.User_tabMapper;
import com.seu.film.pojo.ResultDTO;
import com.seu.film.pojo.User_tab;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("User_tabService")
@Transactional
public class User_tabServiceImpl implements User_tabService{
    @Resource
    User_tabMapper user_tabMapper;

    @Override
    public ResultDTO<User_tab> findUser_tab(User_tab user_tab) {
        ResultDTO<User_tab> resultDTO = new ResultDTO<>();
        List<User_tab> data = new ArrayList<>();
        data = user_tabMapper.findUser_tab(user_tab);
        resultDTO.setData(data);
        resultDTO.setCode(5);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<User_tab> modifyUser_tab(User_tab user_tab) {
        return null;
    }

}
