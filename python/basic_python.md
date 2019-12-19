## 파이썬 기초

## 0. 설치

* 파이썬 3.8.0 설치

* 깃 대시에

```bash
$ python --version
Python 3.8.0

```

​	나오면 설치 완료

* numbers.py , text.py

* .gitignore폴더 생성 후 

  ```bash
  __pycache__/
  
  ```

  기입

  ->'/' 디렉토리 의미 : 아래에 있는 모든 파일에 해당

* 깃에 python numbers.py 검색하면 실행됨

* VS Code에서 bash창 띄우기
  
  * ctrl + shift + `



## 1. 저장

* 숫자

```python
#1. 숫자
#파이썬은 따로 자료형을 선언할 필요가 없다

a = 7

b = 3

print(a) #기본 출력

print(a+b) #더하기

print (a -b) #뺄셈

print(a * b) #곱셈

print (a/b) #나누기

print(a//b) # 몫만 출력

print(a%b) #나머지 
#짝수 / 홀수 판별
# 값 %2 ==0 짝수 값$2==1 홀수

```



* 글자

```python
'''
주석문

String 조작하기

1. 글자 합체

2. 글자 삽입(수술)

3. 글자 자르기


'''
#1. 글자 합체


hphk = "happy"
hp1 = 'happy'
 # "나" '' 둘 다 상관 없음

hp2 = "happy"  + " " + "hacking"

print(hp2)


#2. 글자 삽입
name = "Anna"
age = "26"

text = "안녕하세요. 제 이름은 {}입니다. 나이는 {}입니다".format(name, age)

#2-1방식 1
print(text)

f_text = f"안녕하세요. 제 이름은 {name}입니다. 나이는 {age}입니다"
print(f_text)
#2-2 방식 2 : f스트링


#3.글자 자르기
#3-1 방식 : String > 어떠한 글자들 [시작숫자: 끝낼 숫자]
text_name = text[:15]
print(text_name)

text_age = text[15:]
print(text_age)

#3-2 방식 : split
text_split = text.split()
print(text_split)

#글자의 index
print(sample[0])
print(sample[-1])
#-1은 글자의 맨 뒷값을 추출한다
```



* 참/거짓

```python
'''
주로 조건문에서 사용됩니다!
'''

참 = True
거짓 = False
## 앞 대문자에 주의

if 참 : 
    print("이것은 참입니다.")

if not 거짓 : 
    print("이것은 거짓입니다")

```



* 여러 데이터 조작

```python

hphk = "해피해킹"

print(hphk)
print("happy hacking!")
print("happy hacking!")
print("happy hacking!")
print("happy hacking!")


menus1 = "순남 시래기"
menus2 = "양자강"
menus3 = "20층..."

print(menus1)
print(menus2)
print(menus3)

#하나하나 저장하기 번거로움 -> List

menus = ["순남 시래기", "양자강", "20층...."]

print(menus)
#결과 : ['순남 시래기', '양자강', '20층....']

print(menus[0])
#결과 : 순남시래기

#전화번호부 저장하기
phone_nums = ["02-123-5678", "02-456-7899", "02-789-1234"]
print(phone_nums)


#직관적이지 못함 - Dictionary
dict_nums = {"순남시래기" : "02-123-5678", "양자강" : "02-456-7899", "20층,,," : "02-789-1234"
    
}
#전화번호 출력
print (dict_nums["순남시래기"])
```



## 2. 조건

```python

dust = 120

print(dust >150)
print(dust >100)

if dust >150 :
    print("매우 나쁨")

elif dust >100:
    print("나쁨")

elif dust >80:
    print("나쁨")

else :
    print("좋음")
    

#1 > true
# 0 > false 를 의미
if number%2 :
    print('홀수')
else :
    print('짝수')

#여러 조건을 가진 if문

if a>=90 and b>85 and c>85 and d>80:
   
     result = True
    
```



## 3. 반복

```python

menus = ["순남 시래기", "양자강", "20층....","바스버거"]

#방식 1 ->딱 한번 순회함, 직관적
for menu in menus :
    print(menu)

print("=====")

#방식 2 : i가 0~3까지 증가함
for i in range(4):
    print(i)
    print(menus[i])

```





## 입출력



```python
a = input()

print("--------")
print(a)
print(type(a))

#input함수가 String값으로 반환함
print("--------")

b = int(input())
#형변환
print(b)
print(type(b))
print(b+123456)

```



## 함수

* **String형.split(";")** : ";"을 기준으로 문자열을 잘라서 list에 저장

    ```python
    makes = prices.split(";")
    ```

* **list형.append(값)** : 값을 list에 저장

    ```python
    for make in makes : 
        boxes.append(int(make))
    ```

* **sorted :** 원래 데이터 값을 변경하지 않고 정렬

  * list형.sort(reverse=True) list 자체 순서를 바꿈
  * reverse  = true 내림차순

  ```python
  boxes.sort(reverse=True)
  ```

  

* len() : 개수 구하기



## python 내장 모듈

[내장모듈](https://docs.python.org/ko/3/library/index.html)

```python
import random

numbers = random.sample(range(1,46),6)

#1~45까지의 랜덤함수 그 중 6개 뽑음
print(numbers)
```





## git 언어

* ctrl  l :  깃 화면창 비우기





##  VS Code 단축키

* shift + alt + 방향키 : 복사

* ctrl + del : 줄 삭제