<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
	//utf-8
	// request.setCharacterEncoding("UTF-8");

	// userage 넘어오는 데이터 확인
	int age = Integer.parseInt( request.getParameter("userage") );

	// 만약 19세 미만이라면 나이 넘어오는 데이터 확인
	if( age <19) {	// child sendredirect
		//response.sendRedirect("jsp013_child.jsp?userage=" + age); // 쿼리스트링 주소?name1=value1&name2=value2
		response.sendRedirect("jsp013_child.jsp");
	} else {		// adult 경로숨기기 dispatch
		request.getRequestDispatcher("jsp013_adult.jsp").forward(request, response);
	}
%>