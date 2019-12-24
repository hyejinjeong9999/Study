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



## 이클립스 환경세팅

* 프로젝트에 파일생성 :db_info.properties
  * 환경설정 파일명은 보통 properties다 
  * 옛날 .properties를 가지고 많이함
  * 2000년대부터 xml문서가 많아졌으나 복잡
  * configuration을 .properties로 되돌아 가는 추세

```properties
id = SCOTT
pw = TIGER
driver = 
url = 
```

특정 데이터베이스로 코넥션을 하려면 id pw driver url 정보가 필요하다





### 이클립스 DATABASE 환경설정

#### 1. jdbc 복사

![image-20191224181209965](../../../../AppData/Roaming/Typora/typora-user-images/image-20191224181209965.png)

* 오라클용 jdbc 드라이버

* 오라클에서 만든 클래스들을 압축해서 제공

* OJDBC6 파일을 ```C:\lib```로 이동



#### 2. 이클립스 perspective 변경

* javaEE로 변경

* 하단의 Data Source Exploer 창 확인

![image-20191224102038923](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20191224102038923.png)



	#### 3. new database connection

* database connection - new - oracle (Name 변경) 
* Drivers : Oracle Thin Driver / version 11
* JAR LIST : 기존의 Driver files 지우고 C:\lib의 OJDBC6 add

![](../../../../AppData/Roaming/Typora/typora-user-images/image-20191224102423985.png)



![image-20191224102504341](../../../../AppData/Roaming/Typora/typora-user-images/image-20191224102504341.png)

* Servername : xe
* HOST : 127.0.0.1 (루프백, 내 아이피)
* User name / password 기입
* 내 주소 항상 기억하기
  * jdbc:oracle:thin:@127.0.0.1:1521:xe

![image-20191224102853119](../../../../AppData/Roaming/Typora/typora-user-images/image-20191224102853119.png)





