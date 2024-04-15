package com.itwill.lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface MyFilter {
    boolean test(Object x);
}

@FunctionalInterface
interface MyMapper {
    Object transform(Object x);
}

public class LambdaMain02 {

    public List<Object> filter(List<Object> list, MyFilter filter) {
        List<Object> result = new ArrayList<>();
        
        for (Object x : list) {
            if (filter.test(x)) {
                result.add(x);
            }
        }
        
        return result;
    }
    
    public List<Object> map(List<Object> list, MyMapper mapper) {
        List<Object> result = new ArrayList<>();
        
        for (Object x : list) {
            result.add(mapper.transform(x));
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        LambdaMain02 app = new LambdaMain02(); // filter 메서드를 호출하기 위해서
        
        List<Object> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(numbers);

        // numbers에서 홀수들만 선택(필터링)
        List<Object> odds = app.filter(numbers, new MyFilter() {
            @Override
            public boolean test(Object x) {
                return (Integer) x % 2 == 1;
            }
        });
        System.out.println(odds);
        
        // numbers에서 짝수들만 선택(필터링)
        List<Object> evens = app.filter(numbers, (x) -> (Integer) x % 2 == 0);
        System.out.println(evens);
        
        List<Object> languages = Arrays.asList("Java", "SQL", "HTML", "JavaScript", "Python");
        // languages의 원소들 중 문자열의 길이가 5자 이상인 원소들만 선택(필터링)
        List<Object> longWords = app.filter(languages, (x) -> ((String) x).length() >= 5);
        System.out.println(longWords);
        
        // numbers의 원소들의 제곱을 저장하는 리스트:
//        List<Object> squares = app.map(numbers, new MyMapper() {
//            @Override
//            public Object transform(Object x) {
//                Integer i = (Integer) x;
//                return i * i;
//            }
//        });
        List<Object> squares = app.map(numbers, (x) -> (Integer) x * (Integer) x);
        System.out.println(squares);
        
        // languages의 문자열을 대문자로 변환한 리스트:
        List<Object> upperCases = app.map(languages, (x) -> ((String) x).toUpperCase());
        System.out.println(upperCases);
    }

}
