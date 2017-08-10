<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'contact.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="application/x-javascript"> addEventListener("load", function() {setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
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
  </head>
  
  <body>
    <div class="header-top">
            <nav class="navbar navbar-default">
              <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                    <div class="logo">
                       <a href="index.html"><h1>Lip&nbsp;&nbsp;&nbsp;Rouge&nbsp;&nbsp;&nbsp;Shopping</h1></a>
                    </div>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                  <ul class="nav navbar-nav navbar-right nav-dsgn ">
                      <li><input type="text" class="search"><input type="submit" value="搜索🔍" class="searchicon"></li>
                      <li><a href="index.html">首页</a></li>
                      <li><a href="">购物车</a></li>
                      <li><a href="">注册</a></li>
                      <li><a href="">登录</a></li>
                      <li><a href="contact.html"  class="active">联系我们</a></li>
                </ul>
                </div><!-- /.navbar-collapse -->
                <div class="clearfix"></div>
              </div><!-- /.container-fluid -->
            </nav>
    </div>
    <!--header-->
    <div class="contact_page">
        <div class="container">
             <h3>Contact</h3>
            <div class="col-md-6">
                <div class="contact_form">
                        <textarea value="Message:" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message';}">Enter your text here...</textarea><br>
                    <form>
                        <input class="name" type="text" name="name" value="Your name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}"><br>

                        <input class="nuber" type="text" name="Phone number" value="Phone Number" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Number';}"><br>

                        <input class="mail" type="text" name="email" value="E-mail" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'E-mail';}"><br>
                        <input type="submit" class="btn btn-info mrgn-can"></button>
                    </form>
                </div>
            </div>
            <div class="col-md-6">
                <div class="map">
                    
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    
    <!--footer-->
    <div class="footer">
        <div class="container">
            <div class="col-md-4 sub-scb">
                <form>
                <input class="mail2" type="text" name="email" value="E-mail" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'E-mail';}">
                <input class="btn btn-default sub-scb-btn" type="button" value="join"><br>
                </form>
            </div>
            <div class="col-md-4 design">
                <p>Copyright &copy; 2016.Company name All rights reserved.</p>
            </div>
            <div class="col-md-4 social">
                <ul>
                    <li><a href="#" class="face"></a></li>
                    <li><a href="#" class="twit"></a></li>
                    <li><a href="#" class="gpls"></a></li>
                    <li><a href="#" class="inst"></a></li>
                    <li><a href="#" class="drbl"></a></li>
                    <div class="clearfix"></div>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>  
  </body>
</html>
