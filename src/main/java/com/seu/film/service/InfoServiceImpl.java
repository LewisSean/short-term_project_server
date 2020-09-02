package com.seu.film.service;

import com.seu.film.mapper.InfoMapper;
import com.seu.film.pojo.Info;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

}