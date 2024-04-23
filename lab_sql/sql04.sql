/*
 * 오라클 함수(function)
 * 1. 단일 행 함수:
 *    행(row)이 하나씩 함수의 아규먼트로 전달되고, 
 *    행 마다 하나씩 결과가 리턴되는 함수.
 *    (예) to_date, to_char, lower, upper, ...
 * 2. 다중 행 함수:
 *    여러개의 행들이 함수의 아규먼트로 전달되고, 하나의 결과가 리턴되는 함수.
 *    (예) 통계 관련 함수: count, sum, avg, max, min, variance(분산), stddev(표준편차)
 */

-- 단일 행 함수 예 - 모든 행의 문자열을 소문자로 바꾸기.
select ename, lower(ename), job, lower(job)
from emp;

-- to_char(...): 다른 타입의 값을 문자열로 변환. (예) 날짜 -> 문자열
select hiredate, to_char(hiredate, 'YYYY/MM/DD'), 
    to_char(hiredate, 'MM-DD-YYYY')
from emp;

-- nvl(변수, 값): 변수가 null이면 값을 리턴하고, null 아니면 원래 값을 리턴.
-- nvl2(변수, 값1, 값2): 변수가 null이 아니면 값1을 리턴하고,
-- 변수가 null이면 값2를 리턴.
select comm, nvl(comm, 0), nvl2(comm, comm, 0), nvl2(comm, 'T', 'F')
from emp;

-- 이름이 (대/소문자 구분없이) 'a'로 시작하는 직원들의 이름
-- ALLEN, Allen, allen
select ename from emp
where lower(ename) like 'a%';

-- 사번, 이름, 급여, 수당, 연봉을 검색.
-- 연봉 = 급여 * 12 + 수당.
select empno, ename, sal, comm, sal * 12 + nvl(comm, 0) as "연봉"
from emp;


-- 다중 행 함수 예:
-- count(컬럼): null이 아닌 행의 개수를 리턴.
select count(empno), count(mgr), count(comm)
from emp;

-- 테이블의 행의 개수
select count(*) from emp;

-- 통계 함수: 합계, 평균, 최댓값, 최솟값, 분산, 표준편차
select sum(sal), avg(sal), max(sal), min(sal), variance(sal), stddev(sal)
from emp;

select sum(comm), avg(comm) from emp;
--> 모든 통계 함수들은 null을 제외하고 계산을 함.

-- 단일 행 함수와 다중 행 함수는 함께 사용할 수 없음.
-- select sal, sum(sal) from emp;
-- select nvl(comm, 0), sum(comm) from emp;

/*
 * 그룹별 쿼리(query):
 * (예) 부서별 직원수, 부서별 급여 평균, ...
 * (문법)
 * select 컬럼, 함수호출, ...
 * from 테이블
 * where 조건식(1)
 * group by 컬럼(그룹을 묶을 수 있는 변수)
 * having 조건식(2)
 * order by 컬럼(정렬 기준), ...;
 *
 * 조건식(1): 그룹으로 묶기 전에 행들을 선택할 조건.
 * 조건식(2): 그룹으로 묶은 후에 행들을 선택할 조건.
 */

-- 부서별 급여 평균
select deptno, round(avg(sal), 2) as AVG_SAL
from emp
group by deptno
order by deptno;

-- 부서별 급여 평균, 표준편차
select deptno, round(avg(sal), 2) as AVG_SAL,
    round(stddev(sal), 2) as STD_SAL
from emp
group by deptno
order by deptno;

-- 모든 문제에서 소수점은 반올림해서 소수점 이하 2자리까지 표시.
-- Ex. 업무별 업무, 직원수, 급여 최댓값, 최솟값, 평균을 업무 오름차순으로 출력.
select job, count(job) AS COUNT, 
    max(sal) as MAX_SAL, min(sal) as MIN_SAL, 
    round(avg(sal), 2) as AVG_SAL
from emp
group by job
order by job;

-- Ex. 부서별/업무별로 부서번호, 업무, 직원수, 급여 평균을 검색.
--     정렬 순서: (1) 부서번호 (2) 업무
select deptno, job, 
    count(*) as COUNT, round(avg(sal), 2) as AVG_SAL
from emp
group by deptno, job
order by deptno, job;

-- Ex. 입사연도별 사원수를 검색. (힌트) to_char(날짜, 포맷) 이용.
select to_char(hiredate, 'YYYY') from emp;
select to_char(hiredate, 'YYYY') as YEAR, count(*) as COUNT
from emp
group by to_char(hiredate, 'YYYY')
order by YEAR;

-- Ex. 부서별 급여 평균 검색. 급여 평균이 2000 이상인 부서만 검색.
select deptno, round(avg(sal), 2) as AVG_SAL
from emp
group by deptno
having avg(sal) >= 2000
order by deptno;

-- Ex. mgr 컬럼이 null이 아닌 직원들 중에서 부서별 급여 평균을 검색.
--     정렬순서: 부서번호 오름차순.
select deptno, round(avg(sal), 2) as AVG_SAL
from emp
where mgr is not null
group by deptno
order by deptno;

-- PRESIDENT는 제외하고, 업무별 사원수를 검색.
-- 업무별 사원수가 3명 이상인 업무들만 검색. 업무이름 오름차순 정렬.
select job, count(*) as COUNT
from emp
where job != 'PRESIDENT'
group by job
having count(*) >= 3
order by job;

select job, count(*) as COUNT
from emp
group by job
having job != 'PRESIDENT' and count(*) >= 3
order by job;

-- 입사연도별, 부서별 사원수 검색. 1980년은 검색에서 제외.
-- 연도별, 부서별 사원수가 2명 이상인 경우만 출력.
-- 정렬 순서: (1) 연도, (2) 부서.
select to_char(hiredate, 'YYYY') as YEAR, deptno, count(*) as COUNT
from emp
where to_char(hiredate, 'YYYY') != '1980'
group by to_char(hiredate, 'YYYY'), deptno
having count(*) >= 2
order by YEAR, deptno;

select to_char(hiredate, 'YYYY') as YEAR, deptno, count(*) as COUNT
from emp
group by to_char(hiredate, 'YYYY'), deptno
having to_char(hiredate, 'YYYY') != '1980' and count(*) >= 2
order by YEAR, deptno;
