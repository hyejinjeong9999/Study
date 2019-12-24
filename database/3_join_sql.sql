select * from dept;
select * from emp;

******************
orcle join
******************

--empT - ename  deptT - loc 연결시켜야할때
select ename,loc
from emp,dept
where emp.deptno = dept.deptno;

--별칭 가능
select ename,e.deptno, dname, loc
from emp e,dept d
where e.deptno = d.deptno;

--sal 2000이상 deptno가 20번 부서에 근무하는 사원의 이름, 급여 , loc
select ename,sal,loc
from emp e,dept d
where e.deptno = d.deptno and sal >=2000 and e.deptno = 20;

******************************
--ansi join ->모든 db를 가리지 않고 사용  = 표준
--ansi inner join
*****************************
--테이블 테이블 사이의 , -> 테이블 테이블 사이 join 사용
--where (FK PF)-> on


select ename,e.deptno, dname, loc
from emp e,dept d
where e.deptno = d.deptno;

--=ansi 조인으로 변경 join은 inner join의 축약형

select ename,e.deptno, dname, loc
from emp e inner join dept d
on e.deptno = d.deptno;


--- oracle join
select ename,sal,loc
from emp e,dept d
where e.deptno = d.deptno and sal >=2000 and e.deptno = 20;

---ansi join
select ename,sal,loc
from emp e join dept d
on e.deptno = d.deptno 
where sal >=2000 and e.deptno = 20;
--테이블을 병합하는 where만 on으로 바꿈


--
outer join
--t2의 값이 t1에 없어서 출력하고 싶은데 출력이 안될때
--null 이 있는 쪽에 +마킹

select ename,d.deptno, dname, loc
from emp e inner join dept d
on e.deptno = d.deptno;


--oracle join : emp T의 deptno를 null을 포함한 모든 값을 출력한다 : 필드기준

select ename,d.deptno, dname, loc
from emp e , dept d
where e.deptno (+)= d.deptno;

---ansi join
--right 쪽의 테이블의 (dept d)가 master다  -> 전체 다 나와야돼 : 테이블 기준

select ename,d.deptno, dname, loc
from emp e right outer join dept d
on e.deptno = d.deptno;

---
--non equi join
--범위를 가지고 join
--
--참조테이블일 뿐 FK PF가 없을 때 
--sal이라는 정보가 losal과 hisal 
select ename,sal, grade
from emp, salgrade
where sal between losal and hisal;

---ansi .sal

select ename,sal, grade
from emp join salgrade
on sal between losal and hisal;


---
--n개의 테이블 join
--
--사원명, sal, 부서이름, salgrade 출력

select ename,sal, dname, grade
from emp e, salgrade, dept d
where e.deptno = d.deptno 
and sal between losal and hisal;

---ansi
select ename,sal, dname, grade
from emp e
join dept d
on e.deptno = d.deptno
join salgrade
on sal between losal and hisal;

--+ 조건 급여가 1500 이상
select ename,sal, dname, grade
from emp e
join dept d
on e.deptno = d.deptno
join salgrade
on sal between losal and hisal
where sal >= 1500;

--사원의 이름과 그 사원의 상사 이름 출력 // boss에는boss 표시
--셀프조인 : 한 테이블에서 참조가 일어남 한 테이블을 두테이블처럼
--as 안써도됨
select e.ename " 사원명", nvl(m.ename,'<<BOSS>>') "상사이름"
from emp e, emp m
where e.mgr = m.empno(+);

--상사보다 급여를 많이 받는 사원 list
select e.ename " 사원명", e.sal "급여",nvl(m.ename,'<<BOSS>>') "상사이름", m.sal "상사급여"
from emp e, emp m
where e.mgr = m.empno(+) and e.sal >= m.sal;


--ansi (왜 left인지 확인해보기)

select e.ename " 사원명", m.ename "상사이름"
from emp e left outer join emp m
on e.mgr = m.empno;


--상사보다 급여를 많이 받는 사원 list
select e.ename " 사원명", e.sal "급여",m.ename "상사이름", m.sal "상사급여"
from emp e join emp m
on e.mgr = m.empno 
where e.sal >= m.sal;


--집계함수 
-- round : 싱글
-- avg : 멀티
 
-->12개 출력 (각자로 계산되기 때문)
SELECT ENAME, ROUND(SAL) FROM EMP;

--> 하나만 출력됨 EMP의 평균 급여
SELECT AVG(SAL)
FROM EMP;

-->소숫점 없애기
SELECT ROUND(AVG(SAL))
FROM EMP;

-->전체평균 급여
SELECT ROUND(AVG(SAL))||'만원' 전체평균급여 FROM EMP;

-->부서별 평균 급여
-->GROUP BY에 써진 COLUMN 은 SELECT에 사용 가능
--> 다른건 안됨

SELECT DEPTNO, ROUND(AVG(SAL)) 부서별평균급여 
FROM EMP
GROUP BY DEPTNO;


