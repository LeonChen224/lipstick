<%@ page language="java" import="java.util.*" pageEncoding="gbk" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传文件测试</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
	function pisNull(){
		var form = document.getElementById("form");
		var pname = document.getElementById("pname").value;
		var price = document.getElementById("price").value;
		var provider = document.getElementById("provider").value;
		var ptype = document.getElementById("ptype").value;
		var upfile = document.getElementById("upfile").value;
		if(upfile != "" &&pname != null && price != null && provider != null && ptype != null){
			form.action = "AddProductServlet?pname="+pname+"&price="+price+"&provider="+provider+"upfile="+upfile+"&ptype="+ptype;
			form.submit();
		}else{
			alert("存在未填写内容！");
		}
	}
</script>
  </head>
  
  <body>
  <form action="" method="get" id="form"> 
    	<input type="file" name="upfile" id="upfile" size="50"><br>
    	商品名称：<input type="text" name="pname" id="pname"><br>
    	商品单价：￥<input type="text" name="price" id="price"><br>
    	商品产地：<input type="text" name="provider" id="provider"><br>
    	商品种类：<input type="text" name="ptype" id="ptype"><br>
    	<input type="button" value="提交" onclick="pisNull()">
   </form>
  </body>
</html>
