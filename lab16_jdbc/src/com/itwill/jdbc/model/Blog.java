package com.itwill.jdbc.model;

import java.time.LocalDateTime;

public class Blog {
    
    public static final class Entity {
        // 데이터베이스 테이블 이름을 상수로 선언. 
        public static final String TBL_BLOGS = "BLOGS";

        // 데이터베이스 BLOGS 테이블의 컬럼 이름들을 상수로 선언.
        public static final String COL_ID = "ID";
        public static final String COL_TITLE = "TITLE";
        public static final String COL_CONTENT = "CONTENT";
        public static final String COL_WRITER = "WRITER";
        public static final String COL_CREATED_TIME = "CREATED_TIME";
        public static final String COL_MODIFIED_TIME = "MODIFIED_TIME";
    }
    
    private int id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;
    
    public Blog() {}

    public Blog(int id, String title, String content, String writer, LocalDateTime createdTime,
            LocalDateTime modifiedTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer + ", createdTime="
                + createdTime + ", modifiedTime=" + modifiedTime + "]";
    }

}
