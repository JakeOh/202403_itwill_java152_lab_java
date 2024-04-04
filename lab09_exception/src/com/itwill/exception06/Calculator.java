package com.itwill.exception06;

public class Calculator {

    public int divide(int x, int y) throws Exception {
        if (y != 0) {
            return x / y;
        }
        
        throw new Exception("y는 0이 될 수 없음.");
    }
    
}
