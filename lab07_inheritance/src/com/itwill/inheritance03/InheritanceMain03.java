package com.itwill.inheritance03;

public class InheritanceMain03 {

    public static void main(String[] args) {
        // Car 타입의 객체를 생성:
        Car car1 = new Car(50, 30);
        car1.drive();
        
        // HybridCar 타입의 객체를 생성:
        HybridCar car2 = new HybridCar(25, 30, 0);
        car2.drive();
        car2.charge(100);
        
        // 다형성(polymorphism)을 사용한 변수 선언과 초기화:
        // SuperType var = new SubType();
        Car car3 = new HybridCar(50, 40, 100);
        car3.drive(); //-> 다형성으로 선언되어 있더라도, override되어 있는 메서드가 호출됨!
        // car3.charge(100); //-> casting을 하지 않으면 SubType의(실제 객체의) 모든 메서드를 사용할 수는 없음.
        ((HybridCar) car3).charge(100); //-> casting을 하면, SubType의 모든 메서드를 사용할 수 있음.
        
        // SubType var = new SuperType(); -> 컴파일 오류
        // HybridCar car = new Car(100, 100);

        // 다형성의 장점: 코드의 재사용성(re-usability)을 높여줌.
        // (예) 배열 선언, 파라미터 선언 등에서 
        // 상위 타입으로 선언한 변수에 하위 타입 객체들을 할당할 수 있기 때문에
        // 코드 재사용성이 높아짐.
        Car[] cars = new Car[3];
        cars[0] = car1; // new Car(...)
        cars[1] = car2; // new HybridCar(...)
        cars[2] = car3; // new HybridCar(...)
        
        for (Car c : cars) {
            test(c);
        }
        
    }
    
    public static void test(Car car) {
        // instanceof 연산자: 객체가 어떤 타입인 지를 검사하는 연산자
        // 변수 instanceof Type(Class): 변수가 클래스 타입이면 true, 그렇지 않으면 false.
        if (car instanceof HybridCar) {
            System.out.println("하이브리드 자동차 검사...");
        } else if (car instanceof Car) {
            System.out.println("자동차 검사...");
        }
    }

}
