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
<title>确认订单</title>
</head>
<body>
<div class="catbox">
<form method="post">
	<table border="1" id="cartTable">
	<h1 align="center">订单审核</h1>
	<p>&nbsp;</p>
		<tr>
		<th>商品id</th>
		<th>货品id</th>
		<th>卖家详情</th>
		<th>买家信息</th>
		<th>买家联系方式</th>
		<th>买家地址</th>
		<th>商品属性</th>
		<th>购买个数</th>
		<th>买家留言</th>
		<th>操作</th>
		</tr>
		<c:if test="${empty aorderList }">
		<tr><td colspan="10" align="center"><a style="color: gray;">没有未处理的数据了</a></td></tr>
		</c:if>
		<c:forEach items="${aorderList }" var="aorder">
		<tr>
		<td>${aorder.type.goods.gid }</td>
		<td>${aorder.type.tid }</td>
		<td><a href="#">${aorder.type.goods.user.nickname }+${aorder.type.goods.user.truename }+${aorder.type.goods.user.email }+${aorder.type.goods.user.phone }</a></td>
		<td>${aorder.user.nickname }+${aorder.user.truename }</td>
		<td>${aorder.user.phone }+${aorder.user.email }</td>
		<td>${aorder.address.province}省${aorder.address.city}市${aorder.address.district}区${aorder.address.detail}</td>
		<td>${aorder.type.kind }</td>
		<td>${aorder.quantity }</td>
		<td>${aorder.message }</td>
		<td><input type="submit" value="同意申请" onclick="javascript:this.form.action='agrorder?oid=${aorder.oid }'"></td>
		</tr>
		</c:forEach>
	</table>
</form>
</div>

</body>
</html>