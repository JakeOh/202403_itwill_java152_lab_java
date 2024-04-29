package com.itwill.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.itwill.jdbc.model.Blog;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*;
import static com.itwill.jdbc.model.Blog.Entity.*;

// MVC 아키텍쳐에서 Controller를 담당하는 클래스. DAO(Data Access Object)
// CRUD(Create, Read, Update, Delete) 기능 담당: insert, select, update, delete SQL
public class BlogDao {
    
    //-----> singleton
    private static BlogDao instance = null;
    
    private BlogDao() {
        try {
            // Oracle 드라이버(라이브러리)를 등록.
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static BlogDao getInstance() {
        if (instance == null) {
            instance = new BlogDao();
        }
        
        return instance;
    }
    //<----- singleton
    
    /**
     * CRUD 메서드들에서 사용했던 리소스들을 해제.
     * @param conn Connection 객체
     * @param stmt Statement 객체
     * @param rs ResultSet 객체
     */
    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * CRUD 메서드들에서 사용했던 리소스들을 해제.
     * @param conn Connection 객체
     * @param stmt Statement 객체
     */
    private void closeResources(Connection conn, Statement stmt) {
        closeResources(conn, stmt, null);
    }
    
    // read() 메서드에서 사용할 SQL 문장: select * from blogs order by id desc
    private static final String SQL_SELECT_ALL = String.format(
            "select * from %s order by %s desc", 
            TBL_BLOGS, COL_ID);
    
    /**
     * 데이터베이스 테이블 BLOGS 테이블에서 모든 레코드(행)를 검색해서 
     * ID(고유키)의 내림차순으로 정렬된 리스트를 반환.
     * 테이블에 행이 없는 경우 빈 리스트를 리턴.
     * @return Blog를 원소로 갖는 ArrayList.
     */
    public List<Blog> read() {
        List<Blog> result = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // 데이터베이스에 접속.
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            // SQL 문장을 데이터베이스로 전송해서 실행.
            rs = stmt.executeQuery();
            // 결과 처리.
            while (rs.next()) {
                int id = rs.getInt(COL_ID);
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
                String writer = rs.getString(COL_WRITER);
                LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME)
                        .toLocalDateTime();
                LocalDateTime modifiedTime = rs.getTimestamp(COL_MODIFIED_TIME)
                        .toLocalDateTime();
                
                Blog blog = new Blog(id, title, content, writer, createdTime, modifiedTime);
                result.add(blog);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return result;
    }

}
