package ex02;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto;
import com.the703.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)	//1.spring 구동
// @ContextConfiguration(locations = "classpath:config/*-context.xml") //2.설정파일
@ContextConfiguration(locations = 
			{"classpath:config/root-context.xml", "classpath:config/security-context.xml"}) //2.설정파일
public class ModelTest2 {
	@Autowired UserMapper user;
	@Autowired UserService service;
	@Autowired @Qualifier("passwordEncoder") PasswordEncoder pwencoder;
	// import org.springframework.security.crypto.password.PasswordEncoder;
	
	/* security */
	@Test
	public void test3() {
		/* 로그인시 인가 (해당유저 정보 가져오기) */
		AuthDto dto2 = new AuthDto();
		dto2.setEmail("a@a");
		System.out.println( user.readAuth(dto2) );
		
		
		/* 권한등록 회원(MEMBER & ADMIN) */
//		AuthDto dto1 = new AuthDto();
//		dto1.setEmail("a@a"); dto1.setAuth("ROLE_MEMBER");
//		dto1.setEmail("a@a"); dto1.setAuth("ROLE_ADMIN");
//		System.out.println( user.insertAuth(dto1) );
		
//		AuthListDto result = readAuth(AuthDto dto);
		
		
		/* 회원가입 (암호화) */
//		UserDto dto = new UserDto();
//		dto.setNickname("a");
//		dto.setBpass( pwencoder.encode("a") );
//		dto.setEmail("a@a");
//		dto.setMobile("010-000-0000");
//		System.out.println( service.insert(dto) );
		
//		System.out.println( "암호화 확인: " + service.findByUno(11) );
	}
	
	@Ignore //@Test
	public void test2() throws UnknownHostException {
		//이메일중복: findByEmail
//		System.out.println( "이메일중복 확인: " + service.findByEmail("aaa@gmail.com") );
		
		//마이페이지: findByUno
		System.out.println( "서비스 마이페이지: " + service.findByUno(8) );
		
		//로그인: findLogin
		UserDto dto2 = new UserDto();
		dto2.setEmail("aaa@gmail.com");
		dto2.setBpass("aaa");
		System.out.println( "서비스 로그인: " + service.findLogin(dto2) );
		
		//회원가입 join
//		UserDto dto = new UserDto();
//		dto.setNickname("aaaa");
//		dto.setBpass("aaa");
//		dto.setEmail("aaa@gmail.com");
//		dto.setMobile("000-111-1111");
//		dto.setBip(InetAddress.getLocalHost().getHostAddress());
//		user.insert(dto);
//		System.out.println( service.insert(dto) );
	}
	
	
	
	@Ignore //@Test
	public void test1() throws UnknownHostException {
		//이메일중복: findByEmail
//		System.out.println( "이메일중복 확인: " + user.findByEmail("aaa@gmail.com") );
		
		//마이페이지: findByUno
		System.out.println( "마이페이지: " + user.findByUno(7) );
		
		//로그인: findLogin
		UserDto dto2 = new UserDto();
		dto2.setEmail("aaa@gmail.com");
		dto2.setBpass("aaa");
		System.out.println( "로그인: " + user.findLogin(dto2) );
		
		
		//회원가입: insert
//		UserDto dto = new UserDto();
//		dto.setNickname("aaa");
//		dto.setBpass("aaa");
//		dto.setEmail("aaa@gmail.com");
//		dto.setMobile("000-111-1111");
//		dto.setBip(InetAddress.getLocalHost().getHostAddress());
//		user.insert(dto);
//		System.out.println( user.insert(dto) );
	}
}
