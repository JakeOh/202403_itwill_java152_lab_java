package com.itwill.class03;

public class Person {
    // field
    String name;
    int age;
    
    // constructor
    public Person() {}
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // method
    public void introduce() {
        System.out.println("안녕하세요, 저는 " + name + "입니다.");
        System.out.println("제 나이는 " + age + "입니다.");
    }
    
}
