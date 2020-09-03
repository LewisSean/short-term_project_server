package com.seu.film.service;

import com.seu.film.pojo.Film_info;
import com.seu.film.pojo.Film_tab;
import com.seu.film.pojo.ResultDTO;
import com.seu.film.pojo.User_tab;

public interface Film_InfoService {
    ResultDTO<Film_info> findAllFilm();
    ResultDTO<Film_info> findFilmByKeyWord(String keyWord);
    ResultDTO<Film_tab> findFilm_tabById(int id);
    ResultDTO<Film_tab> findAllFilm_tab();
    ResultDTO<Film_info> guess_you_like(int user_id, int k);
}
