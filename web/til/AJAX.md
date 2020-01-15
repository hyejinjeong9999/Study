# AJAX

* **A**synchronous **J**avaScript **a**nd **X**ML 의 약자 (비동기 자바스크립트)
* 자바스크립트를 이용해서 비동기식으로 서버와 통신하는 방식. 이 때 XML을 이용한다.
* 꼭 XML을 이용할 필요는 없고, 최근에는 json을 더 많이 이용한다.
* ==비동기식==이란 여러가지 일이 동시적으로 발생한다는 뜻으로, 서버와 통신하는 동안 다른 작업을 할 수 있다는 의미.
* 동기식 : 

* AJAX를 하려면 서버를 무조건 구동해야 함 
  * 서버를 통해서 실행된다
* 사용 남발은 하지 말 것
* 요즘은 JQuery AJAX를 사용
* 



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
