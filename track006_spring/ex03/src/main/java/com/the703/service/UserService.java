package com.the703.service;

import com.the703.dto.UserDto;

public interface UserService { // 서비스 로직 처리
	public int insert(UserDto dto); 			//회원가입: insert (int 쓰는이유 성공1, 실패0)
	public int findLogin(UserDto dto); 			//로그인: findLogin
	public UserDto findByUno(int uno); 			//마이페이지: findByUno
	public String findByEmail(String email); 	//이메일중복: findByEmail
	public int update(UserDto dto);
	public int delete(int uno);
}
