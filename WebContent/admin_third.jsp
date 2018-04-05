<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/cart.css"/>
<!-- 弹出添加三级级分类窗口 -->
<LINK rel="stylesheet" href="css/mycss.css">
<script type="text/javascript">
function chgThirdWindow(e){
	if(confirm("确定更改三级分类名称吗？")){
    	document.getElementById("thirdid").value=e;
    	document.getElementById('window_chgthird').style.display='block';
    	document.getElementById('fade').style.display='block';
	}
}
function closeChgThirdWindow(){
	document.getElementById('window_chgthird').style.display='none';
	document.getElementById('fade').style.display='none';
} 
</script>
<script type="text/javascript">
function showThirdWindow(e){
	if(confirm("确定要在此二级分类下添加三级分类吗？")){
	document.getElementById('sid').value=e;
    	document.getElementById('window_third').style.display='block';
    	document.getElementById('fade').style.display='block';
	}
    }
    function closeThirdWindow(){
    	document.getElementById('window_third').style.display='none';
    	document.getElementById('fade').style.display='none';
    }
</script>
<div id="window_chgthird" class="window">
<div class="window_title">
	<H2>修改三级级分类</H2>
</div>
<div class="window_content">
<form action="chgthird" method="post">
	<table width="34%">
		<tr>
			<td width="32%" align="right">三级属名称：</td>
			<td width="68%" align="left"><input type="hidden" name="tid" id="thirdid"/><input type="text" name="name"> </td>
		</tr>
		<tr>
		<td colspan="2" align="center"><input name="submit" type="submit" id="submit" value="确认修改" class="button">
				<input name="cancel" type="button" id="cancel" value="取消" class="button" onclick="closeChgThirdWindow()"></td>
		</tr>
	</table>
	</form>
</div>
</div> 
<!-- 添加三级级分类div -->
<div id="fade" class="black_overlay"></div> 
<div id="window_third" class="window">
<div class="window_title">
	<H2>添加三级级分类</H2>
</div>
<div class="window_content">
<form action="addthird" method="post">
	<table width="34%">
		<tr>
			<td width="32%" align="right">三级属名称：</td>
			<td width="68%" align="left"><input type="hidden" id="sid" name="sid"/><input type="text" name="name"> </td>
		</tr>
		<tr>
		<td colspan="2" align="center"><input name="submit" type="submit" id="submit" value="添加" class="button">
				<input name="cancel" type="button" id="cancel" value="取消" class="button" onclick="closeThirdWindow()"></td>
		</tr>
	</table>
	</form>
</div>
</div> 
</head>
<body>
	<div class="catbox">
		<form action="" method="post">
			<table style="margin-top: 200" border="1" id="cartTable">
			<h1 align="center">管理三级分类</h1>
	<p>&nbsp;</p>
				<tr>
					<th>所属二级目录id</th>
					<th>分类名称</th>
				</tr>

				<c:forEach items="${thirdList }" var="third">
					<tr>
						<td>${third.key } <p><A href="javascript:void(0)" onclick="showThirdWindow(${fn:split(third.key,'.')[0] })" style="color: gray;"><SPAN></SPAN>添加</A></p></td>
						<td><c:forEach items="${third.value }" var="th">
								<p>${fn:split(th,'.')[1] }
									<input type="button" onclick="chgThirdWindow(${fn:split(th,'.')[0] })" value="修改"/>
								</p>
							</c:forEach></td>
					</tr>
				</c:forEach>

			</table>
		</form>
	</div>
</body>
</html>