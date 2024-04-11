package com.itwill.file08;

import java.io.File;

/*
 * 파일, 폴더(디렉토리) 관리 - 정보, 생성, 삭제, ...
 * 
 * 현재 작업 폴더(CWD: Current Working Directory):
 *   현재 프로그램(프로세스)가 실행되는 폴더 위치.
 *   이클립스에서 자바 프로그램을 실행(Run as Java application)할 때, 현재작업폴더의 위치는 프로젝트 폴더.
 * 절대 경로(absolute path):
 *   - 시스템의 루트(C:\, D:\, /)부터 파일 또는 폴더가 있는 위치까지를 찾아가는 방식.
 *   - (Windows 예) C:\study\workspace\lab12_file\data\hello.txt
 *   - (Linux, MacOS 예) /users/itwill/documents/hello.txt
 * 상대 경로(relative path):
 *   - 현재작업폴더를 기준으로 파일 또는 폴더 위치를 찾아가는 방식.
 *   - (Windows 예) data\hello.txt
 *   - (Linux, MacOS 예) document/hello.txt
 *   - 현재 폴더(디렉토리): . (예) .\data\hello.txt
 *   - 상위 폴더(디렉토리): .. (예) ..\src\com\itwill\file08\FileMain.java
 * 파일 구분자(file separator):
 *   - 상위 폴더와 하위 폴더, 폴더와 파일을 구분하기 위한 기호.
 *   - Windows: \
 *   - Linux, MacOS: /
 *   - 문자열("") 안에서 백슬래쉬(\)는 특별한 의미(escape 문자열)
 *     o. "\n": 줄바꿈, "\t": 탭, "\s": 공백, "\\": 백슬래쉬
 *     o. Windows 파일 경로: "C:\\study\\workspace\\lab12"
 *     o. Linux, MacOS 파일 경로: "/users/itwill/documents"
 */

public class FileMain08 {

    public static void main(String[] args) {
        // 이클립스에서 자바 프로그램이 실행되는 현재 작업 디렉토리(CWD)
        String cwd = System.getProperty("user.dir");
        System.out.println("CWD: " + cwd);
        
        String path = "C:\\study\\workspace\\lab12_file"; // Windows 절대 경로 표현법
        System.out.println(path);
        
//        String path2 = "data\\hello.txt"; // Windows 상대 경로 표현법
        String path2 = "data" + File.separator + "hello.txt"; // OS에 무관한 상대 경로
        System.out.println(path2);
        
        // File 클래스:
        // 파일(txt, jpg, mp4, ...)과 폴더(디렉토리)에 관련된 기능들을 가지고 있는 클래스.
        // File 타입 객체 생성 - 파일(과 폴더)를 관리할 수 있는 객체 생성.
        File f = new File(path2);
        System.out.println("경로: " + f.getPath());
        System.out.println("절대경로: " + f.getAbsolutePath());
        System.out.println("존재 여부: " + f.exists());
        System.out.println("파일 여부: " + f.isFile());
        System.out.println("폴더 여부: " + f.isDirectory());
        System.out.println("파일 크기: " + f.length() + "바이트");
        
        // 새 폴더 만들기
        File testFolder = new File("test");
//        System.out.println(testFolder.getAbsolutePath());
        if (testFolder.exists()) {
            System.out.println("이미 폴더가 존재...");
        } else {
            testFolder.mkdir(); // make directory
            System.out.println("폴더 생성 성공");
        }
        
        // 폴더 삭제
        if (testFolder.exists()) {
            testFolder.delete();
            System.out.println("폴더 삭제 성공");
        } else {
            System.out.println("폴더가 존재하지 않음...");
        }
        
    }

}
