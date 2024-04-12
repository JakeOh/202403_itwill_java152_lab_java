package com.itwill.lambda01;

import com.itwill.lambda01.Calculator.Calculable;

public class Adder implements Calculable {

    @Override
    public double calculate(double x, double y) {
        return x + y;
    }
    
}
