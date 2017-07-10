<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>选择歌曲</title>
</head>
<body>
<%
								if (session.getAttribute("PlutoUser") == null) {
									
									out.println("<script> alert('请先登录')</script>");
							%>
	<%}else{ %>						
<iframe align="middle" name="liebiao" height="500" width="310" src="liebiao.jsp" frameborder="0">

                </iframe>
<iframe align="middle" name="gedan" height="500" width="310" src="" frameborder="0">

               </iframe>
               <%} %>
</body>
</html>