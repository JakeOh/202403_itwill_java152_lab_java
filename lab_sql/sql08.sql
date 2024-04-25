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
alter table students drop column department;
describe students;


-- 수정(modify); 컬럼 정의(데이터 타입, 기본값, null 여부)를 수정.
-- students 테이블의 stuname 컬럼의 데이터 타입을 
-- varchar2(4 char)에서 varchar2(40 char)로 변경 & NN 추가.
alter table students modify stuname varchar2(40 char) not null;
describe students;

-- modify는 제약조건의 내용을 변경하지 못함.
-- 제약조건 삭제(alter table ... drop constraint ...) 
--> 제약조건 추가(alter table ... add constraint ...)
