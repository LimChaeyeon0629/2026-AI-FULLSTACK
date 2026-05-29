<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

	<%@include file="./inc/header.jsp" %>
 	<!-- header -->

    <!-- section -->
    <section class="container my-5">
        <h3>MultiBoard</h3>
        <table class="table table-striped table-bordered table-hover table-secondary">
            <!-- THAED TBODY TFOOT -->
            <caption> BOARD 목록 </caption>
            <thead>
                <tr>
                    <th scope="col">NO</th>
                    <th scope="col">TITLE</th>
                    <th scope="col">WRITER</th>
                    <th scope="col">DATE</th>
                    <th scope="col">HIT</th>
                </tr>
            </thead>
            <tbody>
            <%
           	Connection conn = null; 	PreparedStatement pstmt = null;
           	ResultSet  rset = null;

           	String url="jdbc:mysql://localhost:3306/dbdbig";
           	String user="root", pass="1234";
           	
           	// String sql="select * from mvcboard1 b	order by bno desc";
           	// String sql="select count(*) from mvcboard1 b	order by bno desc";
           	String sql="select b.* , ( select count(*) from mvcboard1 ) `cnt`"	
           			 + "from mvcboard1 b	order by bno desc";
 
           	try {
            	// 드라이버 연동
            	Class.forName("com.mysql.cj.jdbc.Driver");
            	
            	// jdbc 연동
            	conn = DriverManager.getConnection(url, user, pass);
            	
            	// sql 연동
                pstmt = conn.prepareStatement(sql , ResultSet.TYPE_SCROLL_INSENSITIVE,
                									ResultSet.CONCUR_READ_ONLY);
            	rset = pstmt.executeQuery();	// 표 ( select -> executeQuery() )
            	//1) 먼저 전체글 갯수 출력
				int cnt=-1;
				//		줄
            	if( rset.next() ) {
					cnt = rset.getInt("cnt");	// 칸
					rset.beforeFirst();			// 다시 처음으로 표부터 처리
				}
            	//2) 
            	while( rset.next() ) {			// 줄
            		out.println( "<tr><td>" + cnt-- /* rset.getInt("bno") */	// 칸
            				+ "</td><td> <a href='detail.jsp?bno=" + rset.getInt("bno") + "'>" 
            				+ rset.getString("btitlc")
            				+ "</a> </td><td>"
            				+ rset.getString("bname")
            				+ "</td><td>"
            				+ rset.getString("bdate")
            				+ "</td><td>"
            				+ rset.getInt("bhit")
            				+ "</td></tr>");
            	}
            	if( rset != null ) {  rset.close(); }
            	if(pstmt != null ) { pstmt.close(); }
            	if( conn != null ) {  conn.close(); }
            	
            } catch (Exception e) { e.printStackTrace(); }
            %>
			</tbody>
        </table>
        
        <div class="text-end">
            <a href="write.jsp" title="글쓰기 폼" class="badge rounded-pill bg-primary p-3">글쓰기</a>
        </div>
    </section> <!-- section END -->
    
    <!-- footer -->
	<%@include file="./inc/footer.jsp" %>