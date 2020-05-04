require(rvest)
require(stringr)


url = 'https://www.rottentomatoes.com/top/bestofrt/?year=2019'


#전체 page의 html
html_page <- read_html(url,encoding="UTF-8")



#html 내에서 내가 원하는 엘리먼트 가져오기
# =#엥커태그 노드 가져오기
#tbody 지우기 : 한 값만 가져올 예정 - html_node  


movie_title = vector(mode="character",length=100)
movie_point = vector(mode="character",length=100)
movie_genre = vector(mode="character",length=100)

for(i in 1:100){
  path = str_c('//*[@id="top_movies_main"]/div/table/tr[',i,']/td[3]/a')
  
  nodes = html_nodes(html_page,xpath = path)
  
  myLink <- html_attr(nodes,"href")
  
  movie_link = str_c("https://www.rottentomatoes.com/",myLink)
  
  movie_html_page = read_html(movie_link,encoding="UTF-8")
  
  #영화제목
  movie_title_nodes = html_node(movie_html_page,xpath = '//*[@id="topSection"]/div[2]/div[1]/h1')
  
  movie_title[i] = html_text(movie_title_nodes)
  
  #영화평점
  movie_point_nodes = html_node(movie_html_page,xpath ='//*[@id="topSection"]/div[2]/div[1]/section/section/div[2]/h2/a/span[2]')
 movie_point[i] = gsub("\n| ", "", html_text(movie_point_nodes))
 
  
  #영화장르
 
 movie_genre_nodes = html_node(movie_html_page,'section.panel.panel-rt.panel-box.movie_info.media div.meta-value > a:nth-child(1)')
 movie_genre[i] = html_text(movie_genre_nodes)
  
  
}



movie_data <- data.frame()

movie_title <- as.data.frame(movie_title)
movie_genre <- as.data.frame(movie_genre)
movie_point <- as.data.frame(movie_point)
movie_data <- cbind(movie_title, movie_genre, movie_point)



View(movie_data)

