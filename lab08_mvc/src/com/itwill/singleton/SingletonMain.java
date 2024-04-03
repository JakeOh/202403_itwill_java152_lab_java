package com.itwill.singleton;

public class SingletonMain {

    public static void main(String[] args) {
        // Captain 타입의 객체 생성
        Captain captain = Captain.getInstance();
        System.out.println(captain);
        System.out.println(captain.getName());
        
        Captain captain2 = Captain.getInstance();
        System.out.println(captain2);
        
        captain2.setName("아이언맨");
        System.out.println(captain.getName());
        System.out.println(captain2.getName());

    }

}
