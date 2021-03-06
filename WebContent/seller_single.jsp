<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary JavaScript plugins) -->
<script type='text/javascript' src="js/jquery-1.11.1.min.js"></script>
<script src="http://ajax.useso.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Furnyish Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='http://fonts.useso.com/css?family=Montserrat|Raleway:400,200,300,500,600,700,800,900,100' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Playfair+Display:400,700,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Aladin' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/message.css" media="screen" type="text/css" />
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/menu_jquery.js"></script>
<script src="js/simpleCart.min.js"> </script>
<script src="js/index.js"></script>
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
<!--etalage-->
<link rel="stylesheet" href="css/etalage.css">
<script src="js/jquery.etalage.min.js"></script>
<script>
			jQuery(document).ready(function($){

				$('#etalage').etalage({
					thumb_image_width: 300,
					thumb_image_height: 400,
					source_image_width: 900,
					source_image_height: 1200,
					show_hint: true,
					click_callback: function(image_anchor, instance_id){
						alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
					}
				});

			});
		</script>
		<script src="http://ajax.useso.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- //etalage-->
<!-- 添加type -->
<LINK rel="stylesheet" href="css/mycss.css">
<script type="text/javascript" src="js/myjs.js" charset="gbk"></script>
<div id="fade" class="black_overlay"></div> 
<div id="window_type" class="window">
<div class="window_title">
	<H2>添加属性</H2>
</div>
<div class="window_content">
<form action="addtype?gid=${goods.gid }" method="post" enctype="multipart/form-data">
	<table width="34%">
		<tr>
			<td align="right">属性名称：</td>
			<td align="left"><input type="text" name="kind"> </td>
			
		</tr>
		<tr>
			<td width="32%" align="right">数量：</td>
			<td width="68%" align="left"><input type="text" name="number"> </td>
			
		</tr>
		<tr >
		<td colspan="2" align="center" ><input type="file" name="uploadFile">
		<input type="hidden" value=ext name="uploadFileContentType"></td>
		</tr>
		<tr>
			<td colspan="2" align="center" ><input name="submit" type="submit" id="submit" value="添加" class="button">
				<input name="cancel" type="button" id="cancel" value="取消" class="button" onclick="closeTypeWindow()"> </td>
        </tr>
	</table>
	
	</form>
</div>
</div> 
<!--添加type  -->  
<!-- 添加photo-->
<div id="window_photo" class="window">
<div class="window_title">
	<H2>添加图片</H2>
</div>
<div class="window_content">
<form action="addphoto?gid=${goods.gid }" method="post" enctype="multipart/form-data">
	<table width="34%">
		<tr>
		<td colspan="2" align="center"><input type="file" name="uploadFile">
		<input type="hidden" value=ext name="uploadFileContentType"></td>
		</tr>
		<tr>
			<td colspan="2" align="center" ><input name="submit" type="submit" id="submit" value="添加" class="button">
				<input name="cancel" type="button" id="cancel" value="取消" class="button" onclick="closePhotoWindow()"> </td>
        </tr>
	</table>
	
	</form>
</div>
</div> 
<!--添加type  -->  
</head>
<body>
<!-- header -->
<div class="top_bg">
	<div class="container">
		<div class="header_top-sec">
			<div class="top_right">
				<ul>
					<li><a href="about">联机帮助</a></li>|
					<c:if test="${user.uid!=null }"><li><a href="contact?uid=${user.uid }">留言</a></li>|</c:if>
					<c:if test="${user.uid==null }"><li><a href="javascript:void(0)" onclick="pleaseLogin(1,0)">留言</a></li>|</c:if>
					<c:if test="${user.uid!=null }"><li><a href="getcollect?uid=${user.uid }">我的收藏</a></li>|</c:if>
					<c:if test="${user.uid==null }"><li><a href="javascript:void(0)" onclick="pleaseLogin(2,0)">我的收藏</a></li>|</c:if>
					<c:if test="${user.uid!=null }"><li><a href="getorder?uid=${user.uid }">追踪订单</a></li></c:if>
					<c:if test="${user.uid==null }"><li><a href="javascript:void(0)" onclick="pleaseLogin(3,0)">追踪订单</a></li></c:if>
					
				</ul>
			</div>
			<div class="top_left">
				<ul>
					
					<c:if test="${session.user==null}">
					<li class="top_link"><a href="indextologin">亲，请登录/注册！</a></li>	
					</c:if>	
					<c:if test="${session.user!=null}">
					<li class="top_link"><a href="userinfo.jsp">个人信息</a></li>|	
					<li class="top_link"><a href="getaddress.action?auid=${user.uid}">管理地址</a></li>|	
					<li class="top_link"><a href="logout">退出登录</a></li>
					</c:if>				
				</ul>
				
			</div>
				<div class="clearfix"> </div>
		</div>
	</div>
