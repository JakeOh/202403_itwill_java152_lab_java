package com.itwill.modifier01;

/*
 * 클래스의 멤버: 필드(field), 생성자(constructor), 메서드(method)
 * 클래스 멤버들의 접근(가시성) 수식어(access modifier):
 * - 클래스의 멤버들을 접근할 수 있는(보여지는) 범위를 제한하는 수식어
 * - 종류와 범위: private < (package) < protected < public
 * (1) private: 선언된 클래스 안에서만 접근할 수 있는(보이는) 멤버.
 * (2) (package): 수식어를 사용하지 않은 경우. 같은 패키지에 있는 클래스에서 접근할 수 있는(보이는) 멤버.
 * (3) protected: 같은 패키지에 있거나 또는 상속하는 클래스에서 접근할 수 있는(보이는) 멤버.
 * (4) public: 어디서든 접근할 수 있는(보이는) 멤버.
 */

public class ModifierMain01 {
    
    public static void main(String[] args) {
        // AccessExample 타입 객체 생성
        AccessExample ex = new AccessExample(1, 2, 3, 4);
//        System.out.println("a = " + ex.a); //-> 컴파일 에러: not visible(보이지 않음).
//        ex.a = 100;
        System.out.println("b = " + ex.b);
        ex.b = 200;
        System.out.println("b = " + ex.b);
        ex.info();
    }

}
