<%@page import="com.cn.Product"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>下单</title>
    
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
<!-- 	<link href='http://fonts.useso.com/css?family=Archivo+Narrow:400,700' rel='stylesheet' type='text/css'>
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
</script>
<style type="text/css">
img{
	width:130px;
	height:130px;
}
table tr td input{
 	border:none;
 }
</style>
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
                  	  <li><input type="text" class="search"><input type="submit" value="搜索" class="searchicon"></li>
                      <li><a href="JspCartPage/Home.jsp">首页</a></li>
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
  
  
            
  <form action="SubmitCartServlet" method="post" name="form">
     <div class="order_mid">
        	<div class="order_text">
        		确认订单信息：
        	</div>
        	<hr class="fengexian">
        	<div class="order_info">
        
     <table border="0" width="800px" align="center">
    <tr height="50px" bgcolor="#f2f7ff">
         <th colspan="2" style="text-align:center">产品信息</th>
         <th>种类</th>
         <th>单价</th>
         <th>数量</th>
         <th>小计</th>
         <th>供应商</th>
    </tr>

      <c:forEach var="c" items="${sessionScope.buycart }">
			<tr>
				<td><img src="${c.product_path }"></td>
				
				<input type="text" name="pid" value="${c.pid }" hidden>
				<td><input type="text" name="pname" value="${c.pname }" readonly="readonly"></td>
				<td><input type="text" name="product_type" value="${c.product_type }" readonly="readonly"></td>
				<td><input type="text" name="price" id="price" value="￥${c.price }" readonly="readonly"></td>
				<td><input type="text" name="num" id="num"  value="${c.num }" readonly="readonly"></td>
				<td><input type="text" name=total id="total"  value="￥${c.total }" readonly="readonly"></td>
				<td><input type="text" name="provider" id="provider"  value="${c.provider }" readonly="readonly"></td>
			</tr>
		</c:forEach>
		<tr bgcolor="#f2f7ff" height="50px">
		  <th>合计：</th>
		  <td colspan="6"><input type="text" name="sum" value="￥${sessionScope.buysum }" readonly="readonly"></td>
		</tr>
      </table>
     </div>
  <br><br>
	   	<div class="person_text">
	   		确认收货信息：
	   	</div>
	   	<hr class="fengexian">
	   	<br>
	   	
	   	<div class="oid">
	   		联系姓名：<input type="text" name="customer" value="${requestScope.username }">       		
	   	</div>
	   	<br>
	   	<div class="oid">
	   		收获地址：<input type="text" name="address" value="${requestScope.address }">       		
	   	</div>
	   	<br>
	   	<div class="oid">
	   		联系方式：<input type="text" name="phone" value="${requestScope.phone }">        		
	   	</div>
	   	<br><br>
	   	<div class="order_submit">
	   		<input type="submit" name="" value="提交订单">
	   	</div>
     
     </div>
     </form>
     
     
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
