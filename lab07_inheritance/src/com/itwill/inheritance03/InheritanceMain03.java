package com.itwill.inheritance03;

public class InheritanceMain03 {

    public static void main(String[] args) {
        // Car 타입의 객체를 생성:
        Car car1 = new Car(50, 30);
        car1.drive();
        
        // HybridCar 타입의 객체를 생성:
        HybridCar car2 = new HybridCar(25, 30, 0);
        car2.drive();

    }

}
