<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商家联系</title>
<link rel="stylesheet" href="css/cart.css"/>
<!-- 弹出回复窗口 -->
<LINK rel="stylesheet" href="css/mycss.css">
<script type="text/javascript">
function showAnswerWindow(e){
	if(confirm("确定回复吗？")){
	document.getElementById("comid").value=e
	document.getElementById('window_answer').style.display='block';
	document.getElementById('fade').style.display='block';
	}
}
function closeAnswerWindow(){
	document.getElementById('window_answer').style.display='none';
	document.getElementById('fade').style.display='none';
}  
</script>

<c:if test="${reloadmessage!=null }">
<script type="text/javascript">
parent.location.reload();
</script>
</c:if>
<!-- 回复div -->
<div id="fade" class="black_overlay"></div> 
<div id="window_answer" class="window">
<div class="window_title">
	<H2>回复</H2>
	<a href = "javascript:void(0)" onclick = "closeAnswerWindow()"><SPAN class="window_close"></SPAN></a>
</div>
<div class="window_content">
<form action="answer" method="post">
	<table width="34%">
		<tr>
			<td width="68%" align="left"><input id="comid" type="hidden" name="cid"><textarea name="answer" placeholder="回复......"></textarea> </td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="回复"> <input name="cancel" type="button" id="cancel" value="取消" class="取消" onclick="closeAnswerWindow()"></td>
		</tr>
	</table>
	</form>
</div>
</div> 
</head>
<body>

<div class="catbox">
<form method="post" id="fm1">
	<table border="1" id="cartTable">
	<h1 align="center">联系商户</h1>
	<p>&nbsp;</p>
		<tr>
		<th>短信id</th>
		<th>用户昵称</th>
		<th>主题</th>
		<th>问题</th>
		<th>操作</th>
		</tr>
		<c:if test="${empty acomList }">
		<tr><td colspan="5" align="center"><a style="color: gray;">没有未处理的数据了</a></td></tr>
		</c:if>
		<c:forEach items="${acomList }" var="acom">
		<tr>
		<td>${acom.cid }</td>
		<td>${acom.user.nickname }</td>
		<td><c:if test="${acom.subject==null }">空</c:if><c:if test="${acom.subject!=null }">${acom.subject }</c:if></td>
		<td>${acom.ask }</td>
		<td><a href="javascript:void(0)" onclick="showAnswerWindow(${acom.cid })" style="color: gray;"><SPAN></SPAN>回复</a></td>
		</tr>
		</c:forEach>
	</table>
</form>
</div>
</body>
</html>
</body>
</html>