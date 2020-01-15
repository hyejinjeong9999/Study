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

* 축약형

  ````html
  <script>
  	$(function(){});
  </script>
  ````

  

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
    $(function()){
      $('.region').show();
    });
    ````
    
    ````html

    ````
    
    * region 클래스를 보여주기

  

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




### 셀렉터

* 문서 내에서 원하는 엘리먼트를 쉽게 식별하고 이를 추출하기 위해 JQuery에서 제공

#### 기본 CSS 셀렉터

| 셀렉터   | 설명                                                         |
| -------- | ------------------------------------------------------------ |
| *        | 모든 엘리먼트와 일치                                         |
| E        | 태그명이  E인  모든 엘리먼트와  일치                         |
| E  F     | E의  자손이면서 엘리먼트의  이름이 F인  모든 엘리먼트        |
| E>F      | E의  바로 아래 F 엘리먼트                                    |
| E+F      | E의  형제 엘리먼트로  바로 다음 형제 F 엘리먼트              |
| E~F      | E의  형제 엘리먼트로  다음에 나오는 모든 F 엘리먼트          |
| E:has(F) | 엘리먼트  F의  자손을 하나 이상 가지고 있는 E 모든 엘리먼트  |
| E.C      | 클래스명  C를  가지고 있는 모든 E 엘리먼트.                  |
| *.C      | 클래서명  C를  가지고 있는 모든 엘리먼트                     |
| E#I      | 아이디가 I  인 모든 E  엘리먼트.                             |
| *#I      | 아이디가 I인 모든 엘리먼트                                   |
| E[A]     | 어트리뷰트  A를  가지는 모든 E 엘리먼트                      |
| E[A=V]   | 어트리뷰트  A의  값이 V인  모든 E 엘리먼트                   |
| E[A^=V]  | 어트리뷰트  A의  값이 V로  시작하는 모든 E 엘리먼트          |
| E[A$=V]  | 값이 V로 끝나는 어트리뷰트 A를 가지고 있는 모든 E 엘리먼트   |
| E[A*=V]  | 값에 V를 포함하는 어브리뷰트 A를 가지고 있는 모든 E 엘리먼트 |

* `<img src = " ">`
  * img = E 
  * scr = A
  * V = " "
* `$` : 끝난다
* `* ` :포함한다



#### 위치기반 셀렉터

| 셀렉터           | 설명                                                         |
| ---------------- | ------------------------------------------------------------ |
| :first           | 페이지에서 처음으로 일치하는 엘리먼트를  반환한다.           |
| :last            | 페이지에서 마지막으로 일치하는 엘리먼트를  반환한다.         |
| :even            | 페이지 전체의 짝수 번째 엘리먼트를  반환한다.                |
| :odd             | 페이지 전체의 홀수 번째 엘리먼트를  반환한다.                |
| :eq(n)           | n번째로  일치하는 엘리먼트를  반환한다.                      |
| :gt(n)           | n번째  엘리먼트(포함하지 않음)  이후의 일치하는 엘리먼트를 반환한다. |
| :lt(n)           | n번째  엘리먼트(포함하지 않음)  이전의 일치하는 엘리먼트를 반환한다. |
| :first-child     | 첫 번째 자식 엘리먼트를 반환한다.                            |
| :last-child      | 마지막 자식 엘리먼트를 반환한다.                             |
| :only-child      | 형제가 없는 모든 엘리먼트를  반환한다.                       |
| :nth-child(n)    | n번째  자식 엘리먼트를  반환한다.                            |
| :nth-child(even) | 짝수 자식 엘리먼트를 반환한다.                               |
| :nth-child(old)  | 홀수 자식 엘리먼트를 반환한다.                               |
| :nth-child(Xn+Y) | 전달된 공식에 따른 n번째  자식 엘리먼트를  반환한다. Y는  0인  경우 생략 가능하다. |



#### JQuery 정의 필터 셀렉터

