package com.guet.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.guet.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guet.dao.IEventDao;
import com.guet.domain.Event;
import com.guet.service.EventService;

@Service
public class EventServiceImpl implements EventService {
    
	@Autowired
	IEventDao eventDao;

	//查询用户发布的已处理的信息
	@Override
	public Page getProcessedEventByUsername(String userName,int currentPage) {

		//分页查询
		userName = "UserA2";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setCurrentTotal(5);
		page.setIndex1((currentPage-1)*5);
		page.setUserName(userName);
		List<Event> events = new ArrayList<Event>();
		events = eventDao.getProcessedEventByUsername(page);
		int totalCount = eventDao.getProcessPagesNumByUsername(userName);
		int numCount = events.size();
		page.setNumCount(numCount);
		page.setTotalCount(totalCount);
		if(totalCount%5==0) {
		page.setTotalPage(totalCount/5);
		}else {
			page.setTotalPage(totalCount/5+1);
		}
		page.setProcessedEvents(events);
		//System.out.println(page);
		return page;
	}

	//用户发布的未处理的信息
	@Override
	public Page getNotProcessedEventByUsername(String userName,int currentPage) {
		//分页查询
		userName = "UserA2";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setCurrentTotal(5);
		page.setIndex1((currentPage-1)*5);
		page.setUserName(userName);
		List<Event> events = new ArrayList<Event>();
		events = eventDao.getNotProcessedEventByUsername(page);
		int totalCount = eventDao.getNotProcessPagesNumByUsername(userName);
		int numCount = events.size();
		page.setNumCount(numCount);
		page.setTotalCount(totalCount);
		if(totalCount%5==0) {
			page.setTotalPage(totalCount/5);
		}else {
			page.setTotalPage(totalCount/5+1);
		}
		page.setProcessedEvents(events);
		System.out.println(page);
		return page;
	}

	//用户接受上级的需要处理的信息，已处理
	@Override
	public Page getHaveProcessedEventByUsername(String userName,int currentPage) {

		//分页查询
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setCurrentTotal(5);
		page.setIndex1((currentPage-1)*5);
		page.setUserName(userName);
		List<Event> events = new ArrayList<Event>();
		int totalCount;
		//讨论如果是角色B只需要选择handler是自己的，如果是角色C还需要选择forwardReceiver是自己的,D只需选择第三方属于自己的
		if(userName.contains("B")) {
			events = eventDao.getHaveProcessedEventByUsername(page);
			totalCount = eventDao.getHaveProcessPagesNumByUsername(userName);
		}else {
			events = eventDao.getHaveProcessedEventByUsername1(page);
			totalCount = eventDao.getHaveProcessPagesNumByUsername1(userName);
		}
		int numCount = events.size();
		page.setNumCount(numCount);
		page.setTotalCount(totalCount);
		if(totalCount%5==0) {
			page.setTotalPage(totalCount/5);
		}else {
			page.setTotalPage(totalCount/5+1);
		}
		page.setProcessedEvents(events);
		System.out.println(page);
		return page;
	}

	//用户接受上级的需要处理的信息，未处理
	@Override
	public Page getHaveNotProcessedEventByUsername(String userName,int currentPage) {
		//分页查询
		//userName = "UserB2";
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setCurrentTotal(5);
		page.setIndex1((currentPage-1)*5);
		page.setUserName(userName);
		List<Event> events = new ArrayList<Event>();
		int totalCount;
		//讨论如果是角色B只需要选择handler是自己的，如果是角色C还需要选择forwardReceiver是自己的,D只要选择第三方是自己的
		if(userName.contains("B")) {
			 events = eventDao.getHaveNotProcessedEventByUsername(page);
			 totalCount = eventDao.getHaveNotProcessPagesNumByUsername(userName);
		} else {
			events = eventDao.getHaveNotProcessedEventByUsername1(page);
			totalCount = eventDao.getHaveNotProcessPagesNumByUsername1(userName);
		}
		int numCount = events.size();
		page.setNumCount(numCount);
		page.setTotalCount(totalCount);
		if(totalCount%5==0) {
			page.setTotalPage(totalCount/5);
		}else {
			page.setTotalPage(totalCount/5+1);
		}
		page.setProcessedEvents(events);
		System.out.println(events);
		//System.out.println(page);
		return page;
	}

	@Override
	public boolean publishEvent(Event event) {
		
		boolean bool = false;
		System.out.println(allFieldIsNULL(event));
		if(allFieldIsNULL(event)) {
		int success = eventDao.insertEvent(event);
		System.out.println(success);
		    if(success==1) {
		    	return bool=true;
		    } else {
		    	return bool;
		    }
		} else {
		  return bool;
		}
		
	}

	@Override
	public void deleteEvent(int eventID) {
		eventDao.deleteEvent(eventID);
		
	}
	
	//检测某个对象是否所有字段都赋值了
	public boolean allFieldIsNULL(Object o){
		
			//System.out.println(o);
			Event event = (Event) o;
			String eventContent = event.getEventContent();
			String eventLevel = event.getEventLevel();
			String startDate = event.getStartDate();
			String endDate = event.getEndDate();
			Integer status = event.getStatus();
			String publisher = event.getPublisher();
			String deadline = event.getDeadline();
			//String progress = event.getProgress();
			String handler = event.getHandler();
			String type = event.getEventtype();
			if(eventContent==null||eventLevel==null||startDate==null||endDate==null||status==null||publisher==null||deadline==null||handler==null||
					type==null) {
				return false;
			}
		
		return true;
	}

	//跳转页面时获取事件的信息
	public Event forwardPage(int eventID) {

		Event event = eventDao.getEventByID(eventID);
		return  event;
	}

	//转发给辖区内受监管的单位处理
	public void updateEventByForward(Event event) {

		//根据事件ID获取事件的信息
        int evnetID = event.getEventID();
		Event dbEvent = eventDao.getEventByID(evnetID);
		//更新事件的信息

        String forwarder = dbEvent.getHandler();
        String forwarderReceiver = event.getForwarderReceiver();
       // System.out.println(evnetID+forwarder+forwarderReceiver);
        eventDao.updateEventByForward(evnetID,forwarder,forwarderReceiver);

	}

	//通过转发更新事件的信息
	public void updateEventByInvitation (Event event) {

		//获取事件的信息
		int evnetID = event.getEventID();
		//Event dbEvent = eventDao.getEventByID(evnetID);
		//更新事件的信息
		String thirdparty = event.getThirdparty();
		// System.out.println(evnetID+forwarder+forwarderReceiver);
		eventDao.updateEventByInvitation(evnetID,thirdparty);
	}

	//获取事件详情
	public Event getDetailEvent(int eventID) {

		Event dbEvent = eventDao.getEventByID(eventID);
		return  dbEvent;
	}

	//提交结果
	public void submitResult(Event event) {

		int eventID = event.getEventID();
		Event dbEvetn = eventDao.getEventByID(eventID);
		System.out.println(event);
		String userName = dbEvetn.getPublisher();
		//System.out.println();
		//对于用户D
		if(userName.contains("D")) {
		eventDao.updateResultD(event);
		} else if(userName.contains("C")){
			//对于用户C
			eventDao.updateResultC(event);
		} else if(userName.contains("B")) {
			//对于用户B
			eventDao.updateResultB(event);
		} else if(userName.contains("A")) {
			//对于用户A
			eventDao.updateResultA(event);
		} else {
			System.out.println("用户名错误");
		}

	}


}
