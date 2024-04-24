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

-- full (outer) join. 표준문법.
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e
    full join dept d on e.deptno = d.deptno;
--> full outer join에서 outer는 생략 가능.

-- Oracle은 full outer join 문법을 제공하지 않음.
-- 집합 연산(합집합 union, 교집합 intersection, 차집합)을 사용.
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno(+)
union
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e, dept d
where e.deptno(+) = d.deptno;

-- equi join: join의 조건식이 = 연산자를 사용해서 만들어진 경우.
-- non-equi join: join의 조건식이 부등호를 사용해서 만들어진 경우.
-- 사번, 이름, 급여, 급여등급(호봉) 검색.
select e.empno, e.ename, e.sal, s.grade
from emp e
    join salgrade s on e.sal between s.losal and s.hisal;
-- join salgrade s on e.sal >= s.losal and e.sal <= s.hisal;

select e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal;

-- self join: 같은 테이블에서 join하는 것.
-- 사번, 이름, 매니저 사번, 매니저 이름을 검색.
select e1.empno, e1.ename, e1.mgr as MGR_NO, e2.ename as MGR_NAME
from emp e1
    join emp e2 on e1.mgr = e2.empno;

select e1.empno, e1.ename, e1.mgr, e2.ename as MGR_NAME
from emp e1, emp e2
where e1.mgr = e2.empno;

select e1.empno, e1.ename, e1.mgr, e2.ename as MGR_NAME
from emp e1
    left join emp e2 on e1.mgr = e2.empno;

select e1.empno, e1.ename, e1.mgr, e2.ename as MGR_NAME
from emp e1, emp e2
where e1.mgr = e2.empno(+);

-- ex1. 직원 이름, 직원 근무 도시를 검색. 근무 도시 오름차순 정렬.
-- ex2. 직원 이름, 매니저 이름, 급여, 급여 등급을 검색.
--      정렬순서: (1)매니저, (2)급여 등급
-- ex3. 직원 이름, 부서 이름, 급여, 급여 등급을 검색.
--      정렬 순서: (1)부서 이름, (2)급여 등급
-- ex4. 부서 이름, 부서 위치, 부서의 직원수를 검색. 부서 번호 오름 차순.
-- ex5. 부서 번호, 부서 이름, 부서 직원수, 부서의 급여 최솟값, 
--      부서의 급여 최댓값 검색. 부서 번호 오름 차순.
-- ex6. 부서 번호, 부서 이름, 사번, 이름, 매니저 사번, 매니저 이름, 
--      급여, 급여 등급을 검색. 급여가 3000 이상인 직원들만 검색.
--      정렬 순서: (1) 부서 번호, (2) 사번 오름차순.