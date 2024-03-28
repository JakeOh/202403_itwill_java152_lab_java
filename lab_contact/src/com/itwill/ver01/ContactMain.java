package com.itwill.ver01;

import java.util.Scanner;

public class ContactMain {
    
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("*** 연락처 프로그램 v0.1");
        
        // 프로그램 계속 실행(run=true) 또는 종료(run=false) 여부를 저장하기 위한 변수.
        boolean run = true;
        while (run) {
            // TODO 메인 메뉴 보여주기
            // switch ()
        }
        
        System.out.println("*** 프로그램 종료 ***");
    }
    
    private int showMainMenu() {
        System.out.println("\n----------------------------------------------");
        System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
        System.out.println("----------------------------------------------");
        System.out.print("선택> ");
        
        int menu = Integer.parseInt(scanner.nextLine());
        
        return menu;
    }

}
