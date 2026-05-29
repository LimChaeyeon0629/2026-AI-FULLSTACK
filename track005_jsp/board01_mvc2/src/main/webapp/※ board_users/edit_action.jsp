<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
	request.setCharacterEncoding("UTF-8");
	
	String btitlc = request.getParameter("btitlc");
	String bpass = request.getParameter("bpass");
	int bno = Integer.parseInt( request.getParameter("bno") );
	String bcontent = request.getParameter("bcontent");
	
	Connection conn=null;
	PreparedStatement pstmt=null;	ResultSet rset =null;

	String url="jdbc:mysql://localhost:3306/dbdbig";
	String user = "root", pass="1234";
	
	String sql="update mvcboard1 set btitlc=?, bcontent=?, bpass=? where bno=?";

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");	//3-1) Class.forName
		
		conn = DriverManager.getConnection(url, user, pass);	//3-2) db연동 (DriverManager.getConnection)
	
		pstmt = conn.prepareStatement(sql);		//3-3) update executeUpdate
		pstmt.setString(1, btitlc);				//executeUpdate = insert, delete, update
		pstmt.setString(2, bcontent);			//executeQuery  = select
		pstmt.setString(3, bpass); 
		pstmt.setInt(4, bno);
		
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