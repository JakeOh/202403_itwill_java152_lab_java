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
        
        // ex3. 아래의 문자열 배열에서 5글자 이상인 문자열들만 출력.
        // 결과: JavaScript Servlet Spring
        String[] languages = {"Java", "SQL", "JavaScript", "HTML", "CSS", "Servlet", "Spring"};
        // TODO
        
        
        // ex4. 아래의 문자열 배열에서 "홍길동" 문자열이 처음 등장하는 인덱스를 출력.
        // 만약에 "홍길동"이 배열에 없는 경우에는 -1을 출력.
        // 결과: 2
        String[] names = {"오쌤", "John", "홍길동", "Gildong", "홍길동"};
        // TODO
        
        
        // ex5. 아래의 문자열 배열에서 대소문자 구별없이 "est"를 포함하는 문자열들을 출력.
        // 결과: TEST test TeSt tEsT
        String[] tests = {"TEST", "test", "TeSt", "tEsT", "테스트"};
        // TODO
        
        
        // ex6. 아래의 "YYYY-MM-DD" 형식의 문자열에서 년/월/일 정보를 "int" 타입 변수에 저장하고 출력.
        // 결과: year=2023, month=10, day=4
        String today = "2024-04-05";
        // TODO
        
    }

}
