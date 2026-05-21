<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
// jsp012_delete.jsp

	//1. utf-8 설정
	request.setCharacterEncoding("UTF-8");




	//2. request.getParameter() 이용해서 데이터 받기 // getParameter(String name) name값
	int		 ono = Integer.parseInt( request.getParameter("ono") );
	
	//3. delete 구문처리
	try {
		Connection conn = null; PreparedStatement pstmt = null;
		
		//3-1. Class.forName
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mbasic";
		String sql="delete from milk_order where ono=?";
		
		//3-2. jdb연동 DriverManager.getConnection
		conn = DriverManager.getConnection(url, "root", "1234");
		
		//3-3. delete executeUpdate
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ono);
		
		int result = pstmt.executeUpdate(); // insert, update, delete 실행한 줄수
		
		//4. milks.jsp로 돌아가기	- alert(알림창)			location.href=주소표시창 경로
		if(result > 0) { 
			out.println("<script> alert('삭제 성공했습니다.');	location.href='milks.jsp';	</script>");
		} else {
			out.println("<script> alert('우유삭제 실패 (관리자 문의)');	location.href='milks.jsp';	</script>");
		}

		//3-4. close
		if( pstmt != null ) { pstmt.close(); }
		if( conn  != null ) { conn.close(); }

	} catch (Exception e) { e.printStackTrace(); }
	
	


%>