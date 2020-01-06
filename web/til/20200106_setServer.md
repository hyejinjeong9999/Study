# 2020.01.06_서버환경설정

### 유용한 사이트

[데이터 전문가 지식포털 DBGuide.net](http://www.dbguide.net/db.db?cmd=view&boardUid=148211&boardConfigUid=9&categoryUid=216&boardIdx=137&boardStep=1)

[SQL서버, 윈도우서버, ASP.NET, WebMatrix, C#, 개발프레임워크, HTML5, Azure, 오픈소스, 개발자, IT전문가 커뮤니티](http://www.sqler.com/)

[꿈꾸는 개발자, DBA 커뮤니티 구루비](http://www.gurubee.net/)

### 오라클 상태 확인하기(껏다/키기)

- 오라클이 제대로 켜져있는지 확인하기
- 시작 - 작업관리자 - 서비스 - oracle 서버 확인
    - OracleServiceXE
    - OracleXEClrAgent
    - OracleXECIrAgent
    - 세부정보에서 시작유형 변경 가능

    →프로세스 : 백 단에서 실행 중인 프로그램

    →프로세서 : CPU의 다른이름

### 오라클 상태 확인하기(껏다/키기)

- 오라클이 제대로 켜져있는지 확인하기
- 시작 - 작업관리자 - 서비스 - oracle 서버 확인
    - OracleServiceXE
    - OracleXEClrAgent
    - OracleXECIrAgent
    - 세부정보에서 시작유형 변경 가능

    →프로세스 : 백 단에서 실행 중인 프로그램

    →프로세서 : CPU의 다른이름

## 메모리 구조

- 메모리 : RAM + ROM
- RAM : 휘발성

    ![2020%2001%2006_/Untitled.png](2020%2001%2006_/Untitled.png)

    자료구조 중 스택구조에 해당

- ROM : 비휘발성, 제조할때부터 세팅이 되어서 나옴

### 1. **construct / static영역**

- 상수가 저장되는 곳
- static키워드 - 전역적으로 사용함
- 운영프로그램이 닫히지 전까지 계속 남아 있다

### **2. heap 영역**

- 동적메모리가 할당되는 곳
- C/C++ : 할당과 해제를 직접 해야됨
- JAVA : 할당(new,객체생성), gc로 자동으로 해제를 해줌

### **3. stack 영역**

- 운영체제가 적재되어 있음
- 부팅 관련된 영역 → ststem
- 변수가 저장됨
    - 일시적으로 사용되는 것 - {} 내의 변수

# 웹 - HTML, CSS, JS

- 최초의 웹

[http://info.cern.ch](http://info.cern.ch/)

### 1. HTML

- 문서구조

![2020%2001%2006_/Untitled%201.png](2020%2001%2006_/Untitled%201.png)

- 보통 head 위치에 css와 js를 넣는다
- 코드가 길면 파일로 따로 저장해서 HTML에서 불러들인다
- HTML 4.X까지는 정적인 페이지였다
- HTML5부터 동적인 페이지가 가능 → JS로 가능해짐

    <자주 쓰는 태그>

    - html : 문서의 시작, 실제 문서 정보와 내용이 시작되고 끝나는 것을 표시
    - head : 웹브라우저 화면에는 보이지 않지만 웹 브라우저가 알아두어야 할 정보 입력
        - title : 브라우저의 제목 표시줄에 사용
        - meta : 문자 인코딩 방법 및 문서의 키워드와 요약정보
    - body : 실제 브라우저에 표시될 내용
    - h1 : 일반 텍스트보다 크기가 크고 진함, h1~h6까지 존재
    - p : 입력한 내용 앞 뒤로 빈줄이 생기면서 텍스트 단락 생성
    - br : 태그가 삽입한 위치에서 줄이 바뀜
    - b : 태그로 감싼 텍스트를 진하게 표시
    - i : 태그로 감싼 텍스트를 기울기로 표시
    - img : 웹 문서에 이미지를 넣음
    - a : 외부 사이트로 연결하는 하이퍼링크를 만듦

### 2.CSS

- HTML 내 <style> 태그 내에 입력
- 디자인을 담당

### 3.javascript

- HTML내 <script> 태그 내에 입력
- 기능 동작

# 환경설정

## 자바 언어변경

- window - preferences - general - content Types
    - css
    - java Properties File
    - java Source File
    - jsp
    - html
- default encoding : UTF-8 후 업데이트

## 이클립스 프로젝트 생성

1. 화면 변경

    window - perspective - open perspective - web

2. 프로젝트 생성

    file - new - dynamic web project

    ![2020%2001%2006_/Untitled%202.png](2020%2001%2006_/Untitled%202.png)

    Dynamic web module version : 서블릿 버전 의미 → 3.1

## 아파치 서버 다운로드

- [https://www.apache.org/](https://www.apache.org/)
- apache projects list - Tomcat 다운로드 (8.5.50)

### 파일 내용

1. bin : 실행파일들
2. conf : xml, 설정파일들
3. lib : jar파일들
4. logs
5. temp
6. webapps
    1. docs : api
    2. examples : 간단한 예제들을 모아놓음
    3. host-manager
    4. manager
    5. ROOT : 서버가 실행될때 사용되는 파일
7. work

### 서버 시작

- `bin - startup` 파일 실행

    ![2020%2001%2006_/Untitled%203.png](2020%2001%2006_/Untitled%203.png)

- 서버 구동 시작

- 크롬창에 localhos:8080 입력 → 사이트 정상실행 확인

### 서버 실행이 안될 경우

- 환경변수에서 oracle이 위에 있어서 그럼
1. 새 시스템 변수에 TOMECAT_HOME 변수 지정

    ![2020%2001%2006_/Untitled%204.png](2020%2001%2006_/Untitled%204.png)

2. 환경변수에 넣기

    ![2020%2001%2006_/Untitled%205.png](2020%2001%2006_/Untitled%205.png)

    **→  `%`의 의미 : 사용자가 직접 만든 것**

3. oracle SQL- admin에서 포트넘버 변경

    ```sql
    --포트넘버 확인
    select dbms_xdb.gethttpport()from dual;
    
    --포트넘버 9090으로 변경
    exec dbms_xdb.sethttpport(9090);
    ```

    ![2020%2001%2006_/Untitled%206.png](2020%2001%2006_/Untitled%206.png)

4. 크롬창에 localhos:8080 입력 → 사이트 정상실행 확인

![2020%2001%2006_/Untitled%207.png](2020%2001%2006_/Untitled%207.png)

`C:\app\apache-tomcat-8.5.50\webapps\ROOT`에 있는 파일들로 실행 된 것

2. 버전 확인 후 입력

## 이클립스 내 서버 실행

- 이클립스 - Sercers(중앙 하단) - 우측클릭 - new - server

    ![2020%2001%2006_/Untitled%208.png](2020%2001%2006_/Untitled%208.png)

    - 버전 꼭 확인할 것

    ![2020%2001%2006_/Untitled%209.png](2020%2001%2006_/Untitled%209.png)

    - TOMCAT이 있는 경로 지정하기

    ![2020%2001%2006_/Untitled%2010.png](2020%2001%2006_/Untitled%2010.png)

## 서버 실행 확인하기



### JSP 파일 넣는 방법

1.  lib폴더에 jsp라이브러리를 넣는다

    → 다른 프로젝트할때 다시 넣어야 한다

2. 한 곳에 넣기

    → 톰캣의 jar파일을 복사해서 java에 넣는다

    `C:\app\apache-tomcat-8.5.50\lib`에 

    - servlet-api.jar
    - jsp-api.jar
    - el-api.jar




````jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    
<%@ page import = "java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Server Test 입니다 수정했어요</h1>
<% Date today = new Date(); %>
<%= today %>
</body>
</html>
````







![2020%2001%2006_/Untitled%2011.png](2020%2001%2006_/Untitled%2011.png)

- **서버사이드 스크립트** : 화면에서 안보이는 코드
- **클라이언트 사이드 스크립트** : 화면에서 보이는 코드

## 실행 브라우저 크롬으로 바꾸기

- window - web browser - chrom
- 혹은 general - web brawser에서 직접 지정