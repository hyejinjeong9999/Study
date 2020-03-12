var1<- matrix(c(1:5)) 
var1

var1<- matrix(c(1:10),nrow=2) 
var1

var1<- matrix(c(1:11),nrow=2) 
var1

var1<- matrix(c(1:11),nrow=2, byrow =TRUE) 
var1

var1 =1:4
var2=5:8

mat1 = rbind(var1,var2)
mat1

mat1 = cbind(var1,var2)
mat1

var1[1,4]

var1[1,]

length(var1) # 전체 요소길이를 알려줌
nrow(var1) # 행의 길이 알려줌
ncol (var1) # 열의 길이 알려줌

#3차원 array
var1 <- array(c(1:24),dim=c(3,2,4))
#dim = 차원/행,열,면
var1


###factor
var1 = c("A","B","AB","O","A","AB")
var1

var1_factor <-factor(var1)
var1_factor

levels(var1_factor)

#범주 지정
var1 = c("A","B","AB","O","A","AB")
var1_factor <- factor(var1,levels=c("A","B","O"))
var1_factor

#순서 지정

var1 = c("A","B","AB","O","A","AB")
var1_factor <- factor(var1,levels=c("A","B","O"), ordered = TRUE)
var1_factor

####list

var1_scalar = 100
var2_vector = c(10,20,30)
var3_matrix = matrix(c(1:6),nrow=3)

myList = list(var1_scalar,var2_vector,var3_matrix)
myList # 키가 없을땐 순서가 키로 잡는다
#key X 호출방법
myList[[2]]
myList[[2]][1]


# 키값 넣기
myList <- list(namec=c("홍길동","김길동"),age=c(20,30),gender=c("남자","여자"))
myList

#호출방법
myList$age
 
myList[[2]]

myList[["age"]]

#### DATAFRAME

df = data.frame(NO=c(1,2,3),Name=c("홍길동","이순신","강감찬"),Age=c(20,30,40))
df
View(df) # 테이블 처럼 확인이 가능하다 


### 내가 원하는 column만 보기
df$Name


df = data.frame(NO=c(1,2,3),Name=c("홍길동","이순신","강감찬"),Age=c(20,30,40), stringsAsFactors=FALSE)
df$Name

#daraframe중 일부룰 추출해 다른 data frame 생성

df<- data.frame(x=c(1:5), y=seq(2,10,2), z=c("a","b","c","d","e"), stringsAsFactors = FALSE)

df

subset1 <-subset(df,x>=3)


subset1


subset(df,x>=3&y<=8)


### 연습문제

#1.
myVal1 <- c(4,5,7,8,10,3)
myVal1


#

Age<-c(22,25,28,29)
Name<-c("홍길동","최길동","박길동","김길동")
Gender <-c("M","F","M","F")

df<-data.frame(Age=Age,Name=Name,Gender=Gender,stringsAsFactors = FALSE)
df

subset(df,Gender!="F")

###

x<-c(2,4,6,8)
y<-c(T,F,T,F)

x[1] # 인덱싱
x[y] # boolean 인덱싱
x[1:3] # 슬라이싱 인덱싱
x[c(1,2,4)] # fancy indexing

x<-c(1,2,3,4)
(x+2) [(!is.na(x)) & x>2] -> k

k

###결측치 na 구하기
x<- c(10,20,30,NA,40,50,60,NA,NA,100)

sum(is.na(x))


