<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/tuijain.css" rel="stylesheet" type="text/css" />
<title>列表</title>
</head>

<body>

<div style="width:300px;">

<center><h3 class="f-2"><span>备选列表</span></h3></center>

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
    ResultSet rs = st.executeQuery("SELECT * FROM my_music ORDER BY clicks DESC");  
    while(rs.next()){%>
     
      
  <tr>  
    <td width="160" ><a href="gedan.jsp?id=<%=rs.getString("id")%>&song=<%=rs.getString("song") %>&singer=<%=rs.getString("singer") %>" target="gedan" style="text-decoration: none;color: rgb(177, 106, 104);"  ><%=rs.getString("song") %></a></td>  
    <td width="80" ><%=rs.getString("singer") %></td>   
  </tr>  
  
<%}
%> 
</table>
</center>
</div>
</body>
</html>