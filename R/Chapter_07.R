##결측치 처리하기

df<-data.frame(id=c(1,2,NA,4,NA,6),
                score =c(20,30,NA,50,70,NA))

df

is.na(df) # na면 TRUE, 아니면 flase
is.na(df$id) #id컬럼에서만 na 판단 - vector로 결과가 나온다
is.na(df$score) # score 컬럼에서만


# 1. 삭제 :NA 값이 적을 경우

library(dplyr) # df를 가장 쉽고 편한게 제어할 수 있는 패키지 dplyr

#id가 NA인 row를 dataframe에서 삭제
result <-df %>% 
        filter(!is.na(df$id))  #df의 id가 na인지 -> 아닌것을 필터

result

result <-df %>% 
  filter(!is.na(df$id),!is.na(df$score)) # id와 scorㄷ가 na인 값들 다 제거

result

##### 쉽게 NA를 찾아서 NA가 포함된 row 제거
result <-na.omit(df) # na로 보여진는 것은 모두 다 지운다
result

####값대체하기

df<-data.frame(id=c(1,2,NA,4,NA,6),
               score =c(20,30,NA,50,70,NA))

mean(df$score) # NA로 떨어짐 안에 NA가 들어가 있기 때문에!

mean(df$score,na.rm=TRUE) # NA를 무시하기 !

### score의 na값을 score 안에 있는 na를 제거한 값의 평균으로 대체해서 새로운 df 만들기

df$score <-ifelse(is.na(df$score),
                  mean(df$score, na.rm=TRUE),
                  df$score)

df

########
결측치 해결 후 이상치 해결


df<-data.frame(id=c(1,2,NA,4,NA,6),
               score =c(20,30,NA,50,70,NA),
               gender=c("^^","F","M","F","M","M"),
               stringsAsFactors = FALSE)

#stringsAsFactors = FALSE) : factors로 잡지말고 문자열로 봐라

#이상치는 NA로 변환 -> 그 후 NA를 처리

result<- ifelse(df$gender%in%c("M","F"),
                df$gender,
                NA)
# 만약 gender가 M,F가 포함되어 있다면 그대로 출력
# 아니면 NA로 보내기

#데이터 분석을 이용하려면 웹 데이터 분석이 가장 많음
# 의사결정에 반영하는 방식으로 이용 => 마케팅분야
# 추천시스템템

#ggplot2

library(ggplot2)
mpg
df <- as.data.frame(mpg) # 테이블 형식의 mpg를 df형식으로 바꿈
df

#scatter를 그리기 
# 배기량과 고속도로 연비의 관계를 알기 위해 산점도를 그리기
 
ggplot(data=df,
        aes(x=displ,y=hwy) ) +
        geom_point()
  
  ## aes : 축 설정  + : dusruf
## geom_point : 산점도를 그리는 함수


ggplot(data=df,
       aes(x=displ,y=hwy) ) +
      geom_point()+
      xlim(3,6)+
      ylim(20,40)  #lim 범위설정

###막대그래프

View(df)


result <-df %>% 
        group_by(drv) %>% # 모든 데이터를 구동방식의 평균으로 그룹핑
      summarise(mean_hwy=mean(hwy)) 
ggplot(data=result,
       aes(x=drv,y=mean_hwy))+
        geom_col() # 막대그래프

###boxplot
ggplot(data=df, aes(x=drv, y = hwy)) +
  geom_boxplot()



####분위

data <-c(1,2,3,4,5,6,7,8,9,10,11,12,50)

mean(data)
#4분위 : 데이터를 4분위
#2,4분위 : 데이터의 중간값 7
# 중위수를 찾아내는 것
# 값의 분포를 보고 중간 값
# 평균 :  지나치게 작은 값이있거나 큰 값이 있으면 수치가 완전 달라짐
# 2/4분위는 평균의 맹점을 잡아줌
# 진짜 값의 분포를 알 수 있음



###문자열 처리 (워드클라우드)
install.packages("koNLP") # 현재 설치 불가능
.libPaths()


install.packages("Sejong")
install.packages("hash")
install.packages("tau")
install.packages("RSQLite")
install.packages("devtools")
##KoNLP 사용을 위한 packages 설치

library(KoNLP)

useNIADic() # 사전 생성

tmp <- "이것은 소리없는 아우성" # 문자열 생성

extractNoun(tmp) # 명사만 추출


library(stringr) #stringr 로딩
txt <-readLines("data/hiphop.txt" ,encoding = "UTF-8")
txt

word <-extractNoun(txt) # 벡터 원소 한줄에 형태소 분석을 함 -> 최종형태 list
#list를 다루기 쉽게 벡터로 변환

result <- unlist(word)

result

#빈도구하기
#table 함수 사용 : 빈도 구하는 함수 각각의 것들이 몇번씩 나오는지
wordcount<-table(result)


#데이터 프레임 형식으로 변경
wordcount_df <-as.data.frame(wordcount, stringsAsFactors = F)


wordcount_df



word_df <-wordcount_df %>% 
          filter(nchar(result) >=2) %>% 
          arrange(desc(Freq)) %>% 
          head(20)
#nchar : 몇글자 짜리인지 일려줌 =>result 의 글자 수가 2개이상인것
# 빈도가 높은 순으로 정렬, 상위 20개만 추출

word_df

install.packages("wordcloud")
library(wordcloud)
##단어 색상 설정
pal <- brewer.pal(8,"Dark2") # Dark2라는 색상목록에서 8개 뽑음 
#word calud는 생성할때마다 다르게 설정
#같은 형태의 wordcloud를 생성하고 싶으면 random에 대한 seed값 설정

set.seed(1) 

wordcloud(words=word_df$result, # 사용할 단어
          freq=word_df$Freq,  # 빈도수
          win.freq = 2,       #최소빈도수 = 빈도수가 2이하인 것은 안잡는다
          max.words = 200,  # 최대 단어수 = 최대 단어수는 200
          random.order=F,   # T : 랜덤배치 F : 가장 고빈도의 단어가 중앙에 위치
          rot.per =.1,       # 글자 돌리기
          colors=pal)          #위에서 설정한 pal 색상 값
