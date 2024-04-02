package com.itwill.inheritance07;

/*
 * 추상 메서드(abstract method):
 * - 메서드의 signature(수식어, 리턴 타입, 메서드 이름, 파라미터 선언)만 선언되어 있고,
 * 메서드의 body(몸통)가 구현되어 있지 않은 메서드.
 * - 추상 메서드는 반드시 "abstract" 키워드로 수식해야 함.
 * - 추상 메서드 선언은 반드시 세미콜론(;)으로 끝내야 함.
 * 
 * 추상 클래스(abstract class):
 * - "abstract" 수식어가 사용된 클래스.
 * - 대부분의 경우 추상 클래스는 추상 메서드를 가지고 있는 경우가 많음.
 * - 클래스가 추상 메서드를 가지고 있는 경우에는 반드시 abstract로 선언해야 함.
 * - 추상 클래스는 객체를 생성할 수 없음.
 * - 추상 클래스를 상속하는 클래스를 선언하고 모든 추상 메서드를 override한 이후에 객체를 생성할 수 있음.
 */

// 추상 클래스
abstract class Animal {
    public abstract void move(); // 추상 메서드
}

class Dog extends Animal {
    @Override
    public void move() {
        System.out.println("강아지 총총총...");
    }
}

class Fish extends Animal {
    @Override
    public void move() {
        System.out.println("물고기는 스윔스윔...");
    }
}

class Bird extends Animal {
    @Override
    public void move() {
        System.out.println("새는 훨훨~~~");
    }
}

public class InheritanceMain07 {

    public static void main(String[] args) {
        Animal[] animals = {
                new Dog(),
                new Fish(),
                new Bird(),
//                new Animal()
        };
        
        for (Animal a : animals) {
            a.move();
        }

    }

}
