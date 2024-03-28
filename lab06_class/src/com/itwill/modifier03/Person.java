package com.itwill.modifier03;

public class Person {
    private String name; // 읽기 전용 필드
    private int age; // 읽기/쓰기 필드
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
