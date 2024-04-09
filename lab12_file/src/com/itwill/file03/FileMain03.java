package com.itwill.file03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 파일 ==> FileInputStream ==> BufferedInputStream ==> 프로그램
 * FIS: 하드디스크에 있는 파일을 직접 접근해서 데이터를 읽고, 메모리(RAM)에 적재.
 * BIS: 메모리(RAM)에 있는 파일 내용을 읽는(read) 메서드를 제공.
 * 
 * 파일 <== FileOutputStream <== BufferedOutputStream <== 프로그램
 * FOS: 하드디스크의 파일에 데이트 씀.
 * BOS: 메모리(RAM)에 데이터를 쓰는(write)하는 메서드를 제공.
 */

public class FileMain03 {

    public static void main(String[] args) {
        // BIS, BOS을 사용한 파일 읽기, 쓰기:
        
        String origin = "data/ratings.dat";
        String dest = "data/rating_copy2.dat";
        
        FileInputStream in = null;
        BufferedInputStream bin = null;
        FileOutputStream out = null;
        BufferedOutputStream bout = null;
        try {
            in = new FileInputStream(origin);
            bin = new BufferedInputStream(in);
//            bin = new BufferedInputStream(new FileInputStream(origin));
            
            out = new FileOutputStream(dest);
            bout = new BufferedOutputStream(out);
            
            long start = System.currentTimeMillis(); // 복사 시작 시간
            
            while (true) {
                byte[] buffer = new byte[4 * 1024]; // 파일에서 읽을 내용을 저장할 배열
                int b = bin.read(buffer);
                if (b == -1) { // EOF
                    break;
                }
                bout.write(buffer, 0, b);
            }
            
            long end = System.currentTimeMillis(); // 복사 종료 시간 측정
            System.out.println("복사 경과 시간: " + (end - start) + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제: 나중에 만들어진 스트림 객체를 먼저 close하고,
            // 먼저 만들어진 스트림 객체를 나중에 close해야 함.
            // 스트림 객체들은 생성된 순서의 반대로 close 메서드를 호출해야 함.
            // 가장 마지막에 생성된 스트림 객체만 close하면 나머지는 자동으로 close됨.
            try {
                bout.close();
                bin.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
