# 0.계정관리

## 1) 로그인

- sqlpluse 테이블명/비밀번호

  → sqlpluse system/1234

- conn 테이블명/비밀번호

  →conn hr/hr

  →**conn하는 순간 오류가 나더라도 이전 계정에는 로그아웃 된다**

## 2) 테이블 생성

```
create user test01 identified by 1234
default TABLESPACE mc;

--test01이라는 이름의 계정생성, 비밀번호는 1234
--기본적으로 mc라는 이름의 TableStace에서 관리
```

## 3) 권한 부여

```
grant connect,resource,dba to test01;

--test01에 connect, resource, dba(관리자권한) 권한을 준다
--connect :연결할수 있는권한 생성 ->로그인 가능
```

## 4) 권한뺏기

```
revoke dba from test01;
```

## 5) 테이블보기

```
select * from tab;
모든 테이블 보기
```

# 1. 관리자 계정

- 전체 테이블들 생성/삭제/ 권한 부여할때 사용
- `sqlpluse system/1234` 로 접속

# 2.HR/HR계정

- 샘플데이터가 존재함

- 생성 후 잠금이 되어 있기 때문에 관리자모드에서 풀어줘야 함

  ```
    alter user hr identified by hr(새로운암호) account unlock;
  ```

# 3.SCOTT/TIGER 계정

- HR/HR의 구버전

1. 생성

   ```
    create user SCOTT identified by TIGER
    default TABLESPACE mc;
   ```

2. 권한설정

   ```
    GRANT CONNECT,RESOURCE, DBA TO SCOTT;
   ```

3. 테이블 보기

   ```
    select * from tab
   ```

4. 데이터 구축

   ```
    @c:lib/scott.sql;
    --기존의 자료들 지우고 다시 실행 (초기화)
   ```

# 5.DBF

- 특정 계정에서 테이블을 만들면 그 실질적인 실제 데이터가 들어가는 공간

- TABLE SAPCE를 제대로 관리 안하면 (직접 언급하지 않으면) 시스템 파일로 들어감

  →성능 저하의 원인!

- **`C:\\oraclexe\\app\\oracle\\oradata\\XE`** 내에 파일 존재

## 1.**생성**

```
create TABLESPACE mc
datafile 'C:\\oraclexe\\app\\oracle\\oradata\\XE\\mc.dbf'
size 10M
autoextend on next 1M maxsize UNLIMITED;
```

## 2.**삭제**

```
drop TABLESPACE mc INCLUDING CONTENTS AND Datafiles;
```