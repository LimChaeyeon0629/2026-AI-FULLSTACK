package com.the703.users;

import java.io.IOException;
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

import com.mysql.cj.exceptions.ConnectionIsClosedException;

/**
 * Servlet implementation class MyAction
 */
@WebServlet("/MyAction")
public class MyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인정보확인 (로그인한정보로 서버에서 해당이메일의 정보가져오기) - session
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession(); // 서버에 저장되어 있는 유저정보 확인
		String email = (String)session.getAttribute("email");

		// sql - 내 정보 가져오기 (select * from where email=?)
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
		String url="jdbc:mysql://localhost:3306/dbdbig", user="root", pass="1234";
		String sql="select * from users where email=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();	// 표
			if(rset.next()) {				// 줄
				// rset.getInt("nickname") 컬럼 값을 가져와서 nickname 에 저장
				request.setAttribute("nickname", rset.getString("nickname"));	// 칸
				request.setAttribute("email", rset.getString("email"));
				request.setAttribute("mobile", rset.getString("mobile"));
				request.setAttribute("udate", rset.getString("udate"));
				request.setAttribute("bip", rset.getString("bip"));
			}
			
		} catch ( Exception e ) { e.printStackTrace(); }
		
		// mypage.jsp로 경로 넘기기
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
