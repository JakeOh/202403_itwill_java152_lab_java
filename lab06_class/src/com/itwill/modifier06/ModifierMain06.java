package com.itwill.modifier06;

/*
 * 접근 수식어(access modifier)는 지역 변수에는 사용할 수 없음!
 * 
 * final 수식어
 * - 클래스, 클래스의 멤버(필드, 메서드), 지역 변수에서 사용 가능.
 * - final 의미: 바꿀 수 없는.
 * - final 필드/지역변수: 한 번 초기화가 되면 더이상 값을 변경할 수 없는 변수. 상수(constant)
 * - final 필드는 반드시
 *   (1) 선언과 동시에 초기화하거나
 *   (2) 아규먼트를 갖는 생성자를 선언해서 명시적으로 초기화해야 함.
 * 
 */

public class ModifierMain06 {
    
    private static final int version = 1; // 선언과 동시에 초기화된 final 필드
    
    private final String message; // 선언할 때 초기화되지 않은 final 필드
    
    // final 필드를 명시적으로 초기화하는 생성자:
    public ModifierMain06(String message) {
        this.message = message;
    }
    
    public static void main(String[] args) {
//        version = 2; // final 필드는 값을 변경할 수 없음.
        
        // 지역 변수 선언 & 초기화.
        int n1 = 10;
        n1 = 100;
        
        final int n2 = 10; //-> 상수. final 지역 변수
//        n2 = 100; // 값을 변경(재할당)할 수 없음.
        
        final int n3;
        n3 = 10;
//        n3 = 100;
        
        // ModifierMain06 타입의 객체를 생성:
        ModifierMain06 app = new ModifierMain06("버스 파업");
//        app.message = ""; //-> final 필드는 객체 생성 이후에 값을 변경할 수 없음.
        
    }

}
