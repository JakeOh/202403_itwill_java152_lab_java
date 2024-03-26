package com.itwill.class02;

// 클래스(class): 객체 설계도. 데이터(필드) + 기능(메서드) => 변수 타입.
public class Score {
    // 필드(field). 멤버 변수.
    int java;
    int sql;
    int javascript;
    
    // 메서드(method).
    public int getTotal() {
        return java + sql + javascript;
    }
    
    public double getMean() {
        return (double) getTotal() / 3;
    }

}
