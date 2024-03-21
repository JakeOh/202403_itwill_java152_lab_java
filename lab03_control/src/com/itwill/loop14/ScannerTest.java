package com.itwill.loop14;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        // Scanner를 사용한 콘솔 입력:
        // nextInt(): 입력 버퍼(임시 메모리)에서 공백문자(스페이스, 탭, 엔터)로 구분된 
        // 입력값을 읽어서 int 타입 정수를 반환. 읽은 값까지만 입력 버퍼를 지움.
        // nextDouble(): 입력 버퍼에서 공백문자로 구분된 입력값을 읽어서 double 타입 실수를 반환.
        // next(): 입력 버퍼에서 공백문자로 구분된 입력값을 읽어서 문자열(String)을 반환.
        // nextLine(): 입력 버퍼에서 엔터를 만날 때까지 모든 값을 읽어서 문자열을 반환.
        // nextLine()을 호출하면 입력 버퍼의 모든 내용이 지워짐!
        
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
        
        scanner.nextLine(); // 입력 버퍼에 남아있는 값을 읽고 버퍼를 지움.
        
        System.out.print("문자열 입력>> ");
        String msg = scanner.nextLine();
        System.out.println("msg: " + msg);
        
        // nextLine()으로 읽은 값을 정수로 변환 -> Integer.parseInt(...)
        // nextLine()으로 읽은 값을 실수로 변환 -> Double.parseDouble(...)
        System.out.print("정수 입력>> ");
        x = Integer.parseInt(scanner.nextLine());
        System.out.println("x = " + x);
        
        System.out.print("실수 입력>> ");
        double y = Double.parseDouble(scanner.nextLine());
        System.out.println("y = " + y);
        
    }

}
