package com.itwill.loop11;

public class LoopMain11 {

    public static void main(String[] args) {
        // Ex1. 1부터 10까지 자연수들의 합을 계산하고 출력
        // 1 + 2 + 3 + ... + 9 + 10 = 55
        int sum = 0; // 1 ~ 10 자연수들의 합을 저장할 변수
        for (int x = 1; x <= 10; x++) {
            sum += x; // sum = sum + x;
            // System.out.println("sum = " + sum);
        }
        System.out.println("sum = " + sum);
        
        // Ex2. 1부터 100까지 자연수들 중에서 짝수들의 합을 계산하고 출력.
        // 2 + 4 + 6 + ... + 98 + 100 = ?
        sum = 0;
        for (int x = 2; x <= 100; x += 2) {
            sum += x;
        }
        System.out.println("sum = " + sum);
        
        sum = 0;
        for (int x = 1; x <= 100; x++) {
            if (x % 2 == 0) {
                sum += x;
            }
        }
        System.out.println("sum = " + sum);
        
        // Ex3. 1부터 100까지 자연수들 중에서 홀수들의 합을 계산하고 출력.
        // 1 + 3 + 5 + ... + 97 + 99 = ?
        sum = 0;
        int x = 1;
        while (x < 100) {
            sum += x;
            x += 2;
        }
        System.out.println("sum = " + sum);
        
        sum = 0;
        x = 1;
        while (x < 100) {
            if (x % 2 == 1) {
                sum += x;
            }
            x++;
        }
        System.out.println("sum = " + sum);

    }

}
