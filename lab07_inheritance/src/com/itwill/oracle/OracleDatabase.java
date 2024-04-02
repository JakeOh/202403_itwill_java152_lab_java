package com.itwill.oracle;

import com.itwill.database.Database;

public class OracleDatabase implements Database {
    
    @Override
    public int select() {
        System.out.println("Oracle 테이블 검색");
        return 0;
    }
    
    @Override
    public int insert() {
        System.out.println("Oracle 테이블 데이터 추가");
        return 0;
    }

}
