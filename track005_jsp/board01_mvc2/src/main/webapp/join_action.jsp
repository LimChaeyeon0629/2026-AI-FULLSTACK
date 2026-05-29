<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%	// 회원가입 action form (insert → executeUpdate)
	String nickname = request.getParameter("nickname");
	String bpass = request.getParameter("bpass");
	String email = request.getParameter("email");
	String mobile = request.getParameter("mobile");
	String bip = InetAddress.getLocalHost().getHostAddress();
	
	Connection conn=null;	PreparedStatement pstmt=null;
	
	String url="jdbc:mysql://localhost:3306/dbdbig";
	
	String sql="insert into mvcboard1 (nickname , bpass , email, mobile , bip) values (?, ?, ?, ?, ?)";
	String user="root", pass="1234";

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, pass);
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nickname);
		pstmt.setString(2, bpass);
		pstmt.setString(3, email);
		pstmt.setString(4, mobile);
		pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
		//out.print(pstmt);
		
		if ( pstmt.executeUpdate() > 0 ) {
			out.println("<script> alert('회원가입 성공'); location.href='list.jsp'; </script>");
		} else { out.println("<script> alert('회원가입 실패'); history.go(-1); </script>"); }
		
		if(pstmt != null) { pstmt.close(); }
		if( conn != null) {  conn.close(); }
		
	} catch ( Exception e ) { e.printStackTrace(); }
%>