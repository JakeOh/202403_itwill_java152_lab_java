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

/*
 * 테이블을 생성할 때 제약조건(constraint) 만들기:
 * (1) primary key(PK, 고유키)
 * (2) not null(NN)
 * (3) unique
 * (4) check
 * (5) foreign key(FK, 외래키)
 */

-- 테이블 생성할 때 제약조건 만들기 1: 제약조건 이름 설정하지 않기.
create table ex_emp1 (
    eno     number(4) primary key, -- 사번. 고유키.
    ename   varchar2(10) not null, -- 이름.
    email   varchar2(100) unique, -- 이메일
    age     number(3) check (age >= 0),
    memo    varchar2(1000)
);

insert into ex_emp1
values (1001, '홍길동', 'hdg@itiwll.com', 16, '안녕하세요');

insert into ex_emp1 (eno, ename) values (1002, '허균');
--> 성공
insert into ex_emp1 (eno, ename) values (1002, 'abc');
--> 실패: PK 제약조건 위배

insert into ex_emp1 (eno) values (1003);
--> NN 제약조건 위배

insert into ex_emp1 (eno, ename, email)
values (1003, 'John Doe', 'hdg@itwill.com');

insert into ex_emp1 (eno, ename, email)
values (1004, 'John Doe', 'hdg@itwill.com');
--> unique 제약조건 위배

insert into ex_emp1 (eno, ename, age)
values (1005, 'Scott', -1);
--> check (age >= 0) 제약 조건 위배

select * from ex_emp1;
commit;

-- 제약조건 만들기 2: 제약조건 이름 설정
create table ex_emp2 (
    id      number(4) 
            constraint ex_emp2_pk_id primary key,
    ename   varchar2(10)
            constraint ex_emp2_nn_ename not null,
    email   varchar2(100) 
            constraint ex_emp2_uq_email unique,
    age     number(3) 
            constraint ex_emp2_ck_age check (age >= 0),
    memo    varchar2(1000)
);

insert into ex_emp2 (id, ename) values (1, '홍길동');

insert into ex_emp2 (id, ename) values (1, '오쌤'); --> PK 위배

select * from ex_emp2;
commit;

-- 제약조건 만들기 3: 컬럼 정의(데이터 타입 선언) 따로, 제약조건 정의 따로.
create table ex_emp3 (
    -- 컬럼 정의: 컬럼 이름 & 데이터 타입
    id      number(4),
    ename   varchar2(10),
    email   varchar2(100),
    age     number(3),
    memo    varchar2(1000),
    -- 제약 조건 정의
    constraint ex_emp3_pk_id primary key (id),
    constraint ex_emp3_nn_ename check (ename is not null), -- 주의!
    constraint ex_emp3_uq_email unique (email),
    constraint ex_emp3_ck_age check (age >= 0)
);

insert into ex_emp3 (id) values (1234);
--> check(not null) 위배

-- FK(Foreign Key, 외래키): 다른 테이블의 PK를 참조하는 제약조건.
-- 데이터를 insert할 때, 다른 테이블의 PK에 없는 값이 삽입되지 않도록.
-- 테이블을 만들 때 FK를 설정하려면, PK가 설정된 다른 테이블이 먼저 생성되어 있어야 함.

create table ex_dept (
    deptno  number(2)
            constraint ex_dept_pk_deptno primary key,
    dname   varchar(10)
            constraint ex_dept_nn_dname not null
);

create table ex_emp4 (
    empno   number(4)
            constraint ex_emp4_pk_empno primary key,
    ename   varchar2(10)
            constraint ex_emp4_nn_ename not null,
    deptno  number(2)
            constraint ex_emp4_fk_deptno references ex_dept (deptno)
);

insert into ex_emp4 values (1200, '오쌤', 10);
--> 10번 부서가 ex_dept 테이블에 없는 경우에는 insert 실패! FK 위배.
--> 10번 부서가 ex_dept 테이블에 있는 경우에는 insert 성공!

insert into ex_dept values(10, '개발1팀');

insert into ex_emp4 (empno, ename) values (1300, '홍길동');
--> FK 제약조건이 있는 컬럼에는 null 삽입될 수도 있음.

insert into ex_emp4 values (1400, 'Jake', 10);
--> FK 제약조건이 있는 컬럼에는 중복된 값이 삽입될 수도 있음.

select * from ex_dept;
select * from ex_emp4;

-- 컬럼 정의 따로, FK 제약조건 설정 따로
create table ex_emp5 (
    -- 컬럼 정의:
    empno   number(4),
    ename   varchar2(10),
    deptno  number(2),
    -- 제약조건 정의:
    constraint ex_emp5_pk_empno primary key (empno),
    constraint ex_emp5_nn_ename check (ename is not null),
    constraint ex_emp5_fk_deptno foreign key (deptno) 
            references ex_dept (deptno)
);


-- 오라클은 테이블들을 관리하기 위한 테이블을 가지고 있음.
select * from user_tables;
select table_name from user_tables;

-- 오라클은 제약조건들을 관리하기 위한 테이블을 가지고 있음.
select * from user_constraints;
select constraint_name from user_constraints;
