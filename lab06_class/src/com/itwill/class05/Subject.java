package com.itwill.class05;

public class Subject {
    // field
    int korean;
    int english;
    int math;
    int science;
    
    // 생성자: 
    // (1)기본 생성자.
    public Subject() {}
    
    // (2)아규먼트를 갖는 생성자.
    public Subject(int korean, int english, int math, int science) {
        this.korean = korean;
        this.english = english;
        this.math = math;
        this.science = science;
    }
    
    // 메서드: 
    //(1)총점 리턴.
    public int getTotal() {
        // this.은 생략 가능.
        return this.korean + this.english + this.math + this.science;
    }
    
    //(2) 평균 리턴.
    public double getMean() {
     // this.getTotal() 가능
        return (double) getTotal() / 4;
    }
    
    public void info() {
        System.out.println("국어: " + this.korean); // this.은 생략가능
        System.out.println("영어: " + this.english);
        System.out.println("수학: " + this.math);
        System.out.println("과학: " + this.science);
        System.out.println("총점: " + getTotal());
        System.out.println("평균: " + getMean());
    }

}
