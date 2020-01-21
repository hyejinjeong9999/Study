# Session



* 세션 : 서버에 저장된 것
* 쿠키 : 클라이언트에 저장된 것
  * 증권 홈페이지에 ~님 : 마지막 접속한 시간 -> 쿠키이용

* 로그인 한 후 내 정보가 따라다니는 것
  * ~님 어서오세요
* setAttribute(변수명,데이터값);

* 데이터를 변수에 저장해서 뿌리는 중

````jsp
<%session.setAttribute("msg", "Session Test"); %>
````

```jsp
<h3>${sessionScope.msg} }</h3>
```

* session text라는 값을 msg에 저장해서 sessionscope로 보여줌



* getAggribute
  * 가져오는거
* param은 사용안됨 (param은 일회성인데 session은 계속 남아있어야함)

