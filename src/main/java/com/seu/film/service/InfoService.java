package com.seu.film.service;

import com.seu.film.pojo.Info;

import java.util.List;

public interface InfoService {    //业务逻辑，在Mapper层（sql操作）之上
    List<Info> findAllInfo();
}
