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


---12/24

--WHERE 절에서 NULL 처리하기

SELECT *
FROM EMP; 

----MGR이 NULL인 값 출력

SELECT *
FROM emp
WHERE mgr IS NULL;

---MGR이 NULL이 아닌 값 출력
SELECT *
FROM EMP
WHERE MGR IS NOT NULL;

--총급여가 2000이상인 값 출력
--WHERE에는 별칭(alias)사용이 안된다
SELECT ENAME,SAL,COMM, SAL+ NVL(COMM,0) AS "총급여"
FROM EMP
WHERE SAL+COMM(COMM,0) >2000;

--정렬 SAL을 기준으로 오름차순 
--오른차순(ASC)이 DEFAULT!
SELECT ENAME,SAL,COMM, SAL+ NVL(COMM,0) AS "총급여"
FROM EMP
ORDER BY SAL;
--내림차순
SELECT ENAME,SAL,COMM, SAL+ NVL(COMM,0) AS "총급여"
FROM EMP
ORDER BY SAL DESC;


----이중 가능
SELECT ENAME,SAL,COMM, SAL+ NVL(COMM,0) AS "총급여"
FROM EMP
ORDER BY SAL ASC, COMM DESC;

---SELECT에 없어도 가능
SELECT ENAME,SAL, SAL+ NVL(COMM,0) AS "총급여"
FROM EMP
ORDER BY SAL ASC, COMM DESC;

---WHERE없어도 SELECT에 없어도 가능
SELECT ENAME,SAL, SAL+ NVL(COMM,0) AS "총급여"
FROM EMP
WHERE COMM IS NOT NULL
ORDER BY SAL ASC, COMM DESC;

---ALIAS문구로 정렬 가능
SELECT ENAME,SAL, SAL+ NVL(COMM,0) AS "총급여"
FROM EMP
WHERE SAL+NVL(COMM,0)>=2000
ORDER BY "총급여"

---위치인덱스로도 정렬 가능
SELECT ENAME,SAL, SAL+ NVL(COMM,0) AS "총급여"
FROM EMP
WHERE SAL+NVL(COMM,0)>=2000
ORDER BY 3;

---단일형 함수
select dname, lower(dname),loc,lower(loc)
from dept;
---반올림 ,자릿수 표현, 소수점 다 자르기
select round(44.55),round(44.55,1),trunc(44.55) 
from dual;

select sal, trunc(sal*0.03) as "TAX"
from emp;

---문자열 자르기 : 월만 출력
select ename,hiredate,substr(hiredate,4,2) as 입사월
from emp;

--사원의 입사월이 12월인 정보 추출
select ename,hiredate
from emp
where substr(hiredate,4,2) like '12';

--+해도 알아서 날짜연산된당
select sysdate, sysdate+30 from dual;
---인덱스 1부터 시작 4번째부터 2자리
select sysdate, substr(sysdate,4,2)from dual;
--format 변경
select sysdate, to_char(sysdate,'yy')from dual;
select sysdate, to_char(sysdate,'yyyy')from dual;
select sysdate, to_char(sysdate,'day')from dual;
select sysdate, to_char(sysdate,'mm')from dual;
select sysdate, to_char(sysdate,'dd')from dual;

--emp에서 사원들의 사원명, 입사월 및 요일 정보 출력, 월별정렬 (오류남 수정)
select ename, to_char(HIREDATE,'mm')as"입사 월",to_char(HIREDATE,'day') as "요일"
from EMP
order by "입사 월";

--날짜형의 다양한 형태
select sysdate,to_date('2019/12/24') from dual;
select sysdate,to_date('2019-12-24') from dual;
select sysdate,to_date('2019 12 24') from dual;
                        --년월일 순
select sysdate,to_date('19 12 19') from dual;
select sysdate,to_date('12/24/19','mm/dd/yy') from dual;


--decode 함수 if문

select ename,sal,decode(deptno, 10,sal*1.2, 20,sal*0.7,sal)as "보너스"
from emp
order by deptno;
