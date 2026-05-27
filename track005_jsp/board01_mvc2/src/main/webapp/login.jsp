<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	<%@include file="./inc/header.jsp" %>
 	<!-- header -->
 	
	<div class="container card my-5">
		<h3 class="card-header">로그인</h3>
		
	    	<!-- 로그인 form -->
			<form action="login_action.jsp" method="post" onsubmit="return checkForm()">
				<!-- 이메일 -->
				<div class="container my-3">
					<label for="email" class="from-label" >이메일</label>
					<input type="text"
							class="form-control" placeholder="이메일을 적어주세요!"
							id="email" name="email">
				</div>
				
				<!-- pw -->
				<div class="container my-3">
					<label for="bpass" class="form-label" >비밀번호</label>
					<input type="text"
							class="form-control" placeholder="비밀번호를 적어주세요!"
							id="bpass" name="bpass">
				</div>
				
				<div class="my-3 text-end">
					<button type="list.jsp"  class="btn btn-outline-danger" title="취소하기" >취소</button>
					<button type="submit" class="btn btn-danger" title="로그인" >로그인</button>
				</div>
			</form> <!-- 로그인 form end -->
		</div>
		
	<!-- footer -->
	<%@include file="./inc/footer.jsp" %>


<script>
	function checkForm(){
		let email = document.getElementById("email");
		let bpass = document.getElementById("bpass");
		if(email.value.trim()=="") {
			alert("이메일이 비어있습니다!");
			return false;
		}
		if(bpass.value.trim()=="") {
			alert("비밀번호가 비어있습니다!");
			return false;
		}
		return true;
	}
</script>