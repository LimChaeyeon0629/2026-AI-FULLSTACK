package com.the703.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.the703.dao.AppUserDao;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
import com.the703.dto.AuthDto;
import com.the703.util.UtilUpload;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired private AppUserDao dao;
	@Autowired private UtilUpload upload;
	@Autowired private PasswordEncoder passwordencoder;
	
	@Transactional
	@Override
	public int insert(MultipartFile file, AppUserDto dto) {
		//이미지 업로드
		dto.setUfile("the703.png");
		if( !file.isEmpty() ) {
			try { dto.setUfile( upload.fileUpload(file) );
			} catch (IOException e) { e.printStackTrace(); }
		}
		
		//비밀번호 암호화
		dto.setProvider("the703");
 		dto.setPassword( passwordencoder.encode( dto.getPassword() ) );
		
		int result = dao.insertAppUser(dto); //# sql1 AppUserDto @Transactional
		
		AuthDto udto = new AuthDto();
		udto.setEmail( dto.getEmail() );
		udto.setAuth("ROLE_MEMBER");
		
		if( result > 0 ) { //# sql2 AuthDto	@Transactional
			dao.insertAuth(udto);
		}

		return result;
	}

	@Transactional
	@Override
	public int update(MultipartFile file, AppUserDto dto) {
		//비번이 안 맞으면 0, 맞으면 수정
		if( !matchesPassword(dto.getEmail(), dto.getProvider(), dto.getPassword()) ) {
			return 0;
		}
		
		//이미지 업로드 
		if( !file.isEmpty() ) {
			try { dto.setUfile( upload.fileUpload(file) );
			} catch (IOException e) { e.printStackTrace(); }
		}
		
		//비밀번호 바꾸기
//		if( matchesPassword(dto.getEmail(), dto.getProvider(), dto.getPassword()) ) {
//			return dto.setPassword( passwordencoder.encode( dto.getEmail() ) );;
//		}
		
		return dao.updateAppUser(dto);
	}

	@Transactional
	@Override
	public int delete(AppUserDto dto, boolean local) {
		//비번이 안 맞으면 0, 맞으면 삭제
		if( !matchesPassword(dto.getEmail(), dto.getProvider(), dto.getPassword()) ) {
			return 0;
		}
		
		AuthDto adto = new AuthDto();
		adto.setEmail( dto.getEmail() );
		adto.setAuth("ROLE_MEMBER");
		dao.deleteAuth(adto);
		
		return dao.deleteAppUser(dto);
	}

	@Override //로그인
	public AppUserAuthDto readAuthByEmail(String email, String provider) {
		AppUserDto dto = new AppUserDto();
		dto.setEmail(email);
		
		return dao.readAuthByEmail(dto);
	}

	@Override //마이페이지
	public AppUserDto selectEmail(String email, String provider) {
		AppUserDto dto = new AppUserDto();
		dto.setEmail(email);
		
		return dao.findByEmail(dto);
	}

	@Override //이메일중복
	public int iddouble(String email, String provider) {
		AppUserDto dto = new AppUserDto();
		dto.setEmail(email);
		
		return dao.iddoubleByEmail(dto);
	}

	@Override public boolean matchesPassword(String email, String provider, String rawPassword) { 
	       //1. dbUser 찾기
	       AppUserDto dbUser = new AppUserDto();   dbUser.setEmail(email);
	       AppUserDto result = dao.findByEmail(dbUser);  
	       //2. 비번맞는지 확인
	       return result != null  &&  result.getPassword() != null &&
	    		   passwordencoder.matches(rawPassword, result.getPassword());  // 사용자가 입력한 비번과 db비번
	    }
	
}