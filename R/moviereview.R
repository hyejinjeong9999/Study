library(rvest)
library(stringr)


movie_comment<-data.frame()


#//*[@id="old_content"]/table/tbody/tr[1]/td[2]/text()
for (j in 1:100){
  url="https://movie.naver.com/movie/point/af/list.nhn?st=mcode&sword=189001&target=after&page="
  request_url <- str_c(url,j)
  page_html <-read_html(request_url, encoding = "CP949")
  
  data=vector(mode="character",length=10)

for(i in 1:10){
  mypath = str_c('//*[@id="old_content"]/table/tbody/tr[',i,']/td[2]/text()')
  nodes = html_nodes(page_html,xpath = mypath)
  data[i] = str_remove_all(html_text(nodes[4]),"[\n\t]")
  
  
}
  tmp <-data.frame(data=data)
  movie_comment<-bind_rows(movie_comment,tmp)
}
View(movie_comment)

#html_text(nodes)


movie_comment <- as.data.frame(movie_comment)
write.table(movie_comment, "C:/R_Workspace/R_lecture/data/movieComment.csv", fileEncoding = "UTF-8",quote = FALSE)

View(movie_comment)

#######워드클라우드
#install.packages("data.table")
library("data.table")
library(KoNLP)
library(wordcloud)
library(dplyr)

text<-readLines("C:/R_Workspace/R_lecture/data/movieComment.csv", encoding = "UTF-8")
  #read("C:/R_Workspace/R_lecture/data/words.csv",encoding ="UTF-8")

  #read.csv("C:/R_Workspace/R_lecture/data/words.csv",encoding = "UTF-8")
  #readLines("C:/R_Workspace/R_lecture/data/words.csv", encoding = "UTF-8")

word <-extractNoun(text)

result <-unlist(word)


wordcount<-table(result)

wordcount_df <-as.data.frame(wordcount, stringsAsFactors = F)

word_df <-wordcount_df %>% 
          filter(nchar(result) >= 2) %>%
          arrange(desc(Freq)) %>% 
          head(20)


word_df<-word_df.
word_df



library(wordcloud)
##단어 색상 설정
pal <- brewer.pal(8,"Dark2") # Dark2라는 색상목록에서 8개 뽑음 
#word calud는 생성할때마다 다르게 설정
#같은 형태의 wordcloud를 생성하고 싶으면 random에 대한 seed값 설정

set.seed(1) 

wordcloud(words=word_df$result, # 사용할 단어
          freq=word_df$Freq,  # 빈도수
          win.freq = 1,       #최소빈도수 = 빈도수가 2이하인 것은 안잡는다
          max.words = 100,  # 최대 단어수 = 최대 단어수는 200
          random.order=F,   # T : 랜덤배치 F : 가장 고빈도의 단어가 중앙에 위치
          rot.per =.1,       # 글자 돌리기
          colors=pal)          #위에서 설정한 pal 색상 값
