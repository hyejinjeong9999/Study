# MVC 컨트롤러 뷰 페이지 만들기

* JSP에는 태그만 남기고

  java코드는 servlet으로 남기자

  =>model2(mvc)의 개념 (서블릿을 다시 그리워하며...)

* 모델2방식

* M모델 = 클래스파일 

* C서블릿이 있는 곳 = 컨트롤러, 중간다리를 함

* V클라이언트 = 뷰

* controller와 model은 자바파일이기 때문에 src에 저장

* view는 html/jsp로 만들 수 있음 WebContent(파일 변경 가능)로 옮김

* MVVC : 오픈소스를 집어넣은 상태



스크립트릿 `<%`

* 함수를 못넣음

`<!`

* 제어문 못넣음



`<%=` 



`<%`와 `<%!`를 대신하는 친구 =>JSTL!!

`<%=`를 대신하는 친구 el!

?? jstl, el을 쓰는 방식이 모델2인가용

모델2에서 JSTL, EL을 사용한다



## EL

* JSP의 출력문법을 대체하는 표현 언어

* `<%=`를 없애기 위해 등장
* 코드를 태그로 교체한것
* JSTL 1.0에 EL이 기본적으로 내장되어 있음

````jsp
${msg}

````

* 파일을 생성할때 jsp파일로 만든다
* 정확히 입력해도 빨간줄뜬다

````jsp
<h3>\${5+7} = ${5+7}</h3>
<h3>\${5-7} = ${5-7}</h3>
<h3>\${5*7} = ${5*7}</h3>
<h3>\${5/7} = ${5/7}</h3>
<h3>\${5div7} = ${5 div 7}</h3>
<h3>\${5%7} = ${5 % 7}</h3>
<h3>\${5mod7} = ${5 mod 7}</h3>
````



* 태그 라이브러리를 넣는다
* 포맷 라이브러리를 넣는다

````jsp
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- http://java.sun.com/jsp/jstl/core 를 별칭 c로 적겠다 -->

````

* 값

````jsp
	<h3>${param['name']}</h3>
	<h3>${param['age']}</h3>
	<h3>${param.search}</h3>
````



---

내장객체 9개 : request response out pagecontext session application config page exception

* Session : 클라이언트 한명당 생기는 무언가



## 폴더의 이해

* src
  * 콘트롤러와 model이 들어가는 곳
  * 자바코드를 놓는 곳
  * 서블릿 = 자바
* webContent
  * html, jsp,css,JSTL,EL 이 들어감
  * 뷰단을 보여주는 곳

servlet 방식 - 이게 모델2인건가?

1) 클래스를 이용한 방식

2)서블릿을 이용한 방식

전송방식설정 피룡함

그냥 클래스를 만들면 그냥 콘솔창에서 만들어짐

웹페이지에서 보여야 함 - http.servlet 이라는 추상클래스를 이용

(클래스 생성시 superclass에서 찾아야 한다)

​	(추상클래스 안에는 추상 메소드가 존재함 -> 필수적으로 만들어야 함)

* get
* post



클라이언트/서버에서 데이터를 주고 받을 때

클라이언트가 서버측에 요청 - request(내장객체)

서버측에서 클라이언트 -reponse

​		-> 내장객체는 9개가 있음

받아오는건 string으로 받아오기 때문에 형변환이 필요하다

request, response는 무조건 필요하다

(아예 인터페이스로 존재흠)



* ServletTest

````java
package com.multi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MessageController")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//<웹 작동 방식>
	// 1, 전송 방식 결정
	// 2. 사용자 요청 분석(doGet / doPost)

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);

		// 응답객체하나 요청객체하나씩은 필수
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	// 공통으로(post든 get 방식이든) 접근하기 위해
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = request.getParameter("message"); // get방식으로 메시지 저장
		//사용자가 message에 입력한 값을 msg에 저장
		Object result = null;

		if (msg == null || msg.equals("test")) {
			result = "메시지가 없거나 test로 넘어왔습니다.";

		} else if (msg.equals("name")) {
			result = "나의 이름은 정혜진 입니다";
		} else {
			result = "찾는 type이 없음";
		}

		// 3. 데이터 저장 result 값에 result를 담아서 view 페이지로 이동
		request.setAttribute("result", result);
		// 4. 해당 뷰 페이지로 이동 -> webcontents의 view(jsp파일)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/msgView.jsp");
		//보내는 것 
		dispatcher.forward(request, response);

	}

}

````

* VIew = my View

````jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	전달된 결과 :
	<h1><c:out value="${result} "> </c:out></h1>
</body>
</html>
````

#### 폼에 내용을 입력하면 결과값 출력하기

* index

````html
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
<!--    <link rel="stylesheet" href="./style.css" />-->
    <title>The Web HTML CSS JS jQuery</title>
  </head>
  <body>
  	<form action="PersonInfo">
		이름:&nbsp;<input type="text" name="name" placeholder="이름"><br>
		주소:&nbsp;<input type="text" name="address" placeholder="주소"><br>
		번호:&nbsp;<input type="text" name="phone" placeholder="폰번호"><br>
		<input type="submit" value="입력"> &nbsp;<input type="reset" value="취소">
	</form>
  </body>
</html>
````

* info

  ````jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8"
  	pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>info.jsp</title>
  </head>
  <body>
  	<p>
  		전달된 사람은 : <c:out value="${person}"></c:out> 입니다.
  	</p>
  </body>
  </html>
  ````

  

* Personinfo

````java
package com.multi.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonInfo
 */
@WebServlet("/PersonInfo")
public class PersonInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
				
		Person person = new Person(name, address, phone);
		
		request.setAttribute("person", person);
		
		RequestDispatcher dispathcer = request.getRequestDispatcher("/view/info.jsp");
		dispathcer.forward(request, response);
		
	}
	
	class Person{
		
		String name;
		String address;
		String phone;
		
		public Person(String name, String address, String phone) {
			super();
			this.name = name;
			this.address = address;
			this.phone = phone;
		}

		@Override
		public String toString() {
			return "이름은 " + name + ", 주소는 " + address + ", 핸드폰 번호는 " + phone;
		}
		
		
		
	}

}

````

