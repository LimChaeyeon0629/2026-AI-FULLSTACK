<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
      
<%
/* jsp015_session4.jsp */
	session.invalidate(); // 로그아웃 할때 - 모든 세션의 정보 지우기
	response.sendRedirect("jsp015_session.jsp");
%>