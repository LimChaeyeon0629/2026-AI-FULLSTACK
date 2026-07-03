package com.the703.llmrag;

import lombok.Value;

//@Getter
//@FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE)
//						- 모든필드를 private final 변경
//@AllArgsConstructor	- 모든생성자
//@ToString				- 문자열연결
//@EqualsAndHashCode.
@Value
public class Message {
	String role;	// 역할
	String content;	// 질문
	
}
