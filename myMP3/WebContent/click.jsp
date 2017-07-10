<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
     String s=new String();
     String t=request.getParameter("test");
     if(t!=null){
    	 System.out.print(t);
    	 //连接MySQL数据库   
    	    Class.forName("com.mysql.jdbc.Driver").newInstance();  
    	    String url="jdbc:mysql://localhost:3306/mp3_demo";  
    	    String user="root";  
    	    String password="baobei1181213";  
    	    Connection conn = DriverManager.getConnection(url, user, password);  
    	    Statement st = conn.createStatement();  
    	    ResultSet rs = st.executeQuery("SELECT clicks FROM songlist where src='"+t+"'");  
    	    if(rs.next()) 
    	    {
    	    	String clicks=rs.getString("clicks");
    	    	int click= Integer.parseInt(clicks)+1;
    	    	clicks=Integer.toString(click);
    	    	String sql = "update songlist set clicks = '" + clicks + "' where src='"+t+"';";
    	    	st.executeUpdate(sql);
    	    }
    	    out.println("<script>window.history.back()</script>");
    %>
    <%} %>