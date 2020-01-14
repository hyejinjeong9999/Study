# JS

#### 위치와 출력

* Script 태그 사이에 위치

```` html
<Script>
    document.write("Hello World");
</Script>
````

> *결과 : Helo World*



#### 대화상자 띄우기

1. **Alter**

   * 대화상자 띄우기 (메시지만 전달)

     ````javascript
     alert( 'Lorem ipsum dolor' );
     ````

     

2. **confirm**

   * 확인, 취소 창 

   * 확인 : true 취소 false 반환

     ````javascript
        var jbResult = confirm( 'Lorem ipsum dolor' );
           document.write( jbResult );
     ````

     

3. **prompt**

   * 사용자가 입력한 값 반환

   * 취소시 null 반환

     ```javascript
           var jbResult = prompt( 'Lorem ipsum dolor', '' );
           document.write( jbResult );
     ```

     



#### window.open("주소",이름,길이,replace)

* 새창을 띄운다

````javascript
window.open("ex07_for.html", "새창", "width=100, height=150");
	
````



#### 배열

````javascript
var fruite = ["apple", "banana","peach"];//선언1
doument.write(fruits[0]); //apple 호출
````

````javascript
var fruite = new array(); //선언 2
var fruite = new Array ("apple","banana","orange");//선언3
````



#### for문

````js
for(var i=0; i<5; i++){
    document.write("helloworld!");
}
````



#### while문

````javascript
var i=0;
while(i<10){
    document.write(i+"<br>");
    i++;
}

````

````javascript
var i=0;
do{
    document.write(i+"<br>");
    i++;
}while(i<10);
    

````







#### 변수와 상수

````javascript
var calculator; 
var num = 1;
const number = 42;
````

* 형태 관계 없이 var 사용
* 변수를 초기화 하지 않으면 undifined 값을 가지게 된다
* const :  상수 선언 (값 변경 불가능)



#### 함수

* function 함수명(){소스}

````javascript
	function myFunc() {
		alert("hello world javascript");
	}
````



#### Onload

* body부분이 시작하자마자 함수실행

````javascript
var str ='자바스크립트';

function varshow(){
		document.write("화면출력문자열");
	}
````

````html
<body onload = "show()">
</body>
````

> *출력결과 : 화면출력문자 자바스크립트* 









### 객체

````javascript
var person = {
			name: "홍길동",
			phone: "010-9872-0202",
			addr: "서울 서대문구 연희동",
			
			info : function() {
				alert("name : " + this.name + "\n"
					+ "phone : " + this.phone +"\n"
					+ "addr : " + this.addr 
				);
 	
	};
     
person.info();
````

* 객체 내 함수 선언

  ````javascript
  	함수명 : function() {}
  ````

  

> *출력결과* : ![image-20200113095404448](C:\Users\student\Desktop\혜\til\img\image-20200113095404448.png)
>
> !

​	

#### this의 생략형

````javascript
var person = {
			name: "홍길동",
			phone: "010-9872-0202",
			addr: "서울 서대문구 연희동",
			
			info : function() {
				var list = '';
					
				with(this) {
					list += "name : " + name + "\n";
					list += "phone : " + phone + "\n";
					list += "addr : " + addr 
				}

				alert(list);
			} // info end		
	};
````



````javascript
	function makePerson(name, phone, addr) {

		var person = {
			name : name,
			phone : phone,
			addr : addr,

			info : function() {
				var list = '';
				for ( var key in this) {
					if (key != 'info') {
						list += key + " : " + this[key] + "\n";
					}
				}// for end

				alert(list);
			}// info method end
		};

		return person;
	} // makePerson(name, phone, addr) end

	var p = makePerson("강감찬", "0000", "서울시");
	var p2 = makePerson("전두환", "8888", "경기");

	var person = [ p, p2 ]; // var 배열명 = [값1, 값2,...];
	person[0].info();
	person[1].info();
````



> *실행 결과*
>
> ![image-20200113103514843](혜/til/img/image-20200113103514843.png)
>
> ![image-20200113103530490](혜/til/img/image-20200113103530490.png)



* 1회용 객체 생성

  ````javascript
   person.push(makePerson("happy", "9999", "seoul"));
  	 person.push(makePerson("kingsmile", "8888", "busan"));
  	
  	 for(var i in person) {
  	 person[i].info();
  ````



> ![image-20200113103745427](혜/til/img/image-20200113103745427.png)
>
> ![image-20200113103757190](혜/til/img/image-20200113103757190.png)



### 연산자

#### ===`와 `==`===`

* `===`와 `==`는 같은 의미지만 `===`를 더 권장함
* `!==` 같지 않다 `!=` 아님!

#### 논리연산자

* && -  and
  * A&&B -> A가 거짓일 경우 B는 수행 안하고 빠져나온다
* || - or

* NOT - and - or 순으로 우선연산





#### 캔버스 (420p 참고)

````javascript
window.onload = function(){
	// Canvas DOM 객체 생성
	var canvas = document.getElementById('diagonal');
	//그리기 컨텍스트 생성
	var context = canvas.getContext('2d');

	// 선그리기 시작
	context.beginPath();
	// 시작좌표
	context.moveTo(70, 140);
	// 대각석 긋기
	context.lineTo(140, 70);

	// 선을 출력 
	context.stroke();
};
````



````html
<body>
	<canvas id="diagonal" width="200" height="200"></canvas>

</body>
````

* 2d스타일의 컨버스 생성 (2d만 가능하다)
* 200*200 컨버스를 생성

> *결과*
>
> ![image-20200113131134487](혜/til/img/image-20200113131134487.png)



#### D&D (514p)

* draggable

    ````html
    
    
    <div id="boxA" draggable="true" ondragstart="return dragStart(event)"></div>
    ````



* dragStart()

  * 사용자가 드래그를 시작할 때 발생

  ````javascript
  function dragStart(ev) {
  			document.getElementById("msg").innerHTML = "onDragStart->";
  		   ev.dataTransfer.effectAllowed='move';
  		   ev.dataTransfer.setData("Text", ev.target.id);
  		   ev.dataTransfer.setDragImage(ev.target,0,0);
  		   return true;
  		}
  ````

  



-> Jquary에 기본적으로 제공함





