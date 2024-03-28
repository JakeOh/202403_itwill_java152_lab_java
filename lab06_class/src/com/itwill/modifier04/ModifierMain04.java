package com.itwill.modifier04;

import com.itwill.modifier05.PublicClassEx;

/*
 * 클래스 멤버의 접근 제한자: private < (package) < protected < public
 * 클래스의 접근 제한자:
 *   (1) public: 어디서든(모든 패키지)에서 공개된 클래스. import 문장을 사용할 수 있음.
 *   (2) (package): 수식어가 없는 경우. 같은 패키지 안에서만 공개된 클래스.
 * (주의) public 클래스의 이름은 java 파일의 이름과 같아야 함!
 * 하나의 java 파일 안에 여러개의 클래스를 선언하는 것은 가능.
 * 하나의 java 파일 안에서 2개 이상의 public 클래스는 선언할 수 없음.
 * 하나의 java 파일에 여러개의 클래스를 선언한 경우, 컴파일 후에는 각각의 클래스 파일(바이트 코드)들이 생성됨.
 *   ModifierMain04.java --[compile]--> A.class, B.class, ModifierMain04.class
 */

class A {}

class B {}

public class ModifierMain04 {

    public static void main(String[] args) {
        // PublicClassEx 타입 객체 생성
        PublicClassEx ex = new PublicClassEx();
        System.out.println(ex);
        
//        com.itwill.modifier05.PackageClassEx ex2; //-> 컴파일 에러(not visible)

    }

}
