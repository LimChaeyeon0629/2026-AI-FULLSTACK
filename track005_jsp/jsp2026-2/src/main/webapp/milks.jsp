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
	       		pstmt = conn.prepareStatement("select * from milk order by mprice asc");
	       		
	       		rset= pstmt.executeQuery(); 	// 표
	       		while ( rset.next() ) {			// 줄
	       			out.println("<tr><td>" 
	       					+ rset.getInt("mno") + "</td><td>"
	       					+ rset.getString("mname") + "</td><td>"
	       					+ rset.getInt("mprice") + "</td></tr>");
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


<!-- 주문현황표 -->
<!-- 주문현황표 -->

	<!-- 
	= MODEL
	★ 다음과 같이 테이블을 준비해주세요!
	mysql> desc milk_order;
	+-------+--------------+------+-----+-------------------+-------------------+
	| Field | Type         | Null | Key | Default           | Extra             |
	+-------+--------------+------+-----+-------------------+-------------------+
	| ono   | int          | NO   | PRI | NULL              | auto_increment    |
	| oname | varchar(20)  | NO   |     | NULL              |                   |
	| onum  | int          | NO   |     | NULL              |                   |
	| odate | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
	| oip   | varchar(100) | NO   |     | NULL              |                   |
	+-------+--------------+------+-----+-------------------+-------------------+
	5 rows in set (0.00 sec)
	
	
	-- Q1.  milk_order 값삽입.  insert 구문 완성    
	-- Q2.  milk_order ono가 1인데이터 조회 
	-- Q3.  milk_order 전체데이터조회
	-- Q4.  milk_order 해당번호의 이름과 갯수 수정
	-- Q5.  milk_order 해당번호의 데이터 삭제
	
	
	
	 -->
	<!-- <div class="container card my-5">
		<h2 class="card-header bg-danger text-white" >MILK ORDER</h2>
			<thead>
				<tr>
					<th>NO</th>
					<th>NAME</th>
					<th>NUM</th>
					<th>주문날짜</th>
				</tr>
			</thead>
			
			<tbody>
			</tbody>
	
	
	
	</div> -->
	

	
<!-- 주문 수정 삭제 -->
<!-- 주문 수정 삭제 -->
	<!-- <div class="container card my-5">
		<h2 class="card-header bg-danger text-white" >Milk Menu</h2>
		
		<form action="" method="get" onsubmit="return check()">
			<div class="container my-5">
				<label for="name" class="form-label" >주문할 우유 이름</label>
				<input class="form-control" value="주문할 우유 이름을 적어주세요!"
						id="name" name="name"></input>
			</div>
			
			<div class="container my-5">
				<label for="cnt" class="from-label" >주문할 우유 갯수</label>
				<input class="form-control" value="우유 갯수를 적어주세요!"
						id="cnt" name="cnt"
						min="0" max="100"></input>
			</div>
			
			<div class="container my-5">
				<button class="btn btn-danger" title="주문하러가기">주문하기</button>
			</div>
		</form>
	</div> -->
	
</body>
</html>