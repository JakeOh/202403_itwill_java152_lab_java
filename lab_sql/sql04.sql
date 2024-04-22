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


-- 다중 행 함수 예:
-- count(컬럼): null이 아닌 행의 개수를 리턴.
select count(empno), count(mgr), count(comm)
from emp;

-- 테이블의 행의 개수
select count(*) from emp;


