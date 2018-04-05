<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/cart.css"/>
<title>用户管理</title>
<!-- 弹出拒绝理由窗口 -->
<LINK rel="stylesheet" href="css/mycss.css">
<script type="text/javascript" src="js/myjs.js" charset="gbk"></script>
<c:if test="${reloadmessage!=null }">
<script type="text/javascript">
parent.location.reload();
</script>
</c:if>
<!-- 拒绝理由div -->
<div id="fade" class="black_overlay"></div> 
<div id="window_goods" class="window">
<div class="window_title">
	<H2>拒绝理由</H2>
</div>
<div class="window_content">
<form action="disagrgoods" method="post">
	<table width="34%">
		<tr>
			<td width="32%" align="right"><input type="hidden" name="gid" id="goodsid">理由：</td>
			<td width="68%" align="left"><input type="text" name="message"> </td>
		</tr>
		<tr>
		<td colspan="2" align="center"><input name="submit" type="submit" id="submit" value="发送" class="button">
				<input name="cancel" type="button" id="cancel" value="取消" class="取消" onclick="closedisagreeGoodsWindow()"></td>
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
	<h1 align="center">上架审核</h1>
	<p>&nbsp;</p>
		<tr>
		<th>商品id</th>
		<th>商品姓名</th>
		<th>商品简介</th>
		<th>商品详情</th>
		<th>商品材质</th>
		<th>商品颜色</th>
		<th>商品风格</th>
		<th>商品品牌</th>
		<th>商品现价</th>
		<th>商品图片</th>
		<th>商品运费</th>
		<th>商户id/姓名/昵称/邮箱/手机</th>
		<th>所属三级分类</th>
		<th>操作</th>
		</tr>
		<c:if test="${empty agList }">
		<tr><td colspan="14" align="center"><a style="color: gray;">没有未处理的数据了</a></td></tr>
		</c:if>
		<c:forEach items="${agList }" var="ag">
		<tr>
		<td>${ag.gid }</td>
		<td>${ag.name }</td>
		<td>${ag.info }</td>
		<td>${ag.detail }</td>
		<td>${ag.material }</td>
		<td>${ag.color }</td>
		<td>${ag.style }</td>
		<td>${ag.brand }</td>
		<td>${ag.preprice }</td>
		<td><c:forEach items="${fn:split(ag.photo,';') }" var="photo"><img src="images/${photo }" width="100" height="40"/></c:forEach></td>
		<td>${ag.transport }</td>
		<td>${ag.user.uid }/${ag.user.truename }/${ag.user.nickname }/${ag.user.email }/${ag.user.phone }</td>
		<td>${ag.third.tid }.${ag.third.name }</td>
		<td><input type="submit" value="同意" onclick="javascript:this.form.action='agrgoods?gid=${ag.gid }'" ><input type="button" value="拒绝" onclick="disagreeGoodsWindow(${ag.gid })" ></td>
		</tr>
		</c:forEach>
	</table>
</form>
</div>
</body>
</html>