<%@page import="com.cn.User"%>
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
    
    <title>详情页面</title>
    
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
	<script src="js/jquery.min.js"></script>
	<!--<link href='http://fonts.useso.com/css?family=Archivo+Narrow:400,700' rel='stylesheet' type='text/css'>-->
	<!--fonts-->
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

  <style type="text/css">
    .btnAddCart img{
       width:15px;
       height:15px;
       margin-right: 5px;
    }
    .btnAddCart{
      width:150px;
      height:30px;
      background: red;
      color: white;
      text-align: center;
      padding-top: 8px;
      cursor: pointer;
      
    }
    .centerright{
       float: right;
	   margin-top: 20px;
	   margin-right: 150px;
	   font-family: Lucida Calligraphy;
    }
    #showContent{
      width:100%;
      height:30px;
    }
  </style>
  <script type="text/javascript">
/*     $ (document).ready(function(){
    $("#btnAddCart").click(function(){
    var num = document.getElementById("test_out").value;
    var price = document.getElementById("price").value; 
    var total = num*price;
    $.post("InsertCartServlet",
    {user_id:"${sessionScope.user_id }",productId:"${requestScope.productId }",productName:"${requestScope.productName }",productPrice:"${requestScope.productPrice }",productProvider:"${requestScope.productProvider }",num:num,total:total,product_path:"${requestScope.productPath }"},
    function(data){
      alert("已成功加入购物车");
    }); 
  });
}); 
 */
   //加入购物车    
   function addCart(user_id,productId,productName,productPrice,productProvider,product_path,product_type){
        //alert(1);
        var num = document.getElementById("test_out").value;
        //alert(num)
        var price = document.getElementById("price").value; 
        var total = num*price;
        //alert(total);
        var form = document.getElementById("form");
        form.action = "InsertCartServlet?user_id="+user_id+"&productId="+productId+"&productName="+productName+"&productPrice="+productPrice+"&productProvider="+productProvider+"&num="+num+"&total="+total+"&product_path="+product_path+"&product_type="+product_type;
        //alert(111);
        form.submit(); 
 	 } 
 	 
 	 //立即购买
 	 function buynow(pid){
 	 	//alert(1);
 	 	var num = document.getElementById("test_out").value;
 	 	var price = document.getElementById("price").value;
 	 	//alert(num);
 	 	var total = num*price;
 	 	alert(total);
 	 	var form = document.getElementById("form");
 	 	form.action = "BuyCartNowServlet?pid="+pid+"&total="+total;
 	 	form.submit();
 	 }
 	 
   
    function jia(){
		var outObj=document.getElementById("test_out");
		var inObj=document.getElementById("test_in");
		outObj.value++;
	}
   function jian(){
		var outObj=document.getElementById("test_out");
		var inObj=document.getElementById("test_in");
		if(outObj.value>1){
			outObj.value--;
	}
}

   //数量文本框只能填写数字
   var num;
   function validNum(input){
	var reg = new RegExp("^[0-9]*$");
    num = document.getElementById("test_out");
    if(!reg.test(num.value)){
       alert("请填写数字");
       num.value = "1";
     }
   }

  </script>
  </head>
  
  <body>
   <div class="header-top_1">
            <nav class="navbar navbar-default">
              <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
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

      <div class="centerright">
       <h3>Welcome!  ${user.username }</h3>
      </div>
      <form action="" method="post" id="form">
        <div class="detail">
        	<div class="pro_pic">
              <img src="${sessionScope.productPath }">
              <input type="text" name="productPath" value="${sessionScope.productPath }" hidden>
        	</div>

        	<div class="otherdetails">
        	    <input type="text" name="productId" value="${sessionScope.productId }" hidden>
        	    <input type="text" id="productType" name="productType" value="${sessionScope.productType }" hidden>

        		<div class="pro_name">名称：<input type="text" id="productName" name="productName" value="${sessionScope.productName }" readonly="readonly"></div>
        		<br>
        		<div class="pro_price">价格：<input type="text" name="productPrice" id="price" value="${sessionScope.productPrice }" readonly="readonly"></div>
        		<br>
        		<div class="provide">产地：<input type="text" name="productProvider" value="${sessionScope.productProvider }" readonly="readonly"></div>
        		<br>
        		<div class="count">
        		购买数量：<input type="text" id="test_out" value="1" name="num" onblur="validNum()"/>
				<input type="button" onclick="jia()" id="test_in" value="+"/>
				<input type="button" onclick="jian()" id="test_in" value="-"/>
        		</div>
       

        		<br><br><br>
        		<div class="buy"><input type="button" name="buy" value="立即购买" class="buy1" onclick="buynow(${sessionScope.productId })"></div>
        		<div class="addtocart" ><input type="button" value="加入购物车" onclick="addCart('${sessionScope.user_id }',${sessionScope.productId },'${sessionScope.productName }',${sessionScope.productPrice },'${sessionScope.productProvider }','${sessionScope.productPath }','${sessionScope.productType }')" id="btnAddCart" class="addtocart1"></div>
        	</div>
        </div>
  </form>
        
        <div class="foot">
        	<div class="container_at_detail">
                <div class="col-md-4 sub-scb">
                    <form>
                    <input class="mail2" type="text" name="email" value="E-mail" onFocus="this.value = '';" onblur="if (this.value == '') {this.value = 'E-mail';} ">
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
