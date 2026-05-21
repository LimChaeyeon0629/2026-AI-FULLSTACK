<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
// update

	//1. utf-8 설정
	request.setCharacterEncoding("UTF-8");
	
	//2. 데이터 넘겨받기 request.getParameter()
	int		 ono = Integer.parseInt( request.getParameter("ono") );
	String oname = request.getParameter("oname");
	int		onum = Integer.parseInt( request.getParameter("onum") );
	
	//3. update 구문처리
	try {
		Connection conn=null; PreparedStatement pstmt=null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");	//3-1) Class.forName
		String url="jdbc:mysql://localhost:3306/mbasic";
		String sql="update milk_order set oname=?, onum=? where ono=?";
		
		conn = DriverManager.getConnection(url, "root", "1234");	//3-2) db연동 (DriverManager.getConnection)
	
		pstmt = conn.prepareStatement(sql);		//3-3) update executeUpdate
		pstmt.setString(1, oname);				//executeUpdate = insert, delete, update
		pstmt.setInt(2, onum);					//executeQuery  = select
		pstmt.setInt(3, ono);
		
		int result = pstmt.executeUpdate();
		
		//4. milks.jsp로 돌아가기
		if(result > 0) {
			out.println("<script> alert('수정성공!'); location.href='milks.jsp'; </script>");
		} else {
			out.println("<script> alert('수정실패...'); location.href='milks.jsp'; </script>");
		}
		
		// close()
		if( pstmt != null ) { pstmt.close(); }
		if( conn  != null ) { conn.close(); }
		
	} catch(Exception e) { e.printStackTrace(); }
%>