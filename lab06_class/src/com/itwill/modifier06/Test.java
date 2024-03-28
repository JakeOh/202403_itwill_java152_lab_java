package com.itwill.modifier06;

public class Test {
    int x; // 인스턴스 필드 -> heap 영역
    static int y; // 정적(static) 필드 -> method 영역
    //-> 프로그램 로딩 시점에 method 영역에 변수가 생성되고 기본값으로 초기화됨.

    // 인스턴스 메서드
    public void printFields() {
        System.out.println("--- 인스턴스 메서드 ---");
        System.out.println("x = " + x);
        System.out.println("y = " + y); // 인스턴스 메서드는 static 필드를 사용할 수 있음.
        System.out.println("-----------------------");
    }
    
    // static 메서드
    public static void printFields2() {
        System.out.println("--- 정적(static) 메서드 ---");
//        System.out.println("x = " + x); // static 메서드는 static이 아닌 멤버를 사용할 수 없음!
        System.out.println("y = " + y);
        System.out.println("---------------------------");
    }
    
}
