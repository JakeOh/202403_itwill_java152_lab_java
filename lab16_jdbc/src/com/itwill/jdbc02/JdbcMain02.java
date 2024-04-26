package com.itwill.jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*;

public class JdbcMain02 {

    public static void main(String[] args) {
        // insert 문장 실행 & 결과 처리
        
        Scanner sc = new Scanner(System.in); // 콘솔 입력
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 오라클 드라이버(라이브러리) 등록
            DriverManager.registerDriver(new OracleDriver());
            
            // 오라클 DB 접속
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Statement 객체 생성
            final String sql = "insert into blogs (title, content, writer) values (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            
            System.out.print("제목 입력>> ");
            String title = sc.nextLine();
            System.out.print("내용 입력>> ");
            String content = sc.nextLine();
            System.out.print("작성자 입력>> ");
            String writer = sc.nextLine();
            
            // PreparedStatement 객체의 SQL에서 ? 부분을 입력받은 내용으로 채움.
            stmt.setString(1, title); // 첫번째 ?에 title 변수의 값을 문자열로 채움.
            stmt.setString(2, content);
            stmt.setString(3, writer);
            
            // SQL 문장을 DB로 보내서 실행 & 결과 처리
            int result = stmt.executeUpdate();
            System.out.println(result + "개 행이 삽입됨.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

}