| 셀렉터         | 설명                                                         |
| -------------- | ------------------------------------------------------------ |
| :animated      | 현재 애니메이션이 적용되고 있는 엘리먼트를  선택한다.        |
| :button        | 모든 버튼을 선택한다(input[type=submit],  input[type=reset], input[type=button], button). |
| :checkbox      | 체크박스 엘리먼트만 선택한다.                                |
| :checked       | 선택된 체크박스나 라디오 버튼만을 선택한다(CSS에서  지원).   |
| :contains(foo) | 텍스트 foo를 포함하는 엘리먼트만 선택한다.                   |
| :disabled      | 인터페이스에서 비활성화 상태인 모든 폼 엘리먼트를  선택한다(CSS에서  지원). |
| :enabled       | 인터페이스에서 활성화 상태인 모든 폼 엘리먼트를  선택한다(CSS에서  지원). |
| :file          | 모든 파일 엘리먼트를 선택한다(input[type=file]).             |
| :header        | 헤더 엘리먼트만 선택한다.  예를 들어<h1>부터 <h6>까지의 엘리먼트를 선택한다. |
| :hidden        | 감춰진 엘리먼트만 선택한다.                                  |
| :image         | 폼 이미지를 선택한다(input[type=image]).                     |
| :input         | 폼 엘리먼트만 선택한다(input,  select, textarea,  button).   |
| :not(filter)   | 필터의 값을 반대로 변경한다.                                 |
| :parent        | 빈 엘리먼트를 제외하고,  텍스트도 포함해서 자식 엘리먼트를  가지는 엘리먼트를  선택한다. |
| :password      | 패스워드 엘리먼트만 선택한다(input[type=password]).          |
| :radio         | 라디오 버튼 엘리먼트만 선택한다(input[type=radio]).          |
| :reset         | 리셋  버튼을 선택한다(input[type=reset]  이나 button[type=reset]). |
| :selected      | 선택된 엘리만트만 선택한다.                                  |
| :submit        | 전송 버튼을 선택한다(button[type=submit]  이나 input[type=submit]). |
| :text          | 텍스트 엘리먼트만 선택한다(input[type=text]).                |
| :visible       | 보이는(visible)  엘리먼트만  선택한다.                       |



### 이벤트

* 슬라이드 업 방식으로 표기

* 클릭할때 이벤트

  

#### 마우스 이벤트

* mouse over

  * 마우스를 가져다 대면 시작되는 이벤트

    ````javascript
        $("div.out").mouseover(function(){
           
            $("p:last",this).text(++i);
    
        });
    ````

    

    ````html
    <style type="text/css">
    
    div.out {
    	width: 200px;
    	height: 60px;
    	background-color: yellow;
    }
    </style>
    <script type="text/javascript" src="jquery-3.4.1.min.js">
    </script>
    
    
    </head>
    <body>
    
    <div class = "out">
    <p> 마우스를 여기로 움직이세요!</p>
    <p>0</p>
    </div>
    <script>
        var i = 0;
        $("div.out").mouseover(function(){
            $("p:first",this).text("mouse over");
            $("p:last",this).text(++i);
    
        });
    
    </script>
    
    
    </body>
    ````

    * `$("div.out").mouseover(function(){`
      * mouseover 하면 function이 실행됨
    * `$("p:first",this).text("mouse over");`
      * p의 첫번째 요소를 mouse over 라는 텍스트로 바꿈
    * `$("p:last",this).text(++i);`
      * p의 마지막 요소를 계속 증가하는 i로 변경

    > ![image-20200114103121016](../../../../혜/til/img/image-20200114103121016.png)![image-20200114103135729](../../../../혜/til/img/image-20200114103135729.png)





#### blur와 focus

* `$(selector).focus(function(){});`

  * 키보드포커스가 생기면 실행하는 이벤트

* `$(selector).blur(function(){});`

  * 키보드 포커스를 읽으면 발생하는 이벤트

  ````html
  <script>
      $(document).ready(function(){
          $("input").focus(function(){
              $(this).css("background-color","yellow");
          });
          $("input").blur(function(){
              $(this).css("background-color","white");
          })
  
      })
  </script>
  </head>
  <body>
      아이디 : <input type="text" name="name"><br>
  </body>
  ````

* `$(document).ready(function(){`
  
  * 이벤트를 호출할 준비가 됨
*  `$("input").focus(function(){`
  
  * input 셀렉터에 키보드 포커스가 들어오면
*  `$(this).css("background-color","yellow");`
  
  * 배경색을 노랑으로 바꾼다
* `$("input").blur(function(){`
  
  * input 셀렉터에 키보드 포커스가 사라지면
* `$(this).css("background-color","white");`
  
  * 배경색을 흰색으로 바꾼다

> 실행결과
>
> ![image-20200114104023380](../../../../혜/til/img/image-20200114104023380.png) ![image-20200114104038213](../../../../혜/til/img/image-20200114104038213.png)



#### css

* `$(selector).css("background-color","white");`
  * 색깔을 변경하는 이벤트



#### 마우스 위치 반환

* `$(document).mousemove(function(e){})`

  * 마우스를 움직일때 이벤트가 실행된다

* `e.pageX`, `e.pageY`

  * e의 X와Y좌표를 구함 

  ````html
      <style>
          body{background-color:brown;}
          div{padding:20px};
      
      </style>
  <script>
    
      $(document).mousemove(function(e){
          $("#log").text("e.pageX : "+ e.pageX + ", e.pageY : " + e.pageY);
  
      });
  
     
  </script>
  </head>
  <body>
      <div id = "log"></div>
    
  </body>
  ````

* ` $(document).mousemove(function(e){`
  
  * 마우스가 움직일때 이벤트가 시작된다
* ` $("#log").text("e.pageX : "+ e.pageX + ", e.pageY : " + e.pageY);`
  
  * id가 log인 값에 e의 X값과 Y값이 출력되도록 한다

