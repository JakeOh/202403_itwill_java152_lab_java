package com.itwill.inheritance05;

import java.util.Random;
import java.util.Scanner;

/*
 * java.lang.Object 클래스: 자바의 최상위 클래스.
 * 자바의 모든 클래스는 Object 클래스를 확장(상속).
 * Object 클래스에서 public으로 공개된 메서드들은 모든 하위 타입에서 사용할 수 있음.
 * Ojbect 클래스의 모든 메서드는 하위 클래스에서 재정의(override)할 수 있음.
 * (예) toString(), equals(), hashCode(), getClass(), ...
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
