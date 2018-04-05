<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Random"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品详情</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/verticleslide.css" rel='stylesheet' type='text/css' />
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
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/scroll.js"></script>
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/menu_jquery.js"></script>
<script src="js/simpleCart.min.js"> </script>
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
<!-- //etalage-->
<script>
$(function(){
	$('.size').click(function(){
		$(this).siblings().removeClass('selected');
		$(this).addClass('selected');
		$('#size_value').val($(this).text());
	});
	$('.button').click(function(){
		if($('#size_value').val() == ''){
			alert('请先选择属性');
		}
		if($('#size_value').val() != ''){
			var kind = document.getElementById('size_value').value;
			 var quantity = document.getElementById('quantity').value;
			 window.location.href = "goorder?uid=${user.uid}&gid=${goods.gid }&kind="+kind+"&quantity="+quantity;
		}
	});
	$('.button1').click(function(){
		if($('#size_value').val() == ''){
			alert('请先选择属性');
		}
		if($('#size_value').val() != ''){
			 var kind = document.getElementById('size_value').value;
			 var quantity = document.getElementById('quantity').value;
			 window.location.href = "addcart?uid=${user.uid }&gid=${goods.gid}&kind="+kind+"&quantity="+quantity;
		}
	});
});
</script>
<style>
.size {
	border: #EFEFEF 2px solid;
	padding: 7px;
}
.size:not (.selected ):hover {
	border: #BFBFBF 2px solid;
	padding: 7px;
}
.size.selected {
	border: #C30008 2px solid;
	padding: 7px;
}
.button {
	background-color: #026466;
	border-radius: 5px;
	padding: 10px;
}
.button:active {
	background-color: #f5f5f5;
}
.button1 {
	background-color: #f5f5f5;
	border-radius: 5px;
	padding: 10px;
}
.button1:active {
	background-color: #026466;
}
.button2 {
	background-color: #026466;
	border-radius: 5px;
	padding: 10px;
}
.button2:active {
	background-color: #f5f5f5;
}
.button3 {
	background-color: #f5f5f5;
	border-radius: 5px;
	padding: 10px;
}
.button3:active {
	background-color: #026466;
}

</style>
<!-- 弹出登录窗口 -->
<LINK rel="stylesheet" href="css/mycss.css">
<script type="text/javascript" src="js/myjs.js" charset="gbk"></script>
<!-- 登录div -->
<div id="fade" class="black_overlay"></div> 
<div id="window_login" class="window">
<div class="window_title">
	<H2>请先登录才能进行此操作哦!</H2>
</div>
<div class="window_content">
<form action="login" method="post">
	<table width="34%">
		<tr>
			<td width="32%" align="right">账号</td>
			<td width="68%" align="left"><input type="hidden" id="lf" name="loginflag"/><input type="text" name="loginname"> </td>
		</tr>
		<tr>
			<td width="32%" align="right">密码</td>
			<td width="68%" align="left"><input type="hidden" id="goodsid" name="gid"/><input type="password" name="password"> </td>
		</tr>
		<tr>
		<td colspan="2" align="center"><input name="submit" type="submit" id="submit" value="登录" class="button">
				<input name="cancel" type="button" value="取消" class="button" onclick="closeLoginWindow()"></td>
		</tr>
		<tr> <td colspan="2" align="right"><a href="account.jsp"><h6>>>>>去注册</h6></a></td></tr>
	</table>
	</form>
</div>
</div> 
${showMessage }
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
					<li class="top_link"><a href="login.jsp">亲，请登录/注册！</a></li>	
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
				 <p><a href="userinfo.jsp" class="simpleCart_empty">欢迎登录，${session.user.nickname }!</a></p>
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
<div class="mega_nav">
	 <div class="container">
		 <div class="menu_sec">
		 <!-- start header menu -->
		 <ul class="megamenu skyblue">
			 <li class="active grid"><a class="color1" href="init">主页</a></li>
		<c:forEach var="firstCollection" items="${classifyTree }">
			 <li class="grid">
			 <a class="color<%=(int)(Math.random()*4+4) %>" href="#">${firstCollection.key } </a>
				<div class="megapanel">
					<div class="row">
					<c:forEach var="secondCollection" items="${firstCollection.value }">
						<div class="col1">
							<div class="h_nav">
								<h4>${secondCollection.key }</h4>
								<ul>
									<c:forEach var="thirdCollection" items="${secondCollection.value }">
									<li><a href="firstsearch?keyword1=${thirdCollection }">${thirdCollection }</a></li>
									</c:forEach>
								</ul>	
							</div>							
						</div>
						</c:forEach>
					</div>
					<div class="row">
						<div class="col2"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
					</div>
    				</div>
				</li>
				</c:forEach>
			</ul> 
			   <div class="search">
				 <form action="firstsearch">
					<input type="text" name="keyword1" placeholder="查找...">
					<input type="submit" value="">
					</form>
			 </div>
			 <div class="clearfix"></div>
		 </div>
	  </div>
