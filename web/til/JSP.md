# JSP

* Servlet :  JAVA + HTML

  * 먼저나옴 JAVA 내에 HTML
  * JAVA, jsp, servlet, : tag sql 문은 문자열 취급한다 => 불편, jsp가 나옴
  * 유지보수에는 좋음 (수정할 때 서버를 내릴 필요가 없음)
  * 최신형은 4.0v

* JSP : HTML 안에 JAVA

  * 최신버전은 2.3v
  * 유지/보수에 어려움 (수정시 서버를 내려야 함)

  

  

  

## JSP 배경

* 클라이언트 사이드 프로그래밍

  * 클라이언트 컴퓨터 쪽에서 실행되는 프로그램만 장석하는 것

* 서버 사이드 프로그래밍

  * 동적 웹페이지가 대표적

* 동적 웹 페이지

  * 사용자의 요청에 따라 웹 페이지의 내용이 달라짐
  * 게시판, 블로그, 방명록
  * 도우미 프로그램(CGI)을 작성하고 필요시 실행시킴
    * Perl, C, python, PHP, ASP 등 사용
  * 클라이언트 요청이 있을 때 마다 새로운 CGI 생성

* 웹서버에서의 자바

  * 플랫폼에 독립적, 스레드 사용 => 효율적, 풍부한 라이브러리
  * 서블릿 사용
    * 효율적 : 스레드를 생성해 각 요청을 서비스
      * 요청이 있을 때마다 새로운 프로세스를 생성하는 CGI에 비해 효율적 
    * 편리 : java 개발자는  서버 스크립트 언어 학습 필요가 없음
      * 강력 : 기존 CGI에서 못했던 작업을 쉽게 처리할 수 있다
        * 웹서버와 직접 통신을 하는 등..
      * 이식성 : 플랫폼과 관계 없이 실행 가능
  * 자바 언어 안에 HTML 언어를 넣어야 하는 어려움
    * JSP가 개발됨

* JSP

  * 자바를 기반으로 동적인 웹페이지를 구축할 수 있는 서버-사이드-스크립트언어

  * 자바 서블릿을 기반으로 함

  * HTML 문서 안에 필요한 자바 코드가 들어감

    * 서블릿과는 반대

  * HTML 페이지 안에 필요할 때마다 `<%..%>`를 이용해 삽입

  * 웹서버가 JSP처리를 하려면 JSP 엔진 필요

    * JSP엔진 : JSP가 필요로 하는 실행환경과 다른 서비스 제공
    * 톰캣이 대표적

  * 동작구조

    ![image-20200116185750147](../../../../혜/til/img/image-20200116185750147.png)



## JSP사용

#### JSP의 특징 : 소스가 드러나지 않음



* 실제 입력

````jsp
<body>
	안녕하세요? 현재 시각은 <%= new java.util.Date() %>입니다.
	
</body>
````

* 소스보기를 통해 확인

  ````jsp
  <body>
  	안녕하세요? 현재 시각은 Thu Jan 16 19:07:22 KST 2020입니다.
  	
  </body>
  ````

  > 소스코드가 그대로 드러나지 않음
  >
  > 개발자의 소스는 보호됨, 스크립트에 의해 생성된 소스만 확인

#### 표현식

````html
<%= expression %></%>
````

* `<%=` 
  * `<%` JSP를 의미 
  * `=` 자바 수식을 의미
* expression
  * 자바의 어느 수식이든 넣을 수 있음
  * 변수, 값, 메소드 가능
  * 수식은 계산 된 후 String 객체로 변환되어 나타남
* `%>`
  * JSP가 종료됨

#### 스크립틀릿

* 많은 분량의 자바 코드 블록 작성

````html
<% code_block%>
````

* `<%`
  * 자바 코드의 시작을 알림
* code_block
  * 어떠한 코드 블록도 가능
* `%>`
  * 자바 코드의 종료를 알림

````jsp
<body>
	<% 
		System.out.println("날짜를 출력해보기");
		 java.util.Date date = new java.util.Date();
	%>	
	안녕하세요 ? 현재 시각은
	<%
		out.println(String.valueOf(date));
	%>
	입니다
</body>
````

> 결과 : 안녕하세요 ? 현재 시각은 Thu Jan 16 19:28:07 KST 2020 입니다



#### 스크립틀립과 HTML 혼합하기

* 스크립틀립 안에서 HTML 출력 가능
  * JSP 프로그래밍 장점을 해치는 행위
* 스크립틀립과 HTML 혼합이 더 효율적

