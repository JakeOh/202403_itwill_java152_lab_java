package com.itwill.swing08;

public class Score {
    private int korean;
    private int english;
    private int math;
    
    public Score() {}

    public Score(int korean, int english, int math) {
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getTotal() {
        return korean + english + math;
    }
    
    public double getMean() {
        return (double) getTotal() / 3;
    }
    
    @Override
    public String toString() {
        return "Score [korean=" + korean + ", english=" + english + ", math=" + math + "]";
    }

}
