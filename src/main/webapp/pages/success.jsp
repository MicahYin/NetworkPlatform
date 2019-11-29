<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
        <meta charset="UTF-8">
        <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport"/>
        <meta content="yes" name="apple-mobile-web-app-capable"/>
        <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
        <meta content="telephone=no" name="format-detection"/>
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>文章发布</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/css/mystyle.css" rel="stylesheet" type="text/css"/>
    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
   

  </head>
  <body>
 
        <section class="aui-flexView">
            <header class="aui-navBar aui-navBar-fixed b-line">
               <!--  <a href="javascript:;" class="aui-navBar-item">
                    <i class="icon icon-return"></i>
                </a> -->
                <div class="aui-center">
                    <span class="aui-center-title">发送成功</span>
                </div>
                <a href="javascript:;" class="aui-navBar-item">
                    <i class="icon icon-sys"></i>
                </a>
            </header>
            <section class="aui-scrollView">
                <div class="aui-back-box">
                    <div class="aui-back-pitch">
                       <img src="${pageContext.request.contextPath}/img/icon-pitch.png" alt="">
                    </div>
                    <div class="aui-back-title">
                        <h2>事件成功发送</h2>
                        <p>事件成功发送</p>
                   <%--  </div>
                    <%Integer browserWidth = (Integer)request.getSession().getAttribute("browserInt"); 
                      String pathString = null;
                      if(browserWidth>906) {
                    	  pathString = "${pageContext.request.contextPath}/jsp/mobileIndex.jsp";
                      }
                    %> --%>
                  
                    
                    
              
					<form action="${pageContext.request.contextPath}/pages/main.jsp" name="goBack" id="goBack">
                    <div class="aui-back-button">
                        <button type="submit">返回首页</button>
                    </div>
                    </form>
                  
                </div>
            </section>
        </section>
    
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>