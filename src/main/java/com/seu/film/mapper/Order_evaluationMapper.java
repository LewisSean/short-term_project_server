package com.seu.film.mapper;

import com.seu.film.pojo.Order_evaluation;

public interface Order_evaluationMapper {
    int addEvaluation(Order_evaluation order_evaluation);

    int findOrder_evaluationByFilm_id(int film_id);
}
