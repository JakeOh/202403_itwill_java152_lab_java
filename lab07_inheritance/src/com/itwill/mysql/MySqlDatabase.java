package com.itwill.mysql;

import com.itwill.database.Database;

public class MySqlDatabase implements Database {
    
    @Override
    public int select() {
        System.out.println(">>> MySQL 테이블 검색");
        return 1;
    }
    
    @Override
    public int insert() {
        System.out.println(">>> MySQL 테이블 자료 추가");
        return 1;
    }

}
