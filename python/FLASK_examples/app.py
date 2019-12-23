
from flask import Flask, render_template, request
import datetime
import random

# 플라스크서버의 이름이 app이다
app = Flask(__name__)

#url을 관리해주는 친구 >@app.rout
@app.route("/")
def hello() :
    return "안녕안녕!!!"

@app.route("/christmas")
def christmas() :
    today = datetime.datetime.now()
    
    month = today.date().month
    day = today.date().day

    if month ==12 and day ==25 : 
        return "<h1>YES<h1>"

    else : 
        return "<h1>NO<h1>"
    
    


@app.route("/dday")
def dday() :
    today = datetime.datetime.now()
    final = datetime.datetime(2020,6,9)
    result = final - today 
    return f"{result.days}일 남았습니다."



@app.route("/movies")
def movies() :
    movies = ["겨울왕국2","클라우스", "어바웃타임", "나홀로 집에1"]
    return render_template("movie.html",movies = movies, text = "목록")
    
@app.route("/greeting/<string:name>")
def greeting(name) : 

    return f"안녕하세요! {name}님!"

@app.route("/cube/<int:num>")
def cube(num) :
    result = num **3
    return str(result)


@app.route("/lunch/<int:num>")
def lunch(num) :
    menu = ["자장면","짬뽕","오므라이스","볶음밥"]
    c_menu = random.sample(menu,num)
    return render_template("movie.html",movies=c_menu,text = "목록")



@app.route("/vonvon")
def vonvon():
    return render_template("vonvon.html")


@app.route("/godmademe")
def godmademe():
   name =  request.args.get("name")
   print(name)
   first_list = ["못생김","어중간함","착하게생김","공부잘하게생김","매력","덕후력"]
   second_list = ["애교","잘난척","쑥스러움","다혈질","자신감","웃김"]
   third_list = ["돈복","찌질","식욕","돈복","착함","멍청함","활기"]

   first = random.sample(first_list,1)
   second = random.sample(second_list,1)
   third = random.sample(third_list,1)


   return render_template("godmademe.html",name=name,first = first, second = second, third = third)



#디버그모드 실행은 무조건 python.app.py로 실행
if __name__ == "__main__" :
     app.run(debug=True)
