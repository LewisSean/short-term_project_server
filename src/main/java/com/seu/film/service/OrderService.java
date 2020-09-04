package com.seu.film.service;

import com.seu.film.pojo.Film_shows;
import com.seu.film.pojo.Order;
import com.seu.film.pojo.ResultDTO;

public interface OrderService {
    //查询一个用户的所有订单
    ResultDTO<Order> findOrderByUser_id(int user_id);

    //查询一个电影场次的所有订单
    ResultDTO<Order> findOrderByFilm_shows(Film_shows film_shows);

    //根据订单id查询
    ResultDTO<Order> findOrderByOrder_id(int order_id);

    ResultDTO<Order> deleteOrder(int order_id);
}
