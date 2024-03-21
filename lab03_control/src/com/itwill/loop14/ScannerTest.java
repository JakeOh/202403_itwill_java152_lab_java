package com.itwill.loop14;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        // Scanner를 사용한 콘솔 입력:
        // nextInt(): 입력 버퍼(임시 메모리)에서 공백문자(스페이스, 탭, 엔터)로 구분된 
        // 입력값을 읽어서 int 타입 정수를 반환. 읽은 값까지만 입력 버퍼를 지움.
        // nextDouble(): 입력 버퍼에서 공백문자로 구분된 입력값을 읽어서 double 타입 실수를 반환.
        // next(): 입력 버퍼에서 공백문자로 구분된 입력값을 읽어서 문자열(String)을 반환.
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("정수 입력>> ");
        int x = scanner.nextInt();
        System.out.println("x = " + x);
        
        System.out.print("정수 입력>> ");
        x = scanner.nextInt();
        System.out.println("x = " + x);
        
        System.out.print("이름 입력>> ");
        String name = scanner.next();
        System.out.println("name: " + name);
        
        System.out.print("이메일 입력>> ");
        String email = scanner.next();
        System.out.println("email: " + email);
        
    }

}
