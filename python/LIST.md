# LIST

#### for문과의 활용

for value in list : 

list 값을 하나씩 꺼내 value에 저장

if문과의 활용

if value in list

value 값이 list에 들어있으면



#### 순차적인 값 채우기

````python
list4=list(range(20))
print(list4)

#0~19까지의 값
````





````python
#list 생성
list1 = [1,2,3,4,5]
print(list1)

#list 값2의 위치 출력
print(list1.index(2))

#list 뒤에 값 추가하기
list1.extend([1,2])
print(list1)

#5번째 위치에 값 추가
list1.insert(4,10)
print(list1)

#값을 순서대로 정렬
list1.sort()
print(list1)

#값을 역순으로 정렬
list1.reverse()
print(list1)

#list에 있는 값 확인하기_ 없으면 None

my_list = [5,6,7,8,9]
value = 3
if value in my_list : 
    print(my_list.index(value))
else : 
    print(None)
````

##### list.index(value)

 value 값을 이용해 위치를 찾음



##### list.extend([value1,value2])

리스트 뒤에 value 값 추가



##### list.insert[index, value]

index 위치에 value 값 추가



##### list.sort()

list 값을 순서대로 정렬

다른형태의 값이 들어있으면 정렬 불가능



##### list.reverse()

list 값을 역순으로 정렬

다른 형태의값이 들어 있으면 정렬 불가능



##### list.append(값)

* list의 뒤에 값을 추가함





#### 2중 리스트 활용

````python
commands = [[2,5,3],[4,4,1],[1,7,3]]
for num in commands :
    num
    #0 : [2,5,3]
    #1 : [4,4,1]
    #2 : [1,7,3]
    #로 list로 출력됨
    num[0]
    #2,4,1 로 하나씩 출력됨
````





## list와 문자열

* 리스트와 문자열은 유사하다
* 서로 변환이 가능하다

````python
str = "가 나 다 라"
print(str)
make_list=str.split()

print(make_list)

make_list.extend(["마","바","사"])
print(make_list)

make_str =" ".join(make_list)
print(make_str)
````



	#### list = str.split()

* 문자열에서 리스트로
* ()은 문자열을 자르는 기준을 의미



#### " ".join(list)

* 리스트에서 문자열로
* " "은 리스트를 공백을 기준으로 문자열화



#### slice

* 리스트나 문자열에서 값을 여러개 가져오는 기능

  ````python
  ##두번째~여섯번째 전 까지 반환
  text = "helloworld"
  text = text[1:5]
  print(text)
  
  #두번째~네번째 전자리까지 반환
  list = [0,1,2,3,4,5]
  list = list[1:3]
  print(list)
  
  # slice_step
  list3 = [4,5,6,7,8,9,10,11]
  print(list3[2:9:2])
  
  list4=list(range(20))
  reversed_list = list4[17:4:-4]
  print(reversed_list)
  
  del list5[ :5]
  print(list5) 
  
  list5[1:3] = [77,88]
  print(list5)
  
  list5[1:3]=[44,55,66]
  print(list5)
  
  list5[1:4]=[10]
  print(list5)
  ````

* `list[2:]`
  
  * 두번째부터 끝까지 반환
* `list[ :2]`
  
  * 처음부터 두번째 까지 반환
* `list[:]`
  
* 처음부터 끝까지 전부 반환
  
* `list[시작:끝:step]`
  * slice한 값의 범위에서 step 값을 주어 그 값만큼 건너뛰어 가져오는 기능
  * step에 - 입력하면 거꾸로 출력도 가능
* `del list [ :5]`
  
  * 처음부터 다섯번째 까지 삭제
* `list [1:3] = [77,88]`
  
  * list의 1,2위치에 있는 값을 77,88로 변환
* `list[1:3]=[77,88,99]`
  
  * 더 많이 추가 할 수 있음
* `list[1:4]=[8]`
  
  * 더 적게 추가할 수 있음





#### List Comprehension

- 파이썬의 유용한 도구
  - 예1 `[ i*i for i in range(1,11) ] # [ 계산식 for문 ]`
  - 예2 `[ i*i for i in range(1,11) if i % 2 == 0 ] # [ 계산식 for문 조건문 ]`
  - 예3 `[ ( x, y ) for x in range(15) for y in range(15) ] # [ 계산식 for문 for문 ]`



````python
1부터 100 사이의 8의 배수
list1 =[i for i in range(8,100,8)]
list1 = [i for i in range(1,101) if i%8==0]
````

