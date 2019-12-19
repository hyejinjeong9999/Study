#print() happy hacking

hphk = "해피해킹"

print(hphk)
print("happy hacking!")
print("happy hacking!")
print("happy hacking!")
print("happy hacking!")


menus1 = "순남 시래기"
menus2 = "양자강"
menus3 = "20층..."

print(menus1)
print(menus2)
print(menus3)

#번거로움 -> List

menus = ["순남 시래기", "양자강", "20층...."]

print(menus)
#결과 : ['순남 시래기', '양자강', '20층....']

print(menus[0])
#결과 : 순남시래기

#전화번호부 저장하기
phone_nums = ["02-123-5678", "02-456-7899", "02-789-1234"]
print(phone_nums)


#직관적이지 못함 - Dictionary
dict_nums = {"순남시래기" : "02-123-5678", "양자강" : "02-456-7899", "20층,,," : "02-789-1234"
    
}
#전화번호 출력
print (dict_nums["순남시래기"])

print (dict_nums.get ("충남시래기"))

#값이 없을때 None을 반환함
