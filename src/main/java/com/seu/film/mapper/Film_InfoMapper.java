package com.seu.film.mapper;

import com.seu.film.pojo.Film_info;
import com.seu.film.pojo.Film_tab;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Film_InfoMapper {
    @Select("SELECT * FROM film_info INNER JOIN film_tab  ON film_info.film_id = film_tab.film_id")
    List<Film_info> findAllFilm();

    @Select("SELECT * FROM film_info INNER JOIN film_tab  ON film_info.film_id = film_tab.film_id WHERE film_info.state=1")
    List<Film_info> findAllFilm_on_show();

    @Select("SELECT * FROM film_info,film_tab WHERE film_info.film_id = film_tab.film_id and film_name LIKE '%${value}%'")
    List<Film_info> findFilmByKeyWord(String keyWord);
    @Select("SELECT * FROM film_tab WHERE film_id = #{value}")
    List<Film_tab> findFilm_tabById(int id);
    @Select("SELECT * FROM film_tab")
    List<Film_tab> findAllFilm_tab();

    @Select("SELECT * FROM film_info WHERE film_id = #{value}")
    Film_info findFilmByFilm_Id(int film_id);

}
