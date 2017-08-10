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
    
    <title>显示商品-副本</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
	<link href="css/main.css" rel="stylesheet" type="text/css"/>
	<script src="js/jquery-2.1.4.min.js"></script>
	<!--bootstrap-js-->
	<script src="js/bootstrap.min.js"></script>
	<!--script-->
	<link rel="stylesheet" href="css/tab.css">

	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/szp-cpts.js"></script>
	<script type="text/javascript" src="js/notice.js"></script> <!-- 从notice.js文件中导入实现“公告栏无缝滚动”的JavaScript程序代码 --> 

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
                      <li><a href="index.html" class="active">首页</a></li>
                      <li><a href="cart.html">购物车</a></li>
                      <li><a href="login.html">登录</a></li>
                      <li><a href="regist.html">注册</a></li>
                      <li><a href="contact.html">联系我们</a></li>
                </ul>
                </div><!-- /.navbar-collapse -->
                <div class="clearfix"></div>
              </div><!-- /.container-fluid -->
            </nav>
        </div>

        <!-- <div class="container">
    		<div class="pao">
   			</div>
		</div> --> 

        <div class="header-bottom_1">
            <div class="container">
            	<div class="sousuolan">
            		按品牌搜索🔍
            	</div>

            	<div class="sousuolan_right">
            		<h3>Welcome!</h3>
            	</div>
            	<!-- 
            	<hr size="50" color="pink" width="97.5%" align="right"> -->
           	
            	
        <div class="menu">

		<div id="Tab1">
			<div class="Menubox">
				<ul>
					<li id="one1" onClick="setTab('one',1,5)" class="hover">全部商品</li>
					<li id="one2" onClick="setTab('one',2,5)">YSL</li>
					<li id="one3" onClick="setTab('one',3,5)">MAC</li>
					<li id="one4" onClick="setTab('one',4,5)">Chanel</li>
					<li id="one5" onClick="setTab('one',5,5)">Armani</li>

				</ul>
			</div>
			<!-- Menubox end! -->

			<div class="Contentbox">
				<div id="con_one_1" class="hover">
					
				</div>
				

				<div id="con_one_2" style="display:none">

				
				</div> 
			
				<!-- con_one_2 end! -->
			

				<div id="con_one_3" style="display:none">
					
					
				</div>
				<!-- con_one_3 end! -->

				<div id="con_one_4" style="display:none">
					
				</div>
				<!-- con_one_4 end!-->	


				<div id="con_one_5" style="display:none">
				
				</div>
				<!-- con_one_5 end!-->	
			</div>
			<!-- Contentbox end! -->
		</div>
				<!-- Tab1 end! -->
		</div>
			<!-- menu end -->
			

            </div>
            <!--container end-->

            <div class="notice_all">
            <div class="notice_top">
            	<div class="blink">号外！号外！</div>
            </div>

            <div id ="notice">
		  
			<div id="breakNews">
               <ul id="breakNewsList" >
               <li><a target="_blank" href="http://www.lindt.cn">ysl52#星你色特价！</a></li>
               <li><a target="_blank" href="http://baike.baidu.com/link?url=HplpcbxwpoIWES3q-zLnCDm_p6nkoFwG93pKFGK0rdvsHEQPcS70olEhS42OPwMfBnfnREjvOM1xRHhffXVtjq">兰芝双色口红太阳的后裔宋慧乔同款</a></li>
               <li><a target="_blank" href="http://baike.baidu.com/link?url=pWLJkspbQwmejvJz6p5_muREu_MphkA24aNGpqbpiOcM8IIsmTQvoN1FUFYDSAt19CEw4Ad39zrqRmV4ZFE_mK">雅诗兰黛刘雯大表姐同款</a></li>
               <li><a target="_blank" href="http://baike.baidu.com/link?url=aqJzzK2vuvYplkK2AXMbBa4qqmdILnhKp4J4noatcx-KIokWlaPHbdf409jgwwxtEkcIWPfM95ATeBrEV2jQEK">MAC子弹头chili小辣椒</a></li>
                <li><a target="_blank" href="http://baike.baidu.com/view/11622588.htm">ysl唇釉12＃斩男色</a></li>
                <li><a target="_blank" href="http://baike.baidu.com/view/2078280.htm">TomFord口红中的贵妇</a></li>
                <li><a target="_blank" href="http://baike.baidu.com/view/5870604.htm">channel新款唇釉</a></li>
               <li><a target="_blank" href="http://baike.baidu.com/view/5339159.htm">ysl新品黑管唇釉</a></li>
               <li><a target="_blank" href="http://www.lindt.cn">ysl52#星你色特价！</a></li>
               <li><a target="_blank" href="http://baike.baidu.com/link?url=HplpcbxwpoIWES3q-zLnCDm_p6nkoFwG93pKFGK0rdvsHEQPcS70olEhS42OPwMfBnfnREjvOM1xRHhffXVtjq">兰芝双色口红太阳的后裔宋慧乔同款</a></li>
               <li><a target="_blank" href="http://baike.baidu.com/link?url=pWLJkspbQwmejvJz6p5_muREu_MphkA24aNGpqbpiOcM8IIsmTQvoN1FUFYDSAt19CEw4Ad39zrqRmV4ZFE_mK">雅诗兰黛刘雯大表姐同款</a></li>
               <li><a target="_blank" href="http://baike.baidu.com/link?url=aqJzzK2vuvYplkK2AXMbBa4qqmdILnhKp4J4noatcx-KIokWlaPHbdf409jgwwxtEkcIWPfM95ATeBrEV2jQEK">MAC子弹头chili小辣椒</a></li>
                <li><a target="_blank" href="http://baike.baidu.com/view/11622588.htm">ysl唇釉12＃斩男色</a></li>
                <li><a target="_blank" href="http://baike.baidu.com/view/2078280.htm">TomFord口红中的贵妇</a></li>
                <li><a target="_blank" href="http://baike.baidu.com/view/5870604.htm">channel新款唇釉</a></li>
               <li><a target="_blank" href="http://baike.baidu.com/view/5339159.htm">ysl新品黑管唇釉</a></li>
             </ul>
			 <script language="javascript" type="text/javascript">
                var scroll2 = new ScrollText("breakNewsList","pre2","next2",true,70,true);
                scroll2.LineHeight =24;
             </script>
      </div>
		  
		</div>
		<!--notice end!-->
		</div>
		<!--notice——all end!-->
        </div>
        <!--header-bottom_1 end!-->


        <div class="zhanggui">
        	掌柜热卖 HOT
        </div>
        <div class="wrap">
        
    	<div class="slide">
            <div class="slide_point">
               <span class="cur_point point1"><img width="210px" height="280px" src="img/image/2_1.png"></span>
               <span class="point2"><img width="200px" height="250px" src="img/image/0_2.png"></span>
               <span class="point3"><img width="200px" height="250px" src="img/image/0_3.png"></span>
               <span class="point4"><img width="200px" height="250px" src="img/image/0_4.png"></span>
            </div>
            <div class="slide_cont">
                <ul class="clearfix">
                    <li>
                    	<img src="img/image/1_1.png" hspace="10" usemap="#s_map_1" ismap="ismap"/>
                    	<map name="s_map_1" class="s_map">
                    		<area class="map_point" shape="rect" coords="10,20,170,300" href="#" target="_blank" alt="" title=""> 
							<area class="map_point" shape="rect" coords="220,20,390,300" href="siteall.htm" target="_blank" alt="" title=""> 
							<area class="map_point" shape="rect" coords="420,20,600,300" href="pageall.htm" target="_blank" alt="" title=""> 
							<area class="map_point" shape="rect" coords="620,20,810,300" href="pageal.htm" target="_blank" alt="" title=""> 
                    	</map>
                    </li>
                    <li>
                    	<img src="img/image/1_2.png" hspace="10" usemap="#s_map_2"/>
                    	<map name="s_map_2" class="s_map">
                    		<area class="map_point" shape="rect" coords="10,20,170,300" href="urlall.htm" target="_blank" alt="" title=""> 
							<area class="map_point" shape="rect" coords="300,20,500,300" href="siteall.htm" target="_blank" alt="" title=""> 
							<area class="map_point" shape="rect" coords="620,20,810,300" href="pageal.htm" target="_blank" alt="" title=""> 
                    	</map>
                    </li>
                    <li>
                    	<img src="img/image/1_3.png" hspace="10" usemap="#s_map_3"/>
                    	<map name="s_map_3" class="s_map">
                    		<area class="map_point" shape="rect" coords="10,20,170,300" href="urlall.htm" target="_blank" alt="" title=""> 
							<area class="map_point" shape="rect" coords="220,20,390,300" href="siteall.htm" target="_blank" alt="" title=""> 
							<area class="map_point" shape="rect" coords="420,20,600,300" href="pageall.htm" target="_blank" alt="" title=""> 
							<area class="map_point" shape="rect" coords="620,20,810,300" href="pageal.htm" target="_blank" alt="" title=""> 
                    	</map>
                    </li>
                    <li>
                    	<img src="img/image/1_4.png" hspace="10" usemap="#s_map_4"/>
                    	<map name="s_map_4" class="s_map">
                    		<area class="map_point" shape="rect" coords="10,20,170,300" href="urlall.htm" target="_blank" alt="" title=""> 
							<area class="map_point" shape="rect" coords="300,20,500,300" href="siteall.htm" target="_blank" alt="" title=""> 
							<area class="map_point" shape="rect" coords="620,20,810,300" href="pageal.htm" target="_blank" alt="" title=""> 
                    	</map>
                    </li>
                </ul>
            </div>
         </div> 

	</div>
	<br><br><br><br><br><br>
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
<script>
	function setTab(name, cursel, n) {
		for (i = 1; i <= n; i++) {
			var menu = document.getElementById(name + i);
			var con = document.getElementById("con_" + name + "_" + i);
			menu.className = i == cursel ? "hover" : "";
			con.style.display = i == cursel ? "block" : "none";
		}
	}
</script>