</div>
<div class="header_top">
	 <div class="container">
		 <div class="logo">
		 	<a href="init"><img src="images/logo.png" alt=""/></a>			 
		 </div>
		 <c:if test="${session.user!=null}">
		 <div class="header_right">	
				 <p><a href="userinfo.jsp" class="simpleCart_empty">欢迎登录，${session.user.nickname }!&nbsp;&nbsp;您现在在卖家主页</a></p>
			<div class="cart box_1">
				<a href="getcart?uid=${user.uid }">
					<h3><span >${session.csum }</span> (<span id="simpleCart_quantity" >${ccount }</span> 件)<img src="images/bag.png" alt=""></h3>
				</a>	
				<c:if test="${csum==0 }">
				<p><a href="javascript:void(0);" class="simpleCart_empty">购物车还是空的哦!</a></p></c:if>
				<div class="clearfix"> </div>
			 </div>		 
		 </div>
		 </c:if>
		  <div class="clearfix"></div>	
	 </div>
</div>

<!--cart-->
<div class="single-sec">
	 <div class="container">
		 <ol class="breadcrumb">
			 <li class="active">编辑商品</li>
		 </ol>
		 <!-- start content -->	
			<div class="col-md-9 det">
				  <div >
					 <div >
						 <h2 style="color: rgb(2, 105, 102)">商品图片</h2><A href="javascript:void(0)" onclick="showPhotoWindow()" style="color: gray;"><SPAN></SPAN>添加</A>
						 <c:forEach items="${fn:split(goods.photo,';')}" var="photo">	
							<div>
									<img width="100" height="100" src="images/${photo }"/><span onclick="location.href='delsellerphoto?gid=${goods.gid }&pname=${photo }'" class="delet"><img width="10" width="10" src="images/delete.png"></span>
							</div>
						</c:forEach>
						 <div class="clearfix"></div>		
				      </div>
				  </div>
				  <div class="clearfix"></div>
				  <div class="sofaset-info">
						 <h2 style="color: rgb(2, 105, 102)">${goods.name } &nbsp;&nbsp;&nbsp;&nbsp;细节展示</h2>
						 <form method="post" action="chggoods?gid=${goods.gid }">
						 <ul>
						 	<li>商品名称：${goods.name }</li>
						 	<li>商品现价：<input value="${goods.preprice }" name="preprice" type="text"/></li>
						 	<li>商品运费：<input value="${goods.transport }"  name="transport" type="text"/></li>
						 	<li>商品简介：<input value="${goods.info }" name="info" type="text"/></li>
						 	<li>商品详情：<input value="${goods.detail }" name="detail" type="text"/></li>
						 	<li>商品原料：<input value="${goods.material }" name="material" type="text"/></li>
							 <li>商品颜色：<input value="${goods.color }" name="color" type="text"/></li>
							 <li>商品风格：<input value="${goods.style }" name="style" type="text"/></li>
							 <li>商品品牌：<input value="${goods.brand }" name="brand" type="text"/></li>
							 <li><input type="submit" value="修改"/></li>
						 </ul>
						 </form>
						 <p>&nbsp;</p>
						 <p>&nbsp;</p>
						 <p>&nbsp;</p>
						 	<h2 style="color: rgb(2, 105, 102)">商品属性</h2><A href="javascript:void(0)" style="color: gray;" onclick="showTypeWindow()"><SPAN></SPAN>添加</A>
						 	<p>&nbsp;</p>
						 	<c:forEach items="${typeList }" var="type">
						 	<form method="post" action="">
						 	<p>${type.kind }&nbsp;&nbsp;&nbsp;<input type="text" value="${type.number }" name="number">&nbsp;&nbsp;&nbsp;<input type="submit" value="修改" onclick="javascript:this.form.action='chgtnum?tid=${type.tid}&gid=${goods.gid }'" ><span onclick="location.href='delsellertype?gid=${goods.gid }&kind=${type.kind }'" class="delet"><img width="10" width="10" src="images/delete.png"></span></p>
						 	</form>
						 	<p>&nbsp;</p>
						 	</c:forEach>
				  </div>				  					
		    </div>
		</div>	     				
		     <div class="clearfix"></div>
	  </div>	 
