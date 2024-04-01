package com.itwill.inheritance06;

// 2차원 평면의 점의 좌표를 표현
public class Point {
    // field
    private int x;
    private int y;
    
    // constructor
    public Point() {}
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override // Object의 클래스에서 상속받은 toString() 재정의
    public String toString() {
        return "Point(x=" + x + ", y=" + y + ")";
    }

}
