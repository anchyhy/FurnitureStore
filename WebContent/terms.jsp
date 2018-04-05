<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>条款和法规</title>
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
			<td width="32%" align="right">账号</td>
			<td width="68%" align="left"><input type="hidden" id="sid" name="sid"/><input type="text" name="loginname"> </td>
		</tr>
		<tr>
			<td width="32%" align="right">密码</td>
			<td width="68%" align="left"><input type="hidden" id="sid" name="sid"/><input type="text" name="password"> </td>
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
					<c:if test="${user.uid==null }"><li><a href="javascript:void(0)" onclick="pleaseLogin()">留言</a></li>|</c:if>
					<c:if test="${user.uid!=null }"><li><a href="getcollect?uid=${user.uid }">我的收藏</a></li>|</c:if>
					<c:if test="${user.uid==null }"><li><a href="javascript:void(0)" onclick="pleaseLogin()">我的收藏</a></li>|</c:if>
					<c:if test="${user.uid!=null }"><li><a href="getorder?uid=${user.uid }">追踪订单</a></li></c:if>
					<c:if test="${user.uid==null }"><li><a href="javascript:void(0)" onclick="pleaseLogin()">追踪订单</a></li></c:if>
					
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
<!--about-->
<div class="terms">
	 <div class="container">
		  <div class="terms-sec-head">
				<h3>条目 & 法律法规</h3>
				<p>进行购物时必须遵守网站条目和法律法规哦.</p>
		  </div> 
		 <div class="term">
				<h4>1)&nbsp; 浏览</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras tempor quis lectus et aliquam. Morbi lobortis tincidunt est, nec sodales quam condimentum a. Integer sollicitudin ornare molestie. Nam vel ligula tincidunt, rutrum lorem ac, euismod leo. Nam ac placerat mauris. Maecenas in accumsan purus, vel facilisis mauris. Cras ac odio metus. Etiam vel congue est, malesuada vulputate lectus.</p>
		 </div>	
		 <div class="term">
				<h4>2)&nbsp; 登录注意</h4>
				<p>Curabitur tempus leo ipsum, nec pulvinar arcu lacinia a. In pretium in tortor vel dictum. Integer porttitor ante vitae finibus porttitor. Praesent elementum tellus at orci posuere, eu imperdiet risus tincidunt. Nunc arcu justo, semper at orci ac, condimentum viverra ligula.</p>
		 </div>	
		 <div class="term">
				<h4>3)&nbsp; 注册规则</h4>
				<p>When we send newsletters to subscribers we may allow advertisers or partners to include messages in those newsletters, or we may send dedicated newsletters on behalf of those advertisers or partners. To unsubscribe from a particular newsletter, click the "unsubscribe" link at the bottom of that email newsletter. If you would like to globally opt-out from ALL About.com email campaigns please send an with "Unsubscribe" in the subject line.</p>
		 </div>
			<div class="term">
				<h4>4)&nbsp; 不合法活动</h4>
				<p> Do not use Blogger to engage in illegal activities or to promote dangerous and illegal activities. For example, don't author a blog encouraging people to drink and drive. Please also do not use Blogger to sell or promote illegal drugs. Otherwise, we may delete your content. Also, in serious cases such as those involving the abuse of children, we may report you to the appropriate authorities.</p>
		 </div>
		 <div class="term">
				<h4>5)&nbsp; 购物时注意</h4>
				<p>Curabitur tempus leo ipsum, nec pulvinar arcu lacinia a. In pretium in tortor vel dictum. Integer porttitor ante vitae finibus porttitor. Praesent elementum tellus at orci posuere, eu imperdiet risus tincidunt. Nunc arcu justo, semper at orci ac, condimentum viverra ligula..</p>
		 </div>
		 <div class="term">
				<h4>6)&nbsp; 其他</h4>
				<p>Aenean sagittis finibus quam, eget lobortis felis varius quis. Phasellus nibh metus, pretium vitae nisi in, cursus cursus ex. Sed eget lorem sit amet dui finibus iaculis. Nulla a turpis turpis. Integer ut molestie nisl, ac dapibus dui. Nullam porttitor tincidunt porttitor. Integer vel arcu quis ex consequat maximus.</p>
				<li class="list">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</li>
				<li>Etiam nec nibh et nulla hendrerit laoreet et convallis arcu.</li>
				<li>Suspendisse porta elit at mauris mattis suscipit.</li>
				<li>Proin a dolor et tellus ullamcorper aliquam.</li>
				<li>Etiam nec nibh et nulla hendrerit laoreet et convallis arcu.</li>
				<li>Vivamus vehicula nibh nec urna malesuada porta.</li>
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
					<c:if test="${user.uid==null }"><li><a href="javascript:void(0)" onclick="pleaseLogin()">>留言</a></li></c:if>				 
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
					 <li><c:if test="${user==null }"><a href="javascript:void(0)" onclick="pleaseLogin()">>您的地址</a></c:if><c:if test="${user!=null }"><a href="getaddress.action?auid=${user.uid}">您的地址</a></c:if></li>
					 <li><c:if test="${user==null }"><a href="javascript:void(0)" onclick="pleaseLogin()">>您的购物车</a></c:if><c:if test="${user!=null }"><a href="getcart?uid=${user.uid }">您的购物车</a></c:if></li>
					 <li><c:if test="${user==null }"><a href="javascript:void(0)" onclick="pleaseLogin()">>您的订单</a></c:if><c:if test="${user!=null }"><a href="getorder?uid=${user.uid }">您的订单</a></c:if></li>
					 <li><c:if test="${user==null }"><a href="javascript:void(0)" onclick="pleaseLogin()">>您的收藏</a></c:if><c:if test="${user!=null }"><a href="getcollect?uid=${user.uid }">您的收藏</a></c:if></li>					 					 
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