> 실행결과
>
> ![image-20200114110052972](../../../../혜/til/img/image-20200114110052972.png)

#### 

#### show, hide, toggle

* `$(selector).show(duration,complete)`
  * 선택된 요소를 화면에 표시한다
* `$(selector).hide(duration,complete)`
  * 선택된 요소를 화면에 숨긴다

````html
   <script type="text/javascript" src="jquery-3.4.1.min.js">
    </script>
    <script>
        $(document).ready(function () {
            $("button").click(function () {
                $("#dog").show("slow");
            })
        })
    </script>
</head>
<body>

    <button>show it</button>
    <img id="dog" src="dog.jpg" alt="" width="120" height="100" style="display : none" />

</body>
````

* `$(document).ready(function () {`
  * function을 실행할 준비가 되어 있음
* ` $("button").click(function () {`
  * button을 클릭하면 function을 실행함
* ` $("#dog").show("slow");`
  * id dog(이미지) 를 느리게 나타낸다

> 실행결과
>
> ![image-20200114111747504](../../../../혜/til/img/image-20200114111747504.png) ![image-20200114111807602](../../../../혜/til/img/image-20200114111807602.png)

* `$(selector).toggle()`
  * 요소가 감추어 있으면 표시, 요소가 나타나 있으면 숨김

````html
 <script>
        $(document).ready(function () {

            $("button").click(function () {

                $("#dog").toggle();
            })
        })
    </script>
````

> 실행결과 
>
> ![image-20200114112216302](../../../../혜/til/img/image-20200114112216302.png)
>
> show it을 누르면 사라졌다/ 나타났다 가능함



#### 버튼관련 이벤트

````html
<script type="text/javascript">

		$(function () {
			var msg = "";
			$("#add").click(function () {

				msg += $("#name").val() + ", " + $("#age").val() + "\n";
				//#name value 가져오고 age value 가져와서 msg에 저장
				$("#result").val(msg);
				//result에 msg출력

			});

			$("#clear").click(function () {
				msg = "";
				$("#result").val(msg);
			});
		});


	</script>

</head>

<body>

	이름 : <input type="text" id="name"><br>
	나이 : <input type="text" id="age"><br>
	<br>

	<div class="btn_group button">
		<button class="test_btn1" type="button" id="add">
			input</button>

		<button class="test_btn2" type="button" id="clear"> clear</button>
	</div>
	<br>
	<form>
		<textarea rows="20" cols="50" id="result"></textarea>
	</form>
</body>

````

> 결과
>
> ![image-20200114164306896](../../../../혜/til/img/image-20200114164306896.png)

#### fadeIn/out

* `$(요소).fadeIn( [duration ] [, easing ] [, complete ]`

  *  선택한 요소를 서서히 나타나게 함

* `$(요소).fadeOut( [duration ] [, easing ] [, complete ]`

  * 선택한 요소를 서서히 사라지게 함

* duration : 완전히 나타날때까지의 시간

  * 1000 = 1초
  * 'fast' = 200 / 'slow'= 600 / 'blank' = 400

* easing

  * 사라지는 모양
  * 'swing' / 'linear'

* complete

  * 지정한 요소가 나타난 다음 불러올 함수

    ````javascript
    .fadeIn(function() {
      // function
    })
    ````

      ````javascript
      //h1 요소가 나타남

      $( document ).ready( function() {
              $( 'h1.fi' ).fadeIn( 2000 );
            } );
      ````

       ````javascript
      //2초 후에 h1 요소가 나타나나고 글자가 빨간색으로 변함  
        $( document ).ready( function() {
                $( 'h1.fi' ).fadeIn( 2000, function() {
                  $( this ).css( 'color', 'red' );
                } );
              } );
       ````



#### custom 태그

* animate

  ````javascript
  	<script>
  		$(function(){
  
  			$('#btn').click(function(){
  				$('#first').slideToggle('show')
  
  			});
  
  			$('span.more').click(function(){
  
  				$('#moreRegion').animate({
  					//json방식으로 입력 var obj = {필드 : 값, 필드, 값의 형식}
  					
  					left : "300px", //왼쪽으로 옮기기
  					opacity : "0.2", //투명도  1에 가까울수록 불투명하다
  					height : "200px", //높이
  					width : "200px", //너비
  
  					
  
  				},'slow');
  			});
  			//animate : 커스텀 태그, 
  		});
  	</script>
  ````

  ````html
  		
  </head>
  <body>
  <input type="button" id="btn" value="누르면 노란창">
  	<div id="first" style="display: none;background-color:gold;height: 100px">
  		First
  	</div>
  	<hr>
  	<span class="more">누르면 투명해져요</span>
  	<div id="moreRegion" style="background-color: red ;height: 100px;width: 100px;position: absolute;">
  		첫번째
  	</div>
  ````

