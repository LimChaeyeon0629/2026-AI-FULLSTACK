package com.the703.basic014;

import java.util.Objects;

public class UserDto {
	// 멤버변수
	private static int cnt=0;	// 클래스변수 (static) - method area - 각각 x - 공용
	private final  int no;		// 인스턴스변수   final 수정 x
	private String email;		// 인스턴스변수 - heap area - new o - 생성자 o - this

	// alt + shift + s (생성자, toString, getters/setters)
	// 멤버 함수						기본값 - 명시적초기화 - 초기화블록 - 생성자
	public UserDto() { this.no = ++cnt; }	// 유저번호 = 값; 값 1개 증가 → 대입
	public UserDto(int no, String email) { super(); this.no = no; this.email = email; }
	public UserDto(String email) {
		this();		// final
		this.email = email;
	}
	@Override public String toString() { return "UserDto [no=" + no + ", email=" + email + "]"; }
	
	public static int getCnt() { return cnt; }
	public static void setCnt(int cnt) { UserDto.cnt = cnt; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public int getNo() { return no; }
	
	// 1. 클래스(UserDto)가 맞는지 확인 → Objects.hash(email, no)
	@Override
	public int hashCode() {
		return Objects.hash(email); 	// 객체들의 값
	}
	// 2. 객체 안에 값이 같은지 확인
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(email, other.email);
	}
}