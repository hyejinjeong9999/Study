'''
주석문

String 조작하기

1. 글자 합체

2. 글자 삽입(수술)

3. 글자 자르기


'''
#1. 글자 합체


hphk = "happy"
hp1 = 'happy'
 # "나" '' 둘 다 상관 없음

hp2 = "happy"  + " " + "hacking"

print(hp2)


#2. 글자 삽입
name = "Anna"
age = "26"

text = "안녕하세요. 제 이름은 {}입니다. 나이는 {}입니다".format(name, age)

#2-1방식 1
print(text)

f_text = f"안녕하세요. 제 이름은 {name}입니다. 나이는 {age}입니다"
print(f_text)
#2-2 방식 2 : f스트링


#3.글자 자르기
#3-1 방식 : String > 어떠한 글자들 [시작숫자: 끝낼 숫자]
text_name = text[:15]
print(text_name)

text_age = text[15:]
print(text_age)

#3-2 방식 : split
text_split = text.split()
print(text_split)