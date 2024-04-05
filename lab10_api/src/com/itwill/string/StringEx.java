package com.itwill.string;

public class StringEx {

    public static void main(String[] args) {
        // java.lang.String 클래스의 메서드 사용법
        
        // ex1. 주민번호에서 성별을 표시하는 위치의 문자열 찾기
        String ssn = "990405-2000000";
        System.out.println(ssn.charAt(7));
        
        // ex2. 문자열 자르기
        String date = "2024-04-05";
        String[] array = date.split("-");
        for (String s : array) {
            System.out.println(s);
        }

    }

}
