# import random

#numbers = random.sample(range(1,46),6)

#url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=836"

# #1~45까지의 랜덤함수 그 중 6개 뽑음
# print(numbers)

import requests
import random
#파이썬 내장 라이브러리 / 설치안됨
from bs4 import BeautifulSoup as bs
import json
#설치 해야됨

#response = requests.get("http://www.naver.com").text


#numbers = random.sample(range(1,46),6)
#rint(numbers)

url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=836"

response = requests.get(url)
print(type(response.text))

lotto = json.loads(response.text)
print(type(lotto))


winner = []

for i in range(1,7):
    winner.append(lotto.get(f"drwtNo{i}"))

print(winner)

#python 함수
def pickLotto() :
    picked = sorted(random.sample(range(1,46),6))

    matched = len(set(winner) & set(picked))
    #set이라는 집합형 자료형이 중복값을 제거해주고 데이터접근을 빠르게 해줌
    #두 자료형이 같은 숫자를 확인해 주고 그 길이만큼 추출한다


    if matched == 6 :
        print("1등")
    
    elif matched ==5:
        print("3등")
    
    elif matched ==4:
     print("4등")
    
    elif matched ==3:
        print("5등")
    
    elif matched <3:
     print("꽝")



pickLotto()