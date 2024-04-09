package com.itwill.file02;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileMain02 {

    public static void main(String[] args) throws Exception {
        // 대용량 파일 복사:
        // data/ratings.dat 파일을 읽고, data/ratings_copy.dat 파일에 복사
        // (1) read(), write(int b) 메서드를 사용할 때 시간 측정.
        // (2) 다른 read/write 메서드를 사용할 때 시간 측정.

        String origin = "data/ratings.dat"; // 원본 파일
        String dest = "data/ratings_copy.dat"; // 복사할 파일
        
        FileInputStream in = new FileInputStream(origin);
        FileOutputStream out = new FileOutputStream(dest);
        
        long start = System.currentTimeMillis(); // 파일 복사 시작 시간 측정
        
        while (true) {
            // (1) read() 메서드 사용:
            // int b = in.read(); // 파일에서 1바이트 읽음.
            
            // (2) read(byte[] b) 메서드 사용:
            byte[] buffer = new byte[4 * 1024]; // 4,096바이트(4KB) 크기의 빈 배열 생성
            int b = in.read(buffer);
            //-> buffer: 파일에서 읽은 내용을 저장하기 위한 바이트 배열.
            //-> 리턴 값: 파일에서 실제로 읽은 바이트 수.
            
            if (b == -1) { // EOF
                break; // 무한루프 종료
            }
            
            // (1) write(int b) 메서드 사용:
            // out.write(b); // 파일에 1바이트 씀.
            
            // (2) write(byte[] b) 메서드 사용:
            // out.write(buffer); //-> 바이트 배열의 내용을 그대로 파일에 씀. 4KB를 파일에 씀.
            
            // write(byte[] buf, int off, int len) 메서드 사용:
            out.write(buffer, 0, b);
            //-> byte[] buf: 파일에 쓸 데이터를 가지고 있는 바이트 배열.
            //-> int off: 배열 b에서 읽기 시작할 인덱스. offset.
            //-> int len: length. 배열에서 실제로 파일에 쓸 바이트 길이. 
            
        }
        
        long end = System.currentTimeMillis(); // 파일 복사 종료 시간 측정
        
        System.out.println("복사 경과 시간: " + (end - start) + "ms");
        
        in.close(); // FIS 리소스 해제
        out.close(); // FOS 리소스 해제
        
    }

}
