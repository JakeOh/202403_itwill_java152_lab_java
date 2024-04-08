package com.itwill.set03;

import java.util.Objects;

public class Score {
    private int java;
    private int sql;
    private int html;
    
    public Score() {}
    
    public Score(int java, int sql, int html) {
        this.java = java;
        this.sql = sql;
        this.html = html;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getSql() {
        return sql;
    }

    public void setSql(int sql) {
        this.sql = sql;
    }

    public int getHtml() {
        return html;
    }

    public void setHtml(int html) {
        this.html = html;
    }

    @Override
    public String toString() {
        return "Score(java=" + java
                + ", sql=" + sql
                + ", html=" + html
                + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this != null && obj instanceof Score) {
            Score other = (Score) obj;
            result = (this.java == other.java) &&
                    (this.sql == other.sql) &&
                    (this.html == other.html);
        }
        
        return result;
    }
    
    @Override
    public int hashCode() {
//        return java + sql + html;
        return Objects.hash(java, sql, html);
    }
    
}
