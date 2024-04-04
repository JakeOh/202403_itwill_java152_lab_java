package com.itwill.exception02;

import java.util.Scanner;

/*
 * try-catch 문장을 사용한 예외 처리:
 * 
 * try {
 *     정상적인 상황에서 실행할 코드들; // (1)
 * } catch (Exception 타입의 변수 선언) {
 *     예외 상황이 발생했을 때 처리할 코드들; // (2)
 * } finally {
 *     예외 상황 발생 여부와 상관 없이 반드시 실행할 코드들; // (3)
 * }
 * 
 * 예외가 발생하지 않을 경우: (1) -> (3)
 * 예외가 발생한 경우: (1) -- 예외 발생 --> (2) -> (3)
 * 
 * try-catch 문장에서 catch 블록은 반드시 1개 이상 있어야 함.
 * catch 블록은 처리하려는 예외의 종류에 따라서 여러개를 작성할 수 있음.
 * finally 블록은 선택 사항.
 * 
 */

public class ExceptionMain02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("x = ");
            int x = Integer.parseInt(sc.nextLine());
            
            System.out.print("y = ");
            int y = Integer.parseInt(sc.nextLine());
            
            System.out.println("x / y = " + (x / y));
        } catch (ArithmeticException e) {
            System.out.println("y는 0이 될 수 없음.");
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("x, y는 정수로 입력하세요.");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("--- end ---");
        }

    }

}
