package com.seu.film.service;

import com.seu.film.mapper.MovieMapper;
import com.seu.film.pojo.Movie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service( "movieService")     //绑定类TestController里面的infoService， string IOC技术
@Transactional
public class MovieServiceImpl implements MovieService{
    @Resource
    MovieMapper movieMapper;
    //ctrl i

    @Override
    public List<Movie> findAllMovie() {
        return movieMapper.findAllMovie();
    }

    @Override
    public List<String> findAllMovieName() {
        return movieMapper.findAllMovieName();
    }
}
