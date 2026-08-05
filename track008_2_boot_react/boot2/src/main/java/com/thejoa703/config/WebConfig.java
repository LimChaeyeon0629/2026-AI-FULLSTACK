package com.thejoa703.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {	// 저장된 파일을 브라우저에서 /uploads/... 주소로 볼 수 있게 연결
	
	// application.yml	에서 업로드된 경로불러오기
	@Value("${file.upload-dir}")
	private String uploadDir;

	// 이미지리소스
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/uploads/**")					// /uploads 경로 
				.addResourceLocations("file:" + uploadDir + "/");	// 실제 올리는경로
	}
	
	// Cor - 외부에서 접근가능하게 설정	( RestController )	##
	@Override
    public void addCorsMappings(CorsRegistry registry) { 
        registry.addMapping("/**")		// controller 모든경로
                .allowedOrigins("http://localhost:3000")	// 프론트엔드 주소 명확히		@CrossOrigin(origins="*")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")		// 허용하는 메서드
                .allowedHeaders("*")
                .allowCredentials(true)	// 세션/쿠키연동하는 방법
                .maxAge(3600);			// 1*60*60=1시간(3600초)
    }
}
