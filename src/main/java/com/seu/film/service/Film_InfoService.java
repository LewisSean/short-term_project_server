package com.seu.film.service;

import com.seu.film.pojo.Film_info;
import com.seu.film.pojo.Film_tab;
import com.seu.film.pojo.ResultDTO;
import com.seu.film.pojo.User_tab;

import java.util.Map;

public interface Film_InfoService {
    ResultDTO<Map> findAllFilm();
    ResultDTO<Map> findAllFilm_on_show();
    ResultDTO<Map> findFilmByKeyWord(String keyWord);
    ResultDTO<Film_tab> findFilm_tabById(int id);
    ResultDTO<Film_tab> findAllFilm_tab();
    ResultDTO<Film_info> guess_you_like(int user_id, int k);
}
