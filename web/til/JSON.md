# JSON(502)

* JavaScript Object Notation
* 텍스트-기반의 데이터 교환 형식
* 이름 : 값 으로 구성
  * "이름" : "value"
* 예시

```json
{
    "name" : "HonggilDong",
    "age" : 25,
    "address":{
        "nation" :"Korea",
        "city" : "seoul",
        "postalCode" : "123-456"
        
    },
    "특기" : ["검술","무술"],
    "phone" : "010-123-4567"
    
}
```

* 객체

  * 이름과 값의 집합 

  ````json
  {"name":"Hong","age":"21"}
  ````

* 배열

  * []로 나타냄

    ````json
    [
        {"name":"Hong","age":"21"},
        {"name":"kim","age":"23"},
        {"name":"park","age":"25"}
    ]
    ````

    

#### 표의 출력

````json
"item" : [
				{"no" : "공지", "subject" : "Javascript 강의자료", "hit" : 3, "date" : "2013.10.29"},
				{"no" : 3, "subject" : "JQuery 강의자료", "hit" : 6, "date" : "2013.11.08"},
				{"no" : 2, "subject" : "AJAX 강의자료", "hit" : 15, "date" : "2013.11.07"},
				{"no" : 1, "subject" : "Oracle 강의자료", "hit" :19, "date" : "2013.11.05"}
			]
````



# JQuery(452p)

* 자바스크립트 라이브러리
* 자바스크립트 사용을 쉽게 하기 위해 사용
* [jquery](https://jquery.com/)에서 라이브러리 사용
* 사용방법
  * file link 방식 (인터넷 상황이 좋지 않은 경우)
  * CDN 방식 (인터넷 상황이 좋을 경우)
    * 네트워크를 통해 웹 페이지를 실행할때마다 다운받음
* 다운로드 파일의 종류
  1. Production(mini) : 소스를 압축, 공백, 주석을 없애서 용량 최소화
  2. development : 공백, 주석이 있어서  개발자가 소스읽기 쉬움



* 사용 방법

  * jquery - 다운로드 참고
   * CDN

      ````html
      <script
        src="https://code.jquery.com/jquery-3.4.1.slim.min.js">
        </script>

      ````
  * file link 방식
  
    ````javascript
    <script type="text/javascript" src="jquery-3.4.1.min.js">
    	
    </script>
    ````





````javascript
<script type="text/javascript">
   $(document).ready(function() {
      $('tr:even').css('backgroundColor', 'pink');
      $('tr:odd').css('backgroundColor', 'yellow');
   });
</script>

````



* 선언부

  ````javascript
  $(document).ready(function() {
  	$(selecotr).action();
  });
  ````

  * Document (dom)이
  * `.reade`준비가 되면
  * funcrion() : 함수를 정의한다 = 작업을 시작한다 = jQuery 메서드를 호출한다
  * $ : jQuery를 의미
  * selector : 선택자
  * `.action` 선택된 요소의 함수 호출

  



* 태그별 사용방법

  * 선택자

    ````javascript
    <script type="text/javascript" src="jquery-3.4.1.min.js">	
    </script>
    
    <script type="text/javascript">
    
    	$(document).ready(function() {
    		$('h1').hide();
            });
    </script>
    ````

    ````html
    <body>
    
    	<h1>이건 h1</h1>
        
    </body>
    ````

    > h1 클래스가 안보임

  

  * 클래스

    ````javascript
    
    ````

    ````html
    
    ````

    

  

  * 아이디

    ````javascript
    $(document).ready(function() {
    		
    		$('#id1').hide();
    		
    	});
    ````

    ````html
    <body>
    <h2 id="id1">아이디원</h2>
    </body>
    ````

    > h2의 id1 아이디를 가진 값이 안보임

  * 그 외 선택자

    * `$("*)` : 모든 요소 선택
    * `$(this)` : 현재 요소 선택
    * `$("p.myClass"`) : <p>요소 중에서 class = "myClass"인 요소
    * `$("p:first")` : 첫번째 <p> 요소
    * `$("div span")` : <div> 안에 포함된 <span> 요소
    * `$(":button")` :버튼과 버튼 타입 요소 모두 선택

* 여러개의 이벤트 표시하기



### 이벤트

* 화면에 표시하기

* 슬라이드 업 방식으로 표기

* 화면에서 감추기

* 클릭할때 이벤트

* mouseover

* focus

* blur

* 

  ````html
  
  ````

  