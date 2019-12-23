--SCOTT/TIGER로 접속
--SCOTT/TIGER의 emp 출력
conn SCOTT/TIGER   
select * from emp ; 
select * from dept;
select * from salgrade;

decs emp;
--사원이름 / 월급/ 부서이름
select ename, sal,deptno 
from emp;

--사원이름 / 입사날짜
select ename,hiredate 
from emp;

--부서번호/부서이름
select deptno, dname
from dept; 

--//중복제거 안되고 그대로 모든 직업정보나옴
select select job  
from emp

--중복제거 된 job 
select distinct select job 
from emp;

--직원이름 , 급여 , 급여 * 12
select ename, sal, sal*12 
from emp;


--이름변경 유일하게 "" 쓰는 구간 (나머지는 ''로 사용함)
select ename, sal, sal*12 as "연봉"
from emp;

--직원이름, 직원, 연봉, commiton(영업수당) 정보 출력
select ename,job sal, comm
from emp;

--월급 + 영업수당 = 실급여
select ename, job, sal, comm, sal + comm as "실급여"
from emp;

--null일땐 0으로 바꿔  !!nvl!! comm이 null이라면 -1출력
-- * null과 0은 다르다! null운 -1 0은 0
select ename, job, sal, comm, sal + comm ,nvl(comm,-1)
from emp;

--null일땐 0으로 바꿔  !!nvl!! comm이 null이라면 0출력
select ename, job, sal, comm, sal + comm ,nvl(comm,0)
from emp;

--이름 설정
select ename, job, sal, comm, sal + comm ,nvl(comm,0)as "총급여"
from emp;

--사번, 사원이름, 상사직번
select empno, ename,mgr
from emp;

--상사가 없는 사람은 CEO라고 출력
select empno, ename,nvl(mgr,'<<CEO>>')
from emp;

--************에러내용
select empno, ename,nvl(mgr,'<<CEO>>')
                            *
ERROR at line 1:
ORA-01722: invalid number

--타입이 일치하지 않아서 오류 'ceo'가 number가 아니다
--****************

--문자열로 바꾸기 to_char / number / date
select empno, ename,nvl(to_char(mgr),'<<CEO>>') as "매니저 코드"
from emp;

--문자열 연결 연산자 ||
select ename|| job
from emp;

--공백포함
select ename||'  '|| job
from emp;

--행 개수만큼 출력된다  (16줄출력)
select 20*20*4
from emp;
 
--가상의 테이블을 만들어주는 dual
select 20*20*4
from dual;

-- sysdate년 /월/일 정보 출력
select SYSDATE
from dual;

--로그인한 유저의 정보 출력
select user
from dual;

--where 조건절 row에 제한을 걸음
select ename,job,deptno
from emp
where deptno = 10;
--10번부서에 해당하는 이름, 직업, 부서번호 출력

select ename,job,deptno
from emp
where job = 'MANAGER';
--대소문자 구분하니까 주의해서 쓰기

--대문자 변환 함수 / lower 소문자 변환 함수
select ename,job,deptno
from emp
where UPPER(job) = UPPER('manager');

--82이년도 이후에 입사한 사람들 목록
select ename, hiredate
from emp
where hiredate > '82/01/01';

--82년 5월 1일 입사한 사람을 제외한 사람들 (!=) 도 가능함
select ename, hiredate
from emp
where hiredate <> '82/05/01';


--between and
select ename, sal
from emp;
where sal >=2450 and sal <=3000;

---2450 / 3000도 포함된다 작은 값 먼저 ㅊ터리하기
select ename, sal
from emp
where sal between 2450 and 3000;

--사번이 10번이거나 20번이거나
select ename, job, deptno
from emp
where deptno = 10d or deptno = 20;

select ename, job, deptno
from emp
where deptno in(10,20);

---dept 테이블 모두 출력
select *
from dept;

--괄호  deptno가 20이면서 loc가 dalla스이거나 deptno가 30이면서 chicago인 
select *
from dept
where (deptno,loc) in ((20,'DALLAS'),(30,'CHICAGO'));

--like 연산자
---이름이 A인 사람
select *
from emp
where ename = 'A'

--이름이 A로 시작하는 사람 % :와일드카드
select *
from emp
where ename like 'A%';
--A로 끝나는 사람
select *
from emp
where ename like '%A';

--A가 포함되는 사람
select *
from emp
where ename like '%A%';

--뒤에서 3글자 앞이 A인사람 ~~AOO 인사람
select *
from emp
where ename like '%A__';

--81년도에 입사한 사원 목록 

select *
from emp
where hiredate like '81%';