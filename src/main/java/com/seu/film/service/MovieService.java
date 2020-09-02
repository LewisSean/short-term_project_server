package com.seu.film.service;

import com.seu.film.pojo.Info;
import com.seu.film.pojo.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAllMovie();
    List<String> findAllMovieName();
}
