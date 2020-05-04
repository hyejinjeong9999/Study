install.packages("rvest")
library(rvest)
library(stringr)

url <- "https://movie.naver.com/movie/point/af/list.nhn?&page="

request_url <- str_c(url,1)

request_url

#html로
#스크랩핑을 할 때 서버쪽 인코딩 타입을 확인한다 네이버 = CP949
page_html <- read_html(request_url,encoding = "CP949")

page_html # url을 이용해서 결과 HTML 코드를 받아오기 

#html 중에 selector에 맞는 element를 가져와
nodes = html_nodes(page_html,"td.title > a.movie")
#td에 class가 title이며 그 자손 class가 a이고 class명이 movie 인것
nodes

#elemet가 가지고 있는 text(teg 사이의 글자)를 얻어오기
movie_title <- html_text(nodes)

movie_title

# 첫번째 페이지의 평점과 코멘트 알아오기
nodes = html_nodes(page_html,"td.title em")

nodes

movie_score <- html_text(nodes)

movie_score
#코멘트

nodes = html_nodes(page_html,"td.title")

nodes

movie_comment <- html_text(nodes)

movie_comment

movie_comment<- str_remove_all(movie_comment,"\n")
movie_comment <-str_remove_all(movie_comment,"\t")
movie_comment <- str_remove_all(movie_comment,movie_title)
movie_comment<- str_remove_all(movie_comment,"별점 - 총 10점 중")
movie_comment<- str_remove(movie_comment,movie_score)
movie_comment<- str_sub(movie_comment,1,nchar(movie_comment)-2)

movie_comment

####xPATH
library(rvest)
library(stringr)
url="https://movie.naver.com/movie/point/af/list.nhn?&page="
request_url <- str_c(url,1)


page_html <-read_html(request_url, encoding = "CP949")

#영화제목 찾기
#영화제목부분을 추출하기 위해서 제모긍ㄹ 가지고 있는html element를 획득

#nodes <- html_nodes(page_html,"td.title>a.movie")

#영화제목을 저장할 10개짜리 빈 vector생성
movie_title=vector(mode="character",length=10)



#xpaht 안에 " 가 있으니 ' 로 감싸기
#딱 첫번째 값만 가져옴
movie_xpath = '//*[@id="old_content"]/table/tbody/tr[1]/td[2]/a[1]'

#'//*[@id="old_content"]/table/tbody/tr[1]/td[2]/a[1]' < 두번째 댓글의 xpath  : 영화제목마다 tr이 다르다는 것을 알 수 있음

#tr을 계속해서 바꾸기


for(i in 1:10){
  mypath = str_c('//*[@id="old_content"]/table/tbody/tr[',i,']/td[2]/a[1]/text()')
  nodes = html_nodes(page_html,xpath = mypath)
  movie_title[i] = html_text(nodes)
}



movie_title      




#로튼 토마토 사이트에 가서 2019년에 가장 인기있었던 영화 100개의 제목, user rating, genre를 추출해서 파일로 저장해보기

#############################################100개 제목 (보류)

#url 설정
url="https://www.rottentomatoes.com/top/bestofrt/?year="
request_url <- str_c(url,2019)

#페이지 열기
page_html <-read_html(request_url)


########################################ver xpath

#영화제목을 저장할 vector 100
movie_title=vector(mode="character",length=100)

# xpath 설정

mypath = '//*[@id="top_movies_main"]/div/table/tbody/tr[1]/td[3]/a'

for(i in 1:100){
  mypath = str_c('//*[@id="top_movies_main"]/div/table/tbody/tr[',i,']/td[3]/a')
  nodes = html_node(page_html,xpath = mypath)
  movie_title[i] = html_text(nodes)
}

#####################################ver selector

nodes = html_nodes(page_html,"")


#######################################출력

movie_title   


# 첫번째 페이지의 평점과 코멘트 알아오기
nodes = html_nodes(page_html,"td>a.unstyled.articleLink")

nodes

movie_score <- html_text(nodes)

movie_score

#####################################################
           
require(rvest)
require(stringr)

url = 'https://www.rottentomatoes.com/top/bestofrt/?year=2019'

#전체 page의 html
html_page <- read_html(url,encoding="UTF-8")



#html 내에서 내가 원하는 엘리먼트 가져오기
# =#엥커태그 노드 가져오기
#tbody 지우기 : 한 값만 가져올 예정 - html_node  
node = html_node(html_page,xpath = '//*[@id="top_movies_main"]/div/table/tr[1]/td[3]/a')

#attr : 태그가 가지고 있는 속성값을 가져오기
myLink <- html_attr(node,"href")

real_link = str_c("https://www.rottentomatoes.com/",myLink)

first_movie_html_page = read_html(real_link,encoding="UTF-8")


first_movie_title_node = html_node(first_movie_html_page,xpath = '//*[@id="topSection"]/div[2]/div[1]/h1')

first_movie_title_node

html_text(first_movie_title_node)


movie_point =html_node(first_movie_html_page,xpath= '//*[@id="topSection"]/div[2]/div[1]/section/section/div[2]/h2/a/span[2]') 

html_text(movie_point)

movie_point

html

