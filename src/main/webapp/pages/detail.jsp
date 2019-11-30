<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>网络应急响应平台</title>
<meta name="description" content="网络应急响应平台">
<meta name="keywords" content="网络应急响应平台">

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/morris/morris.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/select2/select2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

	<div class="wrapper">

		<!-- 页面头部 -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 页面头部 /-->
		<!-- 导航侧栏 -->
		<jsp:include page="aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->

		<!-- 内容区域 -->
		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
			<h1>
				事件发布管理 <small>事件详情</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/product/findAll.do">事件</a></li>
				<li class="active">事件详情</li>
			</ol>
			</section>
			<!-- 内容头部 /-->


			<form action="${pageContext.request.contextPath}/event/submit.do" >
				<!-- 正文区域 -->
				<section class="content"> <!--产品信息-->

				<div class="panel panel-default">
					<div class="panel-heading">事件详情</div>
					<div class="row data-type">

						<div class="col-md-2 title">事件编号</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="eventID"
								   value="${event.eventID}" readonly="readonly">
						</div>

						<div class="col-md-2 title">事件类型</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="eventtype"
								   value="${event.eventtype}" readonly="readonly">
						</div>
						<div class="col-md-2 title">事件级别</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="eventLevel"
								   value="${event.eventLevel}"  readonly="readonly">
						</div>

						<div class="col-md-2 title">发布时间</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="startDate" readonly="readonly"
								 value="${event.startDate}" >
						</div>


						<div class="col-md-2 title">截止时间</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="deadline"
								   value="${event.deadline}" readonly="readonly" >
						</div>
                        
						<c:if test="${fn:contains(event.roleName,'B')}">
						<div class="col-md-2 title">事件发送者</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="publisher"
								   value="${event.departmentA}${event.publisher}" readonly="readonly" >
						</div>
						</c:if>

						<c:if test="${fn:contains(event.roleName,'A')}">
						<div class="col-md-2 title">事件接收者</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="handler"
								   value="${event.departmentB} ${event.handler}" readonly="readonly" >
						</div>
						</c:if>

						<c:if test="${fn:contains(event.roleName,'C')}">
						<c:if test="${event.forwarder!=null}">
						<div class="col-md-2 title">事件发送者</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="handler"
								   value="${event.departmentB} ${event.handler}" readonly="readonly" >
						</div>
						</c:if>
						</c:if>

						<c:if test="${fn:contains(event.roleName,'B')}">
						<div class="col-md-2 title">事件接收者</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="forwarderReceiver"
								   value="${event.departmentC} ${event.forwarderReceiver}" readonly="readonly" >
						</div>
						</c:if>

						<c:if test="${fn:contains(event.roleName,'D')}">
						<div class="col-md-2 title">事件邀请者</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="forwarderReceiver"
								   value="${event.departmentC} ${event.forwarderReceiver}" readonly="readonly" >
						</div>
						</c:if>

						<c:if test="${fn:contains(event.roleName,'C')}">
						<div class="col-md-2 title">受邀请处理事件者</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="thirdparty"
								   value="${event.departmentD} ${event.thirdparty}" readonly="readonly" >
						</div>
						</c:if>

						<c:if test="${event.status==1}">
						<div class="col-md-2 title">进展情况</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="progress"
								   value="已完成" readonly="readonly" >
						</div>
						</c:if>

						<c:if test="${event.status==0}">
							<div class="col-md-2 title">进展情况</div>
							<div class="col-md-4 data">
						<c:if test="${fn:contains(event.roleName,'A')}">
							<c:if test="${event.forwarder==null}">

								<input type="text" class="form-control" name="progress"
									   value="${event.handler}正在处理" readonly="readonly" >
							</c:if>
							<c:if test="${event.forwarder!=null}">
								<c:if test="${event.thirdparty==null}">
								<input type="text" class="form-control" name="progress"
									   value="${event.handler}已转发${event.forwarderReceiver}处理" readonly="readonly" >
								</c:if>
							</c:if>
							<c:if test="${event.forwarder!=null}">
								<c:if test="${event.thirdparty!=null}">
									<input type="text" class="form-control" name="progress"
										   value="${event.handler}已转发${event.forwarderReceiver}处理并邀请${event.thirdparty}一起处理" readonly="readonly" >
								</c:if>
							</c:if>
						</c:if>

						<c:if test="${fn:contains(event.roleName,'B')}">
							<c:if test="${event.forwarder==null}">
								<input type="text" class="form-control" name="progress"
									   value="本部门正在处理" readonly="readonly" >
							</c:if>
							<c:if test="${event.forwarder!=null}">
								<c:if test="${event.thirdparty==null}">
									<input type="text" class="form-control" name="progress"
										   value="已转发${event.forwarderReceiver}处理" readonly="readonly" >
								</c:if>
							</c:if>
							<c:if test="${event.forwarder!=null}">
								<c:if test="${event.thirdparty!=null}">
									<input type="text" class="form-control" name="progress"
										   value="已转发${event.forwarderReceiver}处理并邀请${event.thirdparty}一起处理" readonly="readonly" >
								</c:if>
							</c:if>
						</c:if>

							<c:if test="${fn:contains(event.roleName,'C')}">
									<c:if test="${event.thirdparty==null}">
										<input type="text" class="form-control" name="progress"
											   value="本部门正在处理" readonly="readonly" >
									</c:if>

									<c:if test="${event.thirdparty!=null}">
										<input type="text" class="form-control" name="progress"
											   value="已邀请${event.thirdparty}一起处理" readonly="readonly" >
									</c:if>

							</c:if>


							<c:if test="${fn:contains(event.roleName,'D')}">
								<input type="text" class="form-control" name="progress"
									   value="受${event.forwarderReceiver}邀请参与处理" readonly="readonly" >
							</c:if>
						</div>
						</c:if>


					<div class="col-md-2 title">事件处理结果评级</div>
						<div class="col-md-4 data">
							<c:if test="${event.resultLevelA!=null}">
							<input type="text" class="form-control" name="resultLevelA"
									value="${event.resultLevelA}" readonly="readonly" >
							</c:if>
							<c:if test="${event.resultLevelA==null}">
								<c:if test="${fn:contains(event.roleName,'B' )}">
								<c:if test="${event.forwarderReceiver!=null}">
									<input type="text" class="form-control" name="resultLevelB"
										   value="${event.resultLevelB}" >
								</c:if>
								<c:if test="${event.forwarderReceiver==null}">
								<input type="text" class="form-control" name="resultLevelB"
									   value="${event.resultLevelB}" readonly="readonly">
								</c:if>
								</c:if>
								<c:if test="${fn:contains(event.roleName,'A' )}">
									<input type="text" class="form-control" name="resultLevelA"
										   value="${event.resultLevelB}" >
								</c:if>
							</c:if>
					    </div>

						<c:if test="${fn:contains(event.roleName,'C' )}">
						<div class="col-md-2 title">暂无标签</div>
							<div class="col-md-4 data"></div>
						</c:if>
						<c:if test="${fn:contains(event.roleName,'B' )}">
							<div class="col-md-2 title">暂无标签</div>
							<div class="col-md-4 data"></div>
						</c:if>


						<div class="col-md-2 title rowHeight2x">事件描述</div>
						<div class="col-md-10 data rowHeight2x">
							<textarea class="form-control" rows="3" placeholder="事件描述"
									  name="eventContent" readonly="readonly">${event.eventContent}</textarea>
						</div>



							<c:if test="${event.status==1}">
                            <div class="col-md-2 title rowHeight2x">处理结果</div>
                            <div class="col-md-10 data rowHeight2x">
                                <textarea class="form-control" rows="3" placeholder="处理结果"
                                          name="resultA" readonly="readonly">${event.resultA}</textarea>
                            </div>
                            </c:if>

                            <c:if test="${event.status==0}">
                            <div class="col-md-2 title rowHeight2x">处理结果</div>
                            <div class="col-md-10 data rowHeight2x">
                                <c:if test="${fn:contains(event.roleName,'A' )}">
                                    <textarea class="form-control" rows="3" placeholder="处理结果"
                                              name="resultA">${event.resultB}</textarea>
                                </c:if>

                                <c:if test="${fn:contains(event.roleName,'B' )}">
                                <c:if test="${event.resultB==null}">
                                    <textarea class="form-control" rows="3" placeholder="暂无"
                                              name="resultB">${event.resultC}</textarea>
                                </c:if>
                                <c:if test="${event.resultB!=null}">
                                    <textarea class="form-control" rows="3" placeholder="暂无"
                                              name="resultB">${event.resultB}</textarea>
                                </c:if>
                                </c:if>

                                <c:if test="${fn:contains(event.roleName,'C' )}">
                                    <c:if test="${event.resultC==null}">
                                    <textarea class="form-control" rows="3" placeholder="暂无"
                                              name="resultC">${event.resultD}</textarea>
                                    </c:if>
                                    <c:if test="${event.resultB!=null}">
                                    <textarea class="form-control" rows="3" placeholder="暂无"
                                              name="resultC">${event.resultC}</textarea>
                                    </c:if>
                                </c:if>

                                <c:if test="${fn:contains(event.roleName,'D' )}">
                                    <textarea class="form-control" rows="3" placeholder="暂无"
                                              name="resultD">${event.resultD}</textarea>
                                </c:if>

                            </div>
                            </c:if>

                        </div>
                    </div>
                        <div class="box-tools text-center">
							<c:if test="${event.status==0}">
                            <c:if test="${fn:contains(event.roleName,'D' )}">
                                <button type="submit" class="btn bg-maroon">提交处理意见</button>
                            </c:if>
                            <c:if test="${fn:contains(event.roleName,'C' )}">
                                <button type="submit" class="btn bg-maroon">上报</button>
                            </c:if>
                            <c:if test="${fn:contains(event.roleName,'B' )}">
                                <button type="submit" class="btn bg-maroon">上报</button>
                            </c:if>
                            <c:if test="${fn:contains(event.roleName,'A' )}">
                                <button type="submit" class="btn bg-maroon">确认</button>
                            </c:if>
							</c:if>
                            <button type="button" class="btn bg-default"
                                    onclick="history.back(-1);">返回</button>
                        </div>

				</section>

			</form>

		</div>
		<!-- 内容区域 /-->

		<!-- 底部导航 -->
		<footer class="main-footer">
		<div class="pull-right hidden-xs">
			<b>Version</b> 1.0.8
		</div>
		<strong>Copyright &copy; 2010-2019 <a
				href="http://www.guet.edu.cn">桂林电子科技大学</a>.
		</strong> All rights reserved.
		</footer>
		<!-- 底部导航 /-->

	</div>


	<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

	<script>
		$(document).ready(function() {
			// 选择框
			$(".select2").select2();

			// WYSIHTML5编辑器
			$(".textarea").wysihtml5({
				locale : 'zh-CN'
			});
		});

		// 设置激活菜单
		function setSidebarActive(tagUri) {
			var liObj = $("#" + tagUri);
			if (liObj.length > 0) {
				liObj.parent().parent().addClass("active");
				liObj.addClass("active");
			}
		}

		$(document).ready(function() {
			$('#datepicker-a3').datetimepicker({
				format : "yyyy-mm-dd hh:ii",
				autoclose : true,
				todayBtn : true,
				language : "zh-CN"
			});
		});

		$(document).ready(function() {
			// 激活导航位置
			setSidebarActive("order-manage");
			$("#datepicker-a3").datetimepicker({
				format : "yyyy-mm-dd hh:ii",

			});
			
			$('#datepicker-a4').datetimepicker({
				format : "yyyy-mm-dd hh:ii",
				autoclose : true,
				todayBtn : true,
				language : "zh-CN"
			});
		});

		$(document).ready(function() {
			// 激活导航位置
			setSidebarActive("order-manage");
			$("#datepicker-a4").datetimepicker({
				format : "yyyy-mm-dd hh:ii",

			});

		});
	</script>


</body>

</html>