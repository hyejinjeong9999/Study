
from flask import Flask ,render_template, request
from decouple import config
import requests
import random  #로또용

app = Flask(__name__)

token = config('TELEGRM_BOT_TOKEN')
chat_id = config('CHAT_ID')

app_url = f"https://api.telegram.org/bot{token}"



#root디렉토리
@app.route("/")
def hello():
    return "안녕하세요"


@app.route('/write')
def write() :
    #HTML file return
    return  render_template("write.html")

    
@app.route('/send')
def send():
    message = request.args.get("message")
    message_url = app_url + f"/sendMessage?chat_id={chat_id}&text={message}"
    #message 받아서 telegram 메시지 보내는 요청 함
    requests.get(message_url)
    return "메시지 전송 완료"

   

#Webhook
@app.route(f"/{token}",methods=['POST'] ) 
def telegram():
    print(request.get_json())

#앵무새봇
    response = request.get_json()
    chat_id = response ["message"]["chat"]["id"]
    text = response["message"]["text"]


#로또봇  #사용자가 로또라고 입력하면
    if text =="/로또"  : 
        result = []
        for i in range(5) :
            
            result.append(sorted(random.sample(range(1,46),6)))
        text = result
            
#점심메뉴 추천

    elif text == "/점심" : 
        menus = ["20층","양자강","맥도날드","바스버거"]
        text = random.choice(menus)


    m_url = app_url + f"/sendMessage?chat_id={chat_id}&text={text}"
    requests.get(m_url )
#return body, status_code
    return '', 200




#debug
if __name__=="__main__" :
    app.run(debug=True)


