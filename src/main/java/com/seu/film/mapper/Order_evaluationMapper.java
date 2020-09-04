package com.seu.film.mapper;

import com.seu.film.pojo.Comment;
import com.seu.film.pojo.Order_evaluation;
import com.seu.film.pojo.ResultDTO;

import java.util.List;
import java.util.Map;


public interface Order_evaluationMapper {
    int addEvaluation(Order_evaluation order_evaluation);

    List<Map> findOrder_evaluationByFilm_id(int film_id);
    List<Map> findOrder_evaluationByUser_id(int user_id);
}
