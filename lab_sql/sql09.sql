/*
 * DDL(Data Definition Language): create, alter, truncate, drop
 * DML(Data Manipulation Language): insert, update, delete
 */

-- create table ... as select ...
-- 테이블 모양(컬럼 이름, 데이터 타입)과 데이터를 복사
-- emp 테이블을 ex_emp6으로 복사:
create table ex_emp6
as select * from emp;

select * from ex_emp6;

-- emp 테이블의 모양과 똑같은 테이블을 생성, 데이터(행)는 복사하지 않음.
create table ex_emp7
as select * from emp where empno = -1;

select * from ex_emp7;

-- truncate table: 테이블의 모든 행을 삭제하는 DDL
select * from ex_emp6;
truncate table ex_emp6;

-- drop table: 테이블을 삭제하는 DDL
drop table ex_emp7;


-- DML
-- insert into 테이블 (컬럼, ...) values (값, ...);
----> 테이블에 1개 행을 삽입(insert)
-- insert into 테이블 (컬럼, ...) select ...;
----> select 결과만큼 여러개의 행(들)을 삽입(insert)
select * from ex_emp6;

-- emp 테이블에서 부서번호가 10번인 행들을 ex_emp6에 삽입:
insert into ex_emp6
select * from emp where deptno = 10;

commit;
