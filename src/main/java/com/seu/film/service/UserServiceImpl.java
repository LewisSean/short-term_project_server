package com.seu.film.service;

import com.seu.film.mapper.UserMapper;
import com.seu.film.pojo.ResultDTO;
import com.seu.film.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("userService")
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
        resultDTO.setCode(data.size());
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
                resultDTO.setCode(i);
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
        ResultDTO<User> resultDTO = new ResultDTO<>();
        try{
            int i = userMapper.modifyUserInfo(user);
            if(i > 0){
                resultDTO.setMsg("userinfo update success!");
                resultDTO.setCode(i);
            }else{
                resultDTO.setMsg("userinfo update fail!");
            }

        }catch(Exception e){
            resultDTO.setMsg("fail!");
        }
        //如果希望注册成功立即登录，可能需要查询一次，那么可以直接在该业务中查询用户
        return resultDTO;
    }

    @Override
    public ResultDTO<User> login(User user) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        List<User> data = new ArrayList<>();
        data = userMapper.login(user);
        resultDTO.setData(data);
        resultDTO.setCode(data.size());
        if(resultDTO.getCode()!=0) {
            resultDTO.setMsg("success");
        }
        else{
            resultDTO.setMsg("fail");
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<User> modifyUserBalance(User user) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        try{
            int i = userMapper.modifyUserBalance(user);
            if(i > 0){
                resultDTO.setMsg("userinfo update success!");
            }else{
                resultDTO.setMsg("userinfo update fail!");
            }

        }catch(Exception e){
            resultDTO.setMsg("fail!");
        }
        //如果希望注册成功立即登录，可能需要查询一次，那么可以直接在该业务中查询用户
        return resultDTO;
    }
}
