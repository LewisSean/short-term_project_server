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


    @Override
    public ResultDTO<Order> deleteOrder(int order_id) {
        ResultDTO<Order> resultDTO = new ResultDTO<>();
        try{
            Order order2del= orderMapper.findOrderByOrder_id(order_id).get(0);
            int i = orderMapper.deleteOrder(order_id);
            if(i > 0){
                resultDTO.setMsg("退款成功!");
                resultDTO.setCode(i);
                //退款成功，需要删除film_shows对应的场次信息

                //先查到对应的电影场次信息
                Film_shows film_shows = new Film_shows();
                film_shows.setStart_time(order2del.getStart_time());
                film_shows.setHall_id(order2del.getHall_id());
                film_shows = film_showsMapper.find_one_Film_shows(film_shows);

                System.out.println("----------------------------\n"+film_shows.toString());

                String new_reserve_info = MyTool.deleteReserve(film_shows.getReserve_info(), order2del.getSeats());
                film_shows.setReserve_info(new_reserve_info);
                System.out.println("----------------------------\n"+"new_reserve_info:" + new_reserve_info);
                System.out.println("----------------------------\n"+"new_reserve_info:" + film_shows.getReserve_info());
                film_showsMapper.updateFilm_shows(film_shows);

                //退款成功，需要修改用户余额
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
}
