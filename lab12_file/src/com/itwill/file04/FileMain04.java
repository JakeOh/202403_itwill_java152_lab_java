package com.itwill.file04;

/*
 * 프로그램 ==> ObjectOutputStream ==> FileOutputStream ==> 파일
 * OOS.writeObject(): 자바 객체를 파일에 쓸 수 있는 형태로 변환(직렬화, serialize).
 * 
 * 프로그램 <== ObjectInputStream <== FileInputStream <== 파일
 * OIS.readObject(): 파일에서 읽은 데이터를 자바 객체로 변환(역직렬화, de-serialize).
 * 
 * (주의) OIS, OOS에서 읽고 쓰려는 자바 클래스는 반드시 Serializable 인터페이스를 구현해야 함!
 */

public class FileMain04 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
