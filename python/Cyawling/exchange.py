
import requests
from bs4 import BeautifulSoup as bs

url = 'https://finance.naver.com/marketindex/?tabSel=worldExchange#tab_section'

response = requests.get(url).text

soup = bs(response,'html.parser')

#.또는 #으로 접근 . : 클래스 # : 아이디

money = soup.select_one("#exchangeList > li.on > a.head.usd > div > span.value")

print(f"현재 원/달러 환율은 {money.text}입니다")

##파일 저장 하는 방법
with open('test.txt','w', encoding='utf-8') as f: 
    f.write(f"현재 원/달러 환율은 {money.text}입니다")
    ##txt 자동으로 만들어준당

##with > 스코풀???????? : 여기서만 잠깐 사용할거다