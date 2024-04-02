package com.itwill.inheritance06;

public class InheritanceMain06 {

    public static void main(String[] args) {
        // 기본 생성자를 사용해서 Point 타입 객체 생성
        Point p1 = new Point();
        System.out.println(p1); // p1.toString()
        
        // 아규먼트를 갖는 생성자를 사용해서 Point 타입 객체 생성
        Point p2 = new Point(0, 0);
        System.out.println(p2); // p2.toString()
        
        System.out.println("비교 연산자 == 결과: " + (p1 == p2)); // 비교 연산자
        System.out.println("equals() 메서드 결과: " + p1.equals(p2)); // equals() 메서드
        // 객체의 동등비교에서는 비교 연산자(==, !=)를 사용하면 안됨!
        
        System.out.println("p1 hashCode = " + p1.hashCode());
        System.out.println("p2 hashCode = " + p2.hashCode());

        // String 객체의 동등(equals) 비교
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("s1 == s2 결과: " + (s1 == s2));
        System.out.println("s1.equals(s2) 결과: " + s1.equals(s2));
        
        User user1 = new User("admin", "1234");
        User user2 = new User("admin", "abcd");
        User user3 = new User();
        
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        
        System.out.println("user1 == user2: " + (user1 == user2));
        System.out.println("user1.equals(user2): " + user1.equals(user2));
        System.out.println("user1.equals(user3): " + user1.equals(user3));
        System.out.println("user3.equals(user1): " + user3.equals(user1));
        
        System.out.println("user1 hash: " + user1.hashCode());
        System.out.println("user2 hash: " + user2.hashCode());
        System.out.println("user3 hash: " + user3.hashCode());
    }

}
