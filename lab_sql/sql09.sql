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

-- emp 테이블에서 수당(comm)이 null 아닌 행들을 bonus 테이블에 삽입:
insert into bonus
select ename, job, sal, comm from emp where comm is not null;

select * from bonus;

commit;


-- update 문: 테이블 데이터 업데이트(수정)
-- update 테이블 set 변수 = 값, ... where 조건식;
select * from emp;

-- emp 테이블에서 사번이 1004인 직원의 급여를 6000으로 변경:
update emp set sal = 6000 where empno = 1004;

-- where 조건식이 없으면 update 문장은 테이블의 모든 행의 값을 업데이트함.
commit; -- 현재까지 모든 변경 내용을 영구 저장.

update emp set sal = 6000;
select * from emp;

rollback; -- 직전의 commit 상태로 되돌림.
select * from emp;

-- 사번이 1004인 직원의 업무를 'MANAGER', 입사날짜를 '2024/04/25'로 변경
update emp
set job = 'MANAGER', hiredate = '2024/04/25'
where empno = 1004;

select * from emp where empno = 1004;

-- 'ACCOUNTING' 부서에서 일하는 직원들의 급여를 10% 인상:

-- salgrade가 1인 직원들의 급여를 25% 인상:


