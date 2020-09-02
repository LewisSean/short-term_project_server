package com.seu.film.mapper;

import com.seu.film.pojo.Film_info;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Film_InfoMapper {
    @Select("SELECT * FROM film_info INNER JOIN film_tab  ON film_info.film_id = film_tab.film_id")
    List<Film_info> findAllFilm();
    @Select("SELECT * FROM film_info,film_tab WHERE film_info.film_id = film_tab.film_id and film_name LIKE '%${value}%'")
    List<Film_info> findFilmByKeyWord(String keyWord);

}
