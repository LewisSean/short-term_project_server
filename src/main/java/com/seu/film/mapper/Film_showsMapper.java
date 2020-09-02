package com.seu.film.mapper;

import com.seu.film.pojo.Film_shows;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Film_showsMapper {
    @Select("SELECT * FROM film_shows")
    List<Film_shows> findAllFilm_shows();
    @Select("SELECT * FROM film_shows WHERE film_id = #{value}")
    List<Film_shows> findFilm_showsById(int id);
}
