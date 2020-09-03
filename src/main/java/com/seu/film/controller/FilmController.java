package com.seu.film.controller;

import com.seu.film.pojo.*;
import com.seu.film.service.Film_InfoService;
import com.seu.film.service.Film_showsService;
import com.seu.film.service.Order_evaluationService;
//import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test3")
public class FilmController {

    private static int k = 1;

    @Autowired
    Film_InfoService film_infoService;

    @Autowired
    Film_showsService film_showsService;

    @Autowired
    Order_evaluationService order_evaluationService;

    //http://localhost:8090/film/test3/findAllFilm
    //查询所有电影场次信息，返回的是film_info和film_tab表连接查询的记录
    @RequestMapping("/findAllFilm")
    @ResponseBody
    public ResultDTO<Film_info> findAllFilm() throws Exception{
        return film_infoService.findAllFilm();
    }

    //http://localhost:8090/film/test3/findFilm/fight
    //film_name关键词模糊查询电影信息，返回的是film_info和film_tab表连接查询的记录
    @RequestMapping("/findFilm/{keyWord}")
    @ResponseBody
    public ResultDTO<Film_info> findFilm(@PathVariable("keyWord")String keyWord) throws Exception{
        System.out.println(keyWord);
        return film_infoService.findFilmByKeyWord(keyWord);
    }

    //http://localhost:8090/film/test3/findAllFilm_shows
    //查询film_shows表中的所有电影排场记录
    @RequestMapping("/findAllFilm_shows")
    @ResponseBody
    public ResultDTO<Film_shows> findAllFilm_shows() throws Exception{
        return film_showsService.findAllFilm_shows();
    }

    //http://localhost:8090/film/test3/findFilm_showsById/1
    //通过电影的film_id查询表film_shows
    @RequestMapping("/findFilm_showsById/{id}")
    @ResponseBody
    public ResultDTO<Film_shows> findFilm(@PathVariable("id")int id) throws Exception{
        System.out.println(id);
        return film_showsService.findFilm_showsById(id);
    }

    //http://localhost:8090/film/test3/findAllFilm_tab
    //查询所有的电影标签,film_tab表的所有记录
    @RequestMapping("/findAllFilm_tab")
    @ResponseBody
    public ResultDTO<Film_tab> findAllFilm_tab() throws Exception{
        return film_infoService.findAllFilm_tab();
    }

    //http://localhost:8090/film/test3/findFilm_tabById/1
    //通过电影film_id查询film_tab表
    @RequestMapping("/findFilm_tabById/{id}")
    @ResponseBody
    public ResultDTO<Film_tab> findFilm_tabById(@PathVariable("id")int id) throws Exception{
        System.out.println(id);
        return film_infoService.findFilm_tabById(id);
    }


    //POST方法，对film_shows表的某条场次记录更新（如修改座位信息）
    //更新电影场次信息
    @RequestMapping("/updateFilm_shows")
    @ResponseBody
    public ResultDTO<Film_shows> updateFilm_shows(@RequestBody Film_shows film_shows)throws Exception{
        System.out.println(film_shows.toString());
        return film_showsService.updateFilm_shows(film_shows);
    }


    //http://localhost:8090/film/test3/guess_you_like/1
    //根据用户user_tab查询前K部猜你喜欢的电影，返回的是film_info和film_tab表连接查询的记录
    //向量模型
    @RequestMapping("/guess_you_like/{user_id}")
    @ResponseBody
    public ResultDTO<Film_info> guess_you_like(@PathVariable("user_id") int user_id) throws Exception{
        return film_infoService.guess_you_like(user_id, k);
    }

}
