

sqlplus system/1234

 alter user hr identified by hr account unlock;
 
 conn hr/hr
 
 sqlplus hr/hr
 
 select * from tab;
 select * from employees;
 
**************
* TABLESPACE *
***************
create TABLESPACE mc
datafile 'C:\oraclexe\app\oracle\oradata\XE\mc.dbf'
size 10M
autoextend on next 1M maxsize UNLIMITED;


drop TABLESPACE mc INCLUDING CONTENTS AND Dafatiles;


******************
* CREATE ACCOUNT *
******************
관리자모드에서
test01이라는 계정 생성, 비밀번호는 1234
기본적으로 mc라는 이름의 tablespace는 mc입니당

create user test01 identified by 1234
default TABLESPACE mc;

권한부여 dba : 관리자권한
grant connect,resource,dba to test01;

sqlplus test01/1234

권한뺏기
revoke dba from test01;

삭제

drop user test01 cascade;
test01 테이블을 삭제

**********************
* SCOTT/TIGER 계정 생성 *
**********************

create user SCOTT identified by TIGER
default TABLESPACE mc;

@c:lib/scott.sql;
@실행 : sql파일에 있는거 모두 실행
어느 창에서 실행하든 상관 없음

select * from tab;

set linesize 300;
임의의 폭 값 설정
set pagesize 200;
(1회용임)



select * from emp;
emp테이블에 있는 column 다 보여줘