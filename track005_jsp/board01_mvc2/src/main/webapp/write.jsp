<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@include file="./inc/header.jsp" %>
 	<!-- header -->
 	
	<div class="container card my-5">
		<h3 class="card-header">글 등록</h3>
		
	    	<!-- 등록 form -->
			<form action="write_action.jsp" method="post" onsubmit="return checkForm()">
				
				<!-- name -->
				<div class="container my-3">
					<label for="bname" class="form-label" >이름</label>
					<input type="text"
							class="form-control" placeholder="이름을 적어주세요!"
							id="bname" name="bname">
				</div>

				<!-- pw -->
				<div class="container my-3">
					<label for="bpass" class="form-label" >비밀번호</label>
					<input type="text"
							class="form-control" placeholder="비밀번호를 적어주세요!"
							id="bpass" name="bpass">
				</div>
				
				<!-- 제목 -->
				<div class="container my-3">
					<label for="btitlc" class="from-label" >제목</label>
					<input type="text"
							class="form-control" placeholder="제목을 적어주세요!"
							id="btitlc" name="btitlc">
				</div>
				
				<!-- 내용 -->
				<div class="container my-3">
					<label for="bcontent"  class="form-label">내용</label>
            <textarea  class="form-control"    
               id="bcontent"  name="bcontent"  ></textarea>
				</div>
				
				<div class="my-3 text-end">
					<button type="reset"  class="btn btn-outline-danger" title="글 리셋" >글 리셋</button>
					<a href="list.jsp"    class="btn btn-outline-danger" title="목록보기">목록</a>
					<button type="submit" class="btn btn-danger" title="글등록" >글등록</button>
				</div>
			</form> <!-- 등록 form end -->
		</div>
		
	<!-- footer -->
	<%@include file="./inc/footer.jsp" %>




<script>
	function checkForm(){
		let bname = document.getElementById("bname");
		let bpass = document.getElementById("bpass");
		let btitle = document.getElementById("btitlc");
		let bcontent = document.getElementById("bcontent");
		
		if(bname.value.trim()=="") {
			alert("이름이 비어있습니다!");
			return false;
		}
		if(bpass.value.trim()=="") {
			alert("비밀번호가 비어있습니다!");
			return false;
		}
		if(btitlc.value.trim()=="") {
			alert("제목이 비어있습니다!");
			return false;
		}
		if(bcontent.value.trim()=="") {
			alert("내용이 비어있습니다!");
			return false;
		}
		return true;
	}
</script>