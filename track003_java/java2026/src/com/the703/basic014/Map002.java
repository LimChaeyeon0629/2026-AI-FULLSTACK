package com.the703.basic014;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Map002 {
	public static void main(String[] args) {
		Map<String, UserDto> maps = new HashMap<>();
		maps.put("first" , new UserDto("first@gmail.com"));
		maps.put("second", new UserDto("second@gmail.com"));
		maps.put("third" , new UserDto("third@gmail.com"));
		maps.put("third" , new UserDto("33@gmail.com"));
		maps.put("third" , new UserDto("33@gmail.com"));
		
		System.out.println(maps.size());	// 3
		System.out.println(maps); 			// key 가 같으면 덮어쓰기
		System.out.println();
		// {third=UserDto [no=5, email=33@gamil.com],
		//  first=UserDto [no=1, email=first@gamil.com],
		//  second=UserDto [no=2, email=second@gamil.com]}
		
		// 1. maps.entrySet() 이용해서 향상된 for문
		for( Entry<String, UserDto> u : maps.entrySet() ) {
//			System.out.println(u.getKey() + "-" + u.getValue());
			String key = u.getKey();
			UserDto value = u.getValue();
			System.out.println("닉네임: " + key + " - " + value.getEmail());
		}
		
		// 2. maps.entrySet() 이용해서 향상된 Iterator로 출력
		Iterator<Entry<String, UserDto>> iter = maps.entrySet().iterator(); // #1. iterator 유무
		while(iter.hasNext()) {							// #2. hasNext() 처리대상확인
			Entry<String, UserDto> m = iter.next();		// #3. next() 한 개씩 꺼내오기
//			System.out.println(m.getKey() + "-" + m.getValue());
			String key = m.getKey();
			UserDto value = m.getValue();
			System.out.println("닉네임: " + key + " - " + value.getEmail());
		}
	}
}
