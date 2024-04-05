package com.itwill.string;

public class StringEx {

    public static void main(String[] args) {
        // java.lang.String 클래스의 메서드 사용법
        
        System.out.println("ex1 -----");
        // ex1. 주민번호에서 성별을 표시하는 위치의 문자열 찾기
        String ssn = "990405-2000000";
        System.out.println(ssn.charAt(7));
        
        System.out.println("ex2 -----");
        // ex2. 문자열 자르기
        String date = "2024-04-05";
        String[] array = date.split("-");
        for (String s : array) {
            System.out.println(s);
        }
        
        System.out.println("ex3 -----");
        // ex3. 아래의 문자열 배열에서 5글자 이상인 문자열들만 출력.
        // 결과: JavaScript Servlet Spring
        String[] languages = {"Java", "SQL", "JavaScript", "HTML", "CSS", "Servlet", "Spring"};
        for (String s : languages) {
            if (s.length() >= 5) {
                System.out.print(s + " ");
            }
        }
        System.out.println();
        
        System.out.println("ex4 -----");
        // ex4. 아래의 문자열 배열에서 "홍길동" 문자열이 처음 등장하는 인덱스를 출력.
        // 만약에 "홍길동"이 배열에 없는 경우에는 -1을 출력.
        // 결과: 2
        String[] names = {"오쌤", "John", "홍길동", "Gildong", "홍길동"};
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals("홍길동")) {
                index = i;
                break;
            }
        }
        System.out.println(index);
        
        System.out.println("ex5 -----");
        // ex5. 아래의 문자열 배열에서 대소문자 구별없이 "est"를 포함하는 문자열들을 출력.
        // 결과: TEST test TeSt tEsT
        String[] tests = {"TEST", "test", "TeSt", "tEsT", "테스트"};
        for (String s : tests) {
            if (s.toLowerCase().contains("est")) { // s.toUpperCase().contains("EST")
                System.out.print(s + " ");
            }
        }
        System.out.println();
        
        System.out.println("ex6 -----");
        // ex6. 아래의 "YYYY-MM-DD" 형식의 문자열에서 년/월/일 정보를 "int" 타입 변수에 저장하고 출력.
        // 결과: year=2024, month=4, day=5
        String today = "2024-04-05";
        String[] stringArray = today.split("-");
        int year = Integer.parseInt(stringArray[0]);
        int month = Integer.parseInt(stringArray[1]);
        int day = Integer.parseInt(stringArray[2]);
        System.out.printf("year=%d, month=%d, day=%d\n", year, month, day);
        
    }

}
