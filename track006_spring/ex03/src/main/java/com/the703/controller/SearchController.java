package com.the703.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.the703.service.UserService;

@Controller
public class SearchController {
	@Autowired UserService userService;
	
	//이메일 중복체크
	// 조회 (SELECT) GET		생성 (INSERT) POST
	@ResponseBody
	@RequestMapping(value = "/doubleEmail", method = RequestMethod.GET)
	public Map<String, Object> doubleEmail( @RequestParam("email") String email ){
		Map<String, Object> result = new HashMap<>();
		
		//db에서 이메일 존재여부 확인
		String find = userService.findByEmail(email);
		
		if(find != null) { result.put("exists", true);  }
		else			 { result.put("exists", false); }
		return result;
	}

	//닉네임 중복체크
	@ResponseBody
	@RequestMapping(value = "/doubleNickname", method = RequestMethod.GET)
	public Map<String, Object> doubleNickname( @RequestParam("nickname") String nickname ){
		Map<String, Object> result = new HashMap<>();
		
		//db에서 이메일 존재여부 확인
		String find = userService.findByNickname(nickname);
		
		if(find != null) { result.put("exists", true);  }
		else			 { result.put("exists", false); }
		return result;
	}
}
