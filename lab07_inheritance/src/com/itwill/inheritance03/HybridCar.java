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
    
    /*
     * 메서드/생성자 오버로딩(overloading):
     * 파라미터가 다른 같은 이름의 메서드/생성자를 여러개 선언(정의).
     * 
     * 메서드 오러라이딩(overriding):
     * 상위 타입에서 선언된 메서드를 하위 타입에서 재정의하는 것.
     * 리턴 타입, 메서드 이름, 파라미터 선언이 모두 같아야 함.
     * 접근 수식어는 상위 타입의 가시성 범위와 같거나 더 넓어질 수 있음.
     */
    
    @Override // 애너테이션(annotation) - 자바 컴파일러가 사용.
    public void drive() {
        // super.drive(); //-> 상위 객체의 재정의 하기 전의 메서드 호출
        System.out.println("하이브리드자동차 운전중(속력: " + getSpeed()
                + ", 연료: " + getFuel()
                + ", 배터리: " + battery
                + ")");
    }
    
}
