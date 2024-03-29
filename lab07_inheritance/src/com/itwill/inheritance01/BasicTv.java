package com.itwill.inheritance01;

public class BasicTv {
    // 상수 정의:
    public static final int MIN_CHANNEL = 0;
    public static final int MAX_CHANNEL = 2;
    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 2;
    
    // 필드
    private boolean powerOn; // 전원 상태(true->ON, false->OFF)
    private int channel; // 현재 채널 번호
    private int volume; // 음량
    
    // 생성자
    public BasicTv() {}
    
    public BasicTv(boolean powerOn, int channel, int volume) {
        this.powerOn = powerOn;
        this.channel = channel;
        this.volume = volume;
    }

    // getters and setters
    public boolean isPowerOn() {
        return powerOn;
    }

    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    // 메서드
    /**
     * TV가 켜져 있으면 끄고, TV가 꺼져 있는 켬.
     * powerOn의 값이 true이면 false 변경, powerOn의 값이 false이면 true로 변경.
     * @return powerOn의 값.
     */
    public boolean powerOnOff() {
        return false;
    }
    
    /**
     * channelUp. 현재 채널의 값을 1 증가.
     * 만약 현재 채널 값이 채널의 최댓값(MAX_CHANNEL)인 경우, 채널의 최솟값(MIN_CHANNEL)으로 변경.
     * @return 바뀐 현재 채널 값.
     */
    
    /**
     * channelDown. 현재 채널의 값을 1 감소.
     * 만약 현재 채널 값이 채널의 최솟값(MIN_CHANNEL)인 경우, 채널의 최댓값(MAX_CHANNEL)으로 변경.
     * @return 바뀐 현재 채널 값.
     */
    
    /**
     * volumeUp. 현재 음량의 값을 1 증가.
     * 만약 현재 음량 값이 음량의 최댓값(MAX_VOLUME)인 경우, 음량을 변경하지 않음.
     * @return 바뀐 현재 음량 값.
     */
    
    /**
     * volumeDown. 현재 음량의 값을 1 감소.
     * 만약 현재 음량 값이 음량의 최솟값(MIN_VOLUME)인 경우, 음량을 변경하지 않음.
     * @return 바뀐 현재 음량 값.
     */
    
}
