package com.seu.film.service;

import com.seu.film.pojo.Order_evaluation;
import com.seu.film.pojo.ResultDTO;

public interface Order_evaluationService {
    ResultDTO<Order_evaluation> addEvaluation(Order_evaluation order_evaluation);
}
