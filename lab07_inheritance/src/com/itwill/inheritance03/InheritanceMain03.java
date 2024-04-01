package com.itwill.inheritance03;

public class InheritanceMain03 {

    public static void main(String[] args) {
        // Car 타입의 객체를 생성:
        Car car1 = new Car(50, 30);
        car1.drive();
        
        // HybridCar 타입의 객체를 생성:
        HybridCar car2 = new HybridCar(25, 30, 0);
        car2.drive();
        
        // 다형성(polymorphism)을 사용한 변수 선언과 초기화:
        // SuperType var = new SubType();
        Car car3 = new HybridCar(50, 40, 100);

        // SubType var = new SuperType(); -> 컴파일 오류
        // HybridCar car = new Car(100, 100);

    }

}
