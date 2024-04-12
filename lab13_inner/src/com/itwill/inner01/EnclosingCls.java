package com.itwill.inner01;

public class EnclosingCls {
    public static int var = 1; // static field
    private int x; // instance field
    
    public EnclosingCls(int x) {
        this.x = x;
    }
    
    // static method
    public static void test() {
        System.out.println("var = " + var);
//        System.out.println(x); //-> 컴파일 에러
    }
    
    @Override
    public String toString() {
        return String.format("EnclosingCls(x=%d, var=%d)", x, var);
        //-> 인스턴스 메서드는 static 필드를 사용할 수 있음.
    }
    
    // static 내부 클래스(중첩 클래스)
    public static class NestedCls {
        private int x;
        
        public NestedCls(int x) {
            this.x = x;
        }
        
        public void info() {
            System.out.println("--- NestedCls ---");
            System.out.println("x = " + x); // 중첩 클래스의 필드
            System.out.println("var = " + var); // 외부 클래스의 static 필드
//            System.out.println(EnclosingCls.this.x); //-> 컴파일 에러
            //-> static 내부 클래스(중첩 클래스)에서는
            // 외부 클래스의 static 멤버만 사용 가능하고,
            // 외부 클래스의 non-static 멤버들은 사용할 수 없음!
        }
    } // end class NestedCls

} // end class EnclosingCls
