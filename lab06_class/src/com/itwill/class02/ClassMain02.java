package com.itwill.class02;

public class ClassMain02 {

    public static void main(String[] args) {
        // Score 객체를 생성:
        Score score1 = new Score(); //-> 모든 필드는 기본값으로 생성됨.
        System.out.println("java = " + score1.java);
        
        // score1 인스턴스의 필드 값 변경:
        score1.java = 100;
        score1.sql = 90;
        score1.javascript = 85;
        
        // score1 인스턴스의 메서드 호출:
        System.out.println("총점: " + score1.getTotal());
        System.out.println("평균: " + score1.getMean());

        // 아규먼트를 갖는 생성자를 이용한 Score 객체 생성:
        Score score2 = new Score(90, 95, 80);
        System.out.println("score2 java = " + score2.java);
        System.out.println("score2 총점: " + score2.getTotal());
        System.out.println("score2 평균: " + score2.getMean());
        
    }

}
