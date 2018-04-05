<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 弹出添加二级分类窗口 -->
<LINK rel="stylesheet" href="css/mycss.css">
<link rel="stylesheet" href="css/cart.css"/>
<script type="text/javascript">
function chgSecondWindow(e){
	if(confirm("确定更改二级分类名称吗？")){
    	document.getElementById("secondid").value=e;
    	document.getElementById('window_chgsecond').style.display='block';
    	document.getElementById('fade').style.display='block';
	}
}
function closeChgSecondWindow(){
	document.getElementById('window_chgsecond').style.display='none';
	document.getElementById('fade').style.display='none';
} 
</script>
<script type="text/javascript">
function showSecondWindow(e){
	if(confirm("确定要在此一级分类下添加二级分类吗？")){
		document.getElementById("fid").value=e;
    	document.getElementById('window_second').style.display='block';
    	document.getElementById('fade').style.display='block';
	}
    }
    function closeSecondWindow(){
    	document.getElementById('window_second').style.display='none';
    	document.getElementById('fade').style.display='none';
    }
</script>
<!-- 添加二级分类div -->
<div id="fade" class="black_overlay"></div> 
<div id="window_second" class="window">
<div class="window_title">
	<H2>添加二级分类</H2>
</div>
<div class="window_content">
<form action="addsecond" method="post">
	<table width="34%">
		<tr>
			<td width="32%" align="right">二级属名称：</td>
			<td width="68%" align="left"><input type="hidden" name="fid" id="fid" /><input type="text" name="name"> </td>
		</tr>
		<tr>
		<td colspan="2" align="center"><input name="submit" type="submit" id="submit" value="添加" class="button">
				<input name="cancel" type="button" id="cancel" value="取消" class="button" onclick="closeSecondWindow()"></td>
		</tr>
	</table>
	</form>
</div>
</div> 
<div id="window_chgsecond" class="window">
<div class="window_title">
	<H2>修改二级级分类</H2>
</div>
<div class="window_content">
<form action="chgsecond" method="post">
	<table width="34%">
		<tr>
			<td width="32%" align="right">二级属名称：</td>
			<td width="68%" align="left"><input type="hidden" name="sid" id="secondid"/><input type="text" name="name"> </td>
		</tr>
		<tr>
		<td colspan="2" align="center"><input name="submit" type="submit" id="submit" value="确认修改" class="button">
				<input name="cancel" type="button" id="cancel" value="取消" class="button" onclick="closeChgSecondWindow()"></td>
		</tr>
	</table>
	</form>
</div>
</div> 
</head>
<body>
	<div class="catbox">
		<form method="post">
			<table style="margin-top: 200" border="1" id="cartTable">
			<h1 align="center">管理二级分类</h1>
				<p>&nbsp;</p>
				<tr>
					<th>所属一级目录id</th>
					<th>分类名称</th>
				</tr>
				<c:forEach items="${secondList }" var="second">
					<tr>
						<td>${fn:split(second.key,".")[0] }${fn:split(second.key,".")[1] }<p><A href="javascript:void(0)" onclick="showSecondWindow(${fn:split(second.key,'.')[0] })" style="color: gray;"><SPAN></SPAN>添加</A></p></td>
						<td><c:forEach items="${second.value }" var="se">
								<p>${fn:split(se,".")[1] }
								 <input type="button" value="修改" onclick="chgSecondWindow(${fn:split(se,'.')[0] })"/></p>
							</c:forEach></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>