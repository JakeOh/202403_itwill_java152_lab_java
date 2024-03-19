package com.itwill.loop06;

public class LoopMain06 {

    public static void main(String[] args) {
        // 중첩 반복문: 반복문 안에서 반복문을 사용.
        // 구구단 2단 ~ 9단까지 출력
        for (int x = 2; x < 10; x++) {
            System.out.println("----- " + x + "단 -----");
            for (int y = 1; y < 10; y++) {
                System.out.println(x + " x " + y + " = " + (x * y));
            }
            System.out.println("-----------------------");
        }

    }

}
