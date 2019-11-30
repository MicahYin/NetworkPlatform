package com.guet.controller;

import com.guet.domain.Page;
import com.guet.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/update")
public class updatePageControl {

    @Autowired
    EventService eventService;
    //获取用户发布的已处理的事件信息
    @RequestMapping("/updateProcessedList.do")
    public String getProcessedEventByUserName(Model model) {
        //获取用户名
        int currentPage = 1;
        SecurityContext context= SecurityContextHolder.getContext();//从上下文中获取了当前登录的用户
        User user= (User) context.getAuthentication().getPrincipal();
        String userName=user.getUsername();

        Page page = new Page();
        //List<Event> notProcessEvnets = new ArrayList<Event>();

        page = eventService.getProcessedEventByUsername(userName,currentPage);
        //notProcessEvnets = eventService.getNotProcessedEventByUsername(userName);
        //System.out.println(page);
        model.addAttribute("page",page);
        return "processevent-list";

    }

    //获取用户发布的未处理的信息
    @RequestMapping("/updateNotProcessedList.do")
    public String getNotProcessedEventByUserName(Model model) {
        //获取用户名
        int currentPage = 1;
        SecurityContext context = SecurityContextHolder.getContext();//从上下文中获取了当前登录的用户
        User user = (User) context.getAuthentication().getPrincipal();
        String userName = user.getUsername();

        Page page = new Page();
        //List<Event> processedEvents = new ArrayList<Event>();
        //List<Event> notProcessEvnets = new ArrayList<Event>();

        //processedEvents = eventService.getProcessedEventByUsername(userName);
        page = eventService.getNotProcessedEventByUsername(userName,currentPage);
        model.addAttribute("page",page);
        return "notprocessevent-list";
    }

    //获取用户需要处理但是已处理的事件信息
    @RequestMapping("/updateHaveProcessedList.do")
    public String getHaveProcessedEventByUserName(Model model) throws Exception {
        //获取用户名
        int currentPage = 1;
        SecurityContext context= SecurityContextHolder.getContext();//从上下文中获取了当前登录的用户
        User user= (User) context.getAuthentication().getPrincipal();
        String userName=user.getUsername();

        Page page = new Page();
        //List<Event> notProcessEvnets = new ArrayList<Event>();

        page = eventService.getHaveProcessedEventByUsername(userName,currentPage);
        //notProcessEvnets = eventService.getNotProcessedEventByUsername(userName);
        //System.out.println(page);
        model.addAttribute("page",page);
        return "haveprocessevent-list";

    }

    //获取用户需要处理但是未处理的事件信息
    @RequestMapping("/updateHaveNotProcessedList.do")
    public String getHaveNotProcessedEventByUserName(Model model) throws Exception {
        //获取用户名
        int currentPage = 1;
        SecurityContext context = SecurityContextHolder.getContext();//从上下文中获取了当前登录的用户
        User user = (User) context.getAuthentication().getPrincipal();
        String userName = user.getUsername();

        Page page = new Page();
        //List<Event> processedEvents = new ArrayList<Event>();
        //List<Event> notProcessEvnets = new ArrayList<Event>();

        //processedEvents = eventService.getProcessedEventByUsername(userName);
        page = eventService.getHaveNotProcessedEventByUsername(userName,currentPage);
        model.addAttribute("page",page);
        return "havenotprocessevent-list";
    }
}
