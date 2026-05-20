<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<!-- header -->
<!-- header -->
	<div class="p-5 bg-danger text-white">
		<h1>MILK ORDER Project</h1>
		<p>MVC1 - PreparedStatement Ex</p>
	</div>
	

<!-- 메뉴판테이블 -->
<!-- 메뉴판테이블 -->
	<div class="container card my-5">
		<h2 class="card-header bg-danger text-white" >Milk Menu</h2>
       	
       	<!-- https://www.w3schools.com/bootstrap5/bootstrap_tables.php -->
       	<table class="table my-3 bg-dark text-white">
       		<caption>우유메뉴</caption>
	       	<thead>
		       	<tr>
		       		<th scope="col">NO</th>
		       		<th scope="col">NAME</th>
		       		<th scope="col">PRICE</th>
		       	</tr>
	       	</thead>
	       	
	       	<tbody>
	       	<% 
	       	try{
	       		Class.forName("com.mysql.cj.jdbc.Driver");		//1. 드라이버연동	
	       		Connection conn=null;
	       		PreparedStatement pstmt=null;
	       		ResultSet rset = null;
	       		
	       		//2. JDBC 연동
	       		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234"); 
	       		
	       		// 1 white  1500
	       		// 2 choch  1800
	       		// 3 banana 1800
	       		//3. PreparenedStatement pstmt 이용해서 milk 테이블의 데이터 가져오기 (가격이 낮은 순으로)
	       		pstmt = conn.prepareStatement("select * from milk_order by oprice asc");
	       		
	       		rset= pstmt.executeQuery(); 	// 표
	       		while ( rset.next() ) {			// 줄
	       			out.println("<tr><td>" 
	       					+ rset.getInt("ono") + "</td><td>"
	       					+ rset.getString("oname") + "</td><td>"
	       					+ rset.getInt("oprice") + "</td></tr>");
	       		}

	       		
	       		//4. JDBC 끊기
	       		if(rset  != null) { rset.close(); }
	       		if(pstmt != null) { pstmt.close(); }
	       		if(conn  != null) { conn.close(); }
	       		
	       	} catch(Exception e) { e.printStackTrace(); }
	       	%>
	       	</tbody>
       	</table>
	</div>


<!-- 주문현황표 (입력받은 거 띄우기) -->
<!-- 주문현황표 -->
	<div class="container card my-5 bg-dark">
		<h2 class="card-header text-white" >MILK ORDER</h2>
		<table class="table table-striped table-bordered table-hover">
			<caption class="order text-white">주문현황표</caption>
			<thead>
				<tr>
					<th scope="col">NO</th>
					<th scope="col">NAME</th>
					<th scope="col">NUM</th>
					<th scope="col">DATE</th>
				</tr>
			</thead>
			<tbody>
			<%
			try {
		       	// 드라이버 연동
				Class.forName("com.mysql.cj.jdbc.Driver");

		       	Connection 			 conn = null;
	 			PreparedStatement 	pstmt = null;
		       	ResultSet			 rset = null;
				String url="jdbc:mysql://localhost:3306/mbasic";
				String sql="select * from milk_order order by ono desc";
				
				// jdbc 연동
		       	conn = DriverManager.getConnection(url, "root", "1234");
				
				// pstmt 사용 sql 연동 - 	pstmt.executeQuery(); (select)
				//						pstmt.executeUpdate(); (update, insert, delete)
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();	//표
				
				while( rset.next() ) {			//줄
					out.print("<tr><td>" + rset.getInt("ono")
							+ "</td><td>" + rset.getString("oname")
							+ "</td><td>" + rset.getInt("onum")
							+ "</td><td>" + rset.getString("odate")
							+ "</td></tr>");
				}
				if(rset  != null) { rset.close(); }
				if(pstmt != null) { pstmt.close(); }
				if(conn  != null) { conn.close(); }
				
			} catch (Exception e) { e.printStackTrace(); }
			%>
			</tbody>
		</table>
	</div>
	

	
