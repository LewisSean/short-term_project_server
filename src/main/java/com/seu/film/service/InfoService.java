package com.seu.film.service;

import com.seu.film.pojo.Info;
import com.seu.film.pojo.ResultDTO;

import java.util.List;

public interface InfoService {    //业务逻辑，在Mapper层（sql操作）之上
    List<Info> findAllInfo();
    ResultDTO<Info> findInfoByKeyWord(String keyWord);
    ResultDTO<Info> findAllInfo2();
    ResultDTO<Info> findInfoByInfo(Info info);
    ResultDTO<Info> addInfo(Info info);
}
