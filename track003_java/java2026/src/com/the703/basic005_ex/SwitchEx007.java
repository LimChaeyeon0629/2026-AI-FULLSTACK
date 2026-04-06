package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx007 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("평균 한개 입력: ");
		double avg = sc.nextDouble();
		
		switch((int)avg/10) {
			case 9: case 10:
				System.out.println("수");
				break;
			
		case 8:
			System.out.println("우");
			break;
			
		case 7:
			System.out.println("미");
			break;
			
		case 6:
			System.out.println("양");
			break;
			
		default:
			System.out.println("가");
		}
	}

}
