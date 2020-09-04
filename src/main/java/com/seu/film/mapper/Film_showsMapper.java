package com.seu.film.mapper;

import com.seu.film.pojo.Film_shows;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface Film_showsMapper {
    @Select("SELECT * FROM film_shows")
    List<Film_shows> findAllFilm_shows();
    @Select("SELECT * FROM film_shows WHERE film_id = #{value}")
    List<Film_shows> findFilm_showsById(int id);


    Film_shows find_one_Film_shows(Film_shows target);

    int updateFilm_shows(Film_shows film_shows);

}
