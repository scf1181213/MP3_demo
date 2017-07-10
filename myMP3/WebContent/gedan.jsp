<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/tuijain.css" rel="stylesheet" type="text/css" />
<title>歌单</title>
</head>
<body>
<div style="width:300px;">

<center><h3 class="f-2"><span>歌单</span></h3></center>
 <center><table align="center" class="m-table" >
<tr>
<td style="width:160px">
歌曲标题
</td>
<td style="width:80px">
歌手名字
</td>
</tr>
<%  
 //连接MySQL数据库   
    Class.forName("com.mysql.jdbc.Driver").newInstance();  
    String url="jdbc:mysql://localhost:3306/mp3_demo";  
    String user="root";  
    String password="baobei1181213";  
    Connection conn = DriverManager.getConnection(url, user, password);  
    Statement st = conn.createStatement();  
      
 %>  
<% 
String s=new String();
     String t=request.getParameter("id");
     String song=request.getParameter("song");
     String singer=request.getParameter("singer");
     if(t!=null){
    	 
    	 String sql="insert into linshi(song,singer,id) values('"+song+"','"+singer+"','"+t+"')";
    			 st.executeUpdate(sql);
     }
     
     
 %>
  <%  
    ResultSet rs = st.executeQuery("SELECT * FROM linshi ");  
    while(rs.next()){%>
     
<tr>  
    <td width="160" ><a target="player" href="//music.163.com/outchain/player?type=2&id=<%=rs.getString("id") %>&auto=0&height=66" target="gedan" style="text-decoration: none;color: rgb(177, 106, 104);"  ><%=rs.getString("song") %></a></td>  
    <td width="80" ><%=rs.getString("singer") %></td>   
  </tr> 
<%} %>
</table>
</center>
</div>
<iframe name="player" frameborder="no" border="0" marginwidth="0" marginheight="0" width=300 height=100 src=""></iframe>
</body>
</html>