package com.itwill.array01;

public class ArrayMain01 {

    public static void main(String[] args) {
        // 배열의 필요성:
        
        // 점수들
        int score1 = 100;
        int score2 = 90;
        int score3 = 95;

        // 총점
        int total = score1 + score2 + score3;
        System.out.println("총점: " + total);
        
        // 배열(array): "같은" 타입의 데이터 여러개를 하나의 변수 이름으로 저장하기 위한 타입.
        // 인덱스(index): 배열에 값을 저장하거나, 저장된 값을 읽어올 때 사용하는 정수.
        // - 배열에서 데이터가 저장된 위치를 나타내는 정수.
        // - 인덱스는 0부터 시작하는 연속된 정수.
        // - 배열의 마지막 인덱스는 (배열의 원소 개수 - 1).
        
        // 배열 선언 & 초기화 방법 1:
        // 타입[] 변수이름 = new 타입[원소 개수];
        // -> 배열의 모든 원소를 그 타입의 기본값으로 초기화를 해줌.
        // -> 정수 타입 기본값(0), 실수 타입 기본값(0.0), boolean 타입의 기본값(false), 그 이외의 타입들의 기본값(null)
        int[] scores = new int[3]; // int 타입 3개를 저장할 수 있는 배열. 모든 값은 0으로 초기화.
        System.out.println(scores);
        System.out.println(scores[0]); // 배열 scores의 인덱스 0 위치의 원소를 출력
        
        scores[0] = 100;
        System.out.println(scores[0]);
        
        // 모든 배열 타입의 변수는 length 라는 이름의 속성을 가지고 있음.
        // length: 배열의 길이. 배열의 원소 개수.
        System.out.println("length = " + scores.length);
        
        // 반복문(for 문)을 사용해서 배열의 모든 원소를 순서대로 출력.
        for (int i = 0; i < scores.length; i++) {
            System.out.println(i + ":" + scores[i]);
        }
        
    }

}
