package com.the703.basic010;

/* ★ */
public class UserInfo2 {
	public 	  String name;	   // 아무데서나 다 접근가능
	protected String safeCode; // 자식에서 사용가능 ( extends 시 )
			  String house;    // 패키지 폴더에서만 사용
	private   int    iQ;	   // 클래스 내부에서만 사용 Problem: The value of the field UserInfo.iQ is not used
	
	// alt + shift + s
	public int getiQ() { // getter
		return iQ;
	}
	
	public void setiQ(int iQ) { // setter
		this.iQ = iQ;
	}
}

// public > protected > default(package) 아무것도 안 붙은 지정접근자 > private