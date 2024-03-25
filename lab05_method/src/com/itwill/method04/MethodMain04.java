package com.itwill.method04;

import java.util.Random;

public class MethodMain04 {

    public static void main(String[] args) {
        // 다양한 리턴 타입:
        
        Random random = new Random();
        
        int number = random.nextInt(100);
        System.out.println("number = " + number);
        
        // Ex1. isEven(정수): 정수가 짝수이면 true, 그렇지 않으면 false를 리턴.
        boolean result = isEven(number);
        System.out.println("isEven = " + result);
        
        // Ex2.
        int x = random.nextInt(100);
        int y = random.nextInt(100);
        System.out.println("x=" + x + ", y=" + y);
        
        int big = whoIsBig(x, y);
        System.out.println("big=" + big);
        
        // Ex3.
        int code = random.nextInt(1, 5);
        String gender = parseGenderCode(code);
        System.out.println("code=" + code + ", gender=" + gender);

    }
    
    /**
     * 아규먼트로 전달된 정수가 짝수인 지, 홀수인 지를 리턴하는 메서드.
     * @param x 정수(int). 짝수/홀수를 검사할 정수.
     * @return x가 짝수이면 true, 그렇지 않으면 false.
     */
    public static boolean isEven(int x) {
//        if (x % 2 == 0) {
//            return true;
//        } else {
//            return false;
//        }
        
//        boolean result = false;
//        if (x % 2 == 0) {
//            result = true;
//        } else {
//            result = false;
//        }
//        
//        return result;
        
        return (x % 2 == 0) ? true : false;
    }

}
