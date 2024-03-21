package com.itwill.array02;

public class ArrayMain02 {

    public static void main(String[] args) {
        // 배열 선언 & 초기화 방법 2:
        // 배열이 가지고 있는 원소들을 나열하면서 배열을 초기화.
        // 타입[] 변수이름 = new 타입[] { ... }; -> (주의) 배열 원소 개수를 표기하지 않음!
        // 타입[] 변수이름 = { ... };
        int[] numbers = {1, 3, 5, 7}; // new int[] {1, 3, 5, 7};
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("[%d] %d\n", i, numbers[i]);
        }
        
        // 향상된 for 문(enhanced for statement, for-each)
        // for (변수 선언 : 배열) { ... }
        // 배열의 원소들을 순서대로 반복(iteration)하면서 반복문 블록을 수행.
        // 배열 원소의 값을 읽을 수는 있지만, 변경할 수는 없다.
        for (int x : numbers) {
            System.out.println(x);
        }

    }

}
