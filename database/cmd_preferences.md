## CMD 업무환경 수정

- cmd 창에
  - set linesize 300; set pagesize 200;
  - 하지만 1회용임 -> 창 닫으면 다시 설정해야함

```
C:\\oraclexe\\app\\oracle\\product\\11.2.0\\server\\sqlplus\\admin
```

- `glogin.sql`파일 수정

- **set pagesize 200;col ename for a10;**

  ->10바이트로만 (영문 10글자)

- **col job for a12**;

  ->12바이트로

- **col deptno for 9999;**

  ->정수값 네자리만

- **col sal for 9999;**

  **col mgr for 9999;col comm for 9999;**