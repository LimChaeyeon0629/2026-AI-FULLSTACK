package com.the703.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.the703.dao.AppUserDao;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
import com.the703.security.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired AppUserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//1. username											1@1 : local		2@2 : kakao
		String [] parts = username.split(":"); // : 기준으로 분리	{1@1, local}	{2@2, kakao}
		
		String email = parts[0];
		String provider = parts.length > 1 ? parts[1] : "local"; // local - 회원가입한 사람
		
		AppUserDto dto = new AppUserDto();
		dto.setEmail(email);
		dto.setProvider(provider);
		AppUserAuthDto authDto = dao.readAuthByEmail(dto); // 권한 - username, password, List<AppUserDto>
		
		AppUserDto appUserDto = dao.findByEmail(dto); // 사용자 정보들
		
		return new CustomUserDetails(appUserDto, authDto); // 사용자 정보, 사용자 로그인 정보
	}

}
