/*
 * join: 2개 이상의 테이블에서 검색하는 것.
 * join 종류:
 * 1. inner join
 * 2. outer join
 *    (1) left outer join
 *    (2) right outer join
 *    (3) full outer join
 * 문법:
 * 1. ANSI 표준 문법:
 *    select 컬럼, ...
 *    from 테이블1 join종류 테이블2 on 조건식;
 * 2. Oracle 문법:
 *    select 컬럼, ...
 *    from 테이블1, 테이블2
 *    where 조건식;
 */

-- inner join과 outer join의 차이점을 설명하기 위해서.
insert into emp (empno, ename, sal, deptno)
values (1004, '오쌤', 3500, 50);

commit; -- 테이블의 변경 내용을 영구히 저장.


-- 사번, 이름, 부서번호, 부서이름 검색
-- inner join. 표준 문법.
select emp.empno, emp.ename, emp.deptno, dept.dname
from emp 
    inner join dept on emp.deptno = dept.deptno;
--> inner join에서 inner는 생략 가능.

-- inner join. Oracle 문법.
select emp.empno, emp.ename, emp.deptno, dept.dname
from emp, dept
where emp.deptno = dept.deptno;

-- left (outer) join. 표준문법.
select e.empno, e.ename, e.deptno, d.dname
from emp e
    left outer join dept d on e.deptno = d.deptno;
--> left outer join에서 outer는 생략 가능.

-- left (outer) join. Oracle 문법.
select e.empno, e.ename, e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno(+);

-- right (outer) join. 표준문법.
select e.empno, e.ename, d.deptno, d.dname
from emp e
    right join dept d on e.deptno = d.deptno;
--> right outer join에서 outer는 생략 가능.

-- right (outer) join. Oracle 문법.
select e.empno, e.ename, d.deptno, d.dname
from emp e, dept d
where e.deptno(+) = d.deptno;
