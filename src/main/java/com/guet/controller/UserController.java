package com.guet.controller;

import com.github.pagehelper.PageInfo;
import com.guet.domain.Department;
import com.guet.domain.UserInfo;
import com.guet.service.IDepartmentService;
import com.guet.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;


/**
 * @author MicahYin
 * @date 2019/10/17 21:26
 * 用于处理用户管理页面的Controller
 */
@Controller
@RequestMapping("/account")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "4") Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<UserInfo> accounts = userService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(accounts);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/add.do")
    public ModelAndView add() throws Exception{
        ModelAndView mv = new ModelAndView();
       List<Department> departmentList=departmentService.findAll();
       mv.addObject("departmentList",departmentList);
        mv.setViewName("user-add");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(UserInfo user) throws Exception{
        userService.save(user);
        return "redirect:findAll.do";
    }
}
