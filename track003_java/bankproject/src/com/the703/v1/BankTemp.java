package com.the703.v1;

import java.util.Scanner;

public class BankTemp {
	Scanner sc = new Scanner(System.in);
	int tid = -1, tpw = -1;
	
	public void Id() { 	// tempId
		System.out.print("아이디 입력: ");
		tid = sc.nextInt();
	}
	
	public void Pw() {		 // tempPw
		System.out.print("비밀번호 입력: ");
		tpw = sc.nextInt();
	}
}

/*
		if (tid != id || tpw != pw) {
			System.out.println("다시 입력해주세요");
		} else if (tid == id && tpw == pw) {
 */