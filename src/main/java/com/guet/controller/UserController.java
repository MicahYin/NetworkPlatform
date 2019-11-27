package com.guet.controller;

import com.guet.domain.UserInfo;
import com.guet.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("/findAll.do")
    public String findAll(Model model) throws Exception{
        List<UserInfo> accounts = userService.findAll();
        model.addAttribute("userList",accounts);
        return "user-list";
    }
}
