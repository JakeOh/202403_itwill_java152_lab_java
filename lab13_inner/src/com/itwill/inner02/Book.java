package com.itwill.inner02;

public class Book {
    private String title; // 제목
    private String author; // 저자
    private String publisher; // 출판사
    
    // 생성자 overloading
    public Book() {}
    
    public Book(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }
    
    public Book(String title) {
//        this.title = title;
        this(title, null, null); // 오버로딩된 다른 생성자 호출
    }
    
    // overloading되지 않는 경우:
//    public Book(String author) {
//        this.author = author;
//    }
    
    public Book(String title, String author) {
        this(title, author, null);
//        this.title = title;
//        this.author = author;
    }
    
//    public Book(String title, String publisher) {}
    
    @Override
    public String toString() {
        return String.format("Book(제목:%s, 저자:%s, 출판사:%s)", 
                title, author, publisher);
    }

}
