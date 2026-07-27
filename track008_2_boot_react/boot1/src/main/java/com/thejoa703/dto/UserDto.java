package com.thejoa703.dto;

import com.thejoa703.entity.AppUser;

import lombok.Getter;
import lombok.Setter;

public class UserDto {

	// 회원가입 요청 Dto
	@Setter @Getter
	public static class UserRequestDto {
		private String	email;
		private String	password;
		private String	nickname;
		private String	mobile;
		private Integer mbtiTypeId;
	}
	
	// 회원정보- 응답 Dto
	@Getter
	public static class UserResponseDto {
		private Long	id;
		private String	email;
		private String	password;
		private String	nickname;
		private String	mobile;
		private Integer mbtiTypeId;
		private String	role;

		public UserResponseDto (AppUser user) {	// insert, update 결과물
			this.id = user.getId();
			this.email = user.getEmail();
			this.nickname = user.getNickname();
			this.mobile = user.getMobile();
			this.mbtiTypeId = user.getMbtiTypeId();
			this.role = user.getRole();
		}
		
	}
}
