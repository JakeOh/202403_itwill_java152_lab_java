package com.itwill.modifier02;

import com.itwill.modifier01.AccessExample;
// 다른 패키지에서 선언된 클래스 이름으로 변수를 선언하려면
// (1) import 문장을 작성하고 변수 선언에서 클래스 이름만 사용하거나,
// (2) import 문장 없이 패키지 이름을 포함한 전체 클래스 이름으로 변수를 선언함.
// java.lang 패키지에 포함된 클래스들은 import 문장 없이 클래스 이름만으로 변수 선언할 수 있음.
// (예) java.lang.String, java.lang.System, java.lang.Math, ...

public class ModifierMain02 {

    public static void main(String[] args) {
        // com.itwill.modifier01.AccessExample 타입의 객체를 생성
//        com.itwill.modifier01.AccessExample ex = 
//                new com.itwill.modifier01.AccessExample(1, 2, 3, 4);
        AccessExample ex = new AccessExample(1, 2, 3, 4);
//        System.out.println(ex.b); //-> 컴파일 에러: not visible(보이지 않음)
        ex.info();
    }

}
