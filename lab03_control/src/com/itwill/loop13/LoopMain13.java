package com.itwill.loop13;

public class LoopMain13 {

    public static void main(String[] args) {
        /* 교재 연습문제 5
           출력 결과
           *
           **
           ***
           ****
         */
        System.out.println("교재 Ex 5.");
        for (int x = 1; x <= 4; x++) {
            for (int y = 1; y <= x; y++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        /* 교재 연습문제 6
           출력 결과
               *
              **
             ***
            ****
         */
        System.out.println("교재 Ex 6-1");
        for (int x = 1; x <= 4; x++) {
            for (int y = 1; y <= 4; y++) {
                if (y <= 4 - x) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        
        System.out.println("교재 Ex 6-2");
        for (int x = 1; x <= 4; x++) {
            for (int y = 4; y >= 1; y--) {
                if (y > x) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        
        System.out.println("교재 Ex 6-3");
        for (int x = 1; x <= 4; x++) {
            for (int y = 1; y <= 4 - x; y++) {
                System.out.print(" ");
            }
            for (int y = 1; y <= x; y++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
    }

}
