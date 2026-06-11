package com.the703.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the703.dto.AuthUserDto;
import com.the703.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired UserService service;

	@Override
	public AuthUserDto readAuth(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto findByEmailUserInfo(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
