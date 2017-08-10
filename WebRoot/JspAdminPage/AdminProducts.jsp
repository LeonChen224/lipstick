<%@page import="com.cn.Product"%>
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
    
    <title>显示全部商品</title>
    
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

  </head>
  <script type="text/javascript">
  $(function(){
    var disabled = true;
    $('modify').click(function(){
        $('input[type="text"]').removeAttr('disabled');    
        $(".username-text").attr("readonly","readonly");
        return false;
    });
});

 //更改商品名称
 function changePname(input,pid){
   var newpname = input.value;
   var b = window.confirm("您确定要修改商品名称为："+newpname+"吗？");
    if(b){
     window.location.href="ChangeProInfoServlet?newpname="+newpname+"&pid="+pid;
   }  
 }
 
 //修改价格
function changePrice(input,pid,pname){
   var newprice = input.value;
   var b = window.confirm("您确定要修改商品"+pname+"的价格为："+newprice+"吗？");
    if(b){
     window.location.href="ChangeProInfoServlet?newprice="+newprice+"&pid="+pid;
   }  
 }
 
 //删除商品
 function pdelete(pid){
 	var b = window.confirm("主人您确定不要我了吗？");
	if(b){
	      window.location.href="DeleteProServlet?pid="+pid;
	    }	
 }
 
  </script>
  
  <body>
<div class="Contentbox">
	<div id="con_one_1" class="hover">
	<table border=1>
		<tr>
			<th><input type="checkbox" name="chose"></th>
			<th>商品图片</th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品单价</th>
			<th>商品生产商</th>
			<th>商品种类</th>
			<th>操作</th>
		</tr>
		
		<c:forEach items="${sessionScope.products }" var="p">
		  <tr>
			<td><input type="checkbox" name="single"></td>
		    <td><img src="${p.getProduct_path()}" width="130px" height="130px"></td>
		    <td><input type="text" value="${p.getPid() }" readonly></td>
			<td><input type="text" value="${p.getPname() }" onblur="changePname(this,${p.getPid() })"></td>
		    <td><input type="text" value="${p.getPrice() }" onblur="changePrice(this,${p.getPid() },'${p.getPname() }')"></td>
		    <td><input type="text" value="${p.getProvider() }" readonly></td>
		    <td><input type="text" value="${p.getProduct_type() }" readonly></td>
		    <td><a href="javascript:void(0)" onclick="pdelete(${p.getPid() })">移除</a></td>
		  </tr>
		</c:forEach>
		
    </table>
   <% Integer pageCount = (Integer)request.getAttribute("pageCount");

        for(int i = 1;i <= pageCount;i++){  %>
			<ul style="margin-left:10%">
				<li style="width:50px;"><a
					href="AdminAllProductsServlet?page=<%=i-1%>"><%=i %> &nbsp;</a>
				</li>
			</ul>
	<% } %>
		
</body>
</html>
