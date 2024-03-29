package com.itwill.inheritance01;

public class InheirtanceMain01 {

    public static void main(String[] args) {
        // BasicTv 타입 객체 생성
        BasicTv tv1 = new BasicTv();
        tv1.powerOnOff();
        
        tv1.channelUp();
        tv1.channelUp();
        tv1.channelUp();
        tv1.channelUp();
        tv1.channelDown();
        tv1.channelDown();
        tv1.channelDown();
        
        tv1.volumeUp();
        tv1.volumeUp();
        tv1.volumeUp();
        tv1.volumeUp();
        tv1.volumeDown();
        tv1.volumeDown();
        tv1.volumeDown();
        
        tv1.powerOnOff();

        // SmartTv 타입 객체 생성
        SmartTv tv2 = new SmartTv();
        tv2.powerOnOff(); // 상위클래스에서 상속받은 메서드를 호출.
        tv2.webBrowsing();
        
    }

}
