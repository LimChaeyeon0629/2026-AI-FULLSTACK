package com.the703.basic017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Network001 {
	public static void main(String[] args) {
		try {
			//1. Url
			URL url = new URL("https://www.google.com/");
			//2. 연결객체 (HttpURLConnection)
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//3. 요청설정 (Request)
			conn.setRequestMethod("GET");	// 주소 표시창 줄에 자원 요청 (노출 o) 그외 post, put, path
			//4. 응답코드 (Response)
			int code = conn.getResponseCode(); // 200 응답 성공, 404 페이지 없음, 500 오류
			System.out.println(code);
			//5. 응답데이터
			//	BufferedReader #	>	[프로그램 Network001.java]		> BufferedWriter
			BufferedReader br;		// 줄 단위로 읽기
			
			if(code==200) {
				//		한 줄씩 속도향상	-	바이트 스트림을 문자 스트림		-	응답 데이터스트림
				br = new BufferedReader( new InputStreamReader(conn.getInputStream()) );
			} else {
				System.out.println("에러!	");
				br = new BufferedReader( new InputStreamReader(conn.getErrorStream()) );
			}
			
			String line="";
			StringBuffer sb = new StringBuffer();
			
			while( ( line = br.readLine() ) != null ) {
				sb.append(line + "\n");
			}
			System.out.println(sb.toString());
			br.close();
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}

/*
Network

1) web (http 통신)	→	JSP (java + html)	→	Spring
2) socket

*/