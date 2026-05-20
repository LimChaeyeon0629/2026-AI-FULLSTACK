<%@page import="java.sql.*"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container card my-5">
		<h3 class="card-header"> PSTMT / STMT </h3>
		<pre class="alert alert-info">
			1. jdbc - Java Database Connectivity
			- java 와 db 연결해 sql 실행해주는 표준 api
			2. mysql, oracle,,, 다양한 dbms와 연결
			3. 사용방법
			https://dev.mysql.com/downloads/
			
			[src]-[main]-[webapp]-[WEB-INF]-[lib] -		mysql-connector-j-8.4.0.jar
			
			4. JDBC 사용방법
			1) Class.forName() 드라이버 로딩
			2) DriverManager.Connection 활성화
			3) Connection DB연동
			4) Statement, PreparedStatement sql 구문 실행
			PreparedStatement pstmt =
				conn.prepareStatement("insert into userinfo (name, age) values (?, ?)");
				
				pstmt.setString(1, "길동"); //? 순서, 값								↑
				pstmt.setInt(   2, 11   ); //? 순서, 값									↑
			
				int result = pstmt.executeUpdate();		//INSERT, UPDATE, DELETE, 실행한 줄수
				/////////////////////////////////////////////////////////////////////////////
			5) jdbc 연동끊기
		</pre>
		
		<%
		//1. 드라이버로딩  필요한 코드? "com.mysql.cj.jdbc.Driver"
        //2. JDBC 연동   필요한 코드? "jdbc:mysql://localhost:3306/mbasic"
        //3. JDBC 끊기   필요한 코드?  conn.close();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");				//1. 드라이버로딩
			Connection conn = DriverManager.getConnection(		//2. jdbc 연동
					"jdbc:mysql://localhost:3306/mbasic", "root", "1234");
			/////////////////////////////////////////////////////
			PreparedStatement pstmt =
				conn.prepareStatement("insert into userinfo (name, age) values (?, ?)");
			pstmt.setString(1, "길동"); //? 순서, 값(name)				 			↑
			pstmt.setInt(   2, 11   ); //? 순서, 값(age)								↑
			
			int result = pstmt.executeUpdate();		//INSERT, UPDATE, DELETE, 실행한 줄수
			if (result > 0) {
				out.print("길동이 insert 성공");
			}
			/////////////////////////////////////////////////////
			if(pstmt != null) {
				pstmt.close();									//3. pstmt (먼저) 연동끊기
			}
			if(conn != null) {
				out.print("연동완료! db연동close");
				conn.close();									//3. jdbc 연동끊기
			}
					
		} catch (Exception e) { e.printStackTrace(); }
		%>
		
		
		
		
		
		<%
		//1) Class.forName() 드라이버 로딩
		//2) DriverManager.Connection 활성화
		//3) Connection DB연동
		//1. 드라이버로딩  필요한 코드? "com.mysql.cj.jdbc.Driver"
        //2. JDBC 연동   필요한 코드? "jdbc:mysql://localhost:3306/mbasic"
        //3. JDBC 끊기   필요한 코드?  conn.close();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn =
					DriverManager.getConnection( "jdbc:mysql://localhost:3306/mbasic", "root", "1234");
			/////////////////////////////////////////////////////
			PreparedStatement 	pstmt = null;
			ResultSet 			rset  = null;
			pstmt = conn.prepareStatement("select * from userinfo");
			
			rset = pstmt.executeQuery(); //표:	executeQuery  - select
										 //		executeUpdate - insert, update, delete
	        /*		mysql> select * from userinfo;
		            +----+--------+------+
		            | no | name   | age  |
		            +----+--------+------+
		            |  1 | first  |   11 |
		            |  2 | second |   22 |
		            |  3 | third  |   33 |
		            |  4 | fourth |   44 |
		            +----+--------+------+ */
		            //해당하는 줄수
			while( rset.next() ) { 						// 줄 |  1 | first  |   11 |
				out.print("<p>" + 
						  rset.getInt("no") + "/"		// 칸 rset.getInt("필드명");
						+ rset.getString("name") + "/"
						+ rset.getInt("age") + "</p>");			
			}
		            
		            
			/////////////////////////////////////////////////////
			if(rset  != null) { rset.close(); }		// rset  끊기
			if(pstmt != null) { pstmt.close(); }	// pstmt 끊기
			if(conn  != null) { conn.close(); }		// conn  끊기
			
		} catch(Exception e) { e.printStackTrace(); }
		%>
   </div>
</body>
</html>