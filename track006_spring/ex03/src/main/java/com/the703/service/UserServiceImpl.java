package com.the703.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	@Autowired UserMapper dao; //db관련
	@Autowired @Qualifier("passwordEncoder") PasswordEncoder pwencoder;

	@Override
	public int insert(UserDto dto) {
		AuthDto adto = new AuthDto();
		adto.setEmail( dto.getEmail() );
		
		adto.setAuth( "ROLE_MEMBER" );
		dao.insertAuth( adto ); // 권한 추가
		// 3.셋팅			2.암호화			1.사용자입력값
		dto.setBpass( pwencoder.encode(dto.getBpass()) );

		try { dto.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch(UnknownHostException e) { e.printStackTrace(); }
		
		return dao.insert(dto);
	}

	@Override
	public int findLogin(UserDto dto) {
		return dao.findLogin(dto);
	}

	@Override
	public UserDto findByUno(int uno) {
		return dao.findByUno(uno);
	}

	@Override
	public String findByEmail(String email) {
		return dao.findByEmail(email);
	}
	
	@Override
	public String findByNickname(String nickname) {
		// TODO Auto-generated method stub
		return dao.findByNickname(nickname);
	}

	@Override
	public int update(UserDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int uno) {
		return dao.delete(uno);
	}

	@Override
	public AuthListDto readAuth(AuthDto dto) {
		// TODO Auto-generated method stub
		return dao.readAuth(dto);
	}

	@Override
	public UserDto findByEmailUserInfo(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmailUserInfo(email);
	}

	
	
	
	
}