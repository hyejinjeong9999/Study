# 튜플

- 한번 정해진 순서를 바꿀 수 없다.

- 튜플 선언

  ````python
  tuple1 = (1, 2, 3, 4)
  
  tuple2 = 1, 2, 3, 4
  
  mylist = [1,2,3,4]
  tuple3 = tuple(mylist)
  ````

- 튜플은 값의 변경과 삭제가 불가능

* 튜플의 값 읽기

  ````python
  tuple1 = (11, 22, 33)
  for i in range( len( tuple1) ):
      print( tuple1[i] )
  ````

  * 튜플도 리스트와 마찬가지로 index로 값을 읽어올 수 있다

## packing, unpacking

#### packing

* 하나의 변수에 여러개의 값을 넣음
````python
x = 3
y = 5

position = x,y

print("x, y로 이루어진 튜플 position의 값은 {}입니다.".format(position))
````

> 결과 :  x, y로 이루어진 튜플 position의 값은 (3, 5)입니다.

#### unpacking

* 패킹된 변수에서 여러개의 값을 꺼내옴

````python

a = 1
b = 2

a, b = b,a

print("a : {}, b : {}".format(a, b))
````

> 결과 : a : 2, b : 1

````python
c = (3, 4)
d, e = c    # c의 값을 언패킹하여 d, e에 값을 넣었다
f = d, e    # 변수 d와 e를 f에 패킹
````

#### 튜플의 활용

- 두 변수의 값을 바꿀 때 임시변수가 필요 없다.
- 함수의 리턴 값으로 여러 값을 전달할 수 있다.



#### 튜플 리스트

````python
for a in enumerate(list):
    print('{}번째 값: {}'.format(a[0], a[1]))

for a in enumerate(list):
    print('{}번째 값: {}'.format(*a))
````



#### 튜플 딕셔너리

````python
for a in dict.items():
    print('{}의 나이는:{}'.format(a[0], a[1]))

for a in dict.items():
    print('{}의 나이는:{}'.format(*a))
````





> 