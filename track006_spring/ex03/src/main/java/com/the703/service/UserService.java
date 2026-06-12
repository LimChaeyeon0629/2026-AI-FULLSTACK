package com.the703.service;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto;

public interface UserService { // 서비스 로직 처리
	public int insert(UserDto dto); 				//회원가입: insert (int 쓰는이유 성공1, 실패0) + 권한 추가
	public int findLogin(UserDto dto); 				//로그인: findLogin
	public UserDto findByUno(int uno); 				//마이페이지: findByUno
	public String findByEmail(String email); 		//이메일중복: findByEmail
	public String findByNickname(String nickname); 	//닉네임중복: findByNickname
	public int update(UserDto dto);
	public int delete(int uno);
	
	/* security login */
	public AuthListDto readAuth(AuthDto dto);
	public UserDto findByEmailUserInfo(String email);
}
