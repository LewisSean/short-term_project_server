package com.seu.film.service;

import com.seu.film.pojo.Film_info;
import com.seu.film.pojo.ResultDTO;

public interface Film_InfoService {
    ResultDTO<Film_info> findAllFilm();
    ResultDTO<Film_info> findFilmByKeyWord(String keyWord);
}
