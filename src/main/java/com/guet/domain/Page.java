package com.guet.domain;

import java.util.List;

public class Page {

    //每页显示的条数
    private int currentTotal;
    //当前页
    private int  currentPage;
    //总页数
    private int totalPage;
    //总条数
    private int totalCount;
    //索引
    private int index1;
    //设置当前返回的条目数
    private int numCount;
    //设置UserId
    private String userName;
    //获取需要处理者
    private String handler;
    //获取转发者
    private String forwarder;
    //获取转发接收者
    private String forwarderReceiver;
    //获取受邀请的第三方
    private String thirdparty;
    //每页显示的内容（已处理的事件）
    private List<Event> processedEvents;
    //每页实现的内容（未处理的事件)
    private List<Event> notProcessedEvents;


    public int getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentTotal(int currentTotal) {
        this.currentTotal = currentTotal;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getIndex1() {
        return index1;
    }

    public void setIndex1(int index1) {
        this.index1 = index1;
    }

    public int getNumCount() {
        return numCount;
    }

    public void setNumCount(int numCount) {
        this.numCount = numCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Event> getProcessedEvents() {
        return processedEvents;
    }

    public void setProcessedEvents(List<Event> processedEvents) {
        this.processedEvents = processedEvents;
    }

    public List<Event> getNotProcessedEvents() {
        return notProcessedEvents;
    }

    public void setNotProcessedEvents(List<Event> notProcessedEvents) {
        this.notProcessedEvents = notProcessedEvents;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getForwarder() {
        return forwarder;
    }

    public void setForwarder(String forwarder) {
        this.forwarder = forwarder;
    }

    public String getThirdparty() {
        return thirdparty;
    }

    public void setThirdparty(String thirdparty) {
        this.thirdparty = thirdparty;
    }

    public String getForwarderReceiver() {
        return forwarderReceiver;
    }

    public void setForwarderReceiver(String forwarderReceiver) {
        this.forwarderReceiver = forwarderReceiver;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentTotal=" + currentTotal +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", index1=" + index1 +
                ", numCount=" + numCount +
                ", userName='" + userName + '\'' +
                ", handler='" + handler + '\'' +
                ", forwarder='" + forwarder + '\'' +
                ", forwarderReceiver='" + forwarderReceiver + '\'' +
                ", thirdparty='" + thirdparty + '\'' +
                ", processedEvents=" + processedEvents +
                ", notProcessedEvents=" + notProcessedEvents +
                '}';
    }
}
