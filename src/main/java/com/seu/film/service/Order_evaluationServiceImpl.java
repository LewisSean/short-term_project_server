package com.seu.film.service;

import com.seu.film.mapper.Order_evaluationMapper;
import com.seu.film.pojo.Order_evaluation;
import com.seu.film.pojo.ResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service( "order_evaluationService")
@Transactional
public class Order_evaluationServiceImpl implements  Order_evaluationService{
    @Resource
    Order_evaluationMapper order_evaluationMapper;

    @Override
    public ResultDTO<Order_evaluation> addEvaluation(Order_evaluation order_evaluation) {
        ResultDTO<Order_evaluation> resultDTO = new ResultDTO<>();
        try{
            int i = order_evaluationMapper.addEvaluation(order_evaluation);
            if(i > 0){
                resultDTO.setMsg("添加评价成功!");
            }else{
                resultDTO.setMsg("添加评论失败!");
            }

        }catch(Exception e){
            resultDTO.setMsg("fail!");
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<Order_evaluation> findOrder_evaluationByFilm_id(int film_id) {
        return null;
    }
}

