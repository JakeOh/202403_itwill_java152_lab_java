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

-- 직원 테이블에서 업무가 'CLERK'인  직원들의
-- 업무, 이름, 급여를 출력. 정렬 순서: 이름.
select job, ename, sal
from emp
where job = 'CLERK'
order by ename;
--> SQL에서는 문자열을 비교할 때 =, != 연산자를 사용.
--> SQL에서 문자열을 작은따옴표('')를 사용. 대/소문자를 구분.

-- 직원 테이블에서 업무가 'CLERK' 또는 'MANAGER'인  직원들의
-- 업무, 이름, 급여를 검색. 정렬 순서: (1) 업무, (2) 급여.
select job, ename, sal
from emp
where job = 'CLERK' or job = 'MANAGER'
order by job, sal;
--> where job = 'CLERK' or 'MANAGER' (X)

select job, ename, sal
from emp
where job in ('CLERK', 'MANAGER')
order by job, sal;

-- 직원 테이블에서 20번 부서에서 근무하는 CLERK의 
-- 모든 정보(컬럼)을 검색.
select * from emp
where deptno = 20 and job = 'CLERK';

-- 직원 테이블에서 CLERK, ANALYST, MANAGER가 아닌  직원들의
-- 사번, 이름, 업무, 급여를 검색. 정렬 순서: 사번.
select empno, ename, job, sal
from emp
where job != 'CLERK' and job != 'ANALYST' and job != 'MANAGER'
order by empno;

select empno, ename, job, sal
from emp
where job not in ('CLERK', 'ANALYST', 'MANAGER')
order by empno;

-- 숫자 타입 뿐만 아니라, 문자열과 날짜 타입도 대소비교가 가능.
-- (예) 'a' < 'b', 2024/04/21 < 2024/04/22

-- '1987/01/01' 이후에 입사한 직원들의 모든 정보(컬럼)을 출력.
-- 정렬 순서: 입사일 오름차순.
select * from emp
where hiredate > '1987/01/01'
order by hiredate;
--> 암묵적(자동) 타입 변환:
-- 오라클은 hiredate 컬럼(date 타입)과 문자열 '1987/01/01'의 크기를 비교할 때
-- 날짜 타입을 문자열로 변환한 후 문자열의 크기 비교를 수행함.

select * from emp
where hiredate > to_date('1987/01/01')
order by hiredate;
--> 명시적 타입 변환:
-- to_date('문자열'): '문자열'을 날짜(date) 타입으로 변환.


-- like 검색: 특정 문자열로 시작하거나, 특정 문자열이 포함된 값을 찾는 검색.
-- 이름이 'A'로 시작하는 직원들의 모든 정보:
select * from emp
where ename like 'A%';

-- like 검색에서 사용하는 wildcard:
-- (1) %: 글자 수 제한 없음.
-- (2) _(underscore, 밑줄): 밑줄이 있는 자리에 어떤 문자가 있어도 됨.
select * from emp
where job like '_LERK';

-- 이름에 'A'가 포함된 직원들의 모든 정보:
select * from emp
where ename like '%A%';

-- 30번 부서에 근무하고, 업무이름에 'SALES'가 포함되어 있는 직원들의
-- 사번, 부서번호, 이름, 업무, 급여, 수당을 출력. 사번 오름차순 정렬.
select empno, deptno, ename, job, sal, comm
from emp
where deptno = 30 and job like '%SALES%'
order by empno;
