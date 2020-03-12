
install.packages("stringr")

library(stringr)  # require(stringr)

myStr = "hongkd1051Leess4504YOU25홍길동1004"


str_length(myStr) # 문자열으 길이
str_locate(myStr,"Lee") # 문자열 처음 위치
str_locate(myStr,"0")
str_locate_all(myStr,"0")

# 부분 문자열

str_sub(myStr,2,5)


str_to_upper(myStr)
str_to_lower(myStr)

str_replace(myStr,"홍길동","신사임당")

str_c(myStr,"이순신2020")

myStr = "Hongkd1051,Leess4,5b04YOU,홍길동1004"

str_split(myStr,",")

###정규식
str_extract_all(myStr,"")

str_extract_all(myStr,"[a-z]{3}") # 영소문자가 3개 연달아 있는 경우

str_extract_all(myStr,"[a-z]{3,}") #영소문자가 3개 이상 연달아 있는 경우

str_extract_all(myStr,"[a-z]{3,4}")


str_extract_all(myStr,"[가-힣]{3,4}")

str_extract_all(myStr,"[0-9]{4}")


str_extract_all(myStr,"[^a-z]{4}")

##데이터 입출력

myNum = scan() # 숫자만
#edit() 

myNum

myData = scan(what = character()) # 문자열
myData

df = data.frame()
my_df=edit(df)
my_df

##txt 파일 읽기 

df<-read.table("data/Student_middleterm.txt",sep=",",header=TRUE,fileEncoding = "UTF-8")

df

##파일 직접 선택

df <- read.table(file.choose(),sep=",",header=TRUE,fileEncoding = "UTF-8")


df 

##NA 값 명시하기
df <- read.table(file.choose(),sep=",",header=TRUE,fileEncoding = "UTF-8", na.strings="-")
df

# 데이터 교환, 전달 방식 

#csv 파일 읽기
#read 테이블과 거의 유사 header=TRUE 가 default다, sep=","가 default 
df<-read.csv(file.choose(),fileEncoding = "UTF-8")
df

# exel 파일로 데이터 파일이 되어있는 경우

#Excel file을 사용하려면 기본기능으로는 안되고 외부 package를 이용해야 한다



install.packages("xlsx")
require(xlsx)

df = read.xlsx(file.choose(),sheetIndex = 1,encoding = "UTF-8")
df

a <- 1
class(df) # 자료구조의 타입을알려줌
mode(a) # 데이타 타입을 알려줌

#file의 data frame을 저장
#write.table()
write.table(df,file="data/result.cvs") # 인덱스 가 같이 출력된다 ""도 같이 출력된다

write.table(df,file="data/result.cvs",row.names = FALSE, quote = FALSE) #인덱스 같이 출력 안됨 

#########################
#R에서 외부 web Application 호출한 후 결과물 Data Frame으로 받아올리기

install.packages("jsonlite")
install.packages("curl") #json 의존성
require(jsonlite)
require(curl)
require(stringr) # 문자열 처리

url <- "http://localhost:8080/bookSearch/search?keyword="


request_url <-str_c(url,scan(what=character()))

request_url

df = fromJSON(request_url)

View(df)


for (i in 1:nrow(df)){
  print(df$title[i]) # 벡터의 첫번째 값, 두번째 값, 세번째 값
}

###영화진흥위원회 open API
url <- "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=cd91e963c64309a8a8a9dac0b926f6d9&targetDt=20200310"

df = fromJSON(url)

View(df) # 완전한 data frame 형식으로 못가져옴(복잡해서) - list 형태로 되어 있다
df[[1]] # == df[["boxofficeresult"]] == df$boxofficeresult

df$boxOfficeResult$dailyBoxOfficeList$movieNm


for(i in 1:nrow(df$boxOfficeResult$dailyBoxOfficeList)){
  print(df$boxOfficeResult$dailyBoxOfficeList$movieNm[i])
}



