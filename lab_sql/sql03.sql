/*
 * 조건 검색 where
 *
 * 테이블에서 데이터 검색:
 * (1) projection: 테이블에서 원하는 컬럼(들)을 선택.
 * (2) selection: 테이블에서 조건을 만족하는 행(들)을 검색.
 *
 * 문법: select 컬럼, ... from 테이블 where 조건식 order by 컬럼, ...;
 * 조건식에서 사용되는 연산자들:
 *   (1) 비교 연산자: =, !=, >, >=, <, <=, is null, is not null, ...
 *   (2) 논리 연산자: and, or, not
 */

-- 직원 테이블에서 10번 부서에서 근무하는 직원들의 부서번호, 사번, 이름 출력.
-- 사번 오름차순 정렬.
select deptno, empno, ename
from emp
where deptno = 10
order by empno;

-- 직원 테이블에서 수당(comm)이 null이 아닌 직원들의
-- 사번, 부서번호, 이름, 급여, 수당을 출력. 사번 오름차순 정렬.
select empno, deptno, ename, sal, comm
from emp
where comm is not null
order by empno;
--> SQL에서 null 여부 비교를 할 때는 =, != 사용할 수 안됨!
--> SQL에서 null 여부 비교를 할 때는 반드시 is null, is not null을 사용!

-- 직원 테이블에서 급여가 2000 이상인 직원들의 이름, 업무, 급여를 출력.
-- 급여 내림차순 정렬.
select ename, job, sal
from emp
where sal >= 2000
order by sal desc;

-- 직원 테이블에서 급여가 2000 이상 3000 이하인 직원들의
-- 이름, 업무, 급여를 검색. 급여 내림차순 정렬.
select ename, job, sal
from emp
where sal >= 2000 and sal <= 3000
order by sal desc;
--> where 2000 <= sal <= 3000 (X)
--> 논리 연산자로 & 또는 &&를 사용할 수 없음.

select ename, job, sal
from emp
where sal between 2000 and 3000
order by sal desc;

-- 직원 테이블에서 10번 또는 20번 부서에서 근무하는 직원들의
-- 부서번호, 이름, 급여를 검색. 부서번호 오름차순.
select deptno, ename, sal
from emp
where deptno = 10 or deptno = 20
order by deptno;
--> where deptno = 10 or 20 (X)

select deptno, ename, sal
from emp
where deptno in (10, 20)
order by deptno;