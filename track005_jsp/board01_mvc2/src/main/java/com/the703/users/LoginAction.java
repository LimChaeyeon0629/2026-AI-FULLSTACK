package com.the703.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.mysql.cj.exceptions.ConnectionIsClosedException;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 폼으로
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 처리기능
		//1. 데이터 넘겨받기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String email = request.getParameter("email");
		String bpass = request.getParameter("bpass");
		
		HttpSession session = request.getSession(); // 로그인 상태 저장
		PrintWriter out = response.getWriter();		// 브라우저 출력
		
		//2. sql 처리 (드라이브연동 커넥션 pstmt rset)
		Connection conn=null;
		PreparedStatement pstmt=null;	ResultSet rset=null;

		String url="jdbc:mysql://localhost:3306/dbdbig";
		String user="root", pass="1234";
		String sql="select count(*) cnt	from users where email=? and bpass=?";
		int find = -1;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, bpass);
			
			rset = pstmt.executeQuery(); // = select
								// executeUpdate = insert, update, delete
			if( rset.next() ) {
				find = rset.getInt("cnt");
			} // 아이디랑 비번이 같은 유저는 1명
			
			// 해당 화면으로 넘기기
			if( find == 1 ) {
				session.setAttribute("email", email);
				out.println("<script> alert('성공!'); location.href='MyAction'; </script>");
			} else { out.println("<script> alert('실패...'); history.go(-1); </script>"); }
			
			if( rset != null) { rset.close(); }
			if(pstmt != null) { pstmt.close(); }
			if( conn != null) { conn.close(); }
		
		} catch ( Exception e ) { e.printStackTrace(); }
	}
}