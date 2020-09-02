package com.seu.film.service;

import com.seu.film.pojo.Film_shows;
import com.seu.film.pojo.ResultDTO;

import java.util.Date;

public interface Film_showsService {
    ResultDTO<Film_shows> findAllFilm_shows();
    ResultDTO<Film_shows> findFilm_showsById(int id);
    ResultDTO<Film_shows> updateFilm_shows(Film_shows film_shows);
}
