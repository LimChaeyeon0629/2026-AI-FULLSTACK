<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
	request.setCharacterEncoding("UTF-8");
	int bno = Integer.parseInt( request.getParameter("bno") );
	String bname="", btitlc="", bcontent="", bpass="";
	
	Connection conn=null;
	PreparedStatement pstmt=null;	ResultSet rset=null;
	
	String url="jdbc:mysql://localhost:3306/dbdbig";
	String user="root", pass="1234";
	
	String sql1="update mvcboard1 set bhit=bhit+1 where bno=?";	// 조회수
	String sql2="select * from mvcboard1 where bno=?";			// 상세보기
	
	try {
		// 드라이버 연동
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc 연동
		conn = DriverManager.getConnection(url, user, pass);
		
		// sql 구문처리 (조회수)
		pstmt = conn.prepareStatement(sql1);
		pstmt.setInt(1, bno);
		if( pstmt.executeUpdate() > 0 ) { pstmt.close(); }
 		
		// sql 구문처리 (상세보기)
		pstmt = conn.prepareStatement(sql2);
		pstmt.setInt(1, bno);
		
		rset  = pstmt.executeQuery();				// 표
		if( rset.next() ) {							// 줄
			bname = rset.getString("bname");		// 칸
			btitlc = rset.getString("btitlc");
			bcontent = rset.getString("bcontent");
			bpass = rset.getString("bpass");
		}
		
    	if( rset != null ) {  rset.close(); }
    	if(pstmt != null ) { pstmt.close(); }
    	if( conn != null ) {  conn.close(); }
    	
	} catch ( Exception e ) { e.printStackTrace(); }
%>

	<%@include file="./inc/header.jsp" %>
 	<!-- header -->
 	
	<div class="container card my-5">
		<h3 class="card-header">글 수정</h3>
		
			<!-- 수정 form -->
			<form action="edit_action.jsp?bno=<%=bno%>" method="post" onsubmit="return checkForm()">
				
				<!-- no -->
				<input type="hidden" name="bno" value="<%=bno%>" />

				<!-- name -->
				<div class="container my-3">
					<label for="bname" class="form-label" >이름</label>
					<input type="text"
							value="<%=bname %>"
							class="form-control" placeholder="이름을 적어주세요!"
							id="bname" name="bname"
							readonly>
				</div>
				
				<!-- pw -->
				<div class="container my-3">
					<label for="bpass" class="form-label" >비밀번호</label>
					<input type="password"
							value="<%=bpass %>"
							class="form-control"
							id="bpass" name="bpass"
							readonly>
				</div>

				<!-- 제목 -->
				<div class="container my-3">
					<label for="btitlc" class="from-label" >제목</label>
					<input type="text"
							value="<%=btitlc %>"
							class="form-control" placeholder="제목을 적어주세요!"
							id="btitlc" name="btitlc">
				</div>
				
				<!-- 내용 -->
				<div class="container my-3">
					<label for="bcontent"  class="form-label">내용</label>
        		   <textarea  class="form-control"    
              			 id="bcontent"  name="bcontent"  ><%=bcontent%></textarea>
				</div>
				
				<div class="my-3 text-end">
					<button type="submit"   class="btn btn-danger" title="수정"  >수정</a>
					<button type="reset" class="btn btn-outline-danger" title="글 리셋" >글 리셋</button>
					<a href="list.jsp"   class="btn btn-outline-danger" title="목록보기" >목록보기</a>
				</div>
				
			</form> <!-- 주문 form end -->
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