# BDCP

## DB와 Web 연동하기

#### DB연동시 필요한 것

* 아파치에서  DBCP & Pool & JNDI (커넥션 풀)
* 대신 톰캣 dbcp하나만 이용해도 가능



### JDBC? DBCP?

* 자바 웹 어플리케이션에 DB접속과 관련된 라이브러리 - JDBC, DBCP

#### JDBC

* Java Database Connectivity

* 자바에서 데이터베이스 연결하기 위한 인터페이스

* DB들은 JDBC를 위한 각각의 Driver를 제공함

  * JDBC는 이 Driver를 통해 DB에 접속함

* DB접속시 반복되는 순서

  1. DB 접속을 위한 JDBC 드라이버 로드

  2. getConnection Method로 부터 DB 커넥션 객체를 얻음
  3. 쿼리 수행을 위한 PreparedStatement 객체 생성
  4. excuteQuery를 실행해서 결과를 받아옴.
     * 1번, 2번반복 비효율적

#### DBCP =>보다 효율!

* DataBase Connection Pool
* DB와 커넥션을 맺고 있는 객체를 관리
* WAS실행시 미리 일정량의 DB Connection 객체를 생성하고 Pool에 저장
* DB연결요청이 있으면 Pool에서 Connection 객체를 가져다 쓰고 반환
* 설정 옵션
  * maxActive
    * 동시에 사용할 수 있는 최대 커넥션 수
    * defalut 는 8개
  * maxIdle 
    * Connection Pool에 반납할 때 최대로 유지될 수 있는 커넥션 개수
    * 지연시간
  * maxWait 
    * -1 : 즉각적으로 바로 실행
  * minIdle 
    * 최소한으로 유지할 커넥션 개수
  * initialSize 
    * 최소로 getConnection() Method를 통해 커넥션 풀에 채워 넣을 커넥션 개수

**톰캣 dbcp를 활용해서 연동**  

---

#### DB연결을 위해 수정해야 할 것

* tomcat-dbcp.jar 파일 넣기

1. web.xml

2. context.xml

   * sever폴더는 모든 프로젝트에 영향을 줌

   * context.xml을 따로 만들어 각 프로젝트에 영향주게 함

3. source

   * JSP
   * SERVLET

   

* web.xml

````xml
  <resource-ref>
  		<description>jdbc:dbcpTestDB  DBCP setting</description>
  		<res-ref-name>jdbc:dbcpTestDB</res-ref-name>
  		<res-type>javax.sql.DataSource</res-type>
  		<res-auth>Container</res-auth>
  </resource-ref>
  
````



* context.xml

````xml
<?xml version="1.0" encoding="UTF-8"?>

<Context reloadable="true">
	 <WatchedResource>WEB-INF/web.xml</WatchedResource>
	 
	 <Resource   name="jdbc:dbcpTestDB"
	 				   auth="Container"
	 				   type="javax.sql.DataSource"
	 				   username="kingsmile"
	 				   password="oracle"
	 				   driverClassName="oracle.jdbc.OracleDriver"
	 				   url="jdbc:oracle:thin:@localhost:1521:xe"
	 				   
	 				   maxActive="20"
	 				   maxIdle="10"
	 				   maxWait="-1"	 			 			
	 
	 		/>

</Context>			 			
	 
````

* sorce(dbcpConnection.jsp)

````jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>

<%@ page import = "javax.sql.DataSource , javax.naming.*, java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dbcpConnection.jsp</title>
</head>
<body>

<% 

try{
	Context ctx = new InitialContext();
	Context envCtx = (Context) ctx.lookup("java:comp/env");
	DataSource ds=(DataSource) envCtx.lookup("jdbc:dbcpTestDB");

	Connection conn = ds.getConnection();

	out.println("DBCP Connection success.....<br><br>");
	
}catch(Exception e){
	e.printStackTrace();
}
%>

</body>
</html>
````

## 

