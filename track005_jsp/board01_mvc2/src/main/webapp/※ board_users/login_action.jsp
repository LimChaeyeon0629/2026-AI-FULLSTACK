<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	/* login_action.jsp */
	
/* 2. Login
> 로그인폼    -  Get
> 로그인처리 - Post
1) 처리서블릿   : LoginAction
2) 데이터 노출  : x
3) 보관데이터   : bpass , email  
4) 처리경로     : 처리후 마이페이지로   (MyAction - Get) */

	String email = request.getParameter("email");
	String bpass = request.getParameter("bpass");
	
	Connection conn=null;
	PreparedStatement pstmt=null;	ResultSet rset=null;
	
	String url="jdbc:mysql://localhost:3306/mbasic";
	String user="root", pass="1234";
	
	// select * from
	String sql = "select * from users where email=? and bpass=?";
	
	session.setAttribute("email", email);
	session.setAttribute("bpass", bpass);
	
	out.println("<script> alert('로그인 성공!'); location.href='list.jsp'; </script>");
%>