/*
 * 서브쿼리(subquery): SQL 문장의 일부로 다른 SQL 문장이 포함되는 것.
 */

-- 급여가 평균 이상이 직원들?
select avg(sal) from emp; --> 2073.214285
select * from emp where sal >= 2073.21;

select * from emp
where sal >= (
    select avg(sal) from emp
);

-- ALLEN보다 더 적은 급여를 받는 직원들의 사번, 이름, 급여를 검색.
-- select sal from emp where ename = 'ALLEN';
select empno, ename, sal
from emp
where sal < (
    select sal from emp where ename = 'ALLEN'
);

-- ALLEN과 같은 업무를 담당하는 직원들의 
-- 사번, 이름, 부서번호, 업무, 급여를 검색.
select empno, ename, deptno, job, sal
from emp
where job = (
    select job from emp where ename = 'ALLEN'
);

-- SALESMAN의 급여 최댓값보다 더 많은 급여를 받는 직원들의
-- 사번, 이름, 급여, 업무를 검색.
select empno, ename, sal, job
from emp
where sal > (
    select max(sal) from emp where job = 'SALESMAN'
);
