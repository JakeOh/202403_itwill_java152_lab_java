package com.itwill.inheritance05;

import java.util.Random;
import java.util.Scanner;

/*
 * java.lang.Object 클래스: 자바의 최상위 클래스.
 * 자바의 모든 클래스는 Object 클래스를 확장(상속).
 * Object 클래스에서 public으로 공개된 메서드들은 모든 하위 타입에서 사용할 수 있음.
 * Object 클래스의 모든 메서드는 하위 클래스에서 재정의(override)할 수 있음.
 * (예) toString(), equals(), hashCode(), ...
 * - toString(): 객체의 문자열 표현식을 리턴.
 *   "패키지.클래스@주소" 형식의 문자열을 만들어서 리턴.
 * - equals(): 객체 동등 비교 메서드.
 *   힙(heap)에 생성된 객체가 같으면(객체의 주소가 같으면) true, 다르면 false를 리턴.
 * - hashCode(): 객체의 해시코드(정수) 값을 리턴.
 *   o. 객체의 주소값으로 해시코드를 만듦.
 *   o. 해시코드가 만족해야 하는 조건:
 *      1. 같은 객체에서 hashCode() 여러번 호출하더라도 항상 같은 정수가 리턴되어야 함.
 *      2. equal() 메서드의 결과가 true가 되는 두 객체의 해시코드 값은 같아야 함.
 *      3. 해시코드 값이 같은 두 객체에서 equals() 메서드의 결과가 항상 true가 될 필요는 없음.
 */

class T {
    @Override
    public String toString() {
        return "T 타입 인스턴스";
    }
}

public class InheritanceMain05 {

    public static void main(String[] args) {
        T t = new T();
        System.out.println(t);
        // System.out.println(Object x) 메서드는 객체의 문자열 표현식을 콘솔에 출력.
        // 아규먼트가 null이 아닌 경우에는 x.toString()이 리턴하는 문자열을 콘솔에 출력.
        // 아규먼트가 null인 경우에는 콘솔에 "null"이라고 출력.
        System.out.println(t.toString());
        System.out.println(t.getClass());
        System.out.println(t.hashCode());

        T t1 = new T();
        T t2 = new T();
        T t3 = t1;
        System.out.println(t1.equals(t2));
        System.out.println(t1.equals(t3));
        // Object 클래스에서 상속받은 equals() 메서드:
        // 두 객체가 같은 지(true), 다른 지(false)를 반환하는 메서드.
        // Object에서는 실제로 생성된 객체가 같으면 true를 리턴, 그렇지 않으면 false 리턴.
        
        Object o = new Object();
        System.out.println(o);
        
        Random r = new Random();
        System.out.println(r); //-> Random 클래스는 toString() 메서드를 override하지 않음.
        
        Scanner sc = new Scanner(System.in);
        System.out.println(sc); //-> Scanner 클래스는 toString() 메서드를 override함.
        
    }

}
