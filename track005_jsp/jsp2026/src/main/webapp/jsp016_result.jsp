<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.net.ConnectException"%>
<%@page import="org.apache.catalina.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/* result.jsp */
	request.setCharacterEncoding("UTF-8");

	//1. 데이터 넘겨받기
	String email = request.getParameter("email");
	String bpass = request.getParameter("bpass");
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	Resultset rset=null;
	
	String url="jdbc:mysql://localhost:3306/mbasic";
	String user="root", pass="1234";
	
	//2. sql 구문처리 (insert = update)
	//String sql = "insert into users (email, bpass) values (?, ?)";
	String sql = "select * from users where email=? and bpass=?";
	
	// 로그인에 성공했다면
	session.setAttribute("email", email);
	session.setAttribute("bpass", bpass);

	//3. 로그인 성공 시 - session 설정 (session.setAttribute) / jsp016_login.jsp 페이지로 넘어가기
	out.println("<script> location.href='jsp016_login.jsp'; </script>");
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, pass);
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, bpass);
		// out.print(pstmt);
		
		if( pstmt.executeUpdate()>0 ) {
			out.print("<script> location.href='jsp016_login.jsp'; </script>");
		} else {
			out.print("<script> history.go(-1); </script>");
		}
		
		if(pstmt != null ) {pstmt.close(); }
		if( conn != null ) { conn.close(); }
		
	} catch( Exception e ) { e.printStackTrace(); }
%>