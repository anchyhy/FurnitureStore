<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/cart.css"/>
<c:if test="${reloadmessage!=null }">
<script type="text/javascript">
parent.location.reload();
</script>
</c:if>
<title>Insert title here</title>
<!-- 弹出拒绝理由窗口 -->
<LINK rel="stylesheet" href="css/mycss.css">
<script type="text/javascript" src="js/myjs.js" charset="gbk"></script>

<!-- 拒绝理由div -->
<div id="fade" class="black_overlay"></div> 
<div id="window_seller" class="window">
<div class="window_title">
	<H2>拒绝理由</H2>
</div>
<div class="window_content">
<form action="disagrseller" method="post">
	<table width="34%">
		<tr>
			<td width="32%" align="right"><input type="hidden" name="sid" id="sellerid">理由：</td>
			<td width="68%" align="left"><input type="text" name="message"> </td>
		</tr>
		<tr>
		<td colspan="2" align="center"><input name="submit" type="submit" id="submit" value="发送" class="button">
				<input name="cancel" type="button" id="cancel" value="取消" class="取消" onclick="closedisagreeSellerWindow()"></td>
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
	<h1 align="center">卖家审核</h1>
	<p>&nbsp;</p>
		<tr>
		<th>用户id</th>
		<th>真实姓名</th>
		<th>昵称</th>
		<th>性别</th>
		<th>邮箱</th>
		<th>手机</th>
		<th>本人照片</th>
		<th>证件照正面</th>
		<th>证件照背面</th>
		<th>操作</th>
		</tr>
		<c:if test="${sellerList==null }">
		<tr><td colspan="10" align="center"><a style="color: gray;">没有未处理的数据了</a></td></tr>
		</c:if>
		<c:forEach items="${sellerList }" var="seller">
		<tr>
		<td><input type="hidden" value="${seller.sid }" id="sid"/>${seller.user.uid }</td>
		<td>${seller.user.truename }</td>
		<td>${seller.user.nickname }</td>
		<td><c:if test="${seller.user.gender==1 }">男</c:if><c:if test="${seller.user.gender==2 }">女</c:if></td>
		<td>${seller.user.email }</td>
		<td>${seller.user.phone }</td>
		<td><img src="images/${seller.photo1 }" width="50" height="20"/></td>
		<td><img src="images/${seller.photo2 }" width="50" height="20"/></td>
		<td><img src="images/${seller.photo3 }" width="50" height="20"/></td>
		<td><input type="submit" value="同意申请"  onclick="javascript:this.form.action='agrseller?uid=${seller.user.uid }'"><input type="button" value="拒绝" onclick="disagreeSellerWindow(${seller.sid })" ></td>
		</tr>
		</c:forEach>
	</table>
</form>
</div>

</body>
</html>