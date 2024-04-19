/*
 * 블록 주석
 */
-- 한 줄 주석(comment)
-- SQL 키워드(명령어)는 대소문자를 구분하지 않음.
-- SQL 문장은 세미콜론으로 끝남.
-- 단축키 Ctrl+Enter: 
-- (1) 현재 커서가 있는 위치의 한 문장을 실행.
-- (2) 드래그로 선택한 부분(문장)을 실행.
-- 단축키 F5: 스크립트(파일) 전체 실행.
select sysdate from dual;

-- bonus 테이블의 모든 레코드를 검색:
select * from bonus;

-- dept 테이블에서 모든 레코드를 검색:
select * from dept;

-- SQL 문장에서 키워드(select, from, ...), 테이블/컬럼 이름은 대/소문자를 구분하지 않음.
-- 테이블에 저장되는 문자열은 대/소문자를 구분함.
SELECT * FROM DEPT;
SELECT * FROM dept;
select * from DEPT;
