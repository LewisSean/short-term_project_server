package com.seu.film.service;

import com.seu.film.mapper.Film_showsMapper;
import com.seu.film.pojo.Film_shows;
import com.seu.film.pojo.ResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service( "film_showsService")
@Transactional
public class Film_showsServiceImpl implements  Film_showsService{
    @Resource
    Film_showsMapper film_showsMapper;


    @Override
    public ResultDTO<Film_shows> findAllFilm_shows() {
        ResultDTO<Film_shows> resultDTO = new ResultDTO<>();
        List<Film_shows> data = new ArrayList<>();
        data = film_showsMapper.findAllFilm_shows();
        resultDTO.setData(data);
        resultDTO.setCode(0);
        resultDTO.setMsg("查询所有电影场次");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film_shows> findFilm_showsById(int id) {
        ResultDTO<Film_shows> resultDTO = new ResultDTO<>();
        List<Film_shows> data = new ArrayList<>();
        data = film_showsMapper.findFilm_showsById(id);
        resultDTO.setData(data);
        resultDTO.setCode(0);
        resultDTO.setMsg("查询指定id的电影场次");
        return resultDTO;
    }
}
