package com.the703.basic008_ex;

public class ArrayEx007 {

	public static void main(String[] args) {
		// 음수의 갯수 출력
		// ver-0 3이 음수라면 카운트
		// ver-1 5가 음수라면 카운트
		// ver-2 if (-3이 음수라면) { 카운트 }
		// ver-3 if (5가 음수라면) { 카운트 }
		// ver-4 if (su[0] < 0) { count++; }
		// ver-5 if (su[1] < 0) { count++; }
		
		int [] su = { -3, 5, -1, 9, -7 }; // 0 1 2 3 4
		
		int count = 0;
		
		for(int i = 0; i < su.length; i++) { // 0 1 2 3 4
			if (su[i] < 0) { count++; }
		}
		System.out.println(count);
		
	}

}
