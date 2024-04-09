package com.itwill.file01;

import java.io.FileInputStream;
import java.io.FileOutputStream;

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
        
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(origin); // FIS 객체 생성
            out = new FileOutputStream(destination); // FOS 객체 생성
            
            while (true) {
                int read = in.read(); // 파일에서 1바이트 읽음.
                if (read == -1) { // 파일 끝(EOF: End-Of-File)에 도달했을 때
                    break;
                }
                out.write(read); // 파일에 읽은 1바이트를 씀.
                // System.out.println((char) read);
            }
            
            System.out.println("파일 복사 성공");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close(); // FIS 객체를 닫음(리소스 해제).
                out.close(); // FOS 객체를 닫음(리소스 해제).
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
