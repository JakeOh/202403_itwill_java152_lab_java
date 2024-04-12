package com.itwill.lambda01;

public class Calculator {
    
    // 함수형 인터페이스: 추상 메서드를 오직 1개만 갖는 인터페이스.
    @FunctionalInterface
    public interface Calculable {
        double calculate(double x, double y);
    }
    
    private double x;
    private double y;
    
    public Calculator(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double calculate(Calculable calc) {
        return calc.calculate(x, y);
    }

}
