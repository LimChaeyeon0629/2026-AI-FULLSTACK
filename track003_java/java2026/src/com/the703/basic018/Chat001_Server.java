package com.the703.basic018;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class Chat001_Server {
	public static void main(String[] args) {
//		1) 서버소켓(a/s 센터), 포트바인딩(문 열기)
		ServerSocket ascenter = null;
		Socket		 info	  = null;
		
		try {
			ascenter = new ServerSocket(703);	// 127.0.0.1:703 [ | | | | | ]
			System.out.println("[Server]  1. 서버준비완료 A/S 센터 OPEN..... ");
		} catch (IOException e) { e.printStackTrace(); }
		
		try {
			System.out.println("[Server]  2. 고객을 기다리는중..... ");
			info = ascenter.accept();
			// 연결이 들어오면 socket 으로 연결
			System.out.println("[Server]  4. 고객님 연락와서 상담사랑(socket) 연결함..... ");
			
			Thread sender = new Sender( info );
			sender.start();
			Thread receiver = new Receiver( info );
			receiver.start();
			
		} catch (Exception e) { e.printStackTrace(); }
	}
}

///////////////////////////////////////////////////////////
// 3) # 듣기 InputStream > [프로그램] > 말하기 OutputStream
class Receiver extends Thread {	// 받기
	DataInputStream in;
	Socket socket;
	
	public Receiver() { super(); }
	public Receiver(Socket socket) {
		this.socket = socket;
		try {
			in = new DataInputStream( socket.getInputStream() ); // socket.getInputStream 정보 받음
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	@Override
	public void run() {
		try {
			while(in != null) { 
				System.out.println(in.readUTF()); } // in.readUTF로 읽어들임
				
		} catch (Exception e) {  //			e.printStackTrace();
			System.out.println("통신을 마무리합니다.");
		} finally { // in & socket close()
			try {
				if ( in != null ) { in.close(); }
				if ( socket != null ) { socket.close(); }
			} catch (Exception e) { e.printStackTrace(); }
		}
	} 
}

///////////////////////////////////////////////////////////
// 3) 듣기 InputStream > [프로그램] > # 말하기 OutputStream
class Sender extends Thread { // 말하기
	DataOutputStream out;
	Socket socket;
	
	SimpleDateFormat sdf;
	String who;
	
	public Sender() { super(); }
	public Sender(Socket socket) {
		this.socket = socket;	// 상대방과 연결되어 있는 정보
		try {
			out = new DataOutputStream( socket.getOutputStream() ); // socket.getOutputStream
		} catch (IOException e) { e.printStackTrace(); }
		
		this.who = "[ " + ( socket.getPort() == 703 ? "Client " : "Server ") ;
		this.sdf = new SimpleDateFormat( " HH:mm:ss ] "); // hh12시간(am/pm), HH25시간(24시간 내내)
	}
	
	@Override
	public void run() {
		BufferedReader br = 
				new BufferedReader (new InputStreamReader (System.in)); // 키보드로 써서 말하기
		try {
			while ( out != null ) { 
				String time = sdf.format(System.currentTimeMillis());
				out.writeUTF( this.who + time + br.readLine() ); } // Sender
			
		} catch (Exception e) {  //			e.printStackTrace();
			System.out.println("통신을 마무리합니다.");
		} finally {
			try {
				if ( out != null ) { out.close(); }
				if ( br != null ) { br.close(); }
				if ( !socket.isClosed() ) { socket.close(); }
				
			} catch (Exception e) { e.printStackTrace(); }
		}
	} 
}


/*
1. Http 통신   - 단방향 (Client 요청이 있을 때, Server가 응답하고 연결 종료)
2. Socket 통신 - 양방향 (특정 포트를 통해 실시간으로 정보 주고 받음 -  tcp/udp)
3. 소켓통신 흐름
   1) 서버소켓(as 센터), 포트바인딩(문 열기)
   2) 클라이언트 연결 요청, 수락
   3) 클라이언트 소켓(socket) ↔ 상담사(socket)가 읽어들이기(InputStream > [프로그램] > OutputStream)

*/