package com.itwill.file01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 * 입/출력 스트림(Input/Output Stream): 프로그램에서 값을 입력받거나 출력하는 통로.
 *   (예) System.in: (콘솔) 입력 스트림 객체
 *   (예) System.out: (콘솔) 출력 스트림 객체
 * 
 * 프로그램 <=== InputStream === 입력장치(키보드, 콘솔, 파일, ...)
 * 프로그램 === OutputStream ===> 출력장치(모니터, 프린터, 파일, ...)
 * 
 * 프로그램 <=== FileInputStream === 파일
 * 프로그램 ===> FileOutputStream ===> 파일
 * 
 * java.io.InputStream: 프로그램이 데이터를 읽어들이는 통로.
 * |__ FileInputStream: 프로그램이 파일에서 데이터를 읽어들이는 통로.
 *   (1) FileInputStream 객체 생성.
 *   (2) FIS 객체의 read 관련 메서드를 호출.
 *   (3) FIS 객체를 닫음(close).
 *   
 * java.io.OutputStream: 프로그램에서 데이터를 쓰는(출력하는) 통로.
 * |__ FileOutputStream: 프로그램에서 파일에 데이터를 쓰는 통로.
 *   (1) FileOutputStream 객체 생성.
 *   (2) FOS 객체의 write 관련 메서드 호출.
 *   (3) FOS 객체를 닫음(close).
 */

public class FileMain01 {

    public static void main(String[] args) {
        String origin = "data/hello.txt"; // 원본 파일(읽을 파일) 경로, 이름.
        String destination = "data/hello_copy.txt"; // 복사할 파일 경로, 이름.
        
        try {
            FileInputStream in = new FileInputStream(origin);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
