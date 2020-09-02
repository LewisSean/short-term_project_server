package com.seu.film.mapper;

import com.seu.film.pojo.Info;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Film_InfoMapper {
    @Select("SELECT * FROM film_info")
    List<Info> findAllFilm();
    @Select("SELECT * FROM film_info WHERE name LIKE '%${value}%'")
    List<Info> findFilmByKeyWord(String keyWord);
}
