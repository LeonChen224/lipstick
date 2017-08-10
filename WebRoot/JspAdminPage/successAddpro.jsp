<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>成功加入购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="application/x-javascript"> 
		addEventListener("load", function() {
			setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
	</script>
	<!-- <link href='http://fonts.useso.com/css?family=Archivo+Narrow:400,700' rel='stylesheet' type='text/css'>
 -->	<!--fonts-->
	<!--link css-->
	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="css/demo.css" />
	<!--bootstrap-->
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<!--coustom css-->
	<link href="css/style.css" rel="stylesheet" type="text/css"/>
	<!--default-js-->
	<link href="css/main.css" rel="stylesheet" type="text/css"/>
	<script src="js/jquery-2.1.4.min.js"></script>
	<!--bootstrap-js-->
	<script src="js/bootstrap.min.js"></script>
	<!--script-->
  </head>
  
  <body>

        <div class="validAddCart_mid">
 

        	<div class="validAddCart_success">
        		<div class="validAddCart_success_text">
        			<img src="./images/gou.png">已成功添加商品
        		</div>
        		<br><br>
        		<div class="back_or_cal">
        			<div class="back_or_cal1">
        			<a href="JspAdminPage/addProduct.jsp" > 《返回继续添加 </a>
        			</div>       			
        			&nbsp;&nbsp;
        			<div class="back_or_cal2">
        			<a href="AdminAllProductsServlet" >查看所有商品</a>       			
        			</div>
        		</div>
        	</div>
        	
        </div>

  </body>
</html>
