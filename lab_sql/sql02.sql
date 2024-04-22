/*
 * 기본 Query 문장:
 * select 컬럼이름, ... from 테이블이름;
 * 테이블에서 모든 컬럼을 검색:
 * select * from 테이블이름;
 */

-- emp: 직원 테이블, dept: 부서 테이블
-- 직원 테이블에서 사번(empno)과 직원 이름(ename)을 검색:
select empno, ename from emp;
select ename, empno from emp;

-- 직원 테이블에서 모든 컬럼을 검색:
select * from emp;
select empno, ename, job, mgr, hiredate, sal, comm, deptno
from emp;

-- 컬럼 이름에 별명(alias) 주기: as "별명"
-- 별명에 공백이 없는 경우(한 단어인 경우)에는 큰따옴표를 생략 가능.
-- 별명이 공백을 포함하는 경우 큰따옴표를 반드시 사용.
-- 별명에는 큰따옴표("")만 사용. 작은따옴표는 사용할 수 없음!
-- (주의) SQL에서 문자열은 작은따옴표로 표시: 'SCOTT'
-- 부서 테이블에서 부서번호, 부서이름을 검색:
select deptno as "부서 번호", dname as "부서 이름"
from dept;

select deptno as "부서 번호", dname
from dept;

-- 연결 연산자(||): 2개 이상의 컬럼(또는 문자열)을 합쳐서 하나의 컬럼으로 출력.
-- '부서번호-부서이름' 형식의 문자열을 "부서"라는 컬럼으로 출력:
select deptno || '-' || dname as "부서"
from dept;

-- 부서 테이블을 검색해서 'A부서는 B에 있습니다.' 형식으로 출력:
select dname || '부서는 ' || loc || '에 있습니다.' as "부서 정보"
from dept;

-- 직원 테이블을 검색해서 'A의 급여는 B' 형식으로 출력:
select ename || '의 급여는 ' || sal as "직원 급여"
from emp;

-- 검색 결과를 정렬해서 출력:
-- select 컬럼, ... from 테이블 order by 컬럼 [asc/desc];
-- asc: 오름차순 정렬(ascending order). 기본값. asc 생략 가능.
-- desc: 내림차순 정렬(descending order).

-- 부서 테이블에서 부서 이름을 오름차순 정렬 출력
select deptno, dname from dept order by dname;

-- 부서 테이블에서 부서 이름을 내림차순 정렬 출력
select deptno, dname from dept order by dname desc;

-- 1. 직원 테이블에서 사번, 이름, 급여를 검색. 사번 오름차순 정렬.
select empno, ename, sal
from emp
order by empno;

-- 2. 직원 테이블에서 사번, 이름, 급여를 검색. 급여 내림차순 정렬.
select empno, ename, sal from emp order by sal desc;

-- 3. 직원 테이블에서 부서번호, 사번, 이름을 검색.
-- 정렬 순서: (1) 부서번호 오름차순, (2) 사번 오름차순
select deptno, empno, ename
from emp
order by deptno, empno;

-- 4. 직원 테이블에서 부서번호, 사번, 이름, 급여를 검색.
-- 정렬 순서: (1) 부서번호 오름차순, (2) 급여 내림차순
select deptno, empno, ename, sal
from emp
order by deptno, sal desc;


-- 중복되지 않는 결과 출력:
select job from emp; --> 14개 행(record)
select distinct job from emp; --> 5개 행
select distinct job from emp order by job;

-- 중복되지 않는 부서번호, 업무 출력. (1)부서번호 오름차순, (2) 업무 오름차순.
select distinct deptno, job
from emp
order by deptno, job;
