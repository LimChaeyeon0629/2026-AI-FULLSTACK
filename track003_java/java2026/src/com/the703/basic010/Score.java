package com.the703.basic010;



public class Score {
	private String name;
    private int kor, eng, math, total;
    private double aver;
    private String p, s;
    private String rank = "";
	
    
    public Score() {
		super();
	}

	public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
//		this.total = total;
//		this.aver = aver;
//		this.p = p;
//		this.s = s;
//		this.rank = rank;
	}
	
	public void t1() {
		total = kor + eng + math;
	}
	
	public void a1() {
		aver = (double)total / 3;
	}
	
	public void p1() {
		if (aver >= 50) {
			p = "합격";
		} else {
			p = "불합격";
		}
	}
	
	public void s1() {
		s = aver >= 95 ? "장학생" : "";
	}
	
	public void r1() {
//		String rank = "";
		for(int i=1; i<= aver/10; i++) {
			rank += "*";  // rank = "" + "*"
		}
	}

//	@Override public String toString() { return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", total=" + total + ", aver=" + aver + ", p=" + p + ", s=" + s + ", rank=" + rank + "]"; }
	
	// name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	// kor
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}

	// eng
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}

	// math
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}

	// total
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	// aver
	public double getAver() {
		return aver;
	}
	public void setAver(double aver) {
		this.aver = aver;
	}

	// p
	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
	}

	// s
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}

	// rank
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}

	// info
	public static void info() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹");
	}
	
	// show
	public void show() {
		t1();
		a1();
		p1();
		s1();
		r1();
		
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\n"
						, name, kor, eng, math, total, aver, p, s, rank);
	}
}
