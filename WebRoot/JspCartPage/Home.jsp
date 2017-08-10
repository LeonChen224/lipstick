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
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
    <div class="header-top_1">
            <nav class="navbar navbar-default">
              <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                  <!-- <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button> -->
                    <div class="logo">
                       <a href="JspCartPage/Home.jsp"><h1>Lip&nbsp;&nbsp;&nbsp;Rouge&nbsp;&nbsp;&nbsp;Shopping</h1></a>
                    </div>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                  <ul class="nav navbar-nav navbar-right nav-dsgn ">
                      <li><input type="text" class="search"><input type="submit" value="搜索🔍" class="searchicon"></li>
                      <li><a href="JspCartPage/Home.jsp" class="active">首页</a></li>
                      <li><a href="ListCartServlet">购物车</a></li>
                      <c:if test="${user == null }">
                      <li><a href="JspCartPage/login.jsp">登录</a></li>
                      </c:if>
                      <c:if test="${user != null }">
                      <li><a href="logoutSrevlet">注销</a></li>
                      </c:if>
                      <li><a href="JspCartPage/register.jsp">注册</a></li>
                      <li><a href="JspCartPage/contact.jsp">联系我们</a></li>
                </ul>
                </div><!-- /.navbar-collapse -->
                <div class="clearfix"></div>
              </div><!-- /.container-fluid -->
            </nav>
        </div>
        <div class="header-bottom">
            <div class="container">
                <div id="mycarousel" class="carousel slide" data-ride="carousel">
                  <!-- Indicators -->
                  <ol class="carousel-indicators">
                    <li data-target="#mycarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#mycarousel" data-slide-to="1"></li>
                    <li data-target="#mycarousel" data-slide-to="2"></li>
                    <li data-target="#mycarousel" data-slide-to="3"></li>
                  </ol>

                  <!-- Wrapper for slides -->
                  <div class="carousel-inner" role="listbox">
                    <div class="item active">
                      <img src="images/bn2.jpg" alt="/" />
                    </div>
                    <div class="item">
                      <img src="images/bn3.jpg" alt="/" />
                    </div>
                    <div class="item">
                      <img src="images/bn1.jpg" alt="/">
                    </div>
                    <div class="item">
                      <img src="images/bn4.jpg" alt="/" />
                    </div>
                  </div>
                  <!-- Controls -->
                  <a class="left carousel-control" href="#mycarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                  </a>
                  <a class="right carousel-control" href="#mycarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                  </a>
                </div>
            </div>
        </div>
        <div class="body-cont">
            <div class="container">
          <h3>Welcome!  ${user.username }</h3>
                <div class="grid_v">
                    <ul>
                        <li class="col-md-3 re-size1">
                            <img src="./images/YSL/ysl1.png" alt="/" class="zoom-img"/>
                            <div class="grid-txt">
                                <h4>YSL</h4>
                                <p>方管唇膏52＃星星色</p>
                                <a href="AddCartServlet?name=方管唇膏52＃" class="btn btn-default re-clr1">More</a>
                            </div>
                        </li>
                        <li class="col-md-3 re-size1">
                            <img src="./images/MAC/MAC1.png" alt="/" class="zoom-img"/>
                            <div class="grid-txt">
                                <h4>MAC</h4>
                                <p>c&nbsp;h&nbsp;i&nbsp;l&nbsp;i小辣椒</p>
                                <a href="AddCartServlet?name=chili(小辣椒)" class="btn btn-default re-clr1">More</a>
                            </div>
                        </li>
                        <li class="col-md-3 re-size1">
                            <img src="./images/CHANEL/CHANEL2.png" alt="/" class="zoom-img"/>
                            <div class="grid-txt">
                                <h4>CHANEL</h4>
                                <p>炫亮魅力丝绒唇膏99＃复古红</p>
                                <a href="AddCartServlet?name=炫亮魅力丝绒唇膏99＃" class="btn btn-default re-clr1">More</a>
                            </div>
                        </li>
                        <li class="col-md-3 re-size1">
                            <img src="./images/Armani/Armani3.png" alt="/" class="zoom-img"/>
                            <div class="grid-txt">
                                <h4>Armani</h4>
                                <p>黑管唇釉402#</p>
                                <a href="AddCartServlet?name=黑管唇釉402＃" class="btn btn-default re-clr1">More</a>
                            </div>
                        </li>
                        <div class="clearfix"></div>
                    </ul>
                </div>
            </div><br>
            <div class="find_more"><a href="ListProductsServlet">查看更多</a></div>
        </div>
        <div class="footer">
            <div class="container">
                <div class="col-md-4 sub-scb">
                    <form>
                    <input class="mail2" type="text" name="email" value="E-mail" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'E-mail';}">
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