</div>
<!---->
<div class="single-sec">
	 <div class="container">
		 <ol class="breadcrumb">
			 <li class="active">商品详情</li>
		 </ol>
		 <!-- start content -->	
			<div class="col-md-9 det">
				  <div class="single_left">
					 <div class="grid images_3_of_2">
						 <ul id="etalage">
						 <c:forEach items="${fn:split(goods.photo,';')}" var="photo" >
								<li>
								<img class="etalage_thumb_image" src="images/${photo }" class="img-responsive" />
								<img class="etalage_source_image" src="images/${photo }" class="img-responsive" title="" />
								</li>
							</c:forEach>
						 </ul>
						 <div class="clearfix"></div>		
				      </div>
				  </div>
				  <div class="single-right">
					 <h3>${goods.name }</h3>
					 <div class="id"><h4>ID: ${goods.gid }</h4></div>
					  <form action="" class="sky-form">
						     <fieldset>					
							   <section>
							     <div class="rating">
							     <c:forEach begin="1" end="${goods.evaluate }" step="1">
									<input type="radio" name="stars-rating" id="stars-rating-5">
									<label for="stars-rating-5"><i class="icon-star"></i></label>
								</c:forEach>
									<div class="clearfix"></div>
								 </div>
							  </section>
						    </fieldset>
					  </form>
					  <div class="cost">
						<div class="prdt-cost">
							<ul>
								<c:if test="${goods.oriprice>goods.preprice }">
									<li><del>原价${goods.oriprice}</del></li>
									<li>现价</li>
									<li class="active">${goods.preprice }</li>
								</c:if>
								<c:if test="${goods.oriprice<=goods.preprice }">
									<li>现价</li>
									<li class="active">${goods.preprice }</li>
								</c:if>
								<c:if test="${goods.preprice==0 }">
									<li>现价</li>
									<li class="active">${goods.oriprice }</li>
								</c:if>
								<li>运费: <c:if test="${goods.transport==0 }"> 包邮</c:if> <c:if
										test="${goods.transport>0 }">${goods.transport }</c:if></li>

							</ul>
						</div>
						<div class="clearfix"></div>
					</div>
					<c:if test="${typeList!=null }">
					<form action="" method="post">
						选择属性：
						<c:forEach items="${typeList }" var="type">
							<input type="hidden" name="kind" id="size_value" value="${type.kind }"><a class="size">${type.kind }</a>
						</c:forEach>
						<p>&nbsp;</p>
						<p>&nbsp;</p>
						<table>
							<tr>
								<td>选择个数：</td>
								<td><input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small"></td>
							</tr>
						</table>
						<p>&nbsp;</p>
						<p>&nbsp;</p>
						<c:if test="${user==null }">
							<table>
								<tr>
									<td width="200"><p><input type="button" class="button2" value="加入购物车" style="width: 150px;" onclick="pleaseLogin(6,${goods.gid })"/></p></td>
									<td><input type="button" class="button3" value="立即购买" style="width: 150px;" onclick="pleaseLogin(6,${goods.gid})"/></p></td>
								</tr>
							</table>
						</c:if>
						<c:if test="${user!=null }">
						
						
							<table>
								<tr>
									<td width="200"><p><input onclick="javascript:this.form.action='addcart?uid=${user.uid }&gid=${goods.gid}'" type="button" class="button1" value="加入购物车" style="width: 150px;" /></p></td>
									<td><input onclick="javascript:this.form.action='goorder?uid=${user.uid}&gid=${goods.gid }'" type="button" class="button" value="立即购买" style="width: 150px;" /></td>
									
								</tr>
							</table>
							</c:if>
					</form>
					</c:if>
					<p>&nbsp;</p>
					  <div class="item-list">
						 <ul>
							 <li><a href="#">Click here for more details</a></li>
						 </ul>
					  </div>
					  <div class="single-bottom1">
						<h6>商品简介</h6>
						<p class="prod-desc">${goods.info }</p>
					 </div>					 
				  </div>
				  <div class="clearfix"></div>
				  <div class="sofaset-info">
					<h4>${goods.name }&nbsp;&nbsp;&nbsp;&nbsp;细节展示</h4>
					<ul>
						<li>Material:${goods.gmaterial.name}材质。 ${goods.material }</li>
						<li>Color: ${goods.color }</li>
						<li>Style:${goods.gstyle.name }风格。 ${goods.style }</li>
						<li>Brand:${goods.gbrand.name}品牌。 ${goods.brand }</li>
					</ul>
				</div>			  					
		    </div>
		    <c:if test="${user!=null }">
		    <c:if test="${!empty recentList }" >
			<div class="rsidebar span_1_of_left">
				 <section  class="sky-form">
					 <h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>最近浏览</h4>
					 <div class="list_lh">
			<ul>
			<c:forEach items="${recentList }" var="recent">
				<li >
					<p><a href="single?gid=${recent.gid }&uid=${user.uid}"><img alt="" src="images/${fn:split(recent.photo,';')[0] }" width="120" height="90"></a></p>
					<p><a href="single?gid=${recent.gid }&uid=${user.uid}" class="a_blue">${recent.name }</a><span>${recent.preprice }</span></p>
				</li>
				</c:forEach>
			</ul>
		</div>
		<!--script-->
		<script type="text/javascript">
			$(document).ready(function(){
				$('.list_lh li:even').addClass('lieven');
				})
				$(function(){
				$("div.list_lh").myScroll({
					speed:40, //数值越大，速度越慢
					rowHeight:68 //li的高度
				});
			});
		</script>
		<!-- script -->			
		</section> 				  
			   </div>
			   </c:if>
			   <c:if test="${empty recentList }" >
			<div class="rsidebar span_1_of_left">
				 <section  class="sky-form">
					 <h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>无最近浏览</h4>
			   </c:if>
			   </c:if>
		</div>	     				
		     <div class="clearfix"></div>
	  </div>	 
</div>

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
</div>
<!---->
</body>
</html>