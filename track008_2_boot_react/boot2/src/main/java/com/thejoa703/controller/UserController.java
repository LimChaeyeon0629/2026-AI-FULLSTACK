package com.thejoa703.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name="User Api", description="사용자 관련 API")	// swqgger
@RestController		// @Controller + @ResponseBody	(객체형식)
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins="*")	// 공용으로 접근 가능
public class UserController {

	private final UserService userService;
	
	// 사용자 등록 (회원가입)
	// ResponseEntity - Http 응답 - 상태코드(201) 전달
	// ResponseEntity<UserResponseDto> - 회원가입 결과: UserResponseDto, 상태 코드: 201 Created
	@Operation(summary="회원가입", description="새로운 사용자를 등록합니다.")
	@PostMapping									// springFramework
	public ResponseEntity<UserResponseDto> createUser( @RequestBody UserRequestDto requestDto ) {

		UserResponseDto response = userService.createUser(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);	// HttpStatus.CREATED 201
	}
	
	// 사용자 단건조회			- /api/users/1	해당id번호=1
	@Operation(summary="사용자 단건조회", description="사용자 아이디(id)로 특정회원 정보를 조회합니다.")
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDto> getUser(@PathVariable("id") Long id) {

		UserResponseDto response = userService.getUser(id);
		return ResponseEntity.ok(response);
//		return ResponseEntity.status(HttpStatus.OK).body(response);		// HttpStatus.OK 
	}
}

// http://localhost:8484/swagger-ui/index.html

//1. User Api    - 사용자 관련 API
//- POST     /api/users      	회원가입
//- GET      /api/users/{id}    사용자 단건조회