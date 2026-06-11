package com.the703.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.the703.dao.Mapper;
import com.the703.dao.UserMapper;
import com.the703.dto.AuthUserDto;

//import com.the703.dto.AuthDto;
//import com.the703.dto.AuthListDto;
//import com.the703.service.UserService;

public class CustomUserDetailsService implements UserDetailsService{
//	@Autowired UserService service;
	@Autowired UserMapper Mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AuthUserDto dto = Mapper.readAuth(username); // username - email, bpass, auth(s)
		
		return dto == null? null : new CustomUser(dto);
	}

}