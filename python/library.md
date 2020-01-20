# library

## datetime

* 날씨와 시간을 사용하게 해주는 라이브러리

  ````python
  start_time = datetime.datetime(2016, 2, 1)
  ````

  ````python
  #christmas_2016 = 2016년 12월 25일
  import datetime
  christmas_2016 =datetime.datetime(2016,12,25)
  
  ````

* 현재 날짜 구하기

  ````python
   datetime.datetime.now()
   (datetime.datetime.now()).days #day형식으로 형변환이 필요할때
  ````



## timedelta

* 시간의 연산을 가능하게 해주는 클래스

````python
import datetime
addtime = datetime.timedelta(days = 10)
datetime.datetime.now() + addtime    # 10일 후
datetime.datetime.now() - addtime    # 10일 전

thedate = datetime.datetime.now().replace(hour = 10, minute=0, second = 0)
          + datetime.timedelta(days = 3)       # 3일 후 10시 정각
````

