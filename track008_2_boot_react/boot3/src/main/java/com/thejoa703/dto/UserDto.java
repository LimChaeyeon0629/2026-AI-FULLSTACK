package com.thejoa703.dto;

import java.time.LocalDateTime;

import com.thejoa703.entity.AppUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserDto {

	// 회원가입 요청 Dto
	@Setter @Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class UserRequestDto {
		@Email
		@NotBlank
		private String	email;
		@NotBlank
		private String	password;
		@NotBlank
		private String	nickname;
		private String	mobile;
		private Integer mbtiTypeId;

		private String provider;	// local 기본
	}
	
	// 회원정보- 응답 Dto
	@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
	public static class UserResponseDto {
		
		private Long	id;
		private String	email;
//		private String	password;
		private String	nickname;
		private String	mobile;		// 나중에 확장용도
		private Integer mbtiTypeId;	// 나중에 확장용도
		private String	role;
		
		private String provider;	// local 기본
		private String ufile;
		private LocalDateTime createdAt;
		
		// 변환 메서드
		public static UserResponseDto fromEntity(AppUser user) {	// repository 처리해준값	
			return UserResponseDto.builder()
					.id(user.getId())
					.email(user.getEmail())
					.nickname(user.getNickname())
					.provider(user.getProvider())
					.role(user.getRole())
					.createdAt(user.getCreatedAt())
					.ufile(user.getUfile())
					.build();
		}
		public AppUser toEntity() {
            AppUser user = new AppUser();
            user.setId(this.id);
            user.setEmail(this.email);
            user.setNickname(this.nickname);
            user.setProvider(this.provider != null ? this.provider : "local");
            user.setRole(this.role != null ? this.role : "ROLE_USER");
            user.setUfile(this.ufile);
            return user;
        }
		
		// 생성자
//		public UserResponseDto (com.thejoa703.entity.AppUser user) {	// insert, update 결과물
//			this.id = user.getId();
//			this.email = user.getEmail();
//			this.nickname = user.getNickname();
//			this.mobile = user.getMobile();
//			this.mbtiTypeId = user.getMbtiTypeId();
//			this.role = user.getRole();
//		}
		
	}
}

//1) UserDto: userRequestDto / userResponseDto
//userRequestDto  < email, password, nickname, ☆image(ufile: MultiPart 빠짐)  /  provider, mobile, mbtiTypeId >
//userResponseDto < email, role,     nickname,   ufile  /  provider, mobile, mbtiTypeId >
//
//2) LoginRequest < email, password, provider,  />