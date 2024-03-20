package com.itwill.loop07;

public class LoopMain07 {

    public static void main(String[] args) {
        // 과제: 구구단 출력하기
        // 2단은 2x2까지만, 3단은 3x3까지만, 4단은 4x4까지만, ..., 9단은 9x9까지 출력.
        
        // (1) break 이용하기.
        for (int x = 2; x < 10; x++) {
            System.out.println("----- " + x + "단 -----");
            for (int y = 1; y < 10; y++) {
                System.out.printf("%d x %d = %d\n", x, y, x * y);
                if (x == y) {
                    break;
                }
            }
        }
        
        System.out.println();
        
        // (2) break 이용하지 않기.
        for (int x = 2; x < 10; x++) {
            System.out.println("----- " + x + "단 -----");
            for (int y = 1; y <= x; y++) {
                System.out.printf("%d x %d = %d\n", x, y, x * y);
            }
        }

    }

}
