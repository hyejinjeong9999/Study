
import requests
from bs4 import BeautifulSoup as bs

url = 'https://finance.naver.com/sise/'
#네이버 금융 - 국내증시 탭에서 가져옴

response = requests.get(url).text
soup = bs(response,'html.parser')
#.또는 #으로 접근 . : 클래스 # : 아이디
kospi = soup.select_one("#KOSPI_now")

print(kospi.text)