package com.guet.dao;

import java.util.List;

import com.guet.domain.Event;
import com.guet.domain.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventDao {
	
	//根据用户名查询用户发布的已处理的信息的事件信息
	public List<Event> getProcessedEventByUsername(Page page);
	
	//根据用户名查询用户发布的未处理的信息的事件信息
	public List<Event> getNotProcessedEventByUsername(Page page);

	//根据用户名查询用户需要处理的已处理的信息的事件信息（对于角色B）
	public List<Event> getHaveProcessedEventByUsername(Page page);

	//根据用户名查询用户需要处理的未处理的信息的事件信息（对于角色B）
	public List<Event> getHaveNotProcessedEventByUsername(Page page);

	//根据用户名查询用户需要处理的已处理的信息的事件信息（对于角色C、D）
	public List<Event> getHaveProcessedEventByUsername1(Page page);

	//根据用户名查询用户需要处理的未处理的信息的事件信息（对于角色C、D）
	public List<Event> getHaveNotProcessedEventByUsername1(Page page);
	
	//用户发布事件
	public int insertEvent(Event event);
	
	//删除事件
	public void deleteEvent(int eventID);

	//获取某个用户发布的已处理的事件的数量
	public int getProcessPagesNumByUsername(String userName);

	//获取某个用户发布的未处理的事件的数量
	public int getNotProcessPagesNumByUsername(String userName);

	//获取某个用户需要处理的已处理的事件的数量（对于角色B）
	public int getHaveProcessPagesNumByUsername(String userName);

	//获取某个用户需要处理的未处理的事件的数量（对于角色B）
	public int getHaveNotProcessPagesNumByUsername(String userName);

	//获取某个用户需要处理的已处理的事件的数量（对于角色B）
	public int getHaveProcessPagesNumByUsername1(String userName);

	//获取某个用户需要处理的未处理的事件的数量（对于角色B）
	public int getHaveNotProcessPagesNumByUsername1(String userName);

	//根据事件ID获取事件信息
	public Event getEventByID(int eventID);

	//根据转发更新事件信息
	public void updateEventByForward(@Param("eventID") int eventID, @Param("forwarder") String forward,
									 @Param("forwarderReceiver") String forwarderReceiver,@Param("departmentC") String departmentC);

	//根据邀请更新事件信息
	public void updateEventByInvitation(@Param("eventID") int eventID, @Param("thirdparty") String thirdparty,
										@Param("departmentD") String departmentD);

	//提交事件结果D
	public void updateResultD(Event event);
	//提交事件结果C
	public void updateResultC(Event event);
	//提交事件结果B
	public void updateResultB(Event event);
	//提交事件结果A
	public void updateResultA(Event event);

	public String getRoleNameByUserName(String userName);
}
