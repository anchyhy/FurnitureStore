<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link rel="stylesheet" href="css/cart.css"/>
</head>
<body>
<div class="catbox">
<form method="post">
	<table border="1" id="cartTable">
	<h1 align="center">管理用户</h1>
	<p>&nbsp;</p>
		<tr>
		<th>用户id</th>
		<th>注册时间</th>
		<th>真实姓名</th>
		<th>昵称</th>
		<th>性别</th>
		<th>密码</th>
		<th>邮箱</th>
		<th>手机</th>
		<th>状态</th>
		<th>属性</th>
		</tr>
		<c:forEach items="${userList }" var="user">
		<tr>
		<td>${user.uid }</td>
		<td>${user.registerTime }</td>
		<td>${user.truename }</td>
		<td>${user.nickname }</td>
		<td><c:if test="${user.gender==1 }">男</c:if><c:if test="${user.gender==2 }">女</c:if></td>
		<td>${user.password }</td>
		<td>${user.email }</td>
		<td>${user.phone }</td>
		<td><c:if test="${user.status==0 }">还未激活</c:if><c:if test="${user.status==1 }">已激活</c:if></td>
		<td><c:if test="${user.flag==1 }">普通用户</c:if><c:if test="${user.flag==2 }">已是卖家</c:if></td>
		</tr>
		</c:forEach>
	</table>
	<p>&nbsp;</p>
	<c:if test="${pageNum>1 }"><h3 align="center"><a href="showuser?pageNum=${pageNum-1 }" style="color: gray;">上一页</a></h3></c:if>
	<c:if test="${pageNum<(cuser/10) }"><h3 align="center"><a href="showuser?pageNum=${pageNum+1 }" style="color: gray;">下一页</a></h3></c:if>
</form>
</div>
</body>
</html>