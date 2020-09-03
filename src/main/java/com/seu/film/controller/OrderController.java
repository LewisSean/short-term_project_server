package com.seu.film.controller;

import com.seu.film.pojo.*;
import com.seu.film.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("test2")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    Order_evaluationService order_evaluationService;

    @Autowired
    User_tabService user_tabService;

    @Autowired
    Film_InfoService film_infoService;

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


    //添加订单评论，添加评论会更改用户的个人标签！！！！！
    @RequestMapping("/addEvaluation")
    @ResponseBody
    public ResultDTO<Order_evaluation> addEvaluation(@RequestBody Order_evaluation order_evaluation)throws Exception{


        System.out.println(order_evaluation.toString());
        ResultDTO<Order_evaluation> retVal = order_evaluationService.addEvaluation(order_evaluation);

        //更改用户的个人标签
        if(retVal.getMsg() == "添加评价成功!" && order_evaluation.getRank() != 3) {
            List<Order> data = this.findOrderByOrder_id(order_evaluation.getOrder_id()).getData();
            ResultDTO<User_tab> res1 = user_tabService.findUser_tab(data.get(0).getUser_id());
            User_tab user_tab = res1.getData().get(0);
            int film_id = data.get(0).getFilm_id();
            ResultDTO<Film_tab> res2 = film_infoService.findFilm_tabById(film_id);
            Film_tab film_tab = res2.getData().get(0);
            int flag = 1;
            if (order_evaluation.getRank() <= 2) {
                flag = -1;
            }
            if(film_tab.isMagic())user_tab.setMagic(user_tab.getMagic() + flag);
            if(film_tab.isPlot())user_tab.setPlot(user_tab.getPlot() + flag);
            if(film_tab.isScience_fiction())user_tab.setScience_fiction(user_tab.getScience_fiction() + flag);
            if(film_tab.isRomance())user_tab.setRomance(user_tab.getRomance() + flag);
            if(film_tab.isHistory())user_tab.setHistory(user_tab.getHistory() + flag);
            if(film_tab.isComedy())user_tab.setComedy(user_tab.getComedy() + flag);
            if(film_tab.isAction())user_tab.setAction(user_tab.getAction() + flag);
            if(film_tab.isHorror())user_tab.setHorror(user_tab.getHorror() + flag);
            if(film_tab.isAnimation())user_tab.setAnimation(user_tab.getAnimation() + flag);
            if(film_tab.isWar())user_tab.setWar(user_tab.getWar() + flag);
            System.out.println("------------------------------------------------------"+user_tab.toString());
            ResultDTO<User_tab> res = user_tabService.modifyUser_tab(user_tab);
            System.out.println(res.toString());
            System.out.println("------------------------------------------------------");
        }

        return retVal;
    }

    //http://localhost:8090/film/test2/findOrder_evaluationByFilm_id/1
    //通过film_id查询一部电影的所有影评(包括用户的user_name，rank，mark)
    @RequestMapping("/findOrder_evaluationByFilm_id/{film_id}")
    @ResponseBody
    public ResultDTO<Map> findOrder_evaluationByFilm_id(@PathVariable("film_id")int film_id) throws Exception{
        return order_evaluationService.findOrder_evaluationByFilm_id(film_id);
    }




}
