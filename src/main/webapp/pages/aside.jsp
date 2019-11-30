<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p><security:authentication property="principal.username"/></p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>用户管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li id="system-setting">
						<a href="${pageContext.request.contextPath}/role/findAll.do?page=1&size=4"> <i
							class="fa fa-circle-o"></i> 单位类型管理</a>
					</li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/department/findAll.do?page=1&size=4"> <i
							class="fa fa-circle-o"></i> 单位管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/account/findAll.do?page=1&size=4">
							<i class="fa fa-circle-o"></i> 用户列表
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/sysLog/findAll.do?page=1&size=4"> <i
							class="fa fa-circle-o"></i> 登录日志
					</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
				<span>事件发布管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/pages/event_add.jsp">
						<i class="fa fa-circle-o"></i> 发布预警事件
					</a></li>
					<li id="system-setting1"><a
							href="${pageContext.request.contextPath}/event/eventProcessedList.do?currentPage=1">
						<i class="fa fa-circle-o"></i> 已处理事件
					</a></li>
					<li id="system-setting2"><a
							href="${pageContext.request.contextPath}/event/eventNotProcessedList.do?currentPage=1">
						<i class="fa fa-circle-o"></i> 未处理事件
					</a></li>
					<li id="system-setting2"><a
							href="${pageContext.request.contextPath}/dataDisplay/show.do">
						<i class="fa fa-circle-o"></i> 事件数据统计
					</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
				<span>事件接收管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting3"><a
							href="${pageContext.request.contextPath}/event/eventHaveProcessedList.do?currentPage=1">
						<i class="fa fa-circle-o"></i> 已处理事件
					</a></li>
					<li id="system-setting4"><a
							href="${pageContext.request.contextPath}/event/eventHaveNotProcessedList.do?currentPage=1">
						<i class="fa fa-circle-o"></i> 未处理事件
					</a></li>
				</ul></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>