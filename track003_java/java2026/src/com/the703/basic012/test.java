package com.the703.basic012;

class A11 {
    int a; // (1)

    A11() { super(); }
    A11(int a) { this.a = a; } // (2)

    //(3) void show()
    void show() { 
        this.a = 11; 
        System.out.println(this.a); 
    }

    //(4) static void classMethod()
    static void classMethod() { super.a = 12; }

    //(5) int showZ()
    int showZ() { 
        int a; 
        return a; 
    }
}

///////////////////////////////////////////////////////
public class test {
	public static void main(String[] args) {
		A11 a1 = new A11(); 
	}
}
///////////////////////////////////////////////////////