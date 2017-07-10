<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/tuijain.css" rel="stylesheet" type="text/css" />
<title>推荐</title>
</head>
<script type="text/javascript" language="javascript">
 function aclick(self){
 document.forms["form1"].test.value =self.href;  //获取jsp中表单的值
 document.form1.submit();
 }
</script> 
<body>
<form name="form1" method="post" action="click.jsp">
    <input type="hidden" name="test" value=""  />
    </form>

<div style="width:650px;">

<center><h3 class="f-2"><span>推荐列表</span></h3></center>

<center><table align="center" class="m-table" >
<tr>
<td style="width:160px">
歌曲标题
</td>
<td style="width:80px">
歌手名字
</td>
<td style="width:60px">
播放次数
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
     
    ResultSet rs = st.executeQuery("SELECT * FROM songlist ORDER BY clicks DESC LIMIT 8");  
    while(rs.next()){%>  
      
  <tr>  
    <td width="300" ><a onclick='aclick(this)' target="music" style="text-decoration: none;color: rgb(177, 106, 104);" href="<%=rs.getString("src")%>"><%=rs.getString("songname") %></a></td>  
    <td width="200" ><%=rs.getString("singers") %></td>  
    <td width="100"><%=rs.getString("clicks") %></td>  
  </tr>  

  
<%}
%> 

</table>
</center>
</div>
<iframe name="music" frameborder="no" border="0" marginwidth="0" marginheight="0" width=660 height=100 src="http://music.163.com/outchain/player?type=2&id=34928627&auto=1&height=66"></iframe>
</body>
</html>