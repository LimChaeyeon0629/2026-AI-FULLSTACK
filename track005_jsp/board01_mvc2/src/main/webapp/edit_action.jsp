<%@page import="java.sql.ResultSet"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
	request.setCharacterEncoding("UTF-8");
	
	String btitlc = request.getParameter("btitlc");
	String bpass = request.getParameter("bpass");
	String bno = request.getParameter("bno");
	String bcontent = request.getParameter("bcontent");
	
	try {
		Connection conn=null; PreparedStatement pstmt=null;
		ResultSet rset =null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");	//3-1) Class.forName
		String url="jdbc:mysql://localhost:3306/dbdbig";
		String sql="update mvcboard1 set btitlc=?, bcontent=?, bpass=? where bno=?";
		
		conn = DriverManager.getConnection(url, "root", "1234");	//3-2) db연동 (DriverManager.getConnection)
	
		pstmt = conn.prepareStatement(sql);		//3-3) update executeUpdate
		pstmt.setString(1, btitlc);				//executeUpdate = insert, delete, update
		pstmt.setString(2, bcontent);			//executeQuery  = select
		pstmt.setString(3, bpass);	
		pstmt.setString(4, bno);				
		
		int result = pstmt.executeUpdate();
		
		if(result > 0) {
			out.println("<script> alert('성공!'); location.href='list.jsp'; </script>");
		} else {
			out.println("<script> alert('실패...'); location.href='list.jsp'; </script>");
		}
		
		// close()
		if( pstmt != null ) { pstmt.close(); }
		if( conn  != null ) { conn.close(); }
		
	} catch(Exception e) { e.printStackTrace(); }
%>