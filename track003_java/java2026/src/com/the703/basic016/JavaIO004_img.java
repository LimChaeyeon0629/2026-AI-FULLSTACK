package com.the703.basic016;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class JavaIO004_img {
	public static void main(String[] args) throws IOException {
		//#1. 경로
		String origin  = "src/com/the703/basic016/1.jpg";
		String target1 = "src/com/the703/basic016/11.jpg";
		String target2 = "src/com/the703/basic016/12.jpg";
		
		//#2. byte 이미지 파일 원본 읽어들여서 쓰기
		//	InputStream		>	[프로그램]	>	OutputStream
		InputStream  bis = new FileInputStream(origin);		// 원본 읽어들여서 (read) → add throws
		OutputStream bos = new FileOutputStream(target1);	// 11.jpg 쓰기 (write)
		
		int cnt1=0;		// → add throws
		while( ( cnt1 = bis.read() ) != -1 ) {	// 원본 읽어들여서 (read)
			bos.write( (byte)cnt1 );			// 11.jpg 쓰기 (write)
		}
		bis.close();
		bos.close();
		
		System.out.println("byte 이미지 복사 완료~");
		
		
		
		//#3. char 이미지 파일 원본 읽어들여서 쓰기 ( → 문자 전용 & 2byte 씩 읽어들여서 이미지 x )
		//	Reader	>	[프로그램]	>	# Writer
		Reader cr = new FileReader(origin);		// 원본 읽어들여서 (read)
		Writer cw = new FileWriter(target2); 	// 12.jpg 쓰기 (write)
		
		int cnt2=0;	
		while( (cnt2 = cr.read()) != -1 ) {		// 원본 읽어들여서 (read)
			cw.write( (char)cnt2 );				// 12.jpg 쓰기 (write)
		}
		cr.close();
		cw.close();
		
		System.out.println("char 이미지 복사 완료~!");
		
	}
}
