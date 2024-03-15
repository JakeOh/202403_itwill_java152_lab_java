package com.itwill.variable04;

public class VariableMain04 {

    public static void main(String[] args) {
        // 문자(character) 타입 변수 char
        // char 타입: 문자 1개의 유니코드 값(2바이트 정수)를 저장하는 타입.
        // 문자는 작은따옴표를 사용('a'), 문자열은 큰따옴표를 사용("abc")
        
        char ch1 = 'B';
        System.out.println(ch1);
        System.out.println((int) ch1);
        
        // char는 문자의 유니코드를 저장하는 특별한 종류의 정수 타입.
        // -> 사칙연산이 가능. 크기 비교도 가능.
        char ch2 = (char) (ch1 + 1);
        System.out.println(ch2);
        
        char ch3 = (char) (ch1 - 1);
        System.out.println(ch3);

    }

}
