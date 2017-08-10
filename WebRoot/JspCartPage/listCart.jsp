<%@page import="java.awt.Checkbox"%>
<%@page import="com.cn.Product"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的购物车</title>
    
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
	<script type="text/javascript">
	  function deleteConfirm(user_id,pid){
	  //alert(1);
	    var b = window.confirm("主人您确定不要我了吗？");
	    if(b){
	      window.location.href="DeleteCartServlet?user_id="+user_id+"&pid="+pid;
	    }
	  }
	  
	  //限制只能输入正整数
	  function validNum(input,user_id,pid,oldnum){
	    var num = input.value;
	    if(num < 0 ||num != parseInt(num)){
	       alert("请输入正整数");
	       input.value = oldnum;
	       return;
	    }
	     var price = document.getElementById("price").value;
	     var oldtotal = document.getElementById("total").value;
	     var b = window.confirm("您确定要更改数量为："+num+"吗？");
	     if(b){
	      window.location.href="ChangeCartNumServlet?user_id="+user_id+"&num="+num+"&pid="+pid+"&oldtotal="+oldtotal+"&price="+price;
	    }
	    
	  }
	
	//全选
    function selectAll(obj){
        var all = document.getElementById("all");
        var flag = document.getElementsByName(obj);
        if(all.checked){
            for(var i=0;i<flag.length;i++){
                flag[i].checked=true;
                document.getElementById("sum").value = "￥"+${sessionScope.sum };
            }
        }else{
            for(var i=0;i<flag.length;i++){
                flag[i].checked=false;
                document.getElementById("sum").value = 0;
            }
        }
        //document.getElementById("sum").value = "￥"+${sessionScope.sum };
    }
    //只要有一个不选，全选也不选 只要全都选择 全选就勾选
    function other(){
        var pid = document.getElementsByName("single");       
        var flag = true;
        for(var i=0;i<pid.length;i++){
            if(!pid[i].checked){
                flag=false;
                break;
            }
        }
        //计算总和
        var sum = 0; 
        var nums = 0;              	
        for(var i = 0;i < pid.length;i++){       
        	if(pid[i].checked){
        	 	nums++;       	
        		var totalvalue = pid[i].value;
        		var totalstr = totalvalue.split(",");
        		var total = totalstr[0];
        		//alert(totalstr[0]);
        		sum += parseInt(total);
        	}
        }
        //alert(nums);
        document.getElementById("nums").value = nums;
        //alert(sum);
        if(flag){
            document.getElementById("all").checked=true;
        }else{
            document.getElementById("all").checked=false;
        }
        document.getElementById("sum").value = "￥"+sum;

    }
	  //清空购物车
	  function clearAllCart(user_id){
	     var user_id = document.getElementById("user_id");
	     var b = window.confirm("您确定要清空购物车吗？");
	    if(b){
	      window.location.href="ClearAllCartServlet?user_id="+user_id;
	    }
	  }
	  
	  //结算
	  function buy(){
        var form = document.getElementById("form");
        var flag = document.getElementsByName("single");
        var num = 0;
        for(var i = 0;i < flag.length;i++){
          if(flag[i].checked){
              num++;
           }
        }
        if(num > 0){
          form.action = "BuyCartServlet";
          form.submit();
        }else {
			alert("请选择商品");
		} 
    }
 
 //底部浮动 
 function fixDown(boxId){
    var box = document.getElementById(boxId);
    var cn = box.className;
    var bh=box.offsetTop;
    var wh=document.documentElement.clientHeight;
    if(bh >= wh){
    box.className = cn + " fixed-bottom";
   }else{
    box.className = cn;
     }
 }
    window.onload=function(){
    	fixDown("bb");
    }
    window.onresize=function(){
    	fixDown("bb");
    }
    
    function jia(){
		var outObj = document.getElementById("num");
		var inObj = document.getElementById("test_in");
		outObj.value++;
	}
   function jian(){
		var outObj = document.getElementById("num");
		var inObj = document.getElementById("test_in");
		if(outObj.value>1){
			outObj.value--;
	}
	}  
	</script>
	<style type="text/css">
	 input{
	   width:80px;
	   height:30px;
	 }
  	 .img{
		width:130px;
		height:130px;
  	}
  	.danxuan{
	  	width:15px;
	  	height:15px;
	  	margin-left: 6px;
  	}

	table tr td{
		text-align:center;
	}
	#test_in{
		width: 30px;
		height: 30px;
	}
	.cha{
		width:25px;
		height:25px;
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
   <div class="cart_mid">
      	<div class="cart_text">
      		购物车
      	</div>
      	<hr class="fengexian">
      	<br><br>
      	<div class="order_info">
	     <form action="" method="post" name="form" id="form">
	     <table border=0 align="center" width="1000px">
	     <tr height="50px" bgcolor="#f2f7ff" >
	       <th style="text-align:center"><input type="checkbox" name="" id="all" class="danxuan" onclick='selectAll("single")'>全选</th>
	       <th colspan="3" style="text-align:center">商品信息</th>
	       <th style="text-align:center">单&nbsp;价</th>
	       <th style="text-align:center">数&nbsp;量</th>
	       <th style="text-align:center">金&nbsp;额</th>
	       <th style="text-align:center">操&nbsp;作</th>
	 
	     </tr>
	     
	     <c:forEach items="${sessionScope.cart }" var="lc"> 
	     <tr height="100px" bgcolor="#f2f7ff">
	       <td><input type="checkbox" name="single" id="single" value="${lc.getTotal() },${lc.getPid() }" class="danxuan" onclick="other()"></td>
	       <td><img src="${lc.getProduct_path() }" class="img"></td>
	       <td>${lc.getPname() }</td>
	       <td>${lc.getProduct_type() }</td>
	       <input type="text" id="user_id" value="${lc.getUser_id() }" hidden>
	       <input type="text" value="${lc.getPid() }" hidden>
	       
	       <td><input type="text" value="${lc.getPrice() }" id="price" readonly="readonly" style="border:none;background:none;"></td>
	       <input type="text" value="${lc.getProvider() }" hidden>
	       <td><input type="text" value=${lc.getNum() } id="num" onblur="validNum(this,'${lc.getUser_id() }',${lc.getPid() },${lc.getNum() })" style="width:50px;">     
	       		<input type="button" onclick="jia()" id="test_in" value="+">
				<input type="button" onclick="jian()" id="test_in" value="-">
	       </td>
	       <td><input type="text" value="${lc.getTotal() }" id="total" readonly="readonly" style="border:none;background:none;"></td>
	       <td>
	       		<img src="images/cha.png" class="cha">
	       		<a href="javascript:void(0)" onclick="deleteConfirm('${lc.getUser_id() }','${lc.getPid() }')">删除</a>
	       </td>
	     </tr>
	     <tr height="50px">
	       <td colspan="8"></td>
	     </tr>
	    </c:forEach>

	    </table>
	    </form>
	  </div>
	</div>
	
	<div class="bottombox" id="bb">
       <a href="javascript:void(0)" onclick="clearAllCart()">清空购物车</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                已选商品<input type="text" id="nums" name="nums" readonly="readonly">件
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                合计：<input type="text" id="sum" readonly="readonly">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" onclick="buy()" value="结算" class="jiesuan">
   </div>
  </body>
</html>
