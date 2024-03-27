package com.itwill.modifier03;

public class Member {
    // field
    private String memberId; // 읽기 전용 필드
    private String memberPassword; // 읽기/쓰기 필드

    // constructor
    public Member(String memberId, String memberPassword) {
        if (memberId != null && memberPassword != null) {
            this.memberId = memberId;
            this.memberPassword = memberPassword;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // method
    // getter 메서드
    public String getMemberId() {
        return this.memberId;
    }

    public String getMemberPassword() {
        return this.memberPassword;
    }

    // setter 메서드
    public void setMemberPassword(String password) {
        if (password != null) {
            this.memberPassword = password;
        }
    }

}
