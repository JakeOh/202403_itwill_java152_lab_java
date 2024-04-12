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
    
    //--- Builder(Factory) 디자인 패턴
    public static BookBuilder builder() {
        return new BookBuilder();
        // 외부 클래스에서 내부 클래스의 private 생성자를 호출할 수 있음.
    }
    
    public static class BookBuilder {
        private String title;
        private String author;
        private String publisher;
        
        private BookBuilder() {}
        
        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }
        
        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }
        
        public BookBuilder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }
        
        public Book build() {
            return new Book(title, author, publisher);
        }
        
    } // end class BookBuilder
    //--- Builder(Factory) 디자인 패턴

} // end class Book
