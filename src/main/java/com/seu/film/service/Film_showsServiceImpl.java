package com.seu.film.service;

import com.seu.film.mapper.Film_showsMapper;
import com.seu.film.pojo.Film_shows;
import com.seu.film.pojo.ResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
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
        resultDTO.setCode(data.size());
        resultDTO.setMsg("查询所有电影场次");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film_shows> findFilm_showsById(int id) {
        ResultDTO<Film_shows> resultDTO = new ResultDTO<>();
        List<Film_shows> data = new ArrayList<>();
        data = film_showsMapper.findFilm_showsById(id);
        resultDTO.setData(data);
        resultDTO.setCode(data.size());
        resultDTO.setMsg("查询指定id的电影场次");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film_shows> updateFilm_shows(Film_shows film_shows) {
        ResultDTO<Film_shows> resultDTO = new ResultDTO<>();
        try{
            int i = film_showsMapper.updateFilm_shows(film_shows);
            if(i > 0){
                resultDTO.setMsg("修改场次信息成功!");
            }else{
                resultDTO.setMsg("修改场次失败!");
            }

        }catch(Exception e){
            resultDTO.setMsg("fail!");
        }
        //如果希望注册成功立即登录，可能需要查询一次，那么可以直接在该业务中查询用户
        return resultDTO;
    }
}
