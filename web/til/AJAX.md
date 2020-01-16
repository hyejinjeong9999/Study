# AJAX

* **A**synchronous **J**avaScript **a**nd **X**ML 의 약자 (비동기 자바스크립트)
* 서버와 데이터를 교환하는 기술 중 하나
  * 기존 방식 : 서버로부터 페이지 단위로 받음
  * AJAX : XML 파일조각 단위로 받을 수 있음 (전체 페이지를 다시 로드 할 필요 없음)
* 클라이언트가 서버와 적은 양의 데이터를 교환해 (자바스크립트로)비동기적으로 HTML 페이지 업데이트 가능
  * 웹 페이지의 일부분을 업데이트를 할 수 있다
  * 빠르고 동적인 대화형 웹페이지를 만들 때 유용
  * 맵, 검색창 관련된 애들은 다 AJAX
* ==비동기식== : 여러가지 일이 동시적으로 발생한다
  *  서버와 통신하는 동안 다른 작업을 할 수 있다
* AJAX를 하려면 서버를 무조건 구동해야 함 
  * 서버를 통해서 실행된다
* 사용 남발은 하지 말 것
* 요즘은 JQuery AJAX를 사용



#### 특징

* 자바스크립트 객체다
* 대부분의 브라우저에서 지원
* 표준 HTTP 방식 (GET/POST)로 서버와 통신
* 서버와 통신시 비동기적으로 작업
  * 백단에서 작업



#### AJAX 구성요소

* XMLHttpRequest
* DOM
* CSS
* JavaScript



#### 처리 순서

1. 클라이언트 이벤트 발생

2. XMLHttpRequest 객체 콜백 함수 설정

3. XMLHttpRequest 객체를 통한 비동기화 요청

4. 서버 응답결과를 생성해 클라이언트 전송

5. XMLHttpRequest 객체는 서버결과를 처리할 콜백함수 호출

6. 결과를 클라이언트 화면에 반영



````javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	var httpRequest = null;
	
	function requestMsg() {
		//1단계 : XMLHttpRequest 객체 생성
		if( window.XMLHttpRequest ) {  //chrome, firefox, safri,....
			httpRequest = new XMLHttpRequest();
		}else if( window.ActiveXObject ) {  //IE
			httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		}else {
			httpRequest = null;
		}
	 
	  //2단계 : 서버에서 응답해준 결과를 처리할 수 있는 callback함수를 설정
		httpRequest.onreadystatechange = responseMsg;
		
		//3단계 : 초기화 작업(open())을 한후, XMLHttpRequest객체가 서버에게 요청(send() )
		/* httpRequest.open('GET', 'hello.html', true); */
		httpRequest.open('GET', 'hello.html', true);
		httpRequest.send(null);
		
		function responseMsg() {
			//4단계 : 서버에서 응답한 결과를 처리
			// 서버에서 응답을 완료했고, 올바른 응답 결과가 날아온 경우
			if( httpRequest.readyState == 4 ) {
				if( httpRequest.status == 200 ) {
					
					//5단계 : 서버에서 날아온 응답 결과를 client 브라우저에 적용
					var msgView = document.getElementById("msgView");
					msgView.innerHTML = httpRequest.responseText;
				}
			}
		}
	
	}
</script>
</head>
<body>
	<h1>서버에서 받은 메세지</h1>
	<div id="msgView" style="height: 100px; width: 500px; border: 1px solid black"></div>
	<input type="button" value="서버에서 자료 요청" onclick="requestMsg()" />
</body>
</html>
````

* `httpRequest.onreadystatechange = responseMsg;`

  * onreadystatechange
    * 서버에서 응답이 도착했을 때 호출될 콜백함수 지정
    * 콜백함수는 상태(readyState)가 변경될 때 마다 호출

* `httpRequest.open('GET', 'hello.html', true);`

  * open 메소드
    * 요청의 초기화 작업
    * GET/POST 지정
    * 서버 URL 지정
    * 동기/비동기 설정

  ````javascript
  open("HTTP method". "URL", sys/asyn)
  ````


*   `httpRequest.send(null);`
  * SEND(content) 
    * GET 방식은 URL에 필요한 정보를 추가하기 때문이 null적용
    * POST 방식에서 파라미터 설정을 처리함
* `msgView.innerHTML = httpRequest.responseText;`
  * responseText
    * 서버의 응답결과를 문자열로 받기
  * responseXML
    * 서버의 응답결과를 XML Document로 받기



*   ver2

````javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	var httpRequest = null;

	function getXMLHttpRequest() {
		if (window.XMLHttpRequest) {    
			return new XMLHttpRequest();
		} else if (window.ActiveXObject) { 
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else {
			return null;
		}
	}

	function sendRequest(method, url, params, callback) {
		httpRequest.onreadystatechange = callback;
		httpRequest.open(method, url, true);
		httpRequest.send(params);
	}

	function requestMsg() {
		httpRequest = getXMLHttpRequest();
		sendRequest("GET", "hello.html", null, responseMsg);
	}

	function responseMsg() {
		if (httpRequest.readyState == 4 && httpRequest.status == 200) {
		
				var msgView = document.getElementById("msgView");
				msgView.innerHTML += httpRequest.responseText;
			
		}
	}
</script>
</head>
<body>
	<h1>서버에서 받은 메세지</h1>
	<div id="msgView"
		style="height: 100px; width: 500px; border: 1px solid black"></div>
	<input type="button" value="서버에서 자료 요청" onclick="requestMsg()" />
</body>
</html>
````

* `if (window.XMLHttpRequest) { `

  * IE 이외의 모든 부라우저 통해서 들어올 때

* `httpRequest.onreadystatechange = callback;`

  *  몇번이 오는지 4번이 오면 정상 작동

  

* ==JQuery 활용==

  * 요즘쓰는 방식임!

  ````javascript
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script  src = "http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script>
  	/* $(document).ready(function() {
  		$('#btn').click( function() {
  			$('#msgView').load('hello.html'); 
  		});
  	}); */
  
  	$(document).ready(function() {
  		// $('button').on("click", function() { 
  		$('#btn').click( function() {
  			$.ajax({
  				url: 'hello.html',
  				
  				success: function(data) {
  					$('#msgView').append(data); //  load('hello.html');
  				}
  			});
  		});
  	}); 
  </script>
  </head>
  <body>
  	<h1>서버에서 받은 메세지</h1>
  	<div id="msgView" style="height: 100px; width: 500px; border: 1px solid black;">
  	</div>
  	<input type="button" id="btn" value="서버에 자료요청" />
  </body>
  </html>
  ````

  



> 결과
>
> ![image-20200116095755587](../../../../혜/til/img/image-20200116095755587.png)
>
> ![image-20200116095809506](../../../../혜/til/img/image-20200116095809506.png)



#### 



#### readyState 

* 현재의 요청상태
* 0 :초기화 되지 않음. open 메소드가 아직 호출되지 않았음.
* 1 : 열기. open 메소드가 호출되었으나 send 메소드는 호출되지 않았음.
* 2 : 송신완료. send 메소드가 호출되었음. 요청이 시작되었음
* 3 : 수신 중, 서버가 응답을 보내는 중임.
* 4 : 수신완료. 서버가 응답을 다 보내고 작업을 완료했음



#### HTTP 응답 코드

* 200 : OK, 요청이 정상적으로 성공했음을 나타낸다.
* 302 : Moved Temporarily, 클라이언트가 요청한 리소스가 임시적으로 이동했으며 클라이언트가
  리소스에 접근하기 위해 현재의 URI를 반환해야 함을 나타냄. 클라이언트는 자동으로
  GET또는 HEAD 요청을 리다이렉트 할것이다.
* 400 : Bad Request, 클라이언트의 요청이 부정확한 형태이며 서버가 요청을 처리 할 수 없음
* 401 : Unauthorized, 클라이언트가 제공되지 않은 사용자 인증이 필요한 리소스를
  요청했거나 인증에 실패했음.
* 403 : Forbidden, 서버가 클라이언트의 요청을 이해하지만 클라이언트가 요청한 리소스의
  접근을 거절.
* 404 : Not Found, 요청된 URI에 리소스를 위치시킬수 없는 웹서버가 사용한다. (파일없음)
* 500 : Internal Server Error, 요청을 처리하는 서버나 리소스에 예기치 않은 에러가 발생하여
  요청을 처리할수 없음을 나타냄. <-- 거의 문법오류이거나 Exception의 경우...





* ajax 타입
  * 생략이 가능하다

```javascript
      $.ajax({
      url: 요청이 보내지는 곳,

        type: http요청 방식 get/post,

        dataType: data의 타입,

        data: 서버로 넘어갈 값, 

        success: http 요청 성공의 경우 동작할 함수,

        error: http 요청 실패의 경우 동작할 함수,

        complete: http 요청 완료 후 동작할 함수,

        global: 전역 함수 여부 true/false,

        async: 동기 여부 true/false

    });
```






