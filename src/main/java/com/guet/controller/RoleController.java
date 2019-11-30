package com.guet.controller;

import com.github.pagehelper.PageInfo;
import com.guet.domain.Department;
import com.guet.domain.Role;
import com.guet.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/27 16:20
 */
@Controller
@RequestMapping("/role")
@RolesAllowed("A")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "4") Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Role> roleList=roleService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(roleList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role-list");
        return mv;
    }
}
