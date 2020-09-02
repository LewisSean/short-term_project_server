package com.seu.film.controller;

import com.seu.film.pojo.Info;
import com.seu.film.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    InfoService infoService;       //Autowired自动装载：单个实例，多个访问，节省资源

  //http://localhost:8090/film/test/toIndex
    @RequestMapping("/toIndex")
    public String toIndex() throws Exception{
        System.out.println("Noob java execute toIndex!");
        return "index";                                    //跳转到index页面
    }

    //http://localhost:8090/film/test/testMav
    @RequestMapping("/testMav")
    public ModelAndView testMav(ModelAndView mav) throws Exception{
        //请求域中的值    mav可以携带返回值
        mav.addObject( "name","Liu");
        mav.setViewName("index");
        return mav;
    }


    //http://localhost:8090/film/test/findAll
    @RequestMapping("/findAll")
    @ResponseBody                 //！！！ 将返回的java对象写入http当中
    public List<Info> findAll() throws Exception{
        return infoService.findAllInfo();
    }
}
