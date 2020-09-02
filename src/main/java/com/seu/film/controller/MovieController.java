package com.seu.film.controller;



import com.seu.film.pojo.Movie;
import com.seu.film.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("test2")
public class MovieController {
    @Autowired
    MovieService movieService;



    //http://localhost:8090/film/test2/findAllMovie
    @RequestMapping("/findAllMovie")
    @ResponseBody                 //！！！ 将返回的java对象写入http当中
    public List<Movie> findAllMovie() throws Exception{
        return movieService.findAllMovie();
    }

    //http://localhost:8090/film/test2/findAllMovieName
    @RequestMapping("/findAllMovieName")
    @ResponseBody                 //！！！ 将返回的java对象写入http当中
    public List<String> findAllMovieName() throws Exception{
        return movieService.findAllMovieName();
    }

}