</div>
<!---->
<div class="footer-content">
	 <div class="container">
		 <div class="ftr-grids">
			 <div class="col-md-3 ftr-grid">
				 <h4>关于我们</h4>
				 <ul>
					 <li><a href="about">>品牌介绍</a></li>
					 <li><a href="about">>时尚产业</a></li>
					 <li><a href="about">>我们的认证</a></li>
					 <li><a href="about">>最近的新闻</a></li>
					<c:if test="${user.uid!=null }"><li><a href="contact?uid=${user.uid }">>留言</a></li></c:if>
					<c:if test="${user.uid==null }"><li><a href="javascript:void(0)" onclick="pleaseLogin(1,0)">>留言</a></li></c:if>				 
				 </ul>
			 </div>
			 <div class="col-md-3 ftr-grid">
				 <h4>条款和法规</h4>
				 <ul>
					 <li><a href="terms.jsp">>浏览</a></li>
					 <li><a href="terms.jsp">>登录注意</a></li>
					 <li><a href="terms.jsp">>注册规则</a></li>
					 <li><a href="terms.jsp">>不合法活动</a></li>
					 <li><a href="terms.jsp">>购物时注意</a></li>
				 </ul>
			 </div>
			 <div class="col-md-3 ftr-grid">
				 <h4>你的账户</h4>
				 <ul>
					 <li><c:if test="${user==null }"><a href="javascript:void(0)" onclick="pleaseLogin()">>您的账户</a></c:if><c:if test="${user!=null }"><a href="userinfo.jsp">您的账户</a></c:if></li>
					 <li><c:if test="${user==null }"><a href="javascript:void(0)" onclick="pleaseLogin(4,0)">>您的地址</a></c:if><c:if test="${user!=null }"><a href="getaddress.action?auid=${user.uid}">您的地址</a></c:if></li>
					 <li><c:if test="${user==null }"><a href="javascript:void(0)" onclick="pleaseLogin(5,0)">>您的购物车</a></c:if><c:if test="${user!=null }"><a href="getcart?uid=${user.uid }">您的购物车</a></c:if></li>
					 <li><c:if test="${user==null }"><a href="javascript:void(0)" onclick="pleaseLogin(3,0)">>您的订单</a></c:if><c:if test="${user!=null }"><a href="getorder?uid=${user.uid }">您的订单</a></c:if></li>
					 <li><c:if test="${user==null }"><a href="javascript:void(0)" onclick="pleaseLogin(2,0)">>您的收藏</a></c:if><c:if test="${user!=null }"><a href="getcollect?uid=${user.uid }">您的收藏</a></c:if></li>					 					 
				 </ul>
			 </div>
			 <div class="col-md-3 ftr-grid">
				 <h4>家具分类</h4>
				 <ul>
				 	<c:forEach var="firstCollection" items="${classifyTree }" begin="0" end="4" step="1">
					 <li><a href="firstsearch?keyword1=${firstCollection.key }">> ${firstCollection.key }</a></li>
					</c:forEach>		 
				 </ul>
			 </div>
			 <div class="clearfix"></div>
		 </div>
	 </div>
	  
	 </div>
<!---->

</body>
</html>