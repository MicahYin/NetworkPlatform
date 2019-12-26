package com.guet.controller;

import com.guet.service.IDataDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

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
        SecurityContext context= SecurityContextHolder.getContext();//从上下文中获取了当前登录的用户
        User user= (User) context.getAuthentication().getPrincipal();
        String userName=user.getUsername();
        int zero=dataDisplayService.findDataStatusZero(userName);
        int one=dataDisplayService.findDataStatusOne(userName);
        int two = dataDisplayService.findDataTwo(userName);
        int three = dataDisplayService.findDataThree(userName);
        mv.addObject("zero",zero);
        mv.addObject    ("one",one);
        mv.addObject("two",two);
        mv.addObject("three",three);
        mv.setViewName("data-show");
        return mv;
    }
}
