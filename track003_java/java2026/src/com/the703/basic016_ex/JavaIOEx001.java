package com.the703.basic016_ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;

public class JavaIOEx001 {
	public static void main(String[] args) {
		//#1. 경로
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss"); // 포맷설정
		long millis = System.currentTimeMillis(); 			// 시스템 시간 가져오기
		String folder_rel = "src/com/the703/basic016_ex/"; 	//상대경로 - 현재 작업하는 폴더 기준
		String file_path  = sdf.format(millis) + "app.log"; 
		
		File folder = new File(folder_rel);
		File file   = new File(folder_rel + file_path);
		
		
		//#2. 파일 + 폴더 준비 ( exists, mkdirs, createNewFile )
		// folder.mkdir();		// file.createNewFile();
		try {
			if( !folder.exists() ) { folder.mkdir(); }
			if(   !file.exists() ) { file.createNewFile(); }

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//#3. Char 단위로 파일쓰기
		//	sdf.format(millis) + " 로그파일입니다."		ex) 20260508_1716ss 로그파일입니다.
//		Reader(FileReader)		>	[프로그램]	>	# Writer(FileWriter)
		// Writer writer
		try {
			Writer writer = new FileWriter(file);
			writer.write(sdf.format(millis));
			writer.write(" 로그파일입니다.");
			writer.close();
			System.out.println("로그파일 쓰기 완료~");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//#4. Char 단위로 파일읽기
//		Reader(FileReader) #	>	[프로그램]	>	Writer(FileWriter)
		// Reader reader
		try {
			Reader reader = new FileReader(file);
			int cnt=0;
			while( (cnt = reader.read() ) != -1 ) { // (cnt = reader.read())가 -1 전까지
				System.out.print( (char)cnt );		
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
