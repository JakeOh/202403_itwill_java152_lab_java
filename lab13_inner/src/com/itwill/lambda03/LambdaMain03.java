package com.itwill.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class LambdaMain03 {

    public static void main(String[] args) {
        // Stream 클래스 & 메서드
        
        Random rand = new Random();
        
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(rand.nextInt(100));
        }
        System.out.println(numbers);
        
        // numbers의 원소들 중에서 짝수들만 선택(필터링)한 새로운 리스트를 만들고 출력.
        ArrayList<Integer> evens = new ArrayList<>();
        for (Integer x : numbers) {
            if (x % 2 == 0) {
                evens.add(x);
            }
        }
        System.out.println(evens);

        List<Integer> evens2 = numbers.stream().filter((x) -> x % 2 == 0).toList();
        System.out.println(evens2);
        
        // Stream을 사용해서, numbers의 원소들 중에서 홀수들만 선택한 리스트를 만들고 출력
        List<Integer> odds = numbers.stream().filter((x) -> x % 2 == 1).toList();
        System.out.println(odds);
        
        // Stream 사용해서, numbers의 원소들의 제곱을 저장하는 리스트를 만들고 출력
        List<Integer> squares = numbers.stream().map((x) -> x * x).toList();
        System.out.println(squares);
        
        // Stream 사용해서, numbers의 원소들 중 홀수들의 제곱을 저장하는 리스트를 만들고 출력
        List<Integer> oddSquares = numbers.stream()
                .filter((x) -> x % 2 == 1)
                .map((x) -> x * x)
                .toList();
        System.out.println(oddSquares);
        
        List<Integer> result = new ArrayList<>();
        for (Integer x : numbers) {
            if (x % 2 == 1) {
                result.add(x * x);
            }
        }
        System.out.println(result);
        
        List<String> languages = Arrays.asList("java", "javascript", "python", "c", "kotlin", "swift");
        System.out.println(languages);
        
        // languages의 원소들 중 문자열 길이 5글자 이상인 원소들의 리스트
        List<String> longWords = languages.stream().filter((x) -> x.length() >= 5).toList();
        System.out.println(longWords);
        
        // languages의 문자열을 대문자로 변환한 리스트
        List<String> upperCases = languages.stream().map((x) -> x.toUpperCase()).toList();
        System.out.println(upperCases);
        
        // languages의 원소들 중 길이 5글자 이상인 문자열을 대문자로 변환한 리스트
        List<String> result2 = languages.stream()
                .filter((x) -> x.length() >= 5)
//                .map((x) -> x.toUpperCase())
                .map(String::toUpperCase) // 메서드 참조 람다
                .toList();
        System.out.println(result2);
        
        /*
         * 람다: (파라미터 선언) -> 리턴값
         * "메서드 참조(method reference)"를 사용한 람다 표현식
         * (1) 람다가 아규먼트를 1개만 갖고,
         * 람다의 리턴값이 그 아규먼트에서 "파라미터가 없는 메서드"를 호출한 경우:
         *     x -> x.toUpperCase()
         *     String::toUpperCase
         * (2) 람다가 아규먼트를 1개만 갖고,
         * 람다의 구현부가 메서드 1개 호출이고, 그 메서드가 람다의 아규먼트를 전달받는 경우:
         *      x -> System.out.println(x)
         *      System.out::println
         */
        languages.forEach(System.out::println);
    }

}