````jsp
<body>
	<table border=2>
		<%
			int n = 3;
			for (int i = 0; i < n; i++) {
		%>
		<TR>
			<TD>Number</TD>
			<TD><%= i + 1 %></TD>
		</TR>
		<%
			}
		%>


	</table>
````

* `<%` : 스크립틀릿으로 돌아감
* `%>` HTML로 돌아감
* `<TR>` : for 문 안에 있어서 반복문 실행됨

![image-20200116194143276](../../../../혜/til/img/image-20200116194143276.png)



#### JSP 지시어

1. page

````jsp
    <%@ page import="java.util.*"%>
````

* `<%@`
  
      * 지시어의 시작
* `page`
  
      * 페이지에 관한 지시어
* `import="java.util.*"`
  
      * 페이지를 읽어들임
* %>
      * 지시어의 끝
  
    ````jsp
    
    <!DOCTYPE html>
    <%@ page import="java.util.*"%>
    
    <html>
    <head>
    <meta charset="UTF-8">
    <title></title>
    </head>
    <body>
    	<%
    		Date date = new Date();
    	%>
    	안녕하세요? 현재 시간은
    	<%=date%>
    	입니다.
    </body>
    </html>
    ````
  
    * 이전처럼 java.util을 일일히 넣어 줄 필요가 없다
  
2. includ

    * 물리적으로 다른 파일을 내용의 내용을 포함할 때

    ````  jsp
    <body>
    아래에서 ex01_basic jsp를 포함시킴
    <%@ include file ="ex01_basic.jsp" %>
    	
    </body>
    ````

    

3. taglib

    * 지시어를 부를 수 있음

#### JSP 선언

* JSP는 하나의 클래스로 변환
* 필요한 변수와 메서드 선언을 이 클래스에 추가 할 수 있음

  * 변수, 메서드 추가를 위한 선언


```jsp
 <%@ Date date;...%>
```

* `<%@`
  * 선언의 시작
* `Date date;...`
  * 변수 선언이나 메서드의 정의
* `.%>`
  * 변수 선언의 끝
* 

## 함수

#### out

* html 출력

````jsp
안녕하세요 ? 현재 시각은
	<%
		out.println(String.valueOf(date));
	%>
	입니다
````



#### request

* 브라우저와 서버 사이의 상호작용을 참조
* 브라우저가 보낸 요청에서 정보를 얻을 때
  * 클라이언트 호스트 이름, ip주소..

````jsp
<body>
	<%
		java.util.Date date = new java.util.Date();
	%>
	안녕하세요 ? 현재 시각은
	<%
		out.println(date);
		out.println("<BR>이고 ip 주소는 ");
		out.println(request.getRemoteAddr());
	%>
	입니다
</body>
````

> 실행결과 : 
>
> 안녕하세요 ? 현재 시각은 Thu Jan 16 19:32:53 KST 2020
> 이고 ip 주소는 0:0:0:0:0:0:0:1 입니다



! 변수 밑ㅊ 메소드 선언

<% 변수선언 for while if

<@ 표현식



---

#### 서블릿



클래스 생성

src : 자바 소스

webContent = css, html, js..

jsp 만드는 방법

class파일로 만들기

servlet 파일로만들기



1. 클래스로 만들기



![image-20200117094408824](../../../../혜/til/img/image-20200117094408824.png)

````jsp
package com.sds.date;

import javax.servlet.http.HttpServlet;

public class ServletTest extends HttpServlet {

}

````



![image-20200117100923895](../../../../혜/til/img/image-20200117100923895.png)

A : 추상클래스를 의미

![image-20200117101036324](../../../../혜/til/img/image-20200117101036324.png)



클라이언트가 get 방식이나 post 방식으로 들어와도 접근이 가능하도록 함

#### do post

````jsp
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
````

`HttpServletRequest req`  : 요청객체

`HttpServletResponse resp` : 응답 객체

요청(request)객체와 응답(response)객체

`throws ServletException, IOException {`

예외가 올 수 있다 : `serbletException` `IOException`

`super.doGet(reqest, response);`

없을 경우 부모객체를 소환한다



servletmapping 에서 name에서 클래스를 찾은 후에

servlet의 servletname으로 간다

url pattern 주소줄 표시

servlet class 에 있는 경로대로 가서 창 보여줌





#### 어노테이션

@WebServlet



### 내부 객체

* 선언을 안해도 사용 가능하다

* vrequest, response, out, pageContext, session, application, config, page, exception

* ØJSP 페이지 입출력 관련 기본 객체 

  ØJSP 페이지 외부 환경 정보 제공 기본 객체 

  ØJSP 페이지 서블릿 관련 기본 객체 

  ØJSP 페이지 예외 관련 기본 객체



