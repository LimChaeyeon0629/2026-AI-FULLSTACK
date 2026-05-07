package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;

// 생성자(기본, 필드), toString, hashCode + equals, setters + getters
class BookDto {
	private String title;
	private String author;
	
	public BookDto() { super(); }
	public BookDto(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	@Override
	public String toString() {
		return "BookDto [title=" + title + ", author=" + author + "]";
	}

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
	
	@Override public int hashCode() { return Objects.hash(author, title); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDto other = (BookDto) obj;
		return Objects.equals(author, other.author) && Objects.equals(title, other.title);
	}
}

public class MapEx002 {
	public static void main(String[] args) {
		Map<String, BookDto> map = new HashMap<>();
		map.put("978-11111", new BookDto("자바의 완성", "가길동"));
		map.put("978-22222", new BookDto("파이썬 기초", "홍길동"));
		map.put("978-33333", new BookDto("자료구조와 알고리즘", "이순신"));
		
		System.out.println("=============================="
				+ "\nISBN        TITLE        AUTHOR"
				+ "\n=============================="
				+ "\n978-11111 | 자바의 완성 | 가길동"
				+ "\n------------------------------"
				+ "\n978-22222 | 파이썬 기초 | 홍길동 "
				+ "\n------------------------------"
				+ "\n978-33333 | 자료구조와 알고리즘 | 이순신 "
				+ "\n------------------------------"
				+ "\n도서 정보를 제공중입니다");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("ISBN을 입력하세요: ");
		String num = sc.next();
		
//		#1. key 들의 묶음
//		for ( String key : map.keySet()) {
//			System.out.printf( "%s\t%s\t%s\n: ", key, map.get(key).getTitle(), map.get(key).getAuthor() );
//		}
		
//		#2. key:value 묶음
//		for ( Entry<String, BookDto> e : map.entrySet()) {
//			System.out.printf( "%s\t%s\t%s\n: ", e.getKey(), e.getValue().getTitle(), e.getValue().getAuthor() );
//		}
		
//		#3. 반복자
//		Iterator<Entry<String, BookDto>> iter = map.entrySet().iterator();
//		while(iter.hasNext()) {
//			Entry<String, BookDto> e = iter.next();
//			System.out.printf( "%s\t%s\t%s\n: ", e.getKey(), e.getValue().getTitle(), e.getValue().getAuthor() );
//		}
		
		if(num.equals("978-11111")) {
			for(int i=0; i<map.size(); i++) { // 0 1 2 		    // → BookDto [title=자바의 완성, author=가길동]
				System.out.printf("📖 선택한 도서 정보: %s / 저자: %s", map.get(num), map.get(num).getAuthor() );
				break;
			}
		} else if(num.equals("978-22222")) {
			for(int i=0; i<map.size(); i++) {
				System.out.printf("📖 선택한 도서 정보: %s / 저자: %s", map.get(num).getTitle(), map.get(num).getAuthor() );
				break;
			}
		} else if(num.equals("978-33333")) {
			for(int i=0; i<map.size(); i++) {
				System.out.printf("📖 선택한 도서 정보: %s / 저자: %s", map.get(num).getTitle(), map.get(num).getAuthor() );
				break;
			}
		}
		
	}
}

//2-1. BookDto 만들기   {    private String title;  private String author;}
//2-2. 다음과 같이 출력
//2-3. 사용자에게 KING의 이름을 입력받아 해당하는 값 출력
//==============================
//ISBN        TITLE        AUTHOR
//==============================
//978-11111 | 자바의 완성 | 가길동
//------------------------------
//978-22222 | 파이썬 기초 | 홍길동 
//------------------------------
//978-33333 | 자료구조와 알고리즘 | 이순신 
//------------------------------
//도서 정보를 제공중입니다
//ISBN을 입력하세요> 978-22222
//
//📖 선택한 도서 정보: 파이썬 기초 / 저자: 홍길동