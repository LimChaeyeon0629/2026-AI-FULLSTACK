package com.the703.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinAction
 */
@WebServlet("/JoinAction")
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 폼으로
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 처리기능
		
		// 데이터 넘겨받기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		String nickname = request.getParameter("nickname");
		String bpass = request.getParameter("bpass");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		// sql 확인
		Connection conn=null;	PreparedStatement pstmt=null;
		String url="jdbc:mysql://localhost:3306/dbdbig";
		String user="root", pass="1234";
		String sql="insert into users (nickname, bpass, email, mobile, bip) values (?, ?, ?, ?, ?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, pass);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			pstmt.setString(2, bpass);
			pstmt.setString(3, email);
			pstmt.setString(4, mobile);
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
			
			if(pstmt.executeUpdate() > 0) {
				out.println("<script> alert('회원가입 성공!'); location.href='LoginAction'; </script>");
			} else {
				out.println("<script> alert('회원가입 실패...'); history.go(-1); </script>");
			}
			
			if(pstmt != null) { pstmt.close(); }
			if( conn != null) { conn.close(); }
			
		} catch ( Exception e ) { e.printStackTrace(); }
		// 처리후 로그인 폼으로 (LoginAction - Get)
	}
}