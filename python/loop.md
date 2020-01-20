# 반복문

## for

#### enumerate

- 반복문 사용 시 몇 번째 반복문인지 확인이 필요할 때

- 인덱스 번호와 컬렉션의 원소를 tuple형태로 반환

  ````python
  t = [1, 5, 7, 33, 39, 52]
  for p in enumerate(t):
       print(p)
  //결과
  (0, 1)
  (1, 5)
  (2, 7)
  (3, 33)
  (4, 39)
  (5, 52)
  ````

  ````python
  for i, v in enumerate(t):
  	print("index : {}, value {}".format(i,v))
  //결과
  index : 0, value: 1
  index : 1, value: 5
  index : 2, value: 7
  index : 3, value: 33
  index : 4, value: 39
  index : 5, value: 52
  ````

  

## while

* 조건이 참일 경우 계속 실행하는 반복문

  ````python
  while selected not in ['가위', '바위', '보']:
      selected = input('가위, 바위, 보 중에 선택하세요>')
  ````

  ````python
  
  numbers = [1,2,3]
  length = len(numbers)
  i = 0
  while i<length:
      print(numbers[i])
      i = i + 1
  ````

  > 결과 :  1 2 3



#### break

* 반복문 종료

````python
sizes = [33,35,34,37,32,35,39,32,35,29]
for i,size in enumerate(sizes):
    if size == 32:
        print("사이즈 32인 바지는 {}번째에 있다.".format(i+1))
        break;
````





#### continue

* 반복문의 나머지 부분을 보지 않고 반복문의 처음으로 돌아가는 기능

````python
for i in range(10):
    if i % 2 ==0:
        continue
    print(i)
````

