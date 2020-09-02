package com.seu.film.service;

import com.seu.film.pojo.Film_shows;
import com.seu.film.pojo.ResultDTO;

public interface Film_showsService {
    ResultDTO<Film_shows> findAllFilm_shows();
    ResultDTO<Film_shows> findFilm_showsById(int id);
}
