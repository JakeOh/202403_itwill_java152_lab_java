package com.itwill.file07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/*
 * IO Stream: 바이트 스트림(byte stream). 읽기/쓰기의 기본 단위는 byte 단위.
 *   모든 종류의 파일(txt, jpg, mp4, pptx, pdf, ...)에서 사용 가능.
 * InputStream
 * |__ FileInputStream, BufferedInputStream, ObjectInputStream, ...
 * OutputStream
 * |__ FileOutputStream, BufferedOutputStream, ObjectOutputStream, ...
 * 
 * Reader/Writer: 문자 스트림(character stream). 읽기/쓰기의 기본 단위는 "문자(character)".
 *   텍스트 파일(txt, csv, ...)에서만 사용.
 * Reader
 * |__ InputStreamReader, BufferedReader
 *     |__ FileReader
 * Writer
 * |__ OutputStreamWriter, BufferedWriter
 *     |__ FileWriter
 *     
 * 인코딩(encoding): 문자를 그 문자에 해당하는 코드(정수) 값으로 변환. (예) 'A' -> 65
 * 디코딩(decoding): 문자 코드(정수)를 그 코드에 해당하는 문자로 변환. (예) 65 -> 'A'
 * 운영체제(OS)의 기본 인코딩 방식:
 *   - Unix, Linux, MacOS: UTF-8
 *   - 한글 MS Windows: MS949(CP949, EUC-KR), 영문 MS Windows(CP1252), ...
 */

public class FileMain07 {

    public static void main(String[] args) throws Exception {
        // 파일 이름
        final String utf8File = "data/utf8.txt"; // UTF-8 인코딩으로 저장한 파일
        final String ansiFile = "data/ansi.txt"; // ANSI(MS949) 인코딩으로 저장한 파일
        
        // Java 11 이전 버전에서 문자 스트림과 인코딩을 다루는 방법:
        // FileReader, FileWriter 클래스 생성자에서 인코딩 타입을 설정할 수 있는 방법이 없음.
        // 1. FileInputStream(바이트 스트림) 객체를 생성.
        FileInputStream in = new FileInputStream(ansiFile);
        // 2. 인코딩을 설정한 InputStreamReader(문자 스트림) 객체를 생성.
        InputStreamReader isr = new InputStreamReader(in, "EUC-KR");
        // 3. 읽기 속도를 빠르게 하기 위해서 버퍼(메모리)를 사용.
        BufferedReader reader = new BufferedReader(isr);
        
        while (true) { // 무한 반복문
            int read = reader.read(); // 파일에서 1글자를 읽음.
            if (read == -1) { // EOF
                break;
            }
            System.out.print((char) read);
        }
        System.out.println();
        
        reader.close(); // 리소스 해제
        
        // Java 11 버전부터 FileReader, FileWriter 클래스에서 인코딩을 설정할 수 있는
        // 생성자를 제공하기 시작.
        // 1. FileReader 객체를 생성할 때 인코딩 방식을 설정.
        FileReader fr = new FileReader(utf8File, Charset.forName("UTF-8"));
        // 2. 읽기 속도를 빠르게 하기 위해서 버퍼 사용.
        BufferedReader br = new BufferedReader(fr);
        
//        while (true) {
//            int read = br.read();
//            if (read == -1) {
//                break;
//            }
//            System.out.print((char) read);
//        }
        while (true) {
            String line = br.readLine(); // 파일에서 한 줄을 읽음.
            if (line == null) { // EOF
                break;
            }
            System.out.println(line);
        }
        System.out.println();
        
        br.close(); // 리소스 해제

    }

}
