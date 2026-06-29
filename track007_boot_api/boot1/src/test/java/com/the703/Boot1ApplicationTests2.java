package com.the703;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import com.the703.dao.AppUserDao;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
import com.the703.dto.AuthDto;
import com.the703.service.AppUserService;

@SpringBootTest
class Boot1ApplicationTests2 {

	@Autowired AppUserDao dao;
	@Autowired AppUserService service;
	 @Autowired  private PasswordEncoder  passwordEncoder;
	
	
	@Disabled
	//@Test //삭제
	public void Delete_Service() {
		AppUserDto user = new AppUserDto();
		user.setEmail("8@8");
		user.setPassword("8");
		user.setAppUserId(49);
		assertEquals(1, service.delete(user, true));
		
//		AuthDto adto = new AuthDto();
//		adto.setEmail("8@8");
//		assertEquals(1, dao.deleteAuth(adto));
	}
	
	
	@Disabled
	//@Test //수정
	public void Update_Service() {
		AppUserDto user = new AppUserDto();
		user.setEmail("8@8");
		user.setPassword("8");
		user.setMbtiTypeId(88);
		user.setUfile("88.png");
		user.setNickname("88");
		user.setMobile("01088888888");
		user.setProvider("test");
		user.setAppUserId(49);
		
		MultipartFile file = new MockMultipartFile("file", "test.text", "text/plain", "data".getBytes());
		
		int result = service.update(file, user);
		assertEquals(1, result);
	}
	
	@Disabled
	//@Test //아이디중복
	public void IdDouble_Service() {
		int mypage = service.iddouble("8@8", "local");
		
		assertEquals(1, mypage);
	}
	
	@Disabled
	//@Test //마이페이지
	public void Mypage_Service() {
		AppUserDto mypage = service.selectEmail("8@8", "local");
		
		assertNotNull(mypage);
		assertEquals("8@8", mypage.getEmail());
	}
	       
	@Disabled
	//@Test //로그인
	public void Login_Service() {
//		AppUserDto user = new AppUserDto();
//		user.setEmail("6@6");
//		assertEquals(1, dao.readAuthByEmail(user));
		
		AppUserAuthDto login = service.readAuthByEmail("8@8", "local");
		
		assertNotNull(login);
		assertEquals("8@8", login.getEmail());
		assertTrue( login.getAuthList().stream().anyMatch(a -> "ROLE_MEMBER".equals(a.getAuth())) );
	}
	
	//@Disabled
	@Test
	public void Insert_Service() {
		AppUserDto user = new AppUserDto();
		user.setEmail("8@8");
		user.setPassword("8");
		user.setMbtiTypeId(8);
		user.setUfile("8.png");
		user.setNickname("8");
		user.setMobile("01088888888");
		user.setProvider("local");
		user.setProviderId("local_008");
		
		MultipartFile file = new MockMultipartFile("file", "test.text", "text/plain", "data".getBytes());
		
		int result = service.insert(file, user);
		assertEquals(1, result);
	}
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	
	
	
	
	//6. 동적sql (update)
	@Disabled //@Test
	public void Update_User() {
		AppUserDto user = new AppUserDto();
		user.setPassword("4");
		user.setMbtiTypeId(4);
		user.setUfile("4.png");
		user.setNickname("4");
		user.setMobile("01044444444");
		user.setProvider("local");
		user.setProviderId("local_004");
		
		int result = dao.updateAppUser(user);
		assertEquals(1, result);
	}
	
	//5. 사용자삭제 + 권한삭제
	@Disabled //@Test
	public void Delete_User() {
		AppUserDto user = new AppUserDto();
//		user.setEmail("3@3");
		user.setAppUserId(0);
		assertEquals(1, dao.deleteAppUser(user));
		
		AuthDto auth = new AuthDto();
		auth.setEmail("3@3");
		assertEquals(1, dao.deleteAuth(auth));
	}

	//4. 마이페이지
	@Disabled //@Test
	public void Mypage_User() {
		AppUserDto user = new AppUserDto();
		user.setEmail("3@3");
		
		assertEquals( "3@3", dao.findByEmail(user).getEmail() );
	}
	
	//3. 아이디중복
	@Disabled //@Test
	public void Double_Id() {
		AppUserDto user = new AppUserDto();
		user.setEmail("3@3");
		
		assertEquals(1, dao.iddoubleByEmail(user));
	}
	
	
	//2. 로그인
	@Disabled //@Test
	public void Login_User() {
		AppUserDto user = new AppUserDto();
		user.setEmail("3@3");
	
		assertNotNull( dao.readAuthByEmail(user) );
	}
	
	//1. 회원가입 - 유저등록 + 권한부여
	@Disabled //@Test 
	public void insert_User() {
		AppUserDto user = new AppUserDto();
		user.setEmail("4@4");
		user.setPassword("1");
		user.setMbtiTypeId(1);
		user.setUfile("1.png");
		user.setMobile("01011111111");
		user.setNickname("1");
		user.setProvider("local");
		user.setProviderId("local_001");
		
		int result = dao.insertAppUser(user);
		assertEquals(1, result); //예상되는 결과, 코드

		
		AuthDto auth = new AuthDto();
		auth.setEmail("4@4");
		auth.setAuth("ROLE_USER");
		auth.setAppUserId(25);
		
		int result_auth = dao.insertAuth(auth);
		assertEquals(1, result_auth);
		
	}
}
