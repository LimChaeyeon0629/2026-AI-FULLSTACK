<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
// jsp012_insert.jsp

	//1. utf-8 설정
	request.setCharacterEncoding("UTF-8");	
	//2. request.getParameter() 이용해서 데이터 받기
	String oname = request.getParameter("oname");
	int		onum = Integer.parseInt(request.getParameter("onum"));
	
	out.println(oname + " / " + onum);
	//3. insert 구문처리
	//3-1. Class.forName
	Class.forName("");
	
	//3-2. jdb연동 DriverManager.getConnection
	// DriverManager.get
	
	//3-3. insert executeUpdate
	//3-4. close
	
	//4. jsp012_milks.jsp로 돌아가기


%>