package com.seu.film.service;

import com.seu.film.mapper.Film_InfoMapper;
import com.seu.film.mapper.User_tabMapper;
import com.seu.film.pojo.Film_info;
import com.seu.film.pojo.Film_tab;
import com.seu.film.pojo.ResultDTO;
import com.seu.film.pojo.User_tab;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service( "film_InfoService")     //绑定类TestController里面的infoService， string IOC技术
@Transactional
public class Film_InfoServiceImpl implements Film_InfoService{
    @Resource
    Film_InfoMapper film_infoMapper;

    @Resource
    User_tabMapper userTabMapper;

    @Override
    public ResultDTO<Map> findAllFilm() {
        ResultDTO<Map> resultDTO = new ResultDTO<>();
        List<Map> data = new ArrayList<>();
        data = film_infoMapper.findAllFilm();
        resultDTO.setData(data);
        resultDTO.setCode(data.size());
        resultDTO.setMsg("查询所有电影");
        return resultDTO;
    }

    @Override
    public ResultDTO<Map> findAllFilm_on_show() {
        ResultDTO<Map> resultDTO = new ResultDTO<>();
        List<Map> data = new ArrayList<>();
        data = film_infoMapper.findAllFilm_on_show();
        resultDTO.setData(data);
        resultDTO.setCode(data.size());
        resultDTO.setMsg("查询所有正在上映的电影");
        return resultDTO;
    }

    @Override
    public ResultDTO<Map> findFilmByKeyWord(String keyWord) {
        ResultDTO<Map> resultDTO = new ResultDTO<>();
        List<Map> data = new ArrayList<>();
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

    @Override
    public ResultDTO<Film_info> guess_you_like(int user_id, int k) {
        User_tab user_tab = userTabMapper.findUser_tab(user_id).get(0);
        User_tab normalized_user_tab = normalize_user_tab(user_tab);
        List<Film_tab> tabs = film_infoMapper.findAllFilm_tab();
        /*
        System.out.println("--------------------------------------------");
        System.out.println(tabs.size());
        System.out.println(normalized_user_tab.toString());
        System.out.println("--------------------------------------------");
        */
        List<Double> values = new ArrayList<>();
        List<Integer> selected = new ArrayList<>(k);
        for(int i = 0; i < tabs.size(); i++){
            values.add(calCos(normalized_user_tab, tabs.get(i)));
        }
        double minV = Collections.min(values);
        for(int i = 0; i < k; i++){
            double maxV = Collections.max(values);
            int index = values.indexOf(maxV);
            selected.add(tabs.get(index).getFilm_id());
            values.set(index, minV);
        }
        //用id查找电影信息
        ResultDTO<Film_info> resultDTO = new ResultDTO<>();
        List<Film_info> data = new ArrayList<>();
        for(int i = 0; i < k; i++) {
          data.add(film_infoMapper.findFilmByFilm_Id(selected.get(i)));
        }
        resultDTO.setData(data);
        resultDTO.setCode(data.size());
        resultDTO.setMsg("返回猜你喜欢的电影");
        return resultDTO;
    }

    private User_tab normalize_user_tab(User_tab user_tab){
        PriorityQueue<Integer> list = new PriorityQueue<Integer>(10);
        list.add(user_tab.getMagic());
        list.add(user_tab.getPlot());
        list.add(user_tab.getScience_fiction());
        list.add(user_tab.getRomance());
        list.add(user_tab.getHistory());
        list.add(user_tab.getComedy());
        list.add(user_tab.getAction());
        list.add(user_tab.getHorror());
        list.add(user_tab.getAnimation());
        list.add(user_tab.getWar());

        int kTop = list.poll();
        for(int i = 0;i < 2; i++){
             kTop =  list.poll();
        }
        User_tab new_user_tab = user_tab;
        if(user_tab.getMagic() < kTop || user_tab.getMagic() <= 0)new_user_tab.setMagic(0);
        else new_user_tab.setMagic(1);

        if(user_tab.getPlot() < kTop || user_tab.getPlot() <= 0)new_user_tab.setPlot(0);
        else new_user_tab.setPlot(1);

        if(user_tab.getScience_fiction() < kTop || user_tab.getScience_fiction() <= 0)new_user_tab.setScience_fiction(0);
        else new_user_tab.setScience_fiction(1);

        if(user_tab.getRomance() < kTop || user_tab.getRomance() <= 0)new_user_tab.setRomance(0);
        else new_user_tab.setRomance(1);

        if(user_tab.getHistory() < kTop || user_tab.getHistory() <= 0)new_user_tab.setHistory(0);
        else new_user_tab.setHistory(1);

        if(user_tab.getComedy() < kTop || user_tab.getComedy() <= 0)new_user_tab.setComedy(0);
        else new_user_tab.setComedy(1);

        if(user_tab.getAction() < kTop || user_tab.getAction() <= 0)new_user_tab.setAction(0);
        else new_user_tab.setAction(1);

        if(user_tab.getHorror() < kTop || user_tab.getHorror() <= 0)new_user_tab.setHorror(0);
        else new_user_tab.setHorror(1);

        if(user_tab.getAnimation() < kTop || user_tab.getAnimation() <= 0)new_user_tab.setAnimation(0);
        else new_user_tab.setAnimation(1);

        if(user_tab.getWar() < kTop || user_tab.getWar() <= 0)new_user_tab.setWar(0);
        else new_user_tab.setWar(1);

        return new_user_tab;

    }

    private double calCos(User_tab user_tab, Film_tab film_tab){
        int sum = 0;
        int normal1 = 0;  //film_tab
        int normal2 = 0;  //user_tab
        if(film_tab.isMagic()){normal1++;sum+=user_tab.getMagic();}
        if(film_tab.isPlot()){normal1++;sum+=user_tab.getPlot();}
        if(film_tab.isScience_fiction()){normal1++;sum+=user_tab.getScience_fiction();}
        if(film_tab.isRomance()){normal1++;sum+=user_tab.getRomance();}
        if(film_tab.isHistory()){normal1++;sum+=user_tab.getHistory();}
        if(film_tab.isComedy()){normal1++;sum+=user_tab.getComedy();}
        if(film_tab.isAction()){normal1++;sum+=user_tab.getAction();}
        if(film_tab.isHorror()){normal1++;sum+=user_tab.getHorror();}
        if(film_tab.isAnimation()){normal1++;sum+=user_tab.getAnimation();}
        if(film_tab.isWar()){normal1++;sum+=user_tab.getWar();}
        normal2+=user_tab.getMagic();
        normal2+=user_tab.getPlot();
        normal2+=user_tab.getScience_fiction();
        normal2+=user_tab.getRomance();
        normal2+=user_tab.getHistory();
        normal2+=user_tab.getComedy();
        normal2+=user_tab.getAction();
        normal2+=user_tab.getHorror();
        normal2+=user_tab.getAnimation();
        normal2+=user_tab.getWar();
        return ((double)sum)/ Math.sqrt(normal1)*Math.sqrt(normal2);
    }
}
