package com.the703.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UtilUpload {
	@Value("${resource.path}")
	private String resourcePath; // C:/upload
	
	public String fileUpload(MultipartFile file) throws IOException {
		//1. 파일이름 중복 안되게
		UUID uid = UUID.randomUUID(); 
		String save = uid.toString() + "_" + file.getOriginalFilename(); // UUID를 붙여 만든 저장 파일명.
		
		//2. 파일업로드
		File target = new File(resourcePath, save);
		FileCopyUtils.copy(file.getBytes(), target);
		return save;
	}
	//1. 팀미션1: 업로드 시 확장자, 용량 사이즈 고려
	//2. 팀미션2: 글삭제 시 파일도 같이 삭제
}
