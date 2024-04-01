package com.itwill.inheritance03;

public class HybridCar extends Car {
    // 필드
    private int battery;

    // 생성자
    public HybridCar(int fuel, int speed, int battery) {
        // 상위 타입(Car)에 기본 생성자가 없기 때문에 
        // 반드시 "명시적으로(explicitly)" 아규먼트를 갖는 상위클래스 생성자를 호출해야 함.
        super(fuel, speed);
        this.battery = battery;
    }

    // 메서드
    public void charge(int battery) {
        this.battery = battery;
        System.out.println("충전중: battery=" + battery);
    }
    
    public void drive() {
        System.out.println("하이브리드자동차 운전중(속력: " + getSpeed()
                + ", 연료: " + getFuel()
                + ", 배터리: " + battery
                + ")");
    }
    
}
