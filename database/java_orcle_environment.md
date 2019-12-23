## 자바/오라클 환경 구축

## **자바 환경 구축**

- 이클립스 설치([Eclipse 2019-03 (4.11)](https://www.eclipse.org/downloads/packages/release/2019-03/r))
- JDK 설치 ([Java SE 8u231](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))

## **환경변수 설정**

- 내컴퓨터 - 고급시스템설정 - 환경변수
- JAVA_HOME C:\Program Files\Java\jdk1.8.0_231
- path %JAVA_HOME%\bin
- classpath .;

## **설정확인해보기**

- cmd 창 열기

- **java**

- **set path**

  C:\Users\student>set path Path=C:\Program Files (x86)\Common Files\Oracle\Java\javapath;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Windows\System32\OpenSSH\;C:\Program Files\Java\jdk1.8.0_231\bin;C:\Users\student\AppData\Local\Microsoft\WindowsApps; [PATHEXT=.COM](http://PATHEXT=.COM);.EXE;.BAT;.CMD;.VBS;.VBE;.JS;.JSE;.WSF;.WSH;.MSC

- **set classpath**

  classpath=.;

  가 나오면 정상!

## **이클립스 설정 / SQL 파일 생성**

- Open Perspective - JAVA - Workspace - Text file encoding - UTF-8
- windows - preferance - General
- sql 폴더만들기
- new - other - SQL Development - SQL File

## **오라클 설치**

- 오라클 EX 버전 11 설치
  - 오라클 - 다운로드 - Database -[Database 18c Express Edition](https://www.oracle.com/database/technologies/xe-downloads.html)
- Downloads - Developer Tools -SQL Developer (Windows 64-bit with JDK 8 included)
- Oracle Database 설치