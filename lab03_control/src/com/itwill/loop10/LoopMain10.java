package com.itwill.loop10;

public class LoopMain10 {

    public static void main(String[] args) {
        // while (조건식) { ... }
        // while 반복문은 블록을 시작하기 전에 조건식을 검사하기 때문에,
        // 처음부터 조건식이 false가 되는 경우에는 블록이 한 번도 실행되지 않을 수 있음.
        
        int x = 1;
        while (x < 0) {
            System.out.println(x);
            x--;
        }
        System.out.println("==> end while 1");

        // do { ... } while (조건식);
        // do-while 반복문은 블록을 먼저 한 번은 실행하고,
        // 반복을 계속할 지를 결정하기 위해서 조건식을 검사함.
        // (주의) do-while 문장은 반드시 세미콜론(;)으로 끝내야 함.
        
        x = 1;
        do {
            System.out.println(x);
            x--;
        } while (x < 0);
        System.out.println("===> end do-while 2");
        
    }

}
