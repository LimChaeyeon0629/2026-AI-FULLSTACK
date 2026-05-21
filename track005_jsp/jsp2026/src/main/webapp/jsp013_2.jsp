<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
	String name = request.getParameter("username");
	out.print( name );
	
	String [] op = request.getParameterValues("option1");
	// out.print( op );
	if(op!=null) {
		for (String value : op) {
			out.print( " " + value );
		}
	}
	
	Arrays.toString(op);
	
%>