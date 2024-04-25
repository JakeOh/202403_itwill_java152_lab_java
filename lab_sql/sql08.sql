/*
 * alter table: 테이블 변경
 * (1) 이름 변경: alter table ... rename ... to ...
 * (2) 추가: alter table ... add ...
 * (3) 삭제: alter table ... drop ...
 * (4) 수정: alter table ... modify ...
 */

-- 1. 이름 변경:
-- (1) 테이블 이름 변경
select table_name from user_tables; -- 접속 계정의 테이블 이름
-- ex_students 테이블을 students로 이름 변경
alter table ex_students rename to students;

-- (2) 테이블 컬럼 이름 변경
describe students; -- 오라클의 테이블 설명 명령어.
-- stuno 컬럼을 stuid로 이름 변경:
alter table students rename column stuno to stuid;

-- (3) 제약조건 이름 변경
select constraint_name from user_constraints;
-- 제약조건 ex_emp4_fk_deptno을 emp4_fk로 이름 변경
alter table ex_emp4 rename constraint ex_emp4_fk_deptno to emp4_fk;


-- 추가(add)
-- (1) 제약조건 추가
describe students;
-- students 테이블의 stuid 컬럼을 PK로 설정
alter table students add constraint students_pk primary key (stuid);

-- (2) 컬럼 추가
alter table students add department number(2);


-- 삭제(drop)
-- (1) 제약조건 삭제
alter table students drop constraint students_pk;

-- (2) 컬럼 삭제