<!-- 주문 수정 삭제 -->
<!-- 주문 수정 삭제 -->
	<div class="container card my-5 bg-dark">
		<h3 class="card-header text-white" >Milk Menu</h3>
		
		<!-- 2. milk 주문하러가기
			1) form 만들기
			2) 빈칸검사
			3) 처리해결사
			jsp012_insert.jsp
			데이터 노출x
			보관용기 mname, mprice -->
			
		<div id="accordion">
		
		<!-- insert -->
		<div class="card">
		    <div class="card-header bg-danger">
		    	<a class="btn" data-bs-toggle="collapse" href="#collapseOne" >주문하기</a>
		    </div>
		    	  
		    <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
		    	<div class="card-body">
			    	<!-- 주문 form -->
					<form action="jsp012_insert.jsp" method="post" onsubmit="return check()">
						<div class="container my-3">
							<label for="oname" class="form-label" >주문할 우유 이름</label>
							<input class="form-control" placeholder="주문할 우유 이름을 적어주세요!"
									id="oname" name="oname"></input>
						</div>
						<div class="container my-3">
							<label for="onum" class="from-label" >주문할 우유 갯수</label>
							<input class="form-control" placeholder="우유 갯수를 적어주세요!"
									id="onum" name="onum"
									min="0" max="100"></input>
						</div>
						<div class="container my-3">
							<button class="btn btn-danger" title="주문하러가기">주문하기</button>
						</div>
					</form> <!-- 주문 form end -->
				</div>
			</div>
			
		</div>
		
		<!-- update -->
		<div class="card">
		    <div class="card-header bg-danger">
		    	<a class="collapsed btn" data-bs-toggle="collapse" href="#collapseTwo" >주문수정</a>
		    </div>
		    
		    <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
		    	<div class="card-body">
		        	<!-- 수정 form -->
					<form action="jsp012_update.jsp" method="post" onsubmit="return check1()">
						<div class="container my-3">
							<label for="oname1" class="form-label" >수정할 우유 이름</label>
							<input class="form-control" placeholder="수정할 우유 이름을 적어주세요!"
									id="oname1" name="oname"></input>
						</div>
						<div class="container my-3">
							<label for="onum1" class="from-label" >수정할 우유 갯수</label>
							<input class="form-control" placeholder="수정할 우유 갯수를 적어주세요!"
									id="onum1" name="onum"
									min="0" max="100"></input>
						</div>
						<div class="container my-3">
							<button type="submit" class="btn btn-danger" title="수정하러가기">수정하기</button>
						</div>
					</form> <!-- 수정 form end -->
		    	</div>
		  	</div>
		</div>
	
		<!-- delete -->
		<div class="card">
	    <div class="card-header bg-danger">
	    	<a class="collapsed btn" data-bs-toggle="collapse" href="#collapseThree" >주문삭제</a>
	    </div>
	    
	    <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
	    	<div class="card-body">
	        	<!-- 삭제 form -->
				<form action="jsp012_delete.jsp" method="post" onsubmit="return check2()">
					<div class="container my-3">
						<label for="name2" class="form-label" >주문할 우유 이름</label>
						<input class="form-control" placeholder="삭제할 우유 이름을 적어주세요!"
								id="name2" name="name"></input>
					</div>
					<div class="container my-3">
						<label for="onum2" class="from-label" >주문할 우유 갯수</label>
						<input class="form-control" placeholder="우유 갯수를 적어주세요!"
								id="onum2" name="onum"
								min="0" max="100"></input>
					</div>
					<div class="container my-3">
						<button type="submit" class="btn btn-danger" title="삭제하러가기" >삭제하기</button>
					</div>
				</form> <!-- 삭제 form end -->
	    	</div>
		</div>
		
		</div>
	</div>
	</div>
	
	
</body>
</html>