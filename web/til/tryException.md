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
  
  