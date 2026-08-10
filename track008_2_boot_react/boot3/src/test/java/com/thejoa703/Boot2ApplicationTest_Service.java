package com.thejoa703;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.service.UserService;

@SpringBootTest
@Transactional
class Boot2ApplicationTest_Service {
    
	@Autowired UserService userService;
	
	// 공통으로 사용할 유저를 생성해주는 헬퍼 메서드
	private Long createTestUser(String email, String nickname) {
		UserRequestDto signupDto = new UserRequestDto();
		signupDto.setEmail(email);
		signupDto.setPassword("password123");
		signupDto.setNickname(nickname);
		signupDto.setProvider("local");
		
		MockMultipartFile profileImage = new MockMultipartFile(
				"profileImage", "test.png", "image/png", "test image content".getBytes()
				);
		
		UserResponseDto res = userService.createUser(signupDto, profileImage);	// ##
		return res.getId();
	}
	
	// -------------------------------------------------------------
    // UserService - CRUD
    // -------------------------------------------------------------
    @Test
    @DisplayName("■ UserService - CRUD : 회원가입, 로그인, 마이페이지, 수정, 삭제")
    // Update: 닉네임변경, Update: 프로필이미지변경, Delete: 회원탈퇴
    void testAppUserService() {
    	// 회원가입
    	Long userId = createTestUser("test1@email.com", "test1");
    	
    	// 로그인
    	LoginRequest loginDto = new LoginRequest();
    	loginDto.setEmail("test1@email.com");
    	loginDto.setPassword("password123");
    	loginDto.setProvider("local");
    	
    	UserResponseDto loginRes = userService.login(loginDto);
    	assertThat(loginRes).isNotNull();
    	assertThat(loginRes.getId()).isEqualTo(userId);
    	
    	// 이메일중복검사 - 존재확인
    	boolean doubleEmail = userService.existsByEamil("test1@email.com");
    	assertThat(doubleEmail).isTrue();
    	
    	// 닉네임중복검사 - 존재확인
    	boolean doubleNickname = userService.existsByNickname("test1");
    	assertThat(doubleNickname).isTrue();
    	
    	// 마이페이지
    	UserResponseDto foundUser = userService.getUser(userId);
    	assertThat(foundUser.getNickname()).isEqualTo("test1");

    	// 수정(닉네임변경)
//    	UserResponseDto updatedUserNickname = userService.updateNickname(foundUser.getId(), "test2");
    	UserResponseDto updatedUserNickname = userService.updateNickname(userId, "111");
    	assertThat(updatedUserNickname.getNickname()).isEqualTo("111");
    	
    	// 수정(프로필이미지변경)
//    	UserResponseDto updatedUserImage = userService.updateProfileImage(userId, "1.png");
//    	assertThat(updatedUserImage.getUfile()).isEqualTo("1.png");
    	
    	// 유저삭제(회원탈퇴)
    	userService.deleteById(userId);
//    	UserResponseDto deleteUser = userService.getUser(userId);	없는 유저여서 오류남
//    	assertThat(deleteUser).isNull();
    }
}