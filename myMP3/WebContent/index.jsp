<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>音乐管理</title>
<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/nicejforms.js"></script>
		<script type="text/javascript" src="js/thickbox.js"></script>
		<script type="text/javascript" src="js/audioplayer.js"></script>
		<link href="css/default.css" rel="stylesheet" type="text/css" />
		<link href="css/page.css" rel="stylesheet" type="text/css" />
		<link href="css/thickbox.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="css/LoadingStatus.css" type="text/css" />
</head>
<body>
		<div id="header">
			<div id="logo" style="color:#000;">
				<h1 style="color:#000;" >
				     ECHO音乐站
				</h1>
				<h2>
					嗯~
				</h2>
			</div>
			<div id="menu" style="color:#000;">
				<ul>
					<li class="active">
						<a href="shouye.jsp" target="xianshi" accesskey="1" title="">首页</a>
					</li>
					<li>
						<a href="tuijian.jsp" target="xianshi" accesskey="2" title="">音乐盒</a>
					</li>
					
					<li>
						<a href="player.jsp" target="xianshi" accesskey="4" title="">播放列表</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="LoadingStatus">
			<img src="images/ajax-loader.gif" />
		</div>
		<hr />
		<div id="page">

			<div id="bg">
				<a name="article_md"></a>

				<div id="content">
<iframe align="middle" name="xianshi" height="500" width="700" src="shouye.jsp" frameborder="0">
                </iframe>
				</div>
				<!-- end contentn -->
				<div id="sidebar">
					<div id="about-box" style="font-size: 12px">
						<p>
							<%
								if (session.getAttribute("PlutoUser") == null) {
							%>
						
						<form action="login" method="post" class="niceform">
							<label for="textinput">
								&nbsp;&nbsp;用户名：
							</label>
							<br />
							&nbsp;&nbsp;
							<input type="text" id="textinput" name="username" size="15"
								maxlength="16" />
							<br />
							<label for="passwordinput">
								&nbsp;&nbsp;密 码：
							</label>
							<br />
							&nbsp;&nbsp;
							<input type="password" id="passwordinput" name="password"
								size="15" maxlength="16" />
							<br />
							<br />
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="register.jsp?height=175&width=300&modal=true"
								class="thickbox" title="我要注册">我要注册</a> &nbsp;&nbsp;
							<input type="submit" value="登  陆" />
							<br/>
							<a href="getback.jsp?" title="找回密码">找回密码</a>

						</form>


						<p></p>
						<%
							} else {
						%>
						<p>
							<%=session.getAttribute("PlutoUser").toString()%>，欢迎您回来！
						</p>
	
						<p>
							
							
							<a href="player.jsp" target="xianshi" style="color: red">[播放列表]</a>
							<br />
							</p>
							<p>
							<a href="uploadmusic.jsp?height=175&width=300&modal=true"
								class="thickbox" title="我要注册" style="color: red">[上传音乐]</a>
							<br />
						</p>
						<p>
							
							<a href="logout" style="color: #FF0000">[注销登陆]</a>
						</p>
						<%
							}
						%>
					</div>
					<ul>
						
						<li>
							<h2>
								友情链接
							</h2>

						</li>
						<li><a href="https://github.com/scf1181213">github</a></li>
                        <li><a href="https://blog.kasora.moe/" rel="acquaintance" target="_blank">kasora</a></li>
                        <li><a href="http://scf.natsukawa.moe/jiaju/login.html">testweb</a></li>
                        <li><a href="http://scf.natsukawa.moe/">scf.natsukawa.moe</a></li>
					</ul>
				</div>
				<!-- end sidebar -->
				<div style="clear: both;">
	
				</div>
			</div>
		</div>
		<!-- end page -->
		<hr />
		<div id="footer">
			<p>
				(copyright) 2017 @scf.natsukawa.moe
			</p>
		</div>
	</body>
</html>