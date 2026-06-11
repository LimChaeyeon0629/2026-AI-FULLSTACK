package com.the703.dao;

import com.the703.dto.AuthUserDto;
import com.the703.dto.UserDto;

@Mapper
public interface UserMapper {
	public AuthUserDto readAuth(String email);
	
	public UserDto findByEmailUserInfo(String email);
	
}
