# AJAX/ Jquery

#### AJAX 

*  Asynchronous JavaScript and XML

* 비동기적으로 서버와 브라우저가 데이터를 교환하는 통신방식

* Web에서 화면을 갱신하지 않고 Server로부터 Data를 가져오는 방법

  * 웹페이지 일부만 갱신

* json , xml을 이용

  * xml로 쓰면 코드가 길어지므로 주로 json을 사용

    ##### JSON

    * 경량의 DATA 교환 형식
    * xml을 대체해 데이터 전송 등에 많이 사용됨
    * name - value 형식의 쌍으로 존재한다
    * 배열,리스트 형식으로 실현 가능 `[]`


```json

{
  "firstName": "Kwon",
  "lastName": "YoungJae",
  "email": "kyoje11@gmail.com",
  "hobby": ["puzzles","swimming"]
}
```


* JQuery 문법을 사용

> AJAX라는 통신 형식을 작성하는 언어는 Jquery
>
> 서버와 클라이언트는 서로 다른 언어를 사용하기 때문에 Json형식으로 바뀌어서 교환한다



## Jquery

* 자바스크립트의 생산성을 향상시켜주는 자바스크립트 라이브러리

* 사용방법

````jsp
<script src = "jquery..js"></script> //주소
<script src = "/mvc/resources/jquery.js"></script> //파일명
<script
		src="<%=request.getContextPath()%>/resources/jquery-3.2.1.min.js"> //파일명2
</script>
````

#### 	기본태그

* 이미지 삽입

    ````jsp
    <img src="http://localhost:8081/mvc/resources/images/google.png">
<img src = "/mvc/resources/images/이미지파일명">
    <img src="<%=request.getContextPath()%>/resources/images/google.png">
    ````
    
    * `<%=request.getContextPath()%>` 이전의 주소값 찾아오기
    
* 태그

    ````jsp
        <h1>이미지를 보는 중입니다</h1>
        <h1 id = 'me'>이미지를 보는 중입니다</h1>
        <h1 class = "c">이미지를 보는 중입니다</h1>
    ````

    * 기본 `<태그>`
    * 아이디 `<태그 id = 'ID명'>`
    * 클래스 `<태그 class = "Class명">`

* 함수

    ````jsp
    <script>
        $("h1").css("color", "blue");
        $("#me").css("color", "red");
        $("div#result")
        # = 아이디
        $(".c").css("color", "green");
        .클래스
        ${} jsp el
    </script>
    ````

    * `$(선택자).함수명(매개변수);`
    * `$("h1").css("color", "blue");`
    * h1태그 전체 글자색 생상을 파란색으로 하는 css
    * ` $("#me").css("color", "red");`
        * id가 me인 태그를 찾아 색상을 빨간색으로 변경
    * ` $("div#result")`
        * div태그들 중에 ID가 result인 값
    * ` $(".c").css("color", "green");`
        * c클래스를 찾아 글자색상을 초록색으로 변경

* 버튼

    ````jsp
    <input id = "btn" type = button value = "클릭">
    <script>
     var cnt = 1;
    $("#btn").on('click',function(){
    			$("#result").append("<h3>추가" + cnt++ + "</h3>");
    </script>
    ````

    * html

      * 일반 html형식
        * 버튼을 누르면 cnt++가 되면서 값 출력
      * 추가1

    * test

      * html코드를 출력해줌
      * `<h3>` 그대로 출력되고 cnt는 값이 나옴
      * `<h3>추가 1</h3>`

    * append

      * 누적되어서 출력

      * 추가 1 (클릭)

        추가2 (클릭)

        추가3

        .....

* form

```jsp
<!-- 기본 submit 형태-->
<form action = "주소" method = "post">
<input type = submit value = "수정"> 
</form>

<!-- 일반 버튼으로 submit 형식만들기-->
<input id = "btn2" type = button value = "전송">

<script>
	
	$("#btn2").on('click',function(){
	location.href = "/a";   // /a로 이동
	location.href = "/a?a=" + $("#a2").val(); //a2 아이디의 value값을 받아 전송
	$("from").action = "/b"; //b로 변경
	$("form").submit(); //submit의 버튼 역할을 해라	
		
	});
  </script>
```







---

## ajax



* ajax형식으로 로그인창만들기
* Controller.java

````java
//맨 처음 나오는 부분
@RequestMapping("/ajaxtest")
	public String ajaxtest() {
		return "ajax";
	}

	@RequestMapping(value = "/ajaxlogin2", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String ajaxlogin2(String id, String pw) {
		boolean status = false;
		String logintime ="-";
		
		if(id.equals("ajax")&& pw.equals("ajax")) {
			status = true;
			logintime = new java.util.Date().toLocaleString(); 
		}
		
		return "{\"status\" :" + status + ",\"time\":\""+ logintime + " \"}";
		
				
				//string : view dlfma
				//redirect : 다른 url 호출
				//@ResponseBody : 이 string은 현재 body에 추가할 내용이야! 새로운 view가 아냐!
				//json형식으로 만들어 줘야함
	}
````

* ajax.jsp

````jsp
<form action="/mvc/ajaxlogin">
	아이디<input type=text name="id" id="id"><br> 
    암호 <input type="password" name="pw" id="pw"><br> 
	<input id = "ajaxbtn" type=button value="ajax로그인">
</form>

<!--구현부-->
<script>
	$("#ajaxbtn").on('click',function(){
		$.ajax({
			url: '/mvc/ajaxlogin2' ,
			data: {'id':$("#id").val(),'pw':$("#pw").val()}  ,
			//서버에서 request.getParameter("id") 라고 읽히기위한 것
			type:"get" ,
				//get : 주소에 변수 보임 post : 안보임
			dateType:'json' ,
			success: function(serverdata){
				$("div").html(serverdata.status + " - " + serverdata.time);
				$("div").css("color" , "red");
				$("div").css("border", "2px solid blue");	
			}
		}); //ajax 요청
	});
	
````

* `$("#ajaxbtn").on('click',function(){`
  * ajaxbtn을 클릭하면 함수 실행
* `$.ajax({`
  * ajax 구현부
* `url: '/mvc/ajaxlogin2' ,`
  * `mvc/ajaxlogin2?id=~~~~pw=~~~~'`의 형식
  * form에서 id와 pw값을 받아옴
* `data: {'id':$("#id").val(),'pw':$("#pw").val()}  ,`
  * 서버에서 `request.getParameter("id")`라고 읽힘
* `type:"get" ,`
  * get방식 post 방식 설정
  * get : 주소에 입력한 값이 보인다
  * post : 보이지 않는다
* `dateType:'json' ,`
  * json 방식
* `success: function(serverdata){`
  * ajax실행시 함수 실행
* `$("div").html(serverdata.status + " - " + serverdata.time);`
  * 상태 - 시간

![image-20200206201923119](Study/Study/md_img/image-20200206201923119.png) ![image-20200206201938095](Study/Study/md_img/image-20200206201938095.png)



responseBody

없을 때string 형태로 리턴이 될 때 다 view

있을 때 ajax 형식 결과는 json으로 보냄



seccess

function(server){

server.status}







json 코드르 자동변환

mvnRepository - jackson-databind  - 2.10.2

pom.xml의 dependencies 태그에  추가

````xml
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.10.0</version>
</dependency>

````

자바에서 만들어진 객체 형태를 제이슨 형태로 자동 변환

return으로 자바객체로 주면 클라이언트에서는 jason형태로 가짐





