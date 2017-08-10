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
 
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<title>login</title>
	<script type="application/x-javascript"> 
		addEventListener("load", function() {
			setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
		</script>

	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="css/demo.css" />
	<!--bootstrap-->
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<!--coustom css-->
	<link href="css/style.css" rel="stylesheet" type="text/css"/>
	<!--default-js-->
	<script src="js/jquery-2.1.4.min.js"></script>
	<!--bootstrap-js-->
	<script src="js/bootstrap.min.js"></script>
	<!--script-->
    <link rel="stylesheet" href="assets_login/css/reset.css">
    <link rel="stylesheet" href="assets_login/css/supersized.css">
    <link rel="stylesheet" href="assets_login/css/style.css">
<style type="text/css">
 .register_top{
 	width: 100%;
 	height: 50px;
 	background-color: #b9b8b9;

 }
 .register_top_left{
 	float: left;
 }

 .register_logo a{
 	color: white;
 	font-size: 20px;
 	font-weight: bold;
 	text-decoration: none;
 }

 .register_logo{
 	padding-top: 15px;
 	padding-left: 20px;
 }

 .miandenglu{
     width: 42px;
     margin-top: 40px;

     float: left;
     position: relative;
     left: 80px;
 }

 .miandenglu_text{
     float: left;
     margin-top: 18px;
     position: relative;
     left: 80px;
     color: black;
     font-weight: bold;
 }

.yanzhengcode{
	width:160px;
	float:left;
	margin-left:15px;
}

.yanzhengpic{
	margin-top:27px;
}

.miandenglu{
	width:20px;
	height:20px;
	position:relative;
	left:-80px;
	top:12px;
}

.miandenglu_text{
	position:relative;
	left:-60px;
}
</style>

  
  <script type="text/javascript">
	 function changeImage(img){
	 	img.src=img.src+"?"+new Date().getTime();
	}
	 function dosubmit(){
	//防止表单重复提交
	  	var input=document.getElementById("submit");
	 	 input.disabled=disabled;
	  	return true;
	} 
 </script>
  
  <body>
  	<div class="register_top">
        	<div class="register_top_left">
        		<div class="register_logo">
                       <a href="index.html">Lip&nbsp;&nbsp;&nbsp;Rouge&nbsp;&nbsp;&nbsp;Shopping</a>
                </div>
        	</div>
        	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                  <ul class="nav navbar-nav navbar-right nav-dsgn ">
                 
                      <li><a href="JspCartPage/Home.jsp">首页</a></li>
                      <li><a href="ListCartServlet">购物车</a></li>
                      <li><a href="JspCartPage/login.jsp" class="active">登录</a></li>
                      <li><a href="JspCartPage/regist.jsp">注册</a></li>
                      <li><a href="JspCartPage/contact.jsp">联系我们</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div>

        <div class="page-container">
            <h1>Sign in</h1>
            <c:if test="${user==null }">
            <form action="LoginServlet" method="post" onsubmit="return dosubmit()" id="form">
                <input type="text" name="username" class="username" placeholder="账号">
                <input type="password" name="password" class="password" placeholder="密码">
                <input type="text" name="code" class="yanzhengcode" placeholder="验证码">
				
            		<img src="CodeImageServlet" onclick="changeImage(this);" alt="换一张"
				style="cursor: hand" class="yanzhengpic"/>
				<br>
            	<input type="checkbox" name="" class="miandenglu">
            	<div class="miandenglu_text">七天内免登录</div>
                <button type="submit" name="login">登录</button>
                <br>
            </form>
           </c:if> 
        </div>
        
  </body>
</html>
<!-- Javascript -->
        <script src="assets_login/js/jquery-1.8.2.min.js"></script>
        <script src="assets_login/js/supersized.3.2.7.min.js"></script>
        <script src="assets_login/js/supersized-init.js"></script>
        <script src="assets_login/js/scripts.js"></script>

