/*
 * SQL 종류:
 * 1. DQL(Data Query Language): select
 * 2. DML(Data Manipulation Language): insert, update, delete
 * 3. DDL(Data Definition Language): create, alter, truncate, drop
 * 4. TCL(Transaction Control Language): commit, rollback
 *    - commit: 데이터베이스 테이블의 변경 내용을 영구 저장.
 *    - rollback: 직전의 commit 상태로 되돌리기.
 *
 * 테이블 생성:
 * create table 테이블이름 (
 *    컬럼이름 데이터타입 [제약조건 기본값],
 *    ...
 * );
 *
 * 컬럼의 데이터 타입으로 사용되는 키워드 데이터베이스 종류에 따라서 다름.
 * 오라클 데이터 타입: number, varchar2, date, timestamp, clob, blob, ...
 */

/*
 * 테이블 이름: ex_students
 * 컬럼:
 *   - stuno: 학생 번호(학번). 숫자(6자리)
 *   - stuname: 학생 이름. 문자열(4글자)
 *   - birthday: 생일. 날짜
 */
create table ex_students (
    stuno       number(6),
    stuname     varchar2(4 char),
    birthday    date
);

/*
 * 테이블에 행 추가(insert, 삽입):
 * insert into 테이블 (컬럼, ...) values (값, ...);
 * 
 * 테이블에 삽입하는 값의 개수가 컬럼의 개수와 같고, 
 * 값들의 순서가 테이블 생성시 컬럼 순서와 같으면
 * insert into 테이블 values (값, ...);
 */
select * from ex_students;

insert into ex_students 
values (241001, '홍길동', '2000/12/31');

insert into ex_students (stuno, stuname)
values (241002, '오쌤');




 
 
 
 
 
 
 
 
 
 