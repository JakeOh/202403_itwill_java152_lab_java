package com.itwill.ver03;

import java.util.List;

import com.itwill.ver01.Contact; // Model

// Controller 인터페이스
public interface ContactDao {
    
    /**
     * 새로운 연락처 정보(이름, 전화번호, 이메일)을 리스트에 저장.
     * 
     * @param 리스트에 저장할 Contact 타입 객체.
     * @return 리스트에 연락처 정보를 저장했으면 1, 저장 실패하면 0.
     */
    int create(Contact contact);
    
    /**
     * 연락처 전체 목록 검색. 모든 연락처 정보가 저장된 리스트를 리턴.
     * 
     * @return Contact 타입을 저장하는 리스트.
     */
    List<Contact> read();
    
    /**
     * 인덱스를 사용한 연락처 정보 검색 기능.
     * 
     * @param index 리스트에서 연락처 정보를 검색할 인덱스. 0 이상의 정수(int).
     * @return 아규먼트 index가 리스트의 인덱스 범위 안에 있으면 Contact 타입 객체를 리턴.
     * index가 리스트 범위 밖에 있거나, 해당 인덱스의 리스트 원소가 null이면 null을 리턴.
     */
    Contact read(int index);
    
    /**
     * 연락처 정보 업데이트 기능.
     * 리스트의 특정 인덱스의 연락처 정보(이름, 전화번호, 이메일)을 업데이트.
     * 
     * @param index 수정할 연락처의 리스트 인덱스. 0 이상의 정수.
     * @param contact 업데이트할 이름, 전화번호, 이메일을 저장하고 있는 Contact 타입 객체.
     * @return 업데이트 성공하면 1, 실패하면 0.
     */
    int update(int index, Contact contact);
    
    /**
     * 연락처 삭제 기능.
     * @param index 리스트에서 삭제할 연락처의 인덱스. 0 이상의 정수.
     * @return 삭제 성공하면 1, 실패하면 0.
     */
    int delete(int index);

}
