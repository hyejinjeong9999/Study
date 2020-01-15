# 모듈

- #### 모듈

  - 미리 만들어진 코드를 가져와 쓰는 방법
  - import 모듈이름
  - 사용 방법: 모듈이름.모듈안의 구성요소

  ````python
  import math
  
  math.pi
  random.choice()
  ````

  

- import math

  - 수학과 관련된 기능

- import random

  - 무작위와 관련된 기능

- import urllib.request

  - 인터넷의 내용을 가져오는 기능



## datetime

* 날짜와 시간을 조작하는 클래스를 제공

````python
import date time
print(datetime.date.today())
````



## random

````python
import random
list = ["빨","주","노","초","파","남","보"]
random_element = random.choice(list)
print(random_element)
````

> list 에서 랜덤값 하나를 출력한다



* random.shuffle(x,[random])

  ````python
  import random
  list = ["빨","주","노","초","파","남","보"]
  random.shuffle(list)
  print(list)
  ````

  > list가 섞여서 나온다



* random.randint(a,b)

````python
import random
random.randint(a, b)
````

> a이상 b이하의 랜덤값 출력
>
> Return a random integer *N* such that `a <= N <= b`. 
>
> Alias for `randrange(a, b+1)`.