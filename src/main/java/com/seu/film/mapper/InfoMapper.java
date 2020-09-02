package com.seu.film.mapper;
import com.seu.film.pojo.Info;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InfoMapper {
    @Select("SELECT * FROM info_test")
    List<Info> findAllInfo();
}
