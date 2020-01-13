# CSS



##### 기본양식

````html
<style type="text/css">
    
</style>
````



##### id

* id가 클래스보다 우선순위가 더 높다

`````html
<style type="text/css">
#aa{margin : 100px;}
</style>

<div id = "aa">아이디 사용방법 </div>
`````




##### 클래스

* .className {속성 : 값; 속성2 : 값;...}

````html
<style type="text/css">
.accent {
	font-size: 20px;
	color: red;
	font-weight: bold;
}
</style>

<span calss="accent">클래스 사용 방법</span>
````

* 태그 내 클래스

````html
<style type="text/css">
    h1.hihi{color :pink;}
</style>

<h1 class = "hihi">태그 내 클래스 사용</h1>
````

* 클래스 내 태그

````html
<style type="text/css">
.navi ul {
	list-style : none;
	height: 40px;
	padding-top: 10;
	padding-bottom: 5px;
}

.navi ul li {
	float: left;
	font-size: 15px;
	margin:20px;
}
</style>
````



##### 선택자

* 속성을 다중값으로 입력

````html
<style type="text/css">

body, h1, p {
	backgraound-color: yellow;
}
</style>
````



> **==우선순위는 ID > 클래스 > 선택자==**





#### 
