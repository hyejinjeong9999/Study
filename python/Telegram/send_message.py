import requests
from decouple import config

token =config('TELEGRM_BOT_TOKEN')
#토큰 값 옮겨 붙이기

app_url = f"https://api.telegram.org/bot{token}"
#url + 토큰 값 붙이기

chat_id = config('CHAT_ID')


print(chat_id)
##list임을 알 수 있음 -dictionary 형태
#인자별로 가져올 수 있음
#점점 세부적으로 들어가는중..

text = "곧 점심시간 조금만 ..."
message_url = app_url + f"/sendMessage?chat_id={chat_id}&text={text}"

requests.get(message_url)