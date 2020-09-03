package com.seu.film.service;

import com.seu.film.mapper.OrderMapper;
import com.seu.film.pojo.Film_shows;
import com.seu.film.pojo.Order;
import com.seu.film.pojo.ResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service( "orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
    @Resource
    OrderMapper orderMapper;

    @Override
    public ResultDTO<Order> findOrderByUser_id(int user_id) {
        ResultDTO<Order> resultDTO = new ResultDTO<>();
        List<Order> data = new ArrayList<>();
        data = orderMapper.findOrderByUser_id(user_id);
        resultDTO.setData(data);
        resultDTO.setCode(data.size());
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<Order> findOrderByFilm_shows(Film_shows film_shows) {
        ResultDTO<Order> resultDTO = new ResultDTO<>();
        List<Order> data = new ArrayList<>();
        data = orderMapper.findOrderByFilm_shows(film_shows);
        resultDTO.setData(data);
        resultDTO.setCode(data.size());
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<Order> findOrderByOrder_id(int order_id) {
        ResultDTO<Order> resultDTO = new ResultDTO<>();
        List<Order> data = new ArrayList<>();
        data = orderMapper.findOrderByOrder_id(order_id);
        resultDTO.setData(data);
        resultDTO.setCode(data.size());
        resultDTO.setMsg("success");
        return resultDTO;
    }
}
