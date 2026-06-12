package com.the703.service;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthUserDto;
import com.the703.dto.UserDto;

public interface UserService {

	public     AuthUserDto    readAuth( String email );
	
	public int      	 insert(UserDto dto);  //회원가입 
	
	public String   findByEmail( String email); //이메일중복검사
	public UserDto  findByEmailUserInfo(   String email);
//	public UserDto  findByNickname(   String nickname);
	public String  findByNickname(   String nickname);
	
}

