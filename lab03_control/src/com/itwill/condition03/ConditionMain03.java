package com.itwill.condition03;

import java.util.Scanner;

public class ConditionMain03 {

    public static void main(String[] args) {
        // Scanner 타입의 변수를 선언, 초기화.
        Scanner sc = new Scanner(System.in);
        
        // 콘솔 창에서 Java 과목 점수(0 ~ 100 정수)를 입력받고 저장.
        System.out.print("Java 점수>>> ");
        int java = sc.nextInt();
        
        // 콘솔 창에서 SQL 과목 점수를 입력받고 저장.
        System.out.print("SQL 점수>>> ");
        int sql = sc.nextInt();
        
        // 콘솔 창에서 JavaScript 과목 점수를 입력받고 저장.
        System.out.print("JavaScript 점수>>> ");
        int javascript = sc.nextInt();
        
        // 세 과목의 점수 출력.
        System.out.println("Java: " + java);
        System.out.println("SQL: " + sql);
        System.out.println("JavaScript: " + javascript);
        
        // 세 과목의 총점(정수)을 계산하고 출력.
        int total = java + sql + javascript;
        System.out.println("총점: " + total);
        
        // 세 과목의 평균(소수점까지 계산)을 계산하고 출력.
        double mean = (double) total / 3;
        System.out.println("평균: " + mean);
        
        // 세 과목 평균이 90점 이상이면, "A"
        // 세 과목 평균이 80점 이상이면, "B"
        // 세 과목 평균이 70점 이상이면, "C"
        // 세 과목 평균이 70점 미만이면, "F"라고 출력.
        if (mean >= 90) {
            System.out.println("A");
        } else if (mean >= 80) {
            System.out.println("B");
        } else if (mean >= 70) {
            System.out.println("C");
        } else {
            System.out.println("F");
        }

    }

}
