<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
	request.setCharacterEncoding("UTF-8");
	int bno = Integer.parseInt(request.getParameter("bno"));
	
	String bname="", btitlc="", bcontent=""; int bhit=0;
	
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
			bhit = rset.getInt("bhit");
		}
    	if( rset != null ) {  rset.close(); }
    	if(pstmt != null ) { pstmt.close(); }
    	if( conn != null ) {  conn.close(); }
    	
	} catch ( Exception e ) { e.printStackTrace(); }
%>


	<%@include file="./inc/header.jsp" %>
 	<!-- header -->
 	
	<div class="container card my-5">
		<h3 class="card-header">글 상세보기</h3>
		
    	<!-- 디테일 form -->
		<form action="detail.jsp" method="post" onsubmit="return checkForm()">
			
			<!-- bhit 
			<div class="container my-3">
				<label for="bhit" class="form-label" >조회수</label>
				<input type="text"
						value="<%=bhit%>"
						class="form-control"
						id="bhit" name="bhit"
						readonly >
			</div> -->

			<!-- name -->
			<div class="container my-3">
				<label for="bname" class="form-label" >이름</label>
				<input type="text"
						value="<%=bname%>"
						class="form-control"
						id="bname" name="bname"
						readonly >
			</div>
			
			<!-- 제목 -->
			<div class="container my-3">
				<label for="btitlc" class="from-label" >제목</label>
				<input type="text"
						value="<%=btitlc%>"
						class="form-control"
						id="btitlc" name="btitlc"
						readonly >
			</div>
			
			<!-- 내용 -->
			<div class="container my-3">
				<label for="bcontent"  class="form-label">내용</label>
            <textarea  class="form-control"    
               id="bcontent"  name="bcontent"  readonly ><%=bcontent%></textarea>
			</div>
			
			<div class="my-3 text-end">
				<a href="edit.jsp?bno=<%=bno%>"    class="btn btn-danger" title="수정" >수정</a>
				<a href="delete.jsp?bno=<%=bno %>" class="btn btn-danger" title="삭제" >삭제</a>
				<a href="list.jsp"   class="btn btn-outline-danger" title="목록보기" >목록보기</a>
			</div>
		</form> <!-- 디테일 form end -->
		
	</div>
	
	<!-- footer -->
	<%@include file="./inc/footer.jsp" %>