<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String bname = request.getParameter("bname");
	String bpass = request.getParameter("bpass");
	String btitlc = request.getParameter("btitlc");
	String bcontent = request.getParameter("bcontent");

	try {
		Connection conn=null;	PreparedStatement pstmt =null;
		String url="jdbc:mysql://localhost:3306/dbdbig";
		String sql="insert into mvcboard1 (bname , bpass , btitlc, bcontent , bip) values (?, ?, ?, ?, ?)";
		String user="root", pass="1234";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, pass);
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bname);
		pstmt.setString(2, bpass);
		pstmt.setString(3, btitlc);
		pstmt.setString(4, bcontent);
		pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
		
		if ( pstmt.executeUpdate() > 0 ) {
			out.println("<script> alert('글쓰기 성공'); location.href='list.jsp'; </script>");
		} else {
			out.println("<script> alert('글쓰기 실패'); location.href='list.jsp'; </script>");
		}
		
		if(pstmt != null) { pstmt.close(); }
		if( conn != null) {  conn.close(); }
		
	} catch ( Exception e ) { e.printStackTrace(); }
%>