
menus = ["순남 시래기", "양자강", "20층....","바스버거"]

#방식 1 ->딱 한번 순회함, 직관적
for menu in menus :
    print(menu)

print("=====")

#방식 2 : i가 0~3까지 증가함
for i in range(4):
    print(i)
    print(menus[i])
