<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.net.ConnectException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

	<%@include file="./inc/header.jsp" %>
 	<!-- header -->
 	
	<div class="container card my-5">
		<h3 class="card-header">글 삭제</h3>
		
    	<!-- 삭제 form -->
		<form action="delete.jsp" method="post" onsubmit="return checkForm()">

			<!-- pw -->
			<div class="container my-3">
				<label for="bpass" class="form-label" >비밀번호</label>
				<input type="text"
						class="form-control" placeholder="비밀번호를 적어주세요!"
						id="bpass" name="bpass">
			</div>
		
			<div class="my-3 text-end">
				<button type="submit" class="btn btn-danger" title="확인" >확인</button>
				<a href="list.jsp" 	  class="btn btn-danger" title="취소" >취소</a>
			</div>
		</form> <!-- 삭제 form end -->
	</div>
		
	<!-- footer -->
	<%@include file="./inc/footer.jsp" %>



<%
	String bpass = request.getParameter("bpass");
	
	try {
		
		Connection conn=null;
		PreparedStatement pstmt=null;	Resultset rset=null;
		String url="";
		String sql="";
		String user="root", pass="1234";

		Class.forName("");
		// db연동
		conn = DriverManager.getConnection("", user, pass);
		
		
	} catch(Exception e) { e.printStackTrace(); 
%>




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
</html>