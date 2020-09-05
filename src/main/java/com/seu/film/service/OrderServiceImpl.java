package com.seu.film.service;

import com.seu.film.mapper.Film_showsMapper;
import com.seu.film.mapper.OrderMapper;
import com.seu.film.mapper.UserMapper;
import com.seu.film.pojo.Film_shows;
import com.seu.film.pojo.Order;
import com.seu.film.pojo.ResultDTO;
import com.seu.film.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

import com.seu.film.tool.MyTool;

@Service( "orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
    @Resource
    OrderMapper orderMapper;
    @Resource
    Film_showsMapper film_showsMapper;
    @Resource
    UserMapper userMapper;



    @Override
    public ResultDTO<Map> findOrderByUser_id(int user_id) {
        ResultDTO<Map> resultDTO = new ResultDTO<>();
        List<Map> data = new ArrayList<>();
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


    @Override
    public ResultDTO<Order> deleteOrder(int order_id) {
        ResultDTO<Order> resultDTO = new ResultDTO<>();
        try{
            //保存将要删除的订单信息
            Order order2del= orderMapper.findOrderByOrder_id(order_id).get(0);
            //删除订单
            int i = orderMapper.deleteOrder(order_id);
            if(i > 0){
                resultDTO.setMsg("退款成功!");
                resultDTO.setCode(i);
                //查询并修改对应的电影场次的座位信息
                Film_shows film_shows = new Film_shows();
                film_shows.setStart_time(order2del.getStart_time());
                film_shows.setHall_id(order2del.getHall_id());
                film_shows = film_showsMapper.find_one_Film_shows(film_shows);
                String new_reserve_info = MyTool.deleteReserve(film_shows.getReserve_info(), order2del.getSeats());
                film_shows.setReserve_info(new_reserve_info);
                film_showsMapper.updateFilm_shows(film_shows);
                //修改用户的余额
                User user = new User();
                user.setUser_id(order2del.getUser_id());
                user = userMapper.findUserInfo(user).get(0);
                user.setBalance(user.getBalance()+order2del.getCost());
                userMapper.modifyUserBalance(user);

            }else{
                resultDTO.setMsg("退款失败!");
            }

        }catch(Exception e){
            resultDTO.setMsg("fail!");
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<Order> addOrder(Order order) {
        ResultDTO<Order> resultDTO = new ResultDTO<>();
        order.setOrder_id(MyTool.getOrderId());
        try{
            User user = new User();
            user.setUser_id(order.getUser_id());
            //获取用户余额，余额不足则无法购票并退出
            user = userMapper.findUserInfo(user).get(0);
            if(user.getBalance() < order.getCost()){
                resultDTO.setMsg("余额不足!");
                resultDTO.setCode(0);
                return resultDTO;
            }
            int i = orderMapper.addOrder(order);
            if(i > 0){
                resultDTO.setMsg("订票成功!");
                resultDTO.setCode(i);
                //修改对应的电影场次的座位信息
                Film_shows film_shows = new Film_shows();
                film_shows.setStart_time(order.getStart_time());
                film_shows.setHall_id(order.getHall_id());
                film_shows = film_showsMapper.find_one_Film_shows(film_shows);
                String new_reserve_info = MyTool.addReserve(film_shows.getReserve_info(), order.getSeats());
                film_shows.setReserve_info(new_reserve_info);
                film_showsMapper.updateFilm_shows(film_shows);
                //修改用户余额
                user.setBalance(user.getBalance()-order.getCost());
                userMapper.modifyUserBalance(user);


            }else{
                resultDTO.setMsg("购票失败!");
                resultDTO.setCode(0);
            }

        }catch(Exception e){
            resultDTO.setMsg("fail!");
        }
        return resultDTO;
    }
}
