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
        
        int big = whoIsBig(x, y); // x, y 중 크거나 같은 수를 리턴.
        System.out.println("big=" + big);
        
        // Ex3.
        int code = random.nextInt(1, 5);
        String gender = parseGenderCode(code); // 1 또는 3이면 "male", 2 또는 4이면 "female", 그 이외에는 "unknown"
        System.out.println("code=" + code + ", gender=" + gender);

    }
    
    /**
     * 성별 코드(정수)를 문자열로 변환해서 리턴. 
     * @param code 성별 코드. 1, 2, 3, 4.
     * @return 코드 값이 1 또는 3이면 "male", 코드 값이 2 또는 4이면 "female".
     * 만약 그 이외의 코드 값인 경우에는 "unknown"을 리턴.
     */
    public static String parseGenderCode(int code) {
        String result = ""; // 반환값을 저장하기 위한 변수
        
        switch (code) {
        case 1:
        case 3:
            result = "male";
            break;
        case 2:
        case 4:
            result = "female";
            break;
        default:
            result = "unknown";
        }
        
        return result;
    }
    
    /**
     * 두 수 x와 y 중에서 크거나 같은 수를 리턴.
     * @param x 정수(int). 크기를 비교할 정수.
     * @param y 정수(int). 크기를 비교할 정수.
     * @return x > y 이면 x, 그렇지 않으면 y.
     */
    public static int whoIsBig(int x, int y) {
//        return (x > y) ? x : y;
        
        if (x > y) {
            return x;
        } else {
            return y;
        }
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
