package com.itwill.list02;

import java.util.LinkedList;

public class ListMain02 {

    public static void main(String[] args) {
        // 문자열을 저장하는 LinkedList 객체 생성
        LinkedList<String> languages = new LinkedList<>();
        
        System.out.println("size = " + languages.size());
        System.out.println(languages);
        
        languages.add("Java");
        languages.add("JavaScript");
        System.out.println("size = " + languages.size());
        System.out.println(languages);
        System.out.println(languages.get(0));
        
        languages.set(0, "JAVA"); // 인덱스 위치의 값을 변경
        System.out.println(languages);
        
        languages.remove(0); // 인덱스 위치의 값 삭제
        System.out.println(languages);
        
        languages.remove("JavaScript"); // 같은 값의 원소를 찾아서 삭제
        System.out.println(languages);

    }

}
