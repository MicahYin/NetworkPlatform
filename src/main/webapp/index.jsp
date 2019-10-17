<%--
  Created by IntelliJ IDEA.
  User: Micah
  Date: 2019/7/14
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/findAll">测试</a><br/>
<form method="post" action="account/save">
     姓名:<input type="text" name="name"/><br/>
     金额:<input type="text" name="money"/><br/>
    <input type="submit" value="保存"/><br/>
</form>
</body>
</html>
