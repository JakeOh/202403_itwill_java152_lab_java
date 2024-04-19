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
