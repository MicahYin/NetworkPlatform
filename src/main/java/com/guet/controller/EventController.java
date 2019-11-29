package com.guet.controller;

import com.guet.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guet.service.EventService;
import com.guet.domain.Event;

@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	EventService eventService;
	
	//获取用户发布的已处理的事件信息
	@RequestMapping("/eventProcessedList.do")
	public String getProcessedEventByUserName(Model model,int currentPage) {
		//获取用户名
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
	@RequestMapping("/eventNotProcessedList.do")
	public String getNotProcessedEventByUserName(Model model,int currentPage) {
		//获取用户名
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
	@RequestMapping("/eventHaveProcessedList.do")
	public String getHaveProcessedEventByUserName(Model model,int currentPage) {
		//获取用户名
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
	@RequestMapping("/eventHaveNotProcessedList.do")
	public String getHaveNotProcessedEventByUserName(Model model,int currentPage) {
		//获取用户名
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
	
	//发布事件
	@RequestMapping("/eventPublish.do")
	public String publishEvent(Model model,Event event) {
		//获取用户名
		/*
		 * SecurityContext context= SecurityContextHolder.getContext();//从上下文中获取了当前登录的用户
		 * User user= (User) context.getAuthentication().getPrincipal(); String
		 * userName=user.getUsername();
		 */
		event.setPublisher(event.getPublisher());
		event.setDeadline(event.getDeadline());
		event.setEndDate("0");
		event.setEventContent(event.getEventContent());
		event.setEventLevel(event.getEventLevel());
		event.setHandler(event.getHandler());
		//event.setProgress(event.getHandler()+"正在处理");
		event.setStartDate(event.getStartDate());
	    event.setStatus(0);
	    event.setDepartmentA("桂林市公安局");
		event.setDepartmentB("七星区公安局");
		event.setDepartmentC("桂林电子科技大学");
		event.setDepartmentD("桂林电子科技有限公司");
	    event.setEventtype(event.getEventtype());
	    //event.setEventID(0);
	    System.out.println(event);
	    boolean success = eventService.publishEvent(event);
        //System.out.println("已发布");
		if(success) {
        return "success";
		} else {
			return "error";
		}
		
	}

	
	//删除事件
	@RequestMapping("/eventDelete.do")
	public String deleteEvent(Model model) {
		
		int eventID = 2;
		eventService.deleteEvent(eventID);
		return "test";

	}

	//点击转发或者邀请第三方时调整转发事件的页面
	@RequestMapping("/forwardPage.do")
	public String forwardPage(Model model,int eventID) {

		Event event = eventService.forwardPage(eventID);
		model.addAttribute("event",event);
		return "event_forward";
	}

	//转发接到的上级事件
	@RequestMapping("/forward.do")
	public String forwardEvent(Model model,Event event) {
         //System.out.println(event);
		eventService.updateEventByForward(event);
		return "success";
	}


	//邀请第三方机构协助处理
	@RequestMapping("/invitation.do")
	public String invitationThirdParty(Model model,Event event) {

		//System.out.println(eventID);
		eventService.updateEventByInvitation(event);
		return "success";
	}

	@RequestMapping("/detail.do")
	public String eventDetail(Model model,int eventID) {
         SecurityContext context= SecurityContextHolder.getContext();//从上下文中获取了当前登录的用户
		 User user= (User) context.getAuthentication().getPrincipal();
		 String userName=user.getUsername();
		 Event dbEvent = eventService.getDetailEvent(eventID);
		 //System.out.println(userName);
		//System.out.println(dbEvent);
		dbEvent.setUserName(userName="UserA2");
		System.out.println(dbEvent);
		model.addAttribute("event",dbEvent);
		return "detail";
	}

	@RequestMapping("/submit.do")
	public String submitPage(Model model,Event event) {
		eventService.submitResult(event);
		//System.out.println(event);
		return "success";
	}
	

}
