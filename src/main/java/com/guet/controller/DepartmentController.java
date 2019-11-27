package com.guet.controller;

import com.guet.dao.IRoleDao;
import com.guet.domain.Department;
import com.guet.domain.Role;
import com.guet.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("findAll.do")
    public String findAll(Model model) throws Exception{
        List<Department> departments=departmentService.findAll();
        model.addAttribute("departments",departments);
        return "department-list";
    }
}
