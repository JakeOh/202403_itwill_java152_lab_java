package com.itwill.jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*;
import static com.itwill.jdbc.model.Blog.Entity.*;

public class JdbcMain04 {

    public static void main(String[] args) {
        // delete 문장 실행 & 결과 처리
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            DriverManager.registerDriver(new OracleDriver()); // 오라클 드라이버 등록
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD); // DB 접속
            
            final String sql = String.format(
                    "delete from %s where %s = ?", 
                    TBL_BLOGS, COL_ID);
            System.out.println(sql); // 실행할 SQL 문장
            
            stmt = conn.prepareStatement(sql); // Statement 객체 생성
            stmt.setInt(1, 11); // PreparedStatement의 ?를 정수 11으로 설정
            
            int result = stmt.executeUpdate(); // SQL 실행
            System.out.println(result + "개 행이 삭제됨."); // 실행 결과 출력
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
