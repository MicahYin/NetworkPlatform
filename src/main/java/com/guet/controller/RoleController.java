package com.guet.controller;

import com.guet.domain.Department;
import com.guet.domain.Role;
import com.guet.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author MicahYin
 * @date 2019/11/27 16:20
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("findAll.do")
    public String findAll(Model model) throws Exception{
        List<Role> roleList=roleService.findAll();
        model.addAttribute("roleList",roleList);
        return "role-list";
    }
}
