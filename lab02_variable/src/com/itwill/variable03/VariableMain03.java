package com.itwill.variable03;

public class VariableMain03 {

    public static void main(String[] args) {
        // 변수를 사용할 때 주의할 점: 같은 이름으로 변수를 2번 이상 선언할 수 없음!
        int x = 1; // 정수를 저장할 수 있는 변수 x를 선언하고 1로 초기화.
        System.out.println("x = " + x);
        
        x = 2; // 이미 선언된 변수 x의 값을 2로 변경.
        System.out.println("x = " + x);
        
        //int x = 3;
        //-> x라는 이름의 변수가 이미 선언되어 있기 때문에, 
        // 같은 이름으로 또다른 변수를 선언할 수는 없다.
    }

}
