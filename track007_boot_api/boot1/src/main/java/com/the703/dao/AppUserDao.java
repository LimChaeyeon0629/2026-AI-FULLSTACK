package com.the703.dao;

import org.apache.ibatis.annotations.Mapper;

import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
import com.the703.dto.AuthDto;

@Mapper
public interface AppUserDao {
	public int insertAppUser(AppUserDto dto); //회원가입
	public AppUserAuthDto readAuthByEmail(AppUserDto dto); //로그인 - 이메일로 이메일, 비밀번호, 권한
	public AppUserDto findByEmail(AppUserDto dto); //이메일로 유저찾기
	public int iddoubleByEmail(AppUserDto dto); //이메일로 중복검사
	public int updateAppUser(AppUserDto dto); //회원수정
	public int deleteAppUser(AppUserDto dto); //회원삭제
	public int insertAuth(AuthDto dto); //권한삽입
	public int deleteAuth(AuthDto dto); //권한삭제
}
