#R의 주석은 #입니다
# 
# 홍길동
# a = 100
# 최길동
# 
# a = 100
# b = 200
# A = 100
# B = 200

# a = 100
# a <- 200
# 300 -> a
# ->를 이용해서 assignment를 수행한다

# data type(자료형) data structure (자료구조)
# vector : 자바에서의 1차원 배열, 같은 데이터 타입만 사용할 수 있다
# scala : vector 중 원소가 1개만 있는 vector

myVar<-100
#원소가 1개 뿐임 : vector 면서 scala임 

result = myVar + 200

result
# 출력을 원할때 변수명을 입력한다
# [1] 300 
# [1]은 인덱스를 의미 R의 인덱스는 1부터 시작

print(result)
# print 도 사용 가능
#print 함수는 한개만 출력가능
# 여러개의 값을 출력하려면 cat()을 이용

cat("결과값은 : \n", result, myVar)
# 개행 /n, 문자열 추가 가능
#file writing -- cat에 file option
cat("파일입력",result,file="C:/R_Workspace/R_Lecture/test.txt")
# 경로는 full path
# 덮어쓰기만 가능, append 하려면 append = TRUE 혹은 T
# TRUE 대문자임
cat("파일입력",result,file="C:/R_Workspace/R_Lecture/test.txt", append=TRUE)



##########


#기본적인 연산자는 다른 언어와 유사

var1 <-100
var2 <-3

result <- var1 / var2

result
#33.33333 총 7개의 di git으로 표현 - default 세팅
#digit -> 값이 잘린 것이 아님 값은 그대로 저장되어 있음!! 화면상으로만

options(digits=5)

result
# 33.333 출력 

#format을 이용한 출력

sprintf("%.8f",result)
#33.33333333

# 몫(%/%)과 나머지 구하기

result = var1%/% var2
result 
#33 출력


result = var1 %% var2
result
# 1출력

######################################
####비교연산 , 다른언어와 똑같음 
var1 = 100
var2 = 200
var1 ==var2
var1 != var2

####################
# 논리연산 : 다른언어랑 조금 다름
# &, && and연산, 앞뒤가 true 면 true 아니면false
# |,|| : OR 연산
# 한개,두개의 차이는 vector인지 scala에 따라서 동작이 달라짐

TRUE&TRUE
TRUE&&TRUE
TRUE|TRUE
TRUE||TRUE


###백터 생성 C (Combine)
c(TRUE,FALSE) & c(TRUE,TRUE)
# true false : vector wise연산 1 : 1 , 2: 2 같은 위치의 값 비교
c(TRUE,FALSE) && c(TRUE,TRUE)
# true : 앞값만 비교함 : vector wise 연산을 안함
c(TRUE,FALSE) & c(TRUE,TRUE,FALSE)
# 오류 : 길이가 다름
c(TRUE,FALSE) && c(TRUE,TRUE,FALSE)
# true : 앞만 비교하기 때문에 가능

####
# 기본적으로 사용하는 함수수

#절대값 구하기
abs(-3) #3

#제곱근 구하기
sqrt(4) #2

#factorial 구하기
factorial(4) # 24

###
#R의 데이터 타입
# 1. numeric : 수치형 , 정수와 실수를 구분하지 않음 
# 100, 100.3, 10L(정수) 나머지는 기본으로 실수로 연산한다
# 2. character : 하나의 문자, 문자열 둘 다 문자열로 간주됨 '',"" 혼용해서 사용한다

# var1 = '홍길동'

#3. logical (논리형) : TRUE (T), FALSE(F)
#4. complex(복소수) : 4-3i

#특수 데이터 타입
# 1. NULL , 존재하지 않는 객체를 의미한다
#2. NA(Not Available) : 유효하지 않은 값, 일반적으로 결측치를 표현할 때 사용함 (missing value), 센서를 이용했을 때 빠진 값들
#3. NAN(Not A Number) : 수치값인데 숫자가 아닌 것을 지칭
# sqrt(-9)와 같이 숫자지만 숫자로 표현할 수 없는 것
# (제곱해서 -9가 나오는 수는 없음)
#4. Inf : infinite, 양의 무한대
# 3/0 :무한대

#####################
# R에서 제공하는 기본적인 함수 2개
#mode() : 데이터 타입을 알려주는 함수
var1 <-100
mode(var1)
############################
#is 계열의 함수 #TRUE/FALSE 로 값 나옴
var2 = 300
is.numeric(var2) #TURE
#숫자인지 아닌지
is.double(var2) #TURE
#실수형인지 아닌지 
is.integer(var2) #FALSE
#정수인지 아닌지 
#300처럼 보여도 300.0000임 정수형 : 300L

#######
#데이터 타입의 우선순위
#Character > complex > numeric > logical

#기존적으로 사용되는 자료구조기 vector
# 벡터는 같은 타입만 들어올 수 있고 다른 타입이 들어오면 우선순위에 따라 자동으로 맞춰진다
myVar = c(10,20,30,40)
myVar # 10 20 30 40

