package com.seu.film.controller;

import com.seu.film.pojo.*;
import com.seu.film.service.Film_InfoService;
import com.seu.film.service.Film_showsService;
import com.seu.film.service.Order_evaluationService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test3")
public class FilmController {
    @Autowired
    Film_InfoService film_infoService;

    @Autowired
    Film_showsService film_showsService;

    @Autowired
    Order_evaluationService order_evaluationService;

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

    //http://localhost:8090/film/test3/findAllFilm_tab
    @RequestMapping("/findAllFilm_tab")
    @ResponseBody
    public ResultDTO<Film_tab> findAllFilm_tab() throws Exception{
        return film_infoService.findAllFilm_tab();
    }

    //http://localhost:8090/film/test3/findFilm_tabById/1
    @RequestMapping("/findFilm_tabById/{id}")
    @ResponseBody
    public ResultDTO<Film_tab> findFilm_tabById(@PathVariable("id")int id) throws Exception{
        System.out.println(id);
        return film_infoService.findFilm_tabById(id);
    }


    @RequestMapping("/updateFilm_shows")
    @ResponseBody
    public ResultDTO<Film_shows> updateFilm_shows(@RequestBody Film_shows film_shows)throws Exception{
        System.out.println(film_shows.toString());
        return film_showsService.updateFilm_shows(film_shows);
    }


    @RequestMapping("/addEvaluation")
    @ResponseBody
    public ResultDTO<Order_evaluation> addEvaluation(@RequestBody Order_evaluation order_evaluation)throws Exception{
        System.out.println(order_evaluation.toString());
        return order_evaluationService.addEvaluation(order_evaluation);
    }

}
