package com.seu.film.mapper;

import com.seu.film.pojo.Film_shows;
import com.seu.film.pojo.Order;

import java.util.Date;
import java.util.List;

public interface OrderMapper {
    //查询一个用户的所有订单
    List<Order> findOrderByUser_id(int user_id);

    //查询一个电影场次的所有订单
    List<Order> findOrderByFilm_shows(Film_shows film_shows);

    //根据订单id查询
    List<Order> findOrderByOrder_id(int order_id);

    int deleteOrder(int order_id);
}
