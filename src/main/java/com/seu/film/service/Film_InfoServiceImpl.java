package com.seu.film.service;

import com.seu.film.mapper.Film_InfoMapper;
import com.seu.film.pojo.Film_info;
import com.seu.film.pojo.Film_tab;
import com.seu.film.pojo.ResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service( "film_InfoService")     //绑定类TestController里面的infoService， string IOC技术
@Transactional
public class Film_InfoServiceImpl implements Film_InfoService{
    @Resource
    Film_InfoMapper film_infoMapper;

    @Override
    public ResultDTO<Film_info> findAllFilm() {
        ResultDTO<Film_info> resultDTO = new ResultDTO<>();
        List<Film_info> data = new ArrayList<>();
        data = film_infoMapper.findAllFilm();
        resultDTO.setData(data);
        resultDTO.setCode(data.size());
        resultDTO.setMsg("查询所有电影");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film_info> findFilmByKeyWord(String keyWord) {
        ResultDTO<Film_info> resultDTO = new ResultDTO<>();
        List<Film_info> data = new ArrayList<>();
        data = film_infoMapper.findFilmByKeyWord(keyWord);
        resultDTO.setData(data);
        resultDTO.setCode(data.size());
        resultDTO.setMsg("关键字查询电影");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film_tab> findFilm_tabById(int id) {
        ResultDTO<Film_tab> resultDTO = new ResultDTO<>();
        List<Film_tab> data = new ArrayList<>();
        data = film_infoMapper.findFilm_tabById(id);
        resultDTO.setData(data);
        resultDTO.setCode(data.size());
        resultDTO.setMsg("id查询电影标签");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film_tab> findAllFilm_tab() {
        ResultDTO<Film_tab> resultDTO = new ResultDTO<>();
        List<Film_tab> data = new ArrayList<>();
        data = film_infoMapper.findAllFilm_tab();
        resultDTO.setData(data);
        resultDTO.setCode(data.size());
        resultDTO.setMsg("查询所有电影标签");
        return resultDTO;
    }
}
