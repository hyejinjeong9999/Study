'''
1. 리퀘스트를 통해서 네이버에 요청을 보냄
2. 받아온 데이터를 리스폰스에 저장
3. 저장된 정보를 설치했던 bs4로 모양을 변화해 출력
4. 내장라이브러리인 webbrawser로 브라우저 새로 컨트롤

'''

import requests

from bs4 import BeautifulSoup as bs

import webbrowser
#내장 라이브러리

url = "https://www.naver.com"
#네이버소스의 코드를 가져와!

response = requests.get(url).text

# print(response)  엄청난 양의 (네이버 )코드 나와!
#bs로 변환

#html.parser >받아올 형식
# hltml파일로 가져왔는데 bs야 이쁘게 바꿔조..
doc = bs(response, 'html.parser')

#result = doc.select_one ('.ah_k')
#하나를 선택하겠다
#doc형식에서 하나 가져올껀디 .ah_k라는 이름의 클래스에 해당되는거
# . -> 클래스를 가져오겟다 (클래스의 축약어)
# # -> 아이디를 가져오겠다


result = doc.select ('.ah_k')
#클래스에 해당되는거 전부 가져온당
print(result)

webbrowser.open(url)

print('------')
print(result[0])
#인기검색어 하나만 출력됨
print('------')


serach_url = "https://search.naver.com/search.naver?query="

for i in range(5):

    webbrowser.open(serach_url + result[i].text)
    #텍스트만 가져옴