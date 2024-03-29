package com.itwill.enum01;

public class TestMain {

    public static void main(String[] args) {
        
        int x = 100;
        switch (x) {
        case Season1.SPRING:
            System.out.println("봄");
            break;
        case Season1.SUMMER:
            System.out.println("여름");
            break;
        case Season1.FALL:
            System.out.println("가을");
            break;
        case Season1.WINTER:
            System.out.println("겨울");
            break;
        default:
            System.out.println("이상기후");
        }
        
        Season2 season2 = Season2.SPRING;
        System.out.println(season2);
        if (season2 == Season2.SPRING) {
            System.out.println("봄");
        } else if (season2 == Season2.SUMMER) {
            System.out.println("여름");
        } else {
            System.out.println("...");
        }

        Season3 season3 = Season3.SPRING;
        System.out.println(season3);
        System.out.println(season3.getName());
        
    }

}
