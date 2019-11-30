package com.guet.service;

import java.util.List;

import com.guet.domain.Page;
import org.springframework.stereotype.Service;

import com.guet.domain.Event;


public interface EventService {
	
	//根据用户的名称获取用户发布的已处理的事件
	public Page getProcessedEventByUsername(String userName, int currentPage);
	
	//根据用户的名称获取用户发布的已处理的事件
	public Page getNotProcessedEventByUsername(String userName, int currentPage);

	//根据用户的名称获取用户需要处理的已处理的事件
	public Page getHaveProcessedEventByUsername(String userName, int currentPage) throws Exception;

	//根据用户的名称获取用户需要处理的未处理的事件
	public Page getHaveNotProcessedEventByUsername(String userName, int currentPage) throws Exception;
	
	//用户发布事件
	public boolean publishEvent(Event event);
	
	//删除事件
	public void deleteEvent(int eventID);

	//跳转转发页面是获取事件信息
	public Event forwardPage(int eventID);

	//通过邀请的方式更新事件
	public void updateEventByInvitation(Event event) ;

	//通过转发的方式更新事件
	public void updateEventByForward(Event event);

	//获取事件详情
	public Event getDetailEvent(int eventID);

	//提交结果
	public void submitResult(Event event);

	public String getRoleNameByUserName(String userName);
}
