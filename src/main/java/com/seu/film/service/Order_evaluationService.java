package com.seu.film.service;

import com.seu.film.pojo.Comment;
import com.seu.film.pojo.Order_evaluation;
import com.seu.film.pojo.ResultDTO;

import java.util.List;
import java.util.Map;

public interface Order_evaluationService {
    ResultDTO<Order_evaluation> addEvaluation(Order_evaluation order_evaluation);
    ResultDTO<Map> findOrder_evaluationByFilm_id(int film_id);
    ResultDTO<Map> findOrder_evaluationByUser_id(int user_id);
}
