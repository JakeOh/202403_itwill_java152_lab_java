package com.itwill.exception06;

public class ExceptionMain06 {

    public static void main(String[] args) {
        // Calculator 타입 객체 생성
        Calculator calc = new Calculator();
        try {
            int result = calc.divide(100, 0);
            System.out.println(result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("main 정상 종료");
    }
    
}
