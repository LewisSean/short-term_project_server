package com.seu.film.mapper;
import com.seu.film.pojo.Info;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InfoMapper {
    @Select("SELECT * FROM info_test")
    List<Info> findAllInfo();
    @Select("select * from info_test where name like '%${value}%'")
    List<Info> findInfoByKeyWord(String keyWord);

    //根据Info查询信息
    List<Info> findInfoByInfo(Info info);
}
