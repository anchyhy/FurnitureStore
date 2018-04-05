<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网站新闻管理</title>
<link rel="stylesheet" href="css/cart.css"/>
</head>
<body>
<div class="catbox">
<form method="post">
	<table border="1" id="cartTable">
	<h1 align="center">网站新闻管理</h1>
	<p>&nbsp;</p>
		<tr>
		<th>新闻序号</th>
		<th>标题</th>
		<th>时间</th>
		<th>内容</th>
		<th>操作</th>
		</tr>
		<c:forEach items="${newsList }" var="news">
		<tr>
		<td>${news.nid }</td>
		<td>${news.title }</td>
		<td>${news.time }</td>
		<td>${news.content }</td>
		<td><input type="submit" value="删除" onclick="javascript:this.form.action='delnews?nid=${news.nid}'"/></td>
		</tr>
		</c:forEach>
	</table>
</form>
<form action="addnews" onSubmit="javascript:return window.confirm('确认添加吗？')">
<table>
<tr>
<td><input type="text" name="title" placeholder="标题"/></td>
<td><input type="text" name="content" placeholder="内容"/></td>
<td><input type="submit" value="添加"/></td>
</tr>
</table>
</form>
</div>
</body>
</html>