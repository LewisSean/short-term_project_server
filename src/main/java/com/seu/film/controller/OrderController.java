package com.seu.film.controller;

import com.seu.film.pojo.Film_shows;
import com.seu.film.pojo.Order;
import com.seu.film.pojo.ResultDTO;
import com.seu.film.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test2")
public class OrderController {
    @Autowired
    OrderService orderService;

    //http://localhost:8090/film/test2/findOrderByUser_id/1
    @RequestMapping("/findOrderByUser_id/{user_id}")
    @ResponseBody
    public ResultDTO<Order> findOrderByUser_id(@PathVariable("user_id")int user_id) throws Exception{
        System.out.println(user_id);
        return orderService.findOrderByUser_id(user_id);
    }

    //http://localhost:8090/film/test2/findOrderByFilm_shows
    @RequestMapping("/findOrderByFilm_shows")
    @ResponseBody
    public ResultDTO<Order> updateFilm_shows(@RequestBody Film_shows film_shows)throws Exception{
        System.out.println(film_shows.toString());
        return orderService.findOrderByFilm_shows(film_shows);
    }

    //http://localhost:8090/film/test2/findOrderByOrder_id/2
    @RequestMapping("/findOrderByOrder_id/{order_id}")
    @ResponseBody
    public ResultDTO<Order> findOrderByOrder_id(@PathVariable("order_id")int order_id) throws Exception{
        System.out.println(order_id);
        return orderService.findOrderByOrder_id(order_id);
    }
}
