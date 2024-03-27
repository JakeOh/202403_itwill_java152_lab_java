package com.itwill.class07;

public class ClassMain07 {

    public static void main(String[] args) {
        // ThisTest 객체를 여러가지 생성자들을 이용해서 생성
        ThisTest test1 = new ThisTest();
        test1.info();
        
        ThisTest test2 = new ThisTest(1);
        test2.info();
        
        ThisTest test3 = new ThisTest(1, 20);
        test3.info();
        
        ThisTest test4 = new ThisTest(1, 20, 300);
        test4.info();

    }

}
