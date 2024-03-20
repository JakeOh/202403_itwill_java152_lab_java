package com.itwill.loop08;

public class LoopMain08 {

    public static void main(String[] args) {
        // while 반복문
        
        System.out.println("----- [1] -----");
        int n = 1;
        while (n <= 5) {
            System.out.print(n + " ");
            n++; // n += 1; n = n + 1;
        }
        System.out.println();
        
        System.out.println("----- [2] -----");
        // 5 4 3 2 1 출력
        n = 5;
        while (n > 0) {
            System.out.print(n + " ");
            n--;
        }
        System.out.println();
        
        System.out.println("----- [3] -----");
        // 1 3 5 7 9 출력
        n = 1;
        while (n < 10) {
            System.out.print(n + " ");
            n += 2; // n = n + 2;
        }
        System.out.println();
        
        n = 1;
        while (n < 10) {
            if (n % 2 == 1) {
                System.out.print(n + " ");
            }
            n++;
        }
        System.out.println();
        
        System.out.println("----- [4] -----");
        // while문을 사용해서 구구단 9단을 출력.
        n = 1;
        while (n < 10) {
            System.out.printf("9 x %d = %d\n", n, 9 * n);
            n++;
        }
        // for (int i = 1; i < 10; i++) { print(); }

    }

}
