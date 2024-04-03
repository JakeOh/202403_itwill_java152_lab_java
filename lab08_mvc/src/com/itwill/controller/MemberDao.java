package com.itwill.controller;

import com.itwill.model.Member;

// MVC 아키텍쳐에서 컨트롤러 역할을 담당할 인터페이스.
// DAO(Data Access Object)
public interface MemberDao {
    
    int MAX_LENGTH = 3; // 배열의 최대 길이

    /**
     * 새로운 회원 정보를 배열에 저장.
     * @param member 배열에 저장할 Member 타입 객체.
     * @return 배열에 회원 정보를 저장 성공하면 1, 저장 실패하면 0.
     */
    int create(Member member);
    
    /**
     * 회원 전체 목록 검색. 회원 정보가 저장된 배열을 리턴.
     * @return 회원 정보를 저장하고 있는 배열(Member[]).
     */
    Member[] read();
    
    /**
     * 인덱스를 사용한 회원 정보 검색. 회원 배열의 특정 인덱스에 있는 회원 정보를 리턴.
     * @param index 검색에 필요한 인덱스. 0 이상의 정수.
     * @return 아규먼트 index가 회원 배열의 인덱스 범위 안에 있으면, Member 타입 객체를 리턴.
     * 아규먼트 index가 배열 범위 밖이면, null을 리턴.
     */
    Member read(int index);
    
    /**
     * 회원 정보 업데이트 기능. 회원 배열의 특정 인덱스에 있는 회원 정보 중에서 비밀번호를 변경.
     * @param index 회원 배열에서 수정할 회원 정보의 위치(인덱스). 0 이상의 정수.
     * @param password 변경할 새 비밀번호.
     * @return 업데이트 성공하면 1, 실패하면 0.
     */
    int update(int index, String password);
    
}
