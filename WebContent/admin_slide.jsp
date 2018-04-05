<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>轮播图管理</title>
<!-- 弹出添加轮播图窗口 -->
<LINK rel="stylesheet" href="css/mycss.css">
<link rel="stylesheet" href="css/cart.css"/>
<script type='text/javascript' src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/myjs.js" charset="gbk"></script>

<!-- 添加轮播图div -->
<div id="fade" class="black_overlay"></div> 
<div id="window_slide" class="window">
<div class="window_title">
	<H2>添加轮播图</H2>
</div>
<div class="window_content">
<form action="addslide" method="post" enctype="multipart/form-data">
	<table width="34%">
		<tr>
			<td colspan="2" align="center"><input type="file" name="file">
			<input type="hidden" value=ext name="fileContentType"></td>
		</tr>
		<tr>
			<td width="32%" align="right">备注：</td>
			<td width="68%" align="left"><input type="text" name="saying"></td>
		<tr>
			<td colspan="2" align="center"><input name="submit" type="submit" id="submit" value="添加" class="button">
				<input name="cancel" type="button" id="cancel" value="取消" class="button" onclick="closeSlideWindow()"></td>
		</tr>
	</table>
	</form>
</div>
</div> 
</head>
<body>
<div class="catbox">
<form method="post">
	<table border="1" id="cartTable">
	<h1 align="center">轮播图管理</h1>
	<p>&nbsp;</p>
		<tr>
		<th>轮播图id</th>
		<th>图片</th>
		<th>备注</th>
		<th>删除</th>
		</tr>
		<c:forEach items="${slideList }" var="slide">
		<tr>
		<td>${slide.sid }</td>
		<td><img id="img" src="images/${slide.photo }" style="cursor:pointer;width:100px;height:40px;" onmouseover="bigger()" onmouseout="smaller()" /></td>
		<td>${slide.saying }</td>
		<td><input type="submit" value="删除" onclick="javascript:this.form.action='#'"/></td>
		</tr>
		</c:forEach>
	</table>
</form>
<h3><a href="javascript:void(0)" onclick="showSlideWindow()" style="color: gray;"><SPAN></SPAN>添加</a></h3>
</div>
<script type="text/javascript">
 var img = document.getElementById('img');
 function bigger(){
  img.style.width = '400px';
  img.style.height = '160px';
 }
 
 function smaller(){
  img.style.width = '100px';
  img.style.height = '40px';
 }

</script>
</body>
</html>