myVar = c(10,20,30,FALSE)
myVar # 10 20 30 0
# FALSE = 0 / TURE = 1 
#우선순위가 numeric보다 낮기 때문에 logical은 numeric에 맞춰짐

myVar = c(10,"홍길동",30,TRUE)
myVar
#우선순위가 Character가 가장 높기 때문에 다 Character로 됨

#as계열의 함수 형을 변환시킨다
myVar = "100"
as.numeric(myVar)

############데이터 패키지 설치

install.packages("ggplot2")

.libPaths()

library(ggplot2)

########
myVar =c("남자","여자","여자","여자","여자","남자")
qplot(myVar)
#빈도수를 측정해 차트를 그림

# 함수 사용법이 궁금하다면 help 혹은 RDocumentation 사이트 이용
help(mean)

###############
#자료형은 저장된 데이터의 타입을 저장
#자료구조는 데이터와 메모리에 어떤 방식으로 저장되어 있는지
#homogeneous(같은 종류의) : 저장구조가 같음
# 1. Vector : 1차원 선형구조, 순서 개념이 존재, 같은 개념의 데이터 타입을 이용
# 2. metrix : 2차원 배열, 인덱스 사용가능,같은 종류의 데이터 타입을 이용
# 3. arry : 3차원 이상의 구조, 같은 종류의 데이터 타입을 이용용

#heterogeneous(다른 종류의) : 저장구조가 제각각
# 1. List : 1차원 선형 구조 , 순서개념이 존재함 , 실제로 저장이 되는 구조는 map 구조형태로 <키, 값> 구조로 순서대로 저장된다 (중첩자료 구조가능)
#2. data frame : 2차원 테이블 구조

######
#Vector : 1차원 선형가조 주조, 순서의 개념이 있다
#         index 를 이용해 vector 사용 가능
#         index의 시작은 0이 아닌 1이다 (DB, R은 1부터 시작...
#         []를 이용해 각 요소를 access 할 수 있다
#         Scala : 요소가 1개 짜리 Vector

myVar = c(100) # == myVar = 100

#Vector를 만드는 방법
#1. combine (C)함수 이용하는 방법
# Vector를 만드는 가장 대표적인 방법
# 2개이상의 vector를 하나의 vector로 만들때도 사용가능 
myVal1 = c(10,20,30)
myVal2 = c(3.14,10,100)

myVal1
myVal2 # 3.14 10.00 100.00 //소숫점 자리수를 맞춰준다

result <-c(myVal1,myVal2)
result

# ":"을 이용해서 만드는 방식
# 수치형 대이터 (numeric)에만 사용가능하고 단조증가, 단소감소 (1씩 증/감)형태의 vector를 생성 

myVar = 1:10 #(start:end)
#1부터 10까지 1씩 증가하는 vector
myVar

#2번의 일반형 seq(시작,끝,증가값)
myVar = seq(1,10,2)
myVar =seq(from =10, to =3, by=-3)
myVar

#rep : 반복 적인 값을 이용해 index 생성
myVar = rep(1:3,times=3)
# 앞의 값을 3번 반복해, 123 123 123

myVar = rep(1:3, each=3) #1 1 1 2 2 2 3 3 3
myVar

# vector 안의 요소 개수를 알아내는 함수 length()
myVar = c(10,20,30,40)
length(myVar) # 4

# vector 요소의 지정 (indexing 방식)
myVar  = c(3.14,100,"hello", TRUE,300)
myVar[1] #3.14
myVar[6] #NA 범위를 벗어남 
myVar[length(myVar)] # 300 맨 뒷값 

#slicing indexint - 부분적으로 떼어내기 
result = myVar[2:4]
result # "100" "hello" "TRUE"
#fancy indexing - 하나씩 떼어내기
result = myVar[c(2,3,5)] 
result # "100" "hello" "300"

myVar[-1] #첫번째 값을 뺀 나머지를 의미 // 파이썬 : 맨 뒷 값
myVar[-(3:4)] # 세번째, 네번째 값을 뺀 나머지
myVar[-c(1,4,5)]# 1,4,5 를 제외한 값을 배열로 - 2,4 값만

### vector 데이터에 이름 붙이기
 myVar = c(10,20,30,40,50)
 myVar
 
 names(myVar) # null로 나옴
 names(myVar) = c("a","b","c","d","e")
 names(myVar) # abced 뜸
 myVar # 이름이랑 같이 뜸

myVar[1]
myVar["a"]


#벡터 연산
myVar1 = 1:3
myVar2 = 4:6

result = muVar1 + myVar2
result # 5,7,9
# 사이즈가 같을 경우 같은 위치에 있는 것 끼리 더하게 된다

# 길이가 다른 경우 다시 1부터 recycle rule
myVar3 = 1:6

result = myVar1 + myVar3 # 1 2 3 1 2 3 + 1 2 3 4 5 6

result # 2 4 6 57 9

# vector에 대한 집합연산(합집합, 교집합, 차집합)
var1 = 1:5
var2 = 3:7

union(var1,var2) # 1 2 3 4 5 6 7
intersect(var1,var2) # 3 4 5
setdiff(var1,var2) # 1 2