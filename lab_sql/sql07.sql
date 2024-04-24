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

insert into ex_students values ('abcd', 1, sysdate);
--> 실행 중 오류: 'abcd' 문자열은 학번(숫자 타입)이 될 수 없기 때문.

insert into ex_students values (1, 'abcd');
--> 실행 중 오류: 테이블의 컬럼 개수와 values의 값들의 개수가 다르기 때문.

insert into ex_students (stuname, stuno, birthday)
values ('abcd', 1, sysdate);
--> 테이블 이름 뒤에 컬럼 이름을 쓰는 경우, 테이블의 컬럼 순서를 지킬 필요는 없음.
-- 컬럼 순서와 values의 순서를 맞춰주면 됨.
 
insert into ex_students (stuno) values (1234567);
--> 실행 중 오류: stuno 컬럼의 숫자 자리수보다 큰 값이기 때문에.

insert into ex_students (stuname) values ('가나다라마');
--> 실행 중 오류: stuname 컬럼은 최대 4글자(char)까지만 저장할 수 있기 때문에.

commit; --> 현재까지의 insert 내용을 DB 테이블에 영구 저장.

-- 한글 vs 영문자 byte 비교
create table ex_test_byte (
    ctest varchar2(4 byte)
);

insert into ex_test_byte values ('abcd'); --> 성공
insert into ex_test_byte values ('한글'); --> 실패
-- 오라클에서 문자열 저장할 때 인코딩: UTF-8
-- UTF-8일 때, 영문자/숫자/특수기호 1byte, 한글 3byte.

-- 테이블을 생성할 때 컬럼에 기본값 설정하기:
create table ex_test_default (
    tno     number(4),
    tdate   date default sysdate
);

insert into ex_test_default values (1, '2024-03-14');
insert into ex_test_default (tdate) values ('2024-03-15');
--> tno에는 null이 삽입됨.
insert into ex_test_default (tno) values (1234);
--> tdate에는 null 대신 기본값 sysdate(현재 시간)가 삽입됨.

select * from ex_test_default;
commit;