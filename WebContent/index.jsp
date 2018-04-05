<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
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
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/menu_jquery.js"></script>
<script src="js/simpleCart.min.js"> </script>
<script src="js/responsiveslides.min.js"></script>
<script type="text/javascript" src="js/myjs.js" language="javascript" charset="gb2312"></script>
<script>
    // You can also use "$(window).load(function() {"
    $(function () {
      // Slideshow 1
      $("#slider1").responsiveSlides({
         auto: true,
		 nav: true,
		 speed: 500,
		 namespace: "callbacks",
      });
    });
  </script>
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
			<td width="32%" align="right"><input type="hidden" name="loginflag" id="lf">账号</td>
			<td width="68%" align="left"><input type="text" name="loginname"> </td>
		</tr>
		<tr>
			<td width="32%" align="right">密码</td>
			<td width="68%" align="left"><input type="password" name="password"> </td>
		</tr>
		<tr>
		<td colspan="2" align="center"><input name="submit" type="submit" id="submit" value="登录" class="button">
				<input name="cancel" type="button" id="cancel" value="取消" class="button" onclick="closeLoginWindow()"></td>
		</tr>
		<tr> <td colspan="2" align="right"><a href="logintoaccount"><h6>>>>>去注册</h6></a></td></tr>
	</table>
	</form>
</div>
</div> 
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
<div class="content">
	 <div class="container">
		 <div class="slider">
				<ul class="rslides" id="slider1">
				<c:forEach items="${slideList }" var="slide">
				  <li><img src="images/${slide.photo }" alt=""></li>
				  </c:forEach>
				</ul>
		 </div>
	 </div>
</div>
<!---->

<!---->
<div class="new">
	 <div class="container">
		 <h3>最近特价</h3>
		 <div class="new-products">
		 <div class="new-items">
			 <div class="item1">
				 <a href="single?gid=${specialList[0].gid }&uid=${user.uid}"><img src="images/${fn:split(specialList[0].photo,';')[0]}" alt=""/></a>
				 <div class="item-info">
					 <h4><a href="single?gid=${specialList[0].gid }&uid=${user.uid}">${specialList[0].name }</a></h4>
					 <span>ID: ${specialList[0].gid }</span>
					 <a href="single?gid=${specialList[0].gid }&uid=${user.uid}">立即查看</a>
				 </div>
			 </div>
			 <div class="item4">
				 <a href="single?gid=${specialList[1].gid }&uid=${user.uid}"><img src="images/${fn:split(specialList[1].photo,';')[0]}" alt=""/></a>
				  <div class="item-info4">
					 <h4><a href="single?gid=${specialList[1].gid }&uid=${user.uid}">${specialList[1].name }</a></h4>
					 <span>ID: ${specialList[1].gid }</span>
					 <a href="single?gid=${specialList[1].gid }&uid=${user.uid}">立即查看</a>
				 </div>			 
			 </div>
		 </div>
		 <div class="new-items new_middle">
			 <div class="item2">			 
				 <div class="item-info2">
					 <h4><a href="single?gid=${specialList[2].gid }&uid=${user.uid}">${specialList[2].name }</a></h4>
					 <span>ID: ${specialList[2].gid }</span>
					<a href="single?gid=${specialList[2].gid }&uid=${user.uid}">立即查看</a>
				 </div>
				 <a href="single?gid=${specialList[2].gid }&uid=${user.uid}"><img src="images/${fn:split(specialList[2].photo,';')[0]}" alt=""/></a>
			 </div>
			 <div class="item5">	
				 <a href="single?gid=${specialList[3].gid }&uid=${user.uid}"><img src="images/${fn:split(specialList[3].photo,';')[0]}" alt=""/></a>
				 <div class="item-info5">
					 <h4><a href="single?gid=${specialList[3].gid }&uid=${user.uid}">${specialList[3].name }</a></h4>
					 <span>ID: ${specialList[3].gid }</span>
					 <a href="single?gid=${specialList[3].gid }&uid=${user.uid}">立即查看</a>
				 </div>	
			 </div>
		 </div>		  
		 <div class="new-items new_last">
			 <div class="item3">	
				 <a href="single?gid=${specialList[4].gid }&uid=${user.uid}"><img src="images/${fn:split(specialList[4].photo,';')[0]}" alt=""/></a>
				 <div class="item-info3">
					 <h4><a href="single?gid=${specialList[4].gid }&uid=${user.uid}">${specialList[4].name }</a></h4>
					 <span>ID: ${specialList[4].gid }</span>
					 <a href="single?gid=${specialList[4].gid }&uid=${user.uid}">立即查看</a>
				 </div>			 
			 </div>
			 <div class="item6">	
				 <a href="single?gid=${specialList[5].gid }&uid=${user.uid}"><img src="images/${fn:split(specialList[5].photo,';')[0]}" alt=""/></a>
				 <div class="item-info6">
					 <h4><a href="single?gid=${specialList[5].gid }&uid=${user.uid}">${specialList[5].name }</a></h4>
					 <span>ID: ${specialList[5].gid }</span>
					 <a href="single?gid=${specialList[5].gid }&uid=${user.uid}">Buy Now</a>
				 </div>
				 				 
			 </div>
		 </div>
		 <div class="clearfix"></div>	
		 </div>
	 </div>		 
