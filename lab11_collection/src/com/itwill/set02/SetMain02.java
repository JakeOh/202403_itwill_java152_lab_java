package com.itwill.set02;

import java.util.HashSet;
import java.util.Random;

public class SetMain02 {

    public static void main(String[] args) {
        // 1. 정수를 저장하는 HashSet을 선언, 초기화
        HashSet<Integer> set = new HashSet<>();
        
        // 2. [0, 10) 범위의 (서로 다른) 난수 5개를 집합(Set)에 저장.
        Random rand = new Random();
        while (set.size() < 5) {
//            int x = rand.nextInt(10);
//            System.out.println("x = " + x);
            
            set.add(rand.nextInt(10));
            System.out.println(set);
        }
        
        // 3. 향상된 for 문장을 사용해서 집합의 내용을 출력.
        for (Integer x : set) {
            System.out.print(x + ", ");
        }
        System.out.println();

    }

}
