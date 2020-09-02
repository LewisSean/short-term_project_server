package com.seu.film.controller;

import com.seu.film.pojo.Film_info;
import com.seu.film.pojo.Film_shows;
import com.seu.film.pojo.Info;
import com.seu.film.pojo.ResultDTO;
import com.seu.film.service.Film_InfoService;
import com.seu.film.service.Film_showsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test3")
public class FlimController {
    @Autowired
    Film_InfoService film_infoService;

    @Autowired
    Film_showsService film_showsService;

    //http://localhost:8090/film/test3/findAllFilm
    @RequestMapping("/findAllFilm")
    @ResponseBody                 //！！！ 将返回的java对象写入http当中
    public ResultDTO<Film_info> findAllFilm() throws Exception{
        return film_infoService.findAllFilm();
    }

    //http://localhost:8090/film/test3/findFilm/fight
    //使用地址栏传递参数
    @RequestMapping("/findFilm/{keyWord}")
    @ResponseBody
    public ResultDTO<Film_info> findFilm(@PathVariable("keyWord")String keyWord) throws Exception{
        System.out.println(keyWord);
        return film_infoService.findFilmByKeyWord(keyWord);
    }

    //http://localhost:8090/film/test3/findAllFilm_shows
    @RequestMapping("/findAllFilm_shows")
    @ResponseBody                 //！！！ 将返回的java对象写入http当中
    public ResultDTO<Film_shows> findAllFilm_shows() throws Exception{
        return film_showsService.findAllFilm_shows();
    }

    //http://localhost:8090/film/test3/findFilm_showsById/1
    //使用地址栏传递参数
    @RequestMapping("/findFilm_showsById/{id}")
    @ResponseBody
    public ResultDTO<Film_shows> findFilm(@PathVariable("id")int id) throws Exception{
        System.out.println(id);
        return film_showsService.findFilm_showsById(id);
    }
}
