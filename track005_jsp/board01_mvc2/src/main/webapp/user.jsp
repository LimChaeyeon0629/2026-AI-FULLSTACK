<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	<%@include file="./inc/header.jsp" %>
 	<!-- header -->
 	
	<div class="container card my-5">
		<h3 class="card-header">회원가입</h3>
		
	    	<!-- 회원가입 form -->
			<form action="user_action.jsp" method="post" onsubmit="return checkForm()">
				
				<!-- nickname -->
				<div class="container my-3">
					<label for="nickname" class="form-label" >닉네임</label>
					<input type="text"
							class="form-control" placeholder="닉네임을 적어주세요!"
							id="nickname" name="nickname">
				</div>

				<!-- pw -->
				<div class="container my-3">
					<label for="bpass" class="form-label" >비밀번호</label>
					<input type="text"
							class="form-control" placeholder="비밀번호를 적어주세요!"
							id="bpass" name="bpass">
				</div>
				
				<!-- 이메일 -->
				<div class="container my-3">
					<label for="email" class="from-label" >이메일</label>
					<input type="text"
							class="form-control" placeholder="이메일을 적어주세요!"
							id="email" name="email">
				</div>
				
				<!-- 휴대폰 -->
				<div class="container my-3">
					<label for="mobile" class="from-label" >전화번호</label>
					<input type="text"
							class="form-control" placeholder="전화번호를 적어주세요!"
							id="mobile" name="mobile">
				</div>
				
				<div class="my-3 text-end">
					<button type="reset"  class="btn btn-outline-danger" title="글 리셋" >글 리셋</button>
					<button type="submit" class="btn btn-danger" title="가입하기" >가입하기</button>
				</div>
			</form> <!-- 등록 form end -->
		</div>
		
	<!-- footer -->
	<%@include file="./inc/footer.jsp" %>




<script>
	function checkForm(){
		let nickname = document.getElementById("nickname");
		let bpass = document.getElementById("bpass");
		let email = document.getElementById("email");
		let mobile = document.getElementById("mobile");
		
		if(nickname.value.trim()=="") {
			alert("닉네임이 비어있습니다!");
			return false;
		}
		if(bpass.value.trim()=="") {
			alert("비밀번호가 비어있습니다!");
			return false;
		}
		if(email.value.trim()=="") {
			alert("이메일이 비어있습니다!");
			return false;
		}
		if(mobile.value.trim()=="") {
			alert("전화번호가 비어있습니다!");
			return false;
		}
		return true;
	}
</script>