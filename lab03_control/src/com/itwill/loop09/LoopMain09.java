package com.itwill.loop09;

public class LoopMain09 {

    public static void main(String[] args) {
        // 중첩 while 문장을 사용해서 구구단 1단부터 12단까지 출력.
        int i = 1;
        while (i < 13) {
            System.out.println(i + "단 =====");
            
            int j = 1;
            while (j < 13) {
                System.out.printf("%d x %d = %d\n", i, j, i * j);
                j++;
            }
            
            i++;
        }

    }

}
