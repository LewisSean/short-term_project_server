package com.seu.film.service;

import com.seu.film.mapper.InfoMapper;
import com.seu.film.pojo.Info;
import com.seu.film.pojo.ResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service( "infoService")     //绑定类TestController里面的infoService， string IOC技术
@Transactional
public class InfoServiceImpl implements InfoService {    //类实现接口InfoService
    @Resource
    InfoMapper infoMapper;
    //ctrl i

    @Override
    public List<Info> findAllInfo() {
        return infoMapper.findAllInfo();
    }

    @Override
    public ResultDTO<Info> findInfoByKeyWord(String keyWord) {
        ResultDTO<Info> resultDTO = new ResultDTO<>();
        List<Info> data = new ArrayList<>();
        data = infoMapper.findInfoByKeyWord(keyWord);
        resultDTO.setData(data);
        resultDTO.setCode(7);
        resultDTO.setMsg("关键字查询");
        return resultDTO;
    }

    @Override
    public ResultDTO<Info> findAllInfo2() {
        ResultDTO<Info> resultDTO = new ResultDTO<>();
        List<Info> data = new ArrayList<>();
        data = infoMapper.findAllInfo();
        resultDTO.setData(data);
        resultDTO.setCode(6);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<Info> findInfoByInfo(Info info) {
        ResultDTO<Info> resultDTO = new ResultDTO<>();
        List<Info> data = new ArrayList<>();
        data = infoMapper.findInfoByInfo(info);
        resultDTO.setData(data);
        resultDTO.setCode(5);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<Info> addInfo(Info info){
        ResultDTO<Info> resultDTO = new ResultDTO<>();
        try{
            int i = infoMapper.addInfo(info);
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

}