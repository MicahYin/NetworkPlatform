package com.guet.controller;

import com.guet.domain.Page;
import com.guet.service.IDepartmentService;
import com.guet.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guet.service.EventService;
import com.guet.domain.Event;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	EventService eventService;
    @Autowired
	IUserService userService;
    @Autowired
	IDepartmentService departmentService;
	
	//获取用户发布的已处理的事件信息
	@RequestMapping("/eventProcessedList.do")
	@RolesAllowed({"A","B"})
	public String getProcessedEventByUserName(Model model,int currentPage) throws Exception {
		//获取用户名
		if(currentPage==0) {
			currentPage = 1;
		}
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
	@RolesAllowed({"A","B"})
	public String getNotProcessedEventByUserName(Model model,int currentPage) throws Exception {
		//获取用户名
		if(currentPage==0) {
			currentPage = 1;
		}
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
	@RolesAllowed({"A","B","C","D"})
	public String getHaveProcessedEventByUserName(Model model,int currentPage) throws Exception {
		//获取用户名
		if(currentPage==0) {
			currentPage = 1;
		}
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
	@RolesAllowed({"A","B","C","D"})
	public String getHaveNotProcessedEventByUserName(Model model,int currentPage) throws Exception {
		//获取用户名
		if(currentPage==0) {
			currentPage = 1;
		}
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
	@RolesAllowed({"A","B"})
	public String publishEvent(Model model,Event event) throws Exception {
		//获取用户名

		 SecurityContext context= SecurityContextHolder.getContext();//从上下文中获取了当前登录的用户
		 User user= (User) context.getAuthentication().getPrincipal(); String
		 userName=user.getUsername();
		 String roleName = eventService.getRoleNameByUserName(userName);
		 boolean success;
		 if(roleName.contains("A")) {
		event.setPublisher(event.getPublisher());
		event.setDeadline(event.getDeadline());
		event.setEndDate("0");
		event.setEventContent(event.getEventContent());
		event.setEventLevel(event.getEventLevel());
		event.setHandler(event.getHandler());
		//event.setProgress(event.getHandler()+"正在处理");
		event.setStartDate(event.getStartDate());
	    event.setStatus(0);
	    event.setEventtype(event.getEventtype());
	    event.setProgress("未处理");
	    //event.setEventID(0);
	    System.out.println(event);
	    success = eventService.publishEvent(event);
		 } else {
			 event.setPublisher(event.getPublisher());
			 event.setDeadline(event.getDeadline());
			 event.setEndDate("0");
			 event.setEventContent(event.getEventContent());
			 event.setEventLevel(event.getEventLevel());
			 event.setHandler(event.getHandler());
			 //event.setProgress(event.getHandler()+"正在处理");
			 event.setStartDate(event.getStartDate());
			 event.setStatus(0);
			 event.setProgress("未处理");
			 event.setEventtype(event.getEventtype());
			 event.setForwarder(event.getPublisher());
			 event.setForwarderReceiver(event.getHandler());
			 //event.setEventID(0);
			 System.out.println(event);
			 success = eventService.publishEvent(event);
		 }
        //System.out.println("已发布");
		if(success) {
        return "redirect:/event/eventNotProcessedList.do?currentPage=1";
		} else {
			return "error";
		}
		
	}

	
	//删除事件
	@RequestMapping("/eventDelete.do")
	@RolesAllowed({"A","B"})
	public String deleteEvent(Model model) {
		
		int eventID = 2;
		eventService.deleteEvent(eventID);
		return "test";

	}

	//点击转发或者邀请第三方时调整转发事件的页面
	@RequestMapping("/forwardPage.do")
	@RolesAllowed({"A","B","C","D"})
	public String forwardPage(Model model,int eventID) throws Exception {
		SecurityContext context= SecurityContextHolder.getContext();//从上下文中获取了当前登录的用户
		User user= (User) context.getAuthentication().getPrincipal();
		String userName=user.getUsername();
		Event event = eventService.forwardPage(eventID);
		List<String> users = userService.getAllUser(userName);
		List<String> departNames = departmentService.getAllName(userName);
		String departName = departmentService.getDepartNameByUsername(userName);
		model.addAttribute("departName",departName);
		model.addAttribute("userName",userName);
		model.addAttribute("users",users);
		model.addAttribute("departNames",departNames);
		model.addAttribute("event",event);
		return "event_forward";
	}

	//转发接到的上级事件
	@RequestMapping("/forward.do")
	@RolesAllowed({"A","B","C","D"})
	public String forwardEvent(Model model,Event event) {
         //System.out.println(event);
		eventService.updateEventByForward(event);
		return "redirect:/event/eventHaveNotProcessedList.do?currentPage=1";
	}


	//邀请第三方机构协助处理
	@RequestMapping("/invitation.do")
	@RolesAllowed({"A","B","C","D"})
	public String invitationThirdParty(Model model,Event event) {

		//System.out.println(eventID);
		eventService.updateEventByInvitation(event);
		return "redirect:/event/eventHaveNotProcessedList.do?currentPage=1";
	}

	@RequestMapping("/detail.do")
	@RolesAllowed({"A","B","C","D"})
	public String eventDetail(Model model,int eventID) {
         SecurityContext context= SecurityContextHolder.getContext();//从上下文中获取了当前登录的用户
		 User user= (User) context.getAuthentication().getPrincipal();
		 String userName=user.getUsername();
		 Event dbEvent = eventService.getDetailEvent(eventID);
		 String userId = dbEvent.getPublisher();
		 if(!userId.equals(userName)) {
		 eventService.updataProgress(eventID); }
		 //System.out.println(userName);
		//System.out.println(dbEvent);
		String roleName = eventService.getRoleNameByUserName(userName);
		 dbEvent.setRoleName(roleName);
		//System.out.println(dbEvent);
		model.addAttribute("event",dbEvent);
		return "detail";
	}

	@RequestMapping("/submit.do")
	@RolesAllowed({"A","B","C","D"})
	public String submitPage(Model model,Event event) {
		SecurityContext context= SecurityContextHolder.getContext();//从上下文中获取了当前登录的用户
		User user= (User) context.getAuthentication().getPrincipal();
		String userName=user.getUsername();
		eventService.submitResult(event);
		//System.out.println(event);
		Event dbevent = eventService.getDetailEvent(event.getEventID());
		if(userName.equals(dbevent.getPublisher())) {
			return "redirect:/event/eventProcessedList.do?currentPage=1";
		}
		return "redirect:/event/eventHaveProcessedList.do?currentPage=1";
	}

	@RequestMapping("eventAdd.do")
	@RolesAllowed({"A","B"})
	public String submitPage(Model model) throws Exception {
		SecurityContext context= SecurityContextHolder.getContext();//从上下文中获取了当前登录的用户
		User user= (User) context.getAuthentication().getPrincipal();
		String userName=user.getUsername();
        List<String> users = userService.getAllUser(userName);
        List<String> departNames = departmentService.getAllName(userName);
        String roleName = eventService.getRoleNameByUserName(userName);
		String departName = departmentService.getDepartNameByUsername(userName);
		model.addAttribute("departName",departName);
		model.addAttribute("userName",userName);
        model.addAttribute("roleName",roleName);
        model.addAttribute("users",users);
        model.addAttribute("departNames",departNames);
       // System.out.println(users);
        //System.out.println(departNames);


		return "event_add";
	}
	

}
