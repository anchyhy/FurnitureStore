<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>关于</title>
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
<!---- tabs---->
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
<!---->
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
				 <p><a href="" class="simpleCart_empty">欢迎登录，${session.user.nickname }!</a></p>
				 
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
	 
<!------>
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
<!--abouot-->
<div class="about">
	 <div class="container">
		 <div class="about-info">
		 <h2>关于我们</h2>
		 <div class="about-pic">
		 <img src="images/logo.png" alt="">
		 </div>
		 <div class="about-text">
			<p>网站介绍</p>
			网购系统正如雨后春笋般的速度繁荣发展着，但是目前的网购具有很大的局限性，大部分消费者只是通过电商购买像服装，小型家电等，对于像沙发，床等大型家具却很少有专门的规范网站，然而去实体店购买家具需要耗费大量的时间，运送也十分麻烦。我们的家具自助选购网站在保证家具质量最优价格最低的情况下使您足不出户可以购买到更加合适的大型家装设备，省时省力还节约了您的支出哦！
		 </div>	
			<div class="clearfix"></div>	
			
		 <div class="about-section">
			 <div class="brands">
				 <h3>我们的品牌来源</h3>
				 C2C模式起源于美国，国外的C2C市场拥有成熟的网络市场环境、交易环境和物流环境。而自C2C的电子商务模式正式进入中国以来，中国的C2C电子商务市场发展飞速，随着网民不断增加的网购需求和网购市场的不断成熟，C2C模式的电子商务市场的巨大发展潜力逐渐展现，具体体现在网络购物人数和网络购物消费规模的增长这两个方面。 
				 <p>品牌介绍</p>
			 </div>
			 <div class="Fashion">
				 <div class="col-md-6 about-lists">
					 <h4>您可以在我们的网站：</h4>
					 <ul>
						 <li>注册一个属于自己的账户哦~</li>
						 <li>根据需要搜索出您想要的家具来装扮您可爱的家哦~</li>
						 <li>把感兴趣的家具商品加入您的购物车和收藏哦~</li>
						 <li>购买想要的家具商品，在家等着它来哦~</li>
						 <li>有什么心得、疑问，可以给我们留言哦~</li>
					 </ul>
					 <p>&nbsp;</p>
					 <h4>心动了吗，赶紧开始属于您的购物体验吧！</h4>
				 </div>
				 <div class="col-md-6 news">
					 <h4><a href="allnews">网站新闻</a></h4>	
					 <c:forEach items="${newsList }" var="news">					
							<div class="LatestNews">
								<h6>${news.title }</h6>
								<span>${news.time } </span>
								<marquee><p>${news.content }</p> </marquee>
							</div>			
						</c:forEach>
				 </div>
				 <div class="clearfix"></div>
			       </div>
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