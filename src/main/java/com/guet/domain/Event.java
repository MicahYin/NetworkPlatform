package com.guet.domain;

public class Event {

	private int eventID;
	private String eventContent;
	private String eventLevel;
	private String startDate;
	private String endDate;
	private int status;
	private String publisher;
	private String deadline;
	private String progress;
	private String handler;
	private String eventtype;
	private String forwarder;
	private String forwarderReceiver;
	private String thirdparty;
	//当前登录的角色名
	private String roleName;
	private String newOrOld;
	private String resultLevelB;
	private String resultLevelA;
	private String resultA;
	private String resultB;
	private String resultC;
	private String resultD;
	private String departmentA;
	private String departmentB;
	private String departmentC;
	private String departmentD;


	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String getEventContent() {
		return eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	public String getEventLevel() {
		return eventLevel;
	}

	public void setEventLevel(String eventLevel) {
		this.eventLevel = eventLevel;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getEventtype() {
		return eventtype;
	}

	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}

	public String getForwarder() {
		return forwarder;
	}

	public void setForwarder(String forwarder) {
		this.forwarder = forwarder;
	}


	public String getForwarderReceiver() {
		return forwarderReceiver;
	}

	public void setForwarderReceiver(String forwarderReceiver) {
		this.forwarderReceiver = forwarderReceiver;
	}

	public String getThirdparty() {
		return thirdparty;
	}

	public void setThirdparty(String thirdparty) {
		this.thirdparty = thirdparty;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNewOrOld() {
		return newOrOld;
	}

	public void setNewOrOld(String newOrOld) {
		this.newOrOld = newOrOld;
	}

	public String getResultLevelB() {
		return resultLevelB;
	}

	public void setResultLevelB(String resultLevelB) {
		this.resultLevelB = resultLevelB;
	}

	public String getResultLevelA() {
		return resultLevelA;
	}

	public void setResultLevelA(String resultLevelA) {
		this.resultLevelA = resultLevelA;
	}

	public String getResultA() {
		return resultA;
	}

	public void setResultA(String resultA) {
		this.resultA = resultA;
	}

	public String getResultB() {
		return resultB;
	}

	public void setResultB(String resultB) {
		this.resultB = resultB;
	}

	public String getResultC() {
		return resultC;
	}

	public void setResultC(String resultC) {
		this.resultC = resultC;
	}

	public String getResultD() {
		return resultD;
	}

	public void setResultD(String resultD) {
		this.resultD = resultD;
	}

	public String getDepartmentA() {
		return departmentA;
	}

	public void setDepartmentA(String departmentA) {
		this.departmentA = departmentA;
	}

	public String getDepartmentB() {
		return departmentB;
	}

	public void setDepartmentB(String departmentB) {
		this.departmentB = departmentB;
	}

	public String getDepartmentC() {
		return departmentC;
	}

	public void setDepartmentC(String departmentC) {
		this.departmentC = departmentC;
	}

	public String getDepartmentD() {
		return departmentD;
	}

	public void setDepartmentD(String departmentD) {
		this.departmentD = departmentD;
	}

	@Override
	public String toString() {
		return "Event{" +
				"eventID=" + eventID +
				", eventContent='" + eventContent + '\'' +
				", eventLevel='" + eventLevel + '\'' +
				", startDate='" + startDate + '\'' +
				", endDate='" + endDate + '\'' +
				", status=" + status +
				", publisher='" + publisher + '\'' +
				", deadline='" + deadline + '\'' +
				", progress='" + progress + '\'' +
				", handler='" + handler + '\'' +
				", eventtype='" + eventtype + '\'' +
				", forwarder='" + forwarder + '\'' +
				", forwarderReceiver='" + forwarderReceiver + '\'' +
				", thirdparty='" + thirdparty + '\'' +
				", roleName='" + roleName + '\'' +
				", newOrOld='" + newOrOld + '\'' +
				", resultLevelB='" + resultLevelB + '\'' +
				", resultLevelA='" + resultLevelA + '\'' +
				", resultA='" + resultA + '\'' +
				", resultB='" + resultB + '\'' +
				", resultC='" + resultC + '\'' +
				", resultD='" + resultD + '\'' +
				", departmentA='" + departmentA + '\'' +
				", departmentB='" + departmentB + '\'' +
				", departmentC='" + departmentC + '\'' +
				", departmentD='" + departmentD + '\'' +
				'}';
	}
}
