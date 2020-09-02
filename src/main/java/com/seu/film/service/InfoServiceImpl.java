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
    public ResultDTO<Info> findAllInfo2() {
        ResultDTO<Info> resultDTO = new ResultDTO<>();
        List<Info> data = new ArrayList<>();
        data = infoMapper.findAllInfo();
        resultDTO.setData(data);
        resultDTO.setCode(6);
        resultDTO.setMsg("success");
        return resultDTO;
    }

}