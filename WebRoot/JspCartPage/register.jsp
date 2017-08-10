<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
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
	<!-- <link href='http://fonts.useso.com/css?family=Archivo+Narrow:400,700' rel='stylesheet' type='text/css'> -->
	<!--fonts-->
	<!--link css-->
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
    <link rel="stylesheet" href="assets/css/reset.css">
    <link rel="stylesheet" href="assets/css/supersized.css">
    <link rel="stylesheet" href="assets/css/style.css">


    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <!-- Javascript -->
    <script src="assets/js/jquery-1.8.2.min.js"></script>
    <script src="assets/js/supersized.3.2.7.min.js"></script>
    <script src="assets/js/supersized-init.js"></script>
    <script src="assets/js/scripts.js"></script>
    
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
  </style>
  </head>
  
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
                 <li><a href="JspCartPage/login.jsp">登录</a></li>
                 <li><a href="JspCartPage/regist.jsp" class="active">注册</a></li>
                 <li><a href="JspCartPage/contact.jsp">联系我们</a></li>
           </ul>
    </div><!-- /.navbar-collapse -->
  </div>
  
  <div class="page-container">
      <h1>Register</h1>
      <form action="UserRegisterServlet" method="post">
          <input type="text" name="username" class="username" placeholder="账号" value="${form.username}"><span class="erros">${form.errors.username }</span><br>
          <input type="password" name="password" class="password" placeholder="密码" value="${form.password}"><span class="erros">${form.errors.password}</span><br>
          <input type="password" name="password2" class="password" placeholder="确认密码" value="${form.password2}"><span class="erros">${form.errors.password2}</span><br>
          <input type="text" name="phone" class="username" placeholder="手机号" value="${form.phone }"><span class="erros">${form.errors.phone }</span><br>
          <input type="text" name="mail" class="username" placeholder="邮箱" value="${form.mail }"><span class="erros">${form.errors.mail }</span><br>
          <input type="text" name="address" class="username" placeholder="收货地址" value="${form.address }"><span class="erros">${form.errors.address }</span><br>
          <button type="submit" name="regist">注册</button>
      </form>           
 </div>
  </body>
</html>
