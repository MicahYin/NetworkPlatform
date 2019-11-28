package com.guet.controller;

import com.github.pagehelper.PageInfo;
import com.guet.dao.IRoleDao;
import com.guet.domain.Department;
import com.guet.domain.Role;
import com.guet.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/27 14:38
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "4") Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Department> departments=departmentService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(departments);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("department-list");
        return mv;
    }
}
