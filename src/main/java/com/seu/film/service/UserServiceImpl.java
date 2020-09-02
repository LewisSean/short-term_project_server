package com.seu.film.service;

import com.seu.film.mapper.UserMapper;
import com.seu.film.pojo.ResultDTO;
import com.seu.film.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService{
    @Resource
    UserMapper userMapper;

    @Override
    public ResultDTO<User> findUserInfo(User user) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        List<User> data = new ArrayList<>();
        data = userMapper.findUserInfo(user);
        resultDTO.setData(data);
        resultDTO.setCode(5);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<User> addUserInfo(User user) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        try{
            int i = userMapper.addUserInfo(user);
            if(i > 0){
                resultDTO.setMsg("sign up success!");
            }else{
                resultDTO.setMsg("fail!");
            }

        }catch(Exception e){
            resultDTO.setMsg("fail!");
        }
        //如果希望注册成功立即登录，可能需要查询一次，那么可以直接在该业务中查询用户
        return resultDTO;
    }

    @Override
    public ResultDTO<User> modifyUserInfo(User user) {
        return null;
    }
}
