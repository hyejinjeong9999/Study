require(rvest)
require(stringr)


url = 'https://www.rottentomatoes.com/top/bestofrt/?year=2019'


#전체 page의 html
html_page <- read_html(url,encoding="UTF-8")



#html 내에서 내가 원하는 엘리먼트 가져오기
# =#엥커태그 노드 가져오기
#tbody 지우기 : 한 값만 가져올 예정 - html_node  

for(i in 1:100){
  path = str_c('//*[@id="top_movies_main"]/div/table/tr[',i,']/td[3]/a')
  
  nodes = html_nodes(html_page,xpath = path)
  
  myLink <- html_attr(nodes,"href")
  
  movie_link = str_c("https://www.rottentomatoes.com/",myLink)
  
  movie_html_page = read_html(movie_link,encoding="UTF-8")
  
  movie_title_nodes = html_node(movie_html_page,xpath = '//*[@id="topSection"]/div[2]/div[1]/h1')
  
  movie_title[i] = html_text(movie_title_nodes)
  
 
}



movie_title

########################그래프 그리기
#데이터 조작
#SQL처럼 빅데이터 내에서 필요한 정보를 추출하는 방법
# 기본적인 함수에 대해서 알아야 한다
# ggplot2 package : 그래프를 그리는 package
# 이 package 안에 mpg data set이 있음

install.packages("ggplot2")
library("ggplot2")
mpg
df = as.data.frame(mpg)
View(df)

class(df) #class 자료구조 출력

is(df)

head(df)

tail(df)
dim(df)

nrow(df) # 행의 개수수

ncol(df)# 열의 개수
str(df)

length(df)
# 원래 개수를 구하는 함수이지만 dataframe에선 column의 개수를 알려주어야 함

summary(df)

install.packages ("dplyr")

library("dplyr")

# data frame 제어

library(xlsx)
exel_data = read.xlsx(file.choose(),sheetIndex = 1,encoding = "UTF-8")

exel_data

###칼럼명 변경하기 renames (dataframe,newVar = var)
df = rename (exel_data, 
       Y17_AMT = AMT17,
       Y16_AMT = AMT16)
df

##########filter filter(df, 조건)
df = filter(exel_data,
            SEX=="M",
            AREA %in% c("서울","경기"))

## %in% c("서울","경기") 서울, 경기 인 사람

#arrange (data frame, column명, 동률일때 column명)
# 기본으로 정렬은 오름차순 정렬
# 내림차순 정렬을 하고 싶으면 desc() 를 넣음arrange (data frame, column명, desc(column명)

df = arrange(exel_data, 
             SEX, desc(AGE))
df
### 성별이 남성인 사람들만 찾아서 나이순(내림)으로 정렬해보기
### 체이닝 이용하기

df = filter(exel_data,SEX=="M")%>% 
    arrange(desc(AGE))

###select (datagrame ,컬럼명, 컬럼명, 컬럼명...) ----------수정
df = filter(exel_data, SEX =="M") %>%
      arrange(desc(AGE)) %>%
     select(ID,SEX,AREA)

df = filter(exel_data, SEX =="M") %>%
    arrange(desc(AGE))%>%
    select(-SEX)


#######5. mutate(dataframe,colum명 =수식, column명 + 수식)
# 원본 데이터에 대해서 남자면서 AMT17의 값이 100000이상인 사람들을 찾앗 VIP로 설정
df =filter(exel_data, SEX=="M") %>%
    mutate( VIP = AMT17>500000)


#############집계 summeaise (data frame, 추가할 column명 = 함수, column명 = 함수)
df = summarise(exel_data, SUM17AMT = sum(AMT17),cnt=n()) # 다 더해서 sum17AMT에 저장 cnt라는 컬럼을 만들어 총 몇명이 있는지


###group_by(dataframe,범주형컬럼)
df = group_by (exel_data, SEX)%>%
    summarise(SUM17AMT=sum(AMT17),cnt=n())

########column명이 같은 두개의 df 붙이기
df1 <- data.frame(x=c(1,2,3))
df1
df2  <-data.frame(x=c(4,5,6))
df2
bind_rows(df1,df2)

############EDA(탐색적 데이터 분석)
