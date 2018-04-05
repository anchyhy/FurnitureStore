<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 弹出修改一级分类名称窗口 -->
<LINK rel="stylesheet" href="css/mycss.css">
<link rel="stylesheet" href="css/cart.css"/>
<script type="text/javascript">
function chgFirstWindow(e){
	if(confirm("确定更改一级分类名称吗？")){
    	document.getElementById("firstid").value=e;
    	document.getElementById('window_chgfirst').style.display='block';
    	document.getElementById('fade').style.display='block';
	}
}
function closeChgFirstWindow(){
	document.getElementById('window_chgfirst').style.display='none';
	document.getElementById('fade').style.display='none';
} 
</script>
<!-- 修改一级分类名称div -->
<div id="fade" class="black_overlay"></div> 
<div id="window_chgfirst" class="window">
<div class="window_title">
	<H2>修改一级级分类</H2>
</div>
<div class="window_content">
<form action="chgfirst" method="post">
	<table width="34%">
		<tr>
			<td width="32%" align="right">一级属名称：</td>
			<td width="68%" align="left"><input type="hidden" name="fid" id="firstid"/><input type="text" name="fname"> </td>
		</tr>
		<tr>
		<td colspan="2" align="center"><input name="submit" type="submit" id="submit" value="确认修改" class="button">
				<input name="cancel" type="button" id="cancel" value="取消" class="button" onclick="closeChgFirstWindow()"></td>
		</tr>
	</table>
	</form>
</div>
</div> 
</head>
<body>
<div class="catbox">
<form action="" method="post">
<input type="text" placeholder="添加一级目录" name="fname">
<input type="submit" onclick="javascript:this.form.action='addfirst'" value="添加">
</form >
<form action="" method="post" onSubmit="javascript:return window.confirm('确认修改吗？')">
<table style="margin-top: 200" border="1" id="cartTable">
<h1 align="center">管理一级分类</h1>
	<p>&nbsp;</p>
<tr>
<th>id</th>
<th>以及分类名称</th>
<th>操作</th>
</tr>
<c:forEach items="${firstList }" var="first">
<tr>
<td>${first.fid }</td>
<td>${first.name }</td>
<td><A href="javascript:void(0)" onclick="chgFirstWindow(${first.fid})" style="color: gray;">修改</A></td>
</tr>
</c:forEach>
</table>
</form>
</div>
</body>
</html>