<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商家主页</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary JavaScript plugins) -->
<script type='text/javascript' src="js/jquery-1.11.1.min.js"></script>
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
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/index.js"></script>

  
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
<!--header//-->
<div class="product-model">	 
	 <div class="container">
			<ol class="breadcrumb">
		  <li class="active">商家主页</li>
		 </ol>
			<h2>我的产品</h2>			
		 <div class="col-md-9 product-model-sec">
		 <c:forEach items="${sellergoods }" var="goods">
		 <c:if test="${goods.message==null }">
					 <a href="sellersingle?gid=${goods.gid }">
					 <div class="product-grid love-grid">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/${fn:split(goods.photo,';')[0]}" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span><c:if test="${goods.flag==0 }">还未进行网站审核</c:if><c:if test="${goods.flag==1 }">已通过网站审核</c:if></button>
							</h4>
							</div>
						</div></a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust prt_name">
								<h4><a href="sellersingle?gid=${goods.gid }">${goods.name }</a></h4>
								<p>ID: ${goods.gid }</p>
								<c:if test="${goods.oriprice>goods.preprice }">
								<p>价格&nbsp;<span class="item_price"><del>${goods.oriprice }</del>&nbsp;&nbsp;&nbsp;${goods.preprice }</span></p>	
								</c:if>	
								<c:if test="${goods.oriprice<=goods.preprice }">
								<p>价格&nbsp;<span class="item_price">${goods.oriprice }</span></p>	
								</c:if>	
								<c:if test="${goods.preprice==0 }">
								<p>价格&nbsp;<span class="item_price">${goods.oriprice }</span></p>	
								</c:if>
								<c:if test="${goods.transport>0 }">
								<p>运费&nbsp;<span class="item_price">${goods.transport }</span></p>			
								</c:if>			
								<c:if test="${goods.transport==0 }">
								<p>包邮</p>			
								</c:if>		
								<input type="button" class="item_add items" value="编辑" onclick="location.href='sellersingle?gid=${goods.gid }'">
								<input type="button" class="item_add items" value="删除" onclick="location.href='sdelgoods?gid=${goods.gid}&uid=${user.uid }'" disabled="disabled">
							</div>													
							<div class="clearfix"> </div>
						</div>
					</div>	
					</c:if>
					 <c:if test="${goods.message!=null }">
					 <a href="#">
					 <div class="product-grid love-grid">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/${fn:split(goods.photo,';')[0]}" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>拒绝原因：${goods.message }</button>
							</h4>
							</div>
						</div></a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust prt_name">
								<h4><a>${goods.name }</a></h4>
								<p>ID: ${goods.gid }</p>
								<c:if test="${goods.oriprice>goods.preprice }">
								<p>价格&nbsp;<span class="item_price"><del>${goods.oriprice }</del>&nbsp;&nbsp;&nbsp;${goods.preprice }</span></p>	
								</c:if>	
								<c:if test="${goods.oriprice<=goods.preprice }">
								<p>价格&nbsp;<span class="item_price">${goods.preprice }</span></p>	
								</c:if>	
								<c:if test="${goods.preprice==0 }">
								<p>价格&nbsp;<span class="item_price">${goods.oriprice }</span></p>	
								</c:if>
								<c:if test="${goods.transport>0 }">
								<p>运费&nbsp;<span class="item_price">${goods.transport }</span></p>			
								</c:if>			
								<c:if test="${goods.transport==0 }">
								<p>包邮</p>			
								</c:if>		
								<input type="button" class="item_add items" value="删除后重新添加吧！" onclick="location.href='sdelgoods?gid=${goods.gid}&uid=${user.uid }'">
							</div>													
							<div class="clearfix"> </div>
						</div>
					</div>	
					</c:if>
					</c:forEach>
					
			</div> 
			<div class="rsidebar span_1_of_left">
				 <section  class="sky-form">
					 <h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>查询</h4>
					 <div class="row row1 scroll-pane">
						 <div class="col col-4">
						 		<label class="checkbox"><a href="sellergoods?uid=${user.uid }" style="color: gray;">全部商品</a></label>
						 		<label class="checkbox"><a href="getsdgoods?uid=${user.uid }" style="color: gray;">未通过审核商品(${sdgsum }件)</a></label>
						 		<label class="checkbox"><a href="getsrgoods?uid=${user.uid }" style="color: gray;">被拒绝的商品(${srgsum }件)</a></label>
						 <c:forEach items="${sthird }" var="st">
								<label class="checkbox"><a href="sellerthird?uid=${user.uid }&gtid=${st.tid}" style="color: gray;">${st.name }</a></label>
						</c:forEach>
						 </div>
					 </div>
				 </section> 				 				 
				   <section  class="sky-form">
						<h4 onclick=""><a href="selleraddgoods" style="color: rgb(2, 105, 102)"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>添加商品</a></h4>
						<h4 onclick=""><a href="getsorder?uid=${user.uid }" style="color: rgb(2, 105, 102)"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>商品发货</a><span class="unread">${osum }</span></h4>
				   </section>
			 </div>				 
	      </div>
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