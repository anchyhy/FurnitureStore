<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类查询</title>
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
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
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
<!--header//-->
<div class="product-model">	 
	 <div class="container">
			<ol class="breadcrumb">
		  <li class="active">Products</li>
		 </ol>
			<h2>你想要的：${keyword1 }</h2>
		 <div class="col-md-9 product-model-sec">
		 <c:forEach items="${goodsList1 }" var="goods">
					 <a href="single?gid=${goods.gid }&uid=${user.uid}"> <div class="product-grid love-grid">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img width="850" height="553" src="images/${fn:split(goods.photo,';')[0]}" class="img-responsive" alt="" />
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>查看详情</button>
							</h4>
							</div>
						</div></a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust prt_name">
								<h4><a href="single?gid=${goods.gid }&uid=${user.uid}">${goods.name }</a></h4>
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
								<input type="button" class="item_add items" value="加入收藏" onclick="location.href='addcollect?uid=${user.uid}&gid=${goods.gid }'">
							</div>													
							<div class="clearfix"> </div>
						</div>
					</div>	
					</c:forEach>
					<div>
					<c:if test="${searchflag==1 }"><c:if test="${pageNum>1 }"><a href="firstsearch?keyword1=${keyword1 }&pageNum=${pageNum-1 }&pageSize=${pageSize}" style="color: gray;">上一页</a></c:if><c:if test="${pageNum<(cfirst/9) }"><a style="color: gray;" href="firstsearch?keyword1=${keyword1 }&pageNum=${pageNum+1 }&pageSize=${pageSize}">下一页</a></c:if></c:if>
					<c:if test="${searchflag==2 }"><c:if test="${pageNum>1 }"><a href="discountsearch?keyword1=${keyword1 }&discount=${discount }&pageNum=${pageNum-1 }&pageSize=${pageSize}" style="color: gray;">上一页</a></c:if><c:if test="${pageNum<(cdiscount/9) }"><a style="color: gray;" href="discountsearch?keyword1=${keyword1 }&discount=${discount }&pageNum=${pageNum+1 }&pageSize=${pageSize}">下一页</a></c:if></c:if>
					<c:if test="${searchflag==3 }"><c:if test="${pageNum>1 }"><a href="stylesearch?sid=${sid }&keyword1=${keyword1 }&pageNum=${pageNum-1 }&pageSize=${pageSize}" style="color: gray;">上一页</a></c:if><c:if test="${pageNum<(cstyle/9) }"><a style="color: gray;" href="stylesearch?sid=${sid }&keyword1=${keyword1 }&pageNum=${pageNum+1 }&pageSize=${pageSize}">下一页</a></c:if></c:if>
					<c:if test="${searchflag==4 }"><c:if test="${pageNum>1 }"><a href="brandsearch?bid=${bid }&keyword1=${keyword1 }&pageNum=${pageNum-1 }&pageSize=${pageSize}" style="color: gray;">上一页</a></c:if><c:if test="${pageNum<(cbrand/9) }"><a style="color: gray;" href="brandsearch?bid=${bid }&keyword1=${keyword1 }&pageNum=${pageNum+1 }&pageSize=${pageSize}">下一页</a></c:if></c:if>
					<c:if test="${searchflag==5 }"><c:if test="${pageNum>1 }"><a href="materialsearch?mid=${mid }&keyword1=${keyword1 }&pageNum=${pageNum-1 }&pageSize=${pageSize}" style="color: gray;">上一页</a></c:if><c:if test="${pageNum<(cmaterial/9) }"><a style="color: gray;" href="materialsearch?mid=${mid }&keyword1=${keyword1 }&pageNum=${pageNum+1 }&pageSize=${pageSize}">下一页</a></c:if></c:if>
					<c:if test="${searchflag==6 }"><c:if test="${pageNum>1 }"><a href="price?keyword1=${keyword1 }&pageNum=${pageNum-1 }&pageSize=${pageSize}&pricefrom=${pricefrom }&priceto=${priceto }" style="color: gray;">上一页</a></c:if><c:if test="${pageNum<(cprice/9) }"><a style="color: gray;" href="price?keyword1=${keyword1 }&pageNum=${pageNum+1 }&pageSize=${pageSize}&pricefrom=${pricefrom }&priceto=${priceto }">下一页</a></c:if></c:if>
					<c:if test="${searchflag==7 }"><c:if test="${pageNum>1 }"><a href="transport?keyword1=${keyword1 }&pageNum=${pageNum-1 }&pageSize=${pageSize}" style="color: gray;">上一页</a></c:if><c:if test="${pageNum<(ctransport/9) }"><a style="color: gray;" href="transport?keyword1=${keyword1 }&pageNum=${pageNum+1 }&pageSize=${pageSize}">下一页</a></c:if></c:if>
					</div>
			</div> 
			
			<div class="rsidebar span_1_of_left">
				 <section  class="sky-form">
					 <h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>折扣</h4>
					 <div class="row row1 scroll-pane">
						 <div class="col col-4">
								<label class="checkbox"><input type="radio" name="discount" onclick="location.href='discountsearch?keyword1=${keyword1 }&discount=0'"><i></i>低于1折 (${session.d[0] })</label>
								<label class="checkbox"><input type="radio" name="discount" onclick="location.href='discountsearch?keyword1=${keyword1 }&discount=1'"><i></i>1折 - 2折 (${session.d[1] })</label>
								<label class="checkbox"><input type="radio" name="discount" onclick="location.href='discountsearch?keyword1=${keyword1 }&discount=2'"><i></i>2折 - 3折 (${session.d[2] })</label>
								<label class="checkbox"><input type="radio" name="discount" onclick="location.href='discountsearch?keyword1=${keyword1 }&discount=3'"><i></i>3折 - 4折 (${session.d[3] })</label>
								<label class="checkbox"><input type="radio" name="discount" onclick="location.href='discountsearch?keyword1=${keyword1 }&discount=4'"><i></i>4折 - 5折 (${session.d[4] })</label>
								<label class="checkbox"><input type="radio" name="discount" onclick="location.href='discountsearch?keyword1=${keyword1 }&discount=5'"><i></i>高于5折 (${session.d[5] })</label>
						 </div>
					 </div>
				 </section> 				 				 
				   <section  class="sky-form">
						<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>价格区间</h4>
							<form action="price?keyword1=${keyword1 }" method="post">
					 			<input type="text" class="item_quantity" name="pricefrom" placeholder="price from" required />
					 			<input type="text" class="item_quantity" name="priceto" placeholder="price to" required />
					 			<input type="submit" value="确定">
					 		</form>
							
				   </section>
				   <section  class="sky-form">
						<h4><span class="glyphicon glyphicon-minus" aria-hidden="true" onclick="location.href='transport'"></span><a href="transport?keyword1=${keyword1 }" style="color: rgb(2, 105, 102)">包邮</a></h4>
				   </section>
				   <!---->
					 <script type="text/javascript" src="js/jquery-ui.min.js"></script>
					 <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
					<script type='text/javascript'>//<![CDATA[ 
					$(window).load(function(){
					 $( "#slider-range" ).slider({
								range: true,
								min: 0,
								max: 400000,
								values: [ 8500, 350000 ],
								slide: function( event, ui ) {  $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
								}
					 });
					$( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) + " - $" + $( "#slider-range" ).slider( "values", 1 ) );

					});//]]> 
					</script>
					 <!---->
					 <section  class="sky-form">
						<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>风格</h4>
							<div class="row row1 scroll-pane">
								<div class="col col-4">
									<c:forEach items="${styleList }" var="style">
									<c:if test="${style.name!='其他' }">
									<label class="checkbox"><input type="radio" name="sid" onclick="location.href='stylesearch?sid=${style.sid }&keyword1=${keyword1 }'"><i></i>${style.name }</label>
									</c:if>
									</c:forEach>
								</div>
							</div>
				   </section>
				   		<section  class="sky-form">
						<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>品牌</h4>
							<div class="row row1 scroll-pane">
								<div class="col col-4">
									<c:forEach items="${brandList }" var="brand">
									<c:if test="${brand.name!='其他' }">
										<label class="checkbox"><input type="radio" name="bid" onclick="location.href='brandsearch?bid=${brand.bid}&keyword1=${keyword1 }'"><i></i>${brand.name }</label>
									</c:if>
									</c:forEach>
									</div>
							</div>
				   </section>
				   <section  class="sky-form">
						<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>质地</h4>
							<div class="row row1 scroll-pane">
								<div class="col col-4">
								<c:forEach items="${materialList }" var="material">
								<c:if test="${material.name!='其他' }">
										<label class="checkbox"><input type="radio" name="mid" onclick="location.href='materialsearch?mid=${material.mid}&keyword1=${keyword1 }'"><i></i>${material.name }</label>
								</c:if>
								</c:forEach>
									</div>
								
							</div>
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
</div>
<!---->
</body>
</html>