package com.itwill.class01;

/*
 * 객체지향 프로그래밍 언어(Object-Oriented Programming Language): Java, C++, C#, Kotlin, ...
 * 절차지향 프로그래밍 언어(Procedural Programming Language): C, ...
 * 
 * 객체(Object): 대상. 프로그램에서 사용하려고 하는 대상.
 * 클래스(Class): 객체 설계도. 객체를 만들기 위해서 필요한 코드.
 * - 객체가 가져야 하는 "데이터"를 변수("필드")로 선언하고,
 * - 객체가 가져야 하는 "기능"을 "메서드"로 선언하는 코드.
 * - 변수를 선언할 때 사용할 수 있는 데이터 타입.
 * 인스턴스(Instance): 실제로 생성된 객체.
 */

public class ClassMain01 {

    public static void main(String[] args) {
        String s1 = "안녕하세요!"; // 문자열 객체
        System.out.println("s1 length: " + s1.length()); // length(): 문자열 객체의 기능(메서드)
        System.out.println("s1 concat: " + s1.concat("비가 오네요..."));

        String s2 = new String("Hello");
        System.out.println("s2 length: " + s2.length());
        System.out.println("s2 concat: " + s2.concat("Java"));
        
    }

}
