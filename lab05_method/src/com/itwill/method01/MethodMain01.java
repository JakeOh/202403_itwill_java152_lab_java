package com.itwill.method01;

import java.util.Random;

/*
 * 메서드(method): 클래스 안에서 작성하는 함수(function)/기능.
 * - 프로그램에서 반복적으로 사용되는 기능들을 코드 블록을 작성.
 * - 기능이 필요한 곳에서 불러서(호출해서) 사용하기 위한 코드.
 * - 자바 언어는 클래스 안에서만 함수를 작성할 수 있음 -> 자바는 메서드만 작성할 수 있음.
 * 
 * argument(아규먼트, 인수): 메서드를 호출하는 곳에서 메서드에게 전달하는 "값".
 * parameter(파라미터, 매개변수, 인자): 아규먼트를 저장하기 위해서 선언하는 "변수".
 * return value(반환값): 메서드가 기능을 모두 수행한 후에 메서드를 호출한 곳으로 반환하는 값.
 * - 메서드에 따라서 반환값이 있을 수도 있고, 없을 수도 있음.
 */

public class MethodMain01 {

    // main 메서드(method): 프로그램의 시작과 끝.
    public static void main(String[] args) {
        
        System.out.println("안녕하세요.");
        //-> println 메서드를 호출.
        //-> println을 호출할 때 전달한 값("안녕하세요.")을 argument.
        //-> println 메서드에서 아규먼트를 저장하기 위해서 선언한 변수 -> parameter
        //-> println은 반환값이 없는 메서드
        
        Random rand = new Random();
        
        int x = rand.nextInt(10);
        //-> nextInt 메서드를 호출. 아규먼트 10을 전달.
        //-> nextInt는 반환값이 있는 메서드.
        
        System.out.println("x = " + x);
    }

}
