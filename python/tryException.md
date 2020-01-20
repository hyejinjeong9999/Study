# try exception

* 예외처리

  * 기본
  
  ````python
  try:
      # 에러가 발생할 가능성이 있는 코드
  except Exception: # 에러 종류
    #에러가 발생 했을 경우 처리할코드
  ````
  
  
  * 오류를 알 수 없을 때
  
  ````python
try:
      # 에러가 발생할 가능성이 있는 코드
  except Exception as ex: # 에러 종류
      print('에러가 발생 했습니다', ex) # ex는 발생한 에러의 이름을 받아오는 변수
  ````
  
  
  
* raise 

  * 사용자가 직접 에러를 발생시킴
````python
shops = {
    "송일문방구": {"가위": 500, "크레파스": 3000},
    "알파문구": {"풀": 800, "도화지": 300, "A4용지": 8000},
    "다이소": {"풀": 500, "목공본드": 2000, "화분": 3000}
}
try : 
    for shop, products in shops.items():
        for product, price in products.items():
            if product =='풀':
                print("{}: {}원".format(shop, price))
                raise StopIteration
                   
except StopIteration : 
    print("처리완료")
````

  

#### 예외 정의

- 사용자가 직접 예외처리를 하면 코드의 직관성을 높일 수 있다.
- 파일을 하나 만들어 예외를 정의
- Exception 클래스를 상속받아 만든다

````python
class BadUserName(Exception):             # 이름에 대한 예외처리
class PasswordNotMatched(Exception):      # 패스워드에 대한 예외처리

try:
    sign_up( )
except BadUserName:
    print( "이름으로 사용할 수 없는 입력" )
except PasswordNotMatched:
    print( "입력한 패스워드 불일치")
````



````python
class MyException(Exception): #내 예외 만들기
    pass

shops = {
    "송일문방구": {"가위": 500, "크레파스": 3000},
    "알파문구": {"풀": 800, "도화지": 300, "A4용지": 8000},
    "다이소": {"풀": 500, "목공본드": 2000, "화분": 3000}
}

try:
    for shop, products in shops.items():
        for product, price in products.items():
            if product == '풀':
                print("{}: {}원".format(shop, price))
                raise MyException
except MyException:
    print("풀을 찾았습니다.")
````