서블릿은 수정할때마다 서버 새로 돌려야함

- 서버 리스타트



2,. 서블릿으로 만들기

![image-20200117112418484](../../../../혜/til/img/image-20200117112418484.png)





## 모델 1, 모델 2 (취업 질문) 

![image-20200117164117232](../../../../혜/til/img/image-20200117164117232.png)

#### 모델 1방식

* 뷰와 로직을 모두 JSP 페이지 하나에서 처리하는 구조
* JSP 내에 로직처리를 위한 자바코드가 출력을 위한 코드와 함께 섞여 삽입
* JSP 페이지는 자신이 직접 서비스클래스를 이용해서 작업을 처리하고 처리 정보를 클라이언트에 처리
* 과거에 많이 사용된 아키텍처

#### 모델 1 구성요소

1.  JSP
2. 자바빈 / 서비스 클래스

#### 특징

* 단순한 구조 - 사용법 쉬움

* 뷰코드 + 자바코드의 혼합 -> 코드의 복잡
* 백앤드 + 프론트앤드 혼재 
* 복잡한 코드-> 유지보수의 어려움

![image-20200117164359785](../../../../혜/til/img/image-20200117164359785.png)

#### 모델 2 방식=MVC

* JSP 페이지, 서블릿, 로직을 위한 클래스가 나뉘어 브라우저 요청 처리
  * 모든 처리를 JSP페이지가 하는 모델 1과 다름!!!

#### 모델2 구성요소

1. 서블릿 : 흐름제어 (controller)
2. JSP : 요청결과 (view)
3. 자바빈 / 서비스 클래스 : 요청에 대한 로직처리 ( model)

#### 특징

* 뷰코드 / 자바코드 분리 - 복잡하지 않은 코드
* 뷰/로직처리에 대한 분업 용이
* 유지보수 용이
* 구조가 복잡 - 학습의 어려움
* JAVA이해 필요



#### MVC <-> model2

* model2 : MVC패턴을 웹 개발에 도입한 것

* 똑같음

  | MVC 패턴   | 모델2                   | 특징                                                         |
  | ---------- | ----------------------- | ------------------------------------------------------------ |
  | MODEL      | 서비스 클래스 / 자바 빈 | 비즈니스 로직을 처리하는 모든것<br /> 컨트롤러부터 처리요청이 들어오면 수행하고 수행결과 반영(글작성, 회원가입, 로그인..)<br />request, session 객체에 저장 |
  | VIEW       | JSP 페이지              | 클라이언트에 출력되는 화면<br />CONTROLLER에 요청을 보냄<br />로직처리를 위한 코드가 내포되어 있지 않음<br />request,session 객체에 저장된 정보를 토대로 화면 출력<br /> |
  | CONTROLLER | 서블릿                  | 모든 흐름 제어<br />브라우저로부터 요청이 들어오면 요청분석 후 처리<br /> |

  



#### 모델 1? 모델 2?

* 모델 2 : 규모가 큰 프로젝트, 업데이트가 빈번한 프로젝트 용
  * 규모가 작은데 모델2로 하면 작업량만 늘어 날 뿐
* 모델 1: 규모가 작고 업데이트가 적은 프로젝트 용
  * 간단한 모델

## JSTL

* JSP Standard Tag Library

* 표준 커스텀 태그

* 많은 JSP어플리케이션을 간단한 태그로 캡슐화 함

* 코드가 복잡한 (java + html 혼용) JSP의 문제를  해결

  * 로직부분의 JSP코드를 태그로 대치시킴 => JSTL

* XML 기반

  * 시작태그와 종료태그의 필요

  

### jstl 설치하기

* https://tomcat.apache.org/download-taglibs.cgi 

  혹은

* https://mvnrepository.com/
* 에서 ==jstl.jar, standard.jar== 다운받아서 `WEB-INF\lib` 에 붙여넣기



## 주요 태그

| 라이브러리              | URL                                        | Prefix | ex)                         |
| ----------------------- | ------------------------------------------ | ------ | --------------------------- |
| Core                    | **http://java.sun.com/jsp/jstl/core**      | c      | **<****c:tagname** **...>** |
| XML processing          | **http://java.sun.com/jsp/jstl/xml**       | x      | **<****x:tagname** **...>** |
| I18N capable formatting | **http://java.sun.com/jsp/jstl/fmt**       | fmt    |                             |
| Database access(SQL)    | **http://java.sun.com/jsp/jstl/sql**       | sql    |                             |
| Functions(함수)         | **http://java.sun.com/jsp/jstl/functions** | fn     |                             |

