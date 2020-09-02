package com.seu.film.mapper;


import com.seu.film.pojo.Movie;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MovieMapper  {
    @Select("SELECT * FROM movie")
    List<Movie> findAllMovie();

    @Select("SELECT name FROM movie")
    List<String> findAllMovieName();

}
