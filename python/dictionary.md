# Dictionary

* 여러 값을 저장해 두고 필요한 값을 꺼내 씀

* 이름표를 이용하여 값을 꺼내 사용

* 사용할 때는 리스트와 비슷한 방식

  ````python
  wintable = {
      '가위' : '보',
      '바위' : '가위',
      '보' : '바위',
  }
  
  print(wintable['가위'])
  ````

  

* 리스트로도 제작이 가능

  ````python
  dict = {     "이름표"    :    [1,2,3] }
  print( dict["이름표"] )
  ````

  

>  [1, 2, 3]

* dictionary 추가/삭제/수정

  ````python
  dict= {'one' : 1, 'two' : 2}
  dict['three'] = 3   # 값을 추가
  dict['one'] = 11     # 값을 수정
  del(dict['one']) 	#값 삭제
  dict.pop('two')		#값 삭제2
  ````

* 업데이트

  ````python
  dict1 = {1 : 100, 2 : 200}
  dict2 = {1 : 1000, 3 : 300}
  dict1.update(dict2)       
  #{1 : 1000, 2 : 200 : 3 : 300}
  ````

  

* 값 가져오기

  

  ````python
  ages = {'Tod' : 35, 'Jane' = 23, 'Paul' : 62}
  
  for key in ages.keys():      # keys() 생략 가능
      print(key)              
      
      # Tod, Jame, Paul 출력
  
  for value in ages.values():
      print(value)
      
      # 62, 23, 35
      
  for key, value in ages.items():
      print('{}의 나이는 {} 입니다'.format(key, value))
  ````

* 조건에 맞는 값 처리

  ````python
          if "key값" in dict.keys():
              조건문
  ````


* 전체 가져오기

````python
ages = {'Tod' : 35, 'Jane' : 23, 'Paul' : 62}
for a in ages.items():
    print('{}의 나이는:{}'.format(*a)) 
````





### LIST와 Dictionary

|               |        List        | Dictionary                  |
| :-----------: | :----------------: | --------------------------- |
|   **생성**    | list = [ 1, 2 ,3 ] | dict = { 'one':1, 'two':2 } |
|   **호출**    |     list[ 0 ]      | dict[ 'one' ]               |
|   **삭제**    |  del( list[ 0 ] )  | del( dict[ 'one' ] )        |
| **개수 확인** |    len( list )     | len( dict )                 |
|  **값 확인**  |     2 in list      | 'two' in dict.keys( )       |
| **전부 삭제** |   list.clear( )    | dict.clear( )               |



|          |                          List                          | Dictionary                                      |
| :------: | :----------------------------------------------------: | ----------------------------------------------- |
| **순서** | 삭제 시 순서가 바뀌기 때문에 인덱스에 대한 값이 바뀐다 | key로 값을 가져오기 때문에 삭제 여부와 상관없다 |
| **결합** |                     list1 + list2                      | dict1.update( dict2 )                           |

