package com.itwill.array08;

public class ArrayMain08 {

    public static void main(String[] args) {
        // 2차원 배열 선언 & 초기화 방법 2:
        // 2차원 배열을 그 타입의 기본값으로 초기화하는 방법.
        // 타입[][] 변수이름 = new 타입[행의 개수][열의 개수];
        // - 행의 개수: 2차원 배열이 가지고 있는 1차원 배열들의 개수.
        // - 열의 개수: 1차원 배열이 가지고 있는 원소들의 개수.
        // - 행의 개수는 생략하면 안됨! 열이 개수는 생략 가능.
        
        // (1) 2차원 배열을 생성할 때 행과 열의 개수가 모두 결정된 경우 -> 직사각형 모양 배열
        int[][] array1 = new int[2][3];
        
        for (int[] arr : array1) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

    }

}
