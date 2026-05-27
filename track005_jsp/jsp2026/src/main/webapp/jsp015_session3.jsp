<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
    
<%
/* jsp015_session3.jsp 초기화 */
	session.removeAttribute("username");
	session.removeAttribute("userage");
	
	// response.sendRedirect("jsp015_session.jsp"); // alert x
	out.println("<script> location.href='jsp015_session.jsp'; </script>"); // alert o
%>