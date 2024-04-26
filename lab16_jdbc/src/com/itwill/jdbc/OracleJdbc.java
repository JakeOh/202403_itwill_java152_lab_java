package com.itwill.jdbc;

public interface OracleJdbc {
    // public static final 생략 가능
    
    // 오라클 데이터베이스에 접속하기 위한 라이브러리 정보와 서버 주소/포트/SID 정보
    String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    
    // 오라클 데이터베이스에 접속할 수 있는 계정 이름
    String USER = "scott";
    
    // 오라클 데이터베이스에 접속할 때 사용할 비밀번호
    String PASSWORD = "tiger";

}
