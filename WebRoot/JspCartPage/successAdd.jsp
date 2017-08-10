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
  <div class="header-top_1">
            <nav class="navbar navbar-default">
              <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <div class="logo">
                       <a href="index.html"><h1>Lip&nbsp;&nbsp;&nbsp;Rouge&nbsp;&nbsp;&nbsp;Shopping</h1></a>
                    </div>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                  <ul class="nav navbar-nav navbar-right nav-dsgn ">
                  	  <li><input type="text" class="search"><input type="submit" value="搜索🔍" class="searchicon"></li>
                      <li><a href="JspCartPage/Home.jsp">首页</a></li>
                      <li><a href="ListCartServlet" class="active">购物车</a></li>
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

        <div class="validAddCart_mid">
        <c:forEach items="${requestScope.successlist }" var="sl">
        	<div class="validAddCart_pic">
        		<img src="${sl.getProduct_path() }">
        	</div>

        	<div class="validAddCart_detail">           
     			<input type="text" name="" value="${sl.getPid() }" hidden>
        		<div class="validAddCart_detail_proname">
        			名称：${sl.getPname() }
        		</div>
        		<br>
        		<div class="validAddCart_detail_proname">
        			价格：￥${sl.getPrice() }
        		</div>
        		<br>
        		<div class="validAddCart_detail_proname">
        			生产商：${sl.getProvider() }
        		</div>
        		<br>
        		<div class="validAddCart_detail_proname">
        			数量：${sl.getNum() }
        		</div>       	
        	</div>

        	<div class="validAddCart_success">
        		<div class="validAddCart_success_text">
        			<img src="./images/gou.png">已成功加入购物车
        		</div>
        		<div class="validAddCart_success_xiaoji">
        			小计：￥${sl.getTotal() }
        		</div>
        </c:forEach>
        		<br><br>
        		<div class="back_or_cal">
        			<div class="back_or_cal1">
        			<a href="JspCartPage/addCart.jsp" > 《返回商品详情 </a>
        			</div>       			
        			&nbsp;&nbsp;
        			<div class="back_or_cal2">
        			<a href="ListCartServlet" >去购物车结算</a>       			
        			</div>
        		</div>
        	</div>
        	
        </div>

        <div class="foot">
        	<div class="container_at_detail">
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