</div>
<!---->
<div class="top-sellers">
	 <div class="container">
		 <h3>top销量</h3>
		 <div class="seller-grids">
		 <c:forEach items="${topList }" var="top">
			 <div class="col-md-3 seller-grid">
				 <a href="single?gid=${top.gid }&uid=${user.uid}"><img src="images/${fn:split(top.photo,';')[0]}" alt=""/></a>
				 <h4><a href="single?gid=${top.gid }&uid=${user.uid}">${top.name }</a></h4>
				 <span>ID: ${top.gid }</span>
				 <p>Rs. ${top.preprice }/-</p>
			 </div>
		</c:forEach>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>
<!---->
<div class="recommendation">
	 <div class="container">
		 <div class="recmnd-head">
			 <h3>新品上架</h3>
		 </div>
		 <div class="bikes-grids">			 
			 <ul id="flexiselDemo1">
				 <li>
					 <a href="single?gid=${newList[0].gid }&uid=${user.uid}"><img src="images/${fn:split(newList[0].photo,';')[0]}" alt=""/></a>	
					 <h4><a href="single?gid=${newList[0].gid }&uid=${user.uid}">${newList[0].name }</a></h4>	
					 <p>ID: ${newList[0].gid }</p>
				 </li>
				 <li>
					 <a href="single?gid=${newList[1].gid }&uid=${user.uid}"><img src="images/${fn:split(newList[1].photo,';')[0]}" alt=""/></a>	
					 <h4><a href="single?gid=${newList[1].gid }&uid=${user.uid}">${newList[1].name }</a></h4>	
					 <p>ID: ${newList[1].gid }</p>
				 </li>
				 <li>
					 <a href="single?gid=${newList[2].gid }&uid=${user.uid}"><img src="images/${fn:split(newList[2].photo,';')[0]}" alt=""/></a>	
					 <h4><a href="single?gid=${newList[2].gid }&uid=${user.uid}">${newList[2].name }</a></h4>	
					 <p>ID: ${newList[2].gid }</p>
				 </li>
				 <li>
					 <a href="single?gid=${newList[3].gid }&uid=${user.uid}"><img src="images/${fn:split(newList[3].photo,';')[0]}" alt=""/></a>	
					 <h4><a href="single?gid=${newList[3].gid }&uid=${user.uid}">${newList[3].name }</a></h4>	
					 <p>ID: ${newList[3].gid }</p>
				 </li>
				 <li>
					 <a href="single?gid=${newList[4].gid }&uid=${user.uid}"><img src="images/${fn:split(newList[4].photo,';')[0]}" alt=""/></a>	
					 <h4><a href="single?gid=${newList[4].gid }&uid=${user.uid}">${newList[4].name }</a></h4>	
					 <p>ID: ${newList[4].gid }</p>
				 </li>
				 <li>
					 <a href="single?gid=${newList[5].gid }&uid=${user.uid}"><img src="images/${fn:split(newList[5].photo,';')[0]}" alt=""/></a>	
					 <h4><a href="single?gid=${newList[5].gid }&uid=${user.uid}">${newList[5].name }</a></h4>	
					 <p>ID: ${newList[5].gid }</p>
				 </li>
				 <li>
					 <a href="single?gid=${newList[6].gid }&uid=${user.uid}"><img src="images/${fn:split(newList[6].photo,';')[0]}" alt=""/></a>	
					 <h4><a href="single?gid=${newList[6].gid }&uid=${user.uid}">${newList[6].name }</a></h4>	
					 <p>ID: ${newList[6].gid }</p>
				 </li>
				 <li>
					 <a href="single?gid=${newList[7].gid }&uid=${user.uid}"><img src="images/${fn:split(newList[7].photo,';')[0]}" alt=""/></a>	
					 <h4><a href="single?gid=${newList[7].gid }&uid=${user.uid}">${newList[7].name }</a></h4>	
					 <p>ID: ${newList[7].gid }</p>
				 </li>
				 
		    </ul>
			<script type="text/javascript">
			 $(window).load(function() {			
			  $("#flexiselDemo1").flexisel({
				visibleItems: 5,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,    		
				pauseOnHover:true,
				enableResponsiveBreakpoints: true,
				responsiveBreakpoints: { 
					portrait: { 
						changePoint:480,
						visibleItems: 1
					}, 
					landscape: { 
						changePoint:640,
						visibleItems: 2
					},
					tablet: { 
						changePoint:768,
						visibleItems: 3
					}
				}
			});
			});
			</script>
			<script type="text/javascript" src="js/jquery.flexisel.js"></script>			 
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
</div>
<!---->
<!---->
</body>
</html>