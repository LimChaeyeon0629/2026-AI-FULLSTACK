package com.the703.llmrag;

import java.util.List;

public record LlmRagResponse ( // OpenAI한테서 받은 전체 응답 JSON을 담는 객체
	List<Choice> choices
) {}
