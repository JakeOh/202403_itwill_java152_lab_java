package com.itwill.thread01;

/*
 * 쓰레드 사용법 1:
 * (1) Thread 상속하는 클래스 선언
 * (2) (1)에서 선언한 클래스에서 run 메서드를 재정의(override) -> 쓰레드가 할 일.
 * (3) (2)에서 작성한 클래스의 객체를 생성.
 * (4) (3)에서 생성된 객체의 start() 메서드를 호출 -> 쓰레드가 실행됨.
 * (주의) 쓰레드 객체의 run 메서드를 직접 호출하면 안됨!
 * 이유: start() 호출 -> JRE에서 쓰레드를 초기화(메모리 할당, 스케쥴링, ...) 
 *                    -> JRE에 의해서 run() 메서드가 호출됨. 
 */

public class ThreadMain01 {

    public static void main(String[] args) {
        // (1) Thread를 상속하는 클래스를 선언
        class MyThread extends Thread {
            private String name;
            
            public MyThread(String name) {
                this.name = name;
            }
            
            // (2) run 메서드 재정의
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i + " : " + name);
                    try {
                        sleep(100); // Thread 클래스의 static 메서드 호출
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
        // (3) MyThread 객체 생성
        MyThread th1 = new MyThread("쓰레드");
        
        // (4) MyThread 객체의 start() 메서드 호출
        th1.start();

        System.out.println("***** main 메서드 종료 *****");
    }

}
