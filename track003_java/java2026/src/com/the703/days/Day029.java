package com.the703.days;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

//Q1. Player DTO 클래스 만들기
//속성:
//private String name;
//private int score;


// 1. DTO
class Player {
	private String name;
	private int score;

	public Player() { super(); }
	public Player(String name, int score) { super(); this.name = name; this.score = score; }
	@Override public String toString() { return "Player [name=" + name + ", score=" + score + "]"; }
	
	@Override public int hashCode() { return Objects.hash(name, score); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(name, other.name) && score == other.score;
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public int getScore() { return score; }
	public void setScore(int score) { this.score = score; }
}


public class Day029 {
	public static void main(String[] args) { 
		//List: 기차 	(순서 o, 중복 o) 		add, get, size, remove, contains
		//Set : 주머니 	(순서 x, 중복 x) 		add, 향상된 for/Iterator, size, remove, contains
		//Map : 기차 	(key:value-쌍-엔트리) put, get(key), size, remove, contains
		
//		Q2. List (ArrayList) 출력
//		2-1. players 이름으로 ArrayList 만들기
//		2-2. 데이터 추가:
//		new Player("Mario", 1200),
//		new Player("Luigi", 1500),
//		new Player("Peach", 1800),
//		new Player("Bowser", 900)
//		new Player("Bowser", 900)
//
//		2-3. for + size 이용해서 출력
//
//		출력 예시
//		1   Mario    1200
//		2   Luigi    1500
//		3   Peach    1800
//		4   Bowser   900
//		5   Bowser   900
		List<Player> players = new ArrayList<>();
		players.add( new Player("Mario", 1200) );
		players.add( new Player("Luigi", 1500) );
		players.add( new Player("Peach", 1800) );
		players.add( new Player("Bowser", 900) );
		players.add( new Player("Bowser", 900) );
		
		int cnt=0;
		for(int i=0; i<players.size(); i++) {
//			System.out.println( ++cnt
//					+ "\t" + players.get(i).getName()
//					+ "\t" + players.get(i).getScore() );
			Player p = players.get(i);
			System.out.printf("%d\t%s\t%d\n", ++cnt, p.getName(), p.getScore());
		}
		
//		Q3. List에서 출력을 보면 Bowser   900  라는 같은데이터를 넣었는데 2개가 나옴. 이유는?
//				4   Bowser   900
//				5   Bowser   900
//		→ A. List 는 순서가 있는 기차 구조이고 중복 가능이라서 2개 나옴.
		
//		Q4. Set (HashSet) 출력
//		4-1. setPlayers 이름으로 HashSet 만들기
//		4-2. 동일한 데이터 넣기 (중복 허용 안됨)
//		4-3. Iterator 이용해서 출력
//		출력 예시
//		1   Mario    1200
//		2   Luigi    1500
//		3   Peach    1800
//		4   Bowser   900
		Set<Player> setPlayers = new HashSet<>();
		setPlayers.add( new Player("Mario", 1200) );
		setPlayers.add( new Player("Luigi", 1500) );
		setPlayers.add( new Player("Peach", 1800) );
		setPlayers.add( new Player("Bowser", 900) );
		setPlayers.add( new Player("Bowser", 900) );
		
		System.out.println();
		Iterator<Player> iter = setPlayers.iterator(); // 1. 줄을 서시오.
		cnt=0;
		while(iter.hasNext()) { 		// 2. 처리 대상의 유무
			Player p = iter.next();		// 3. 한 개씩 꺼내오기
//			System.out.println( ++cnt
//					+ "\t" + p.getName()
//					+ "\t" + p.getScore());
			System.out.printf("%d\t%s\t%d\n", ++cnt, p.getName(), p.getScore());
		}
		
//		Q5. Map (HashMap) 출력
//		5-1. mapPlayers 이름으로 HashMap 만들기
//		5-2.  데이터 넣기 (Key-Value 구조)
//		mapPlayers.put("mario", new Player("Mario", 1200));
//		mapPlayers.put("luigi", new Player("Luigi", 1500));
//		mapPlayers.put("peach", new Player("Peach", 1800));
//		mapPlayers.put("bowser", new Player("Bowser", 900));
//		5-3. for-each + entrySet 이용해서 출력
//		출력 예시
//		mario   Mario    1200
//		luigi   Luigi    1500
//		peach   Peach    1800
//		bowser  Bowser   900
		
		Map<String, Player> mapPlayers = new HashMap<>();
		mapPlayers.put("mario", new Player("Mario", 1200));
		mapPlayers.put("luigi", new Player("Luigi", 1500));
		mapPlayers.put("peach", new Player("Peach", 1800));
		mapPlayers.put("bowser", new Player("Bowser", 900));
		
		System.out.println();
//		Set<Entry<String, Player>> m = mapPlayers.entrySet();
//		for ( String key : mapPlayers.keySet() ) {
//			System.out.println( key
//					+ "\t" + mapPlayers.get(key).getName()
//					+ "\t" + mapPlayers.get(key).getScore() );
//		}
		for( Entry<String, Player> e : mapPlayers.entrySet() ) {
			System.out.println( e.getKey()
					+ "\t" + e.getValue().getName()
					+ "\t" + e.getValue().getScore() );
		}
		
		
		
//		Q6. 정렬 문제
//
//		출력 예시 (오름차순)
//		코드
//		Bowser   900
//		Bowser   900
//		Mario    1200
//		Luigi    1500
//		Peach    1800
		
//		List<Player> players = new ArrayList<>();
//		players.add( new Player("Mario", 1200) );
//		players.add( new Player("Luigi", 1500) );
//		players.add( new Player("Peach", 1800) );
//		players.add( new Player("Bowser", 900) );
//		players.add( new Player("Bowser", 900) );
		
//		6-1. List코드에서 익명 클래스로 점수 오름차순 정렬
		players.sort( new Comparator<Player>() { // Comparator<? super Player> c
			@Override
			public int compare(Player o1, Player o2) {
				return Integer.compare(o1.getScore(), o2.getScore()); // 오름차순
//				return Integer.compare(o2.getScore(), o1.getScore()); // 내림차순
			} 
		});
		
		System.out.println(); cnt=0;
		for(int i1=0; i1<players.size(); i1++) {
			Player p = players.get(i1);
			System.out.printf("%d\t%s\t%d\n", ++cnt, p.getName(), p.getScore());
		}
		
//		6-2. 람다식으로 점수 내림차순 정렬
		players.sort( (o1, o2) -> Integer.compare(o2.getScore(), o1.getScore()) );
		
		System.out.println(); cnt=0;
		for(int i1=0; i1<players.size(); i1++) {
			Player p = players.get(i1);
			System.out.printf("%d\t%s\t%d\n", ++cnt, p.getName(), p.getScore());
		}
		
//		6-3. 메서드 참조로 점수 오름차순 정렬
		players.sort( Comparator.comparingInt(Player::getScore) );
		
		System.out.println(); cnt=0;
		for(int i1=0; i1<players.size(); i1++) {
			Player p = players.get(i1);
			System.out.printf("%d\t%s\t%d\n", ++cnt, p.getName(), p.getScore());
		}
    }
}