package com.itwill.file06;

import java.io.Serializable;

public class Score implements Serializable {
    private int java;
    private int web;
    private int spring;
    
    public Score() {}

    public Score(int java, int web, int spring) {
        this.java = java;
        this.web = web;
        this.spring = spring;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getWeb() {
        return web;
    }

    public void setWeb(int web) {
        this.web = web;
    }

    public int getSpring() {
        return spring;
    }

    public void setSpring(int spring) {
        this.spring = spring;
    }

    @Override
    public String toString() {
        return "Score [java=" + java + ", web=" + web + ", spring=" + spring + "]";
    }
    
}
