package com.guet.controller;

import com.guet.service.IDataDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

/**
 * 用于数据展示
 * @author MicahYin
 * @date 2019/11/29 17:01
 */
@Controller
@RequestMapping("/dataDisplay")
public class DataDisplay {

    @Autowired
    private IDataDisplayService dataDisplayService;
    @RequestMapping("/show.do")
    @RolesAllowed({"A","B"})
    public ModelAndView show() throws Exception{
        ModelAndView mv =new ModelAndView();
        int zero=dataDisplayService.findDataStatusZero();
        int one=dataDisplayService.findDataStatusOne();
        mv.addObject("zero",zero);
        mv.addObject("one",one);
        mv.setViewName("data-show");
        return mv;
    }
}
