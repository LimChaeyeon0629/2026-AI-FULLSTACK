<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	// bno, bpass 넘겨받기
	int bno = Integer.parseInt( request.getParameter("bno") );
	String bpass = request.getParameter("bpass");
	
	Connection conn=null;
	PreparedStatement pstmt=null;	ResultSet rset=null;
	
	String url="jdbc:mysql://localhost:3306/dbdbig";
	String user="root", pass="1234";
	
	String sql="delete from mvcboard1 where bno=? and bpass=?";
	
	try {
		// 드라이버 연동
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db연동
		conn = DriverManager.getConnection(url, user, pass);
		
		pstmt = conn.prepareStatement(sql); 	// 컴파일
		pstmt.setInt(1, bno);					// 입력받은 bno 값
		pstmt.setString(2, bpass);				// 입력받은 bpass 값
		
		int result = pstmt.executeUpdate();		// executeUpdate 실행 (insert, delete, update)
			
		if( result >0 ) {
			out.print("<script> alert('성공!'); location.href='list.jsp'; </script>");
		} else { out.print("<script> alert('비밀번호 재입력!'); history.go(-1); </script>"); }
		
		if(pstmt != null ) { pstmt.close(); }
		if( conn != null ) { conn.close(); }
		
	} catch(Exception e) { e.printStackTrace(); }
%>