<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%	
	request.setCharacterEncoding("UTF-8");
	int bno = Integer.parseInt( request.getParameter("bno") );
%>
	
	
	<%@include file="./inc/header.jsp" %>
 	<!-- header -->
 	
	<div class="container card my-5">
		<h3 class="card-header">글 삭제</h3>
		
    	<!-- 삭제 form -->
		<form action="delete_action.jsp?bno<%= request.getParameter("bno") %>" method="post" onsubmit="return checkForm()">
			
			<!-- no -->
			<input type="hidden" name="bno" value="<%=bno %>" />
			
			<!-- pw -->
			<div class="container my-3">
				<label for="bpass" class="form-label" >비밀번호</label>
				<input type="password"
						class="form-control" placeholder="비밀번호를 적어주세요!"
						id="bpass" name="bpass">
			</div>
		
			<div class="my-3 text-end">
				<button type="submit" class="btn btn-danger" title="확인" >확인</button>
				<a href="list.jsp" 	  class="btn btn-outline-danger" title="취소" >취소</a>
			</div>
		</form> <!-- 삭제 form end -->
	</div>
		
	<!-- footer -->
	<%@include file="./inc/header.jsp" %>
	
	
	
<script>
	function checkForm(){
		let bpass = document.getElementById("bpass");
		
		if(bpass.value.trim()=="") {
			alert("비밀번호가 비어있습니다!");
			return false;
		}
		return true;
	}
</script>