
#list 생성
list1 = [1,2,3,4,5]
print(list1)

#list 값2의 위치 출력
print(list1.index(2))

#list 뒤에 값 추가하기
list1.extend([1,2])
print(list1)

#5번째 위치에 값 추가
list1.insert(4,10)
print(list1)

#값을 순서대로 정렬
list1.sort()
print(list1)

#값을 역순으로 정렬
list1.reverse()
print(list1)

#list에 있는 값 확인하기_ 없으면 None

my_list = [5,6,7,8,9]
value = 3
if value in my_list : 
    print(my_list.index(value))
else : 
    print(None)

print("========문자열과 list========")

str = "가 나 다 라"
print(str)
make_list=str.split()

print(make_list)

make_list.extend(["마","바","사"])
print(make_list)

make_str =" ".join(make_list)
print(make_str)

print("========slice=======")
##두번째~여섯번째 전 까지 반환
text = "helloworld"
text = text[1:5]
print(text)

#두번째~네번째 전자리까지 반환
list2 = [0,1,2,3,4,5]
list2 = list2[1:3]
print(list2)

# slice_step
list3 = [4,5,6,7,8,9,10,11]
print(list3[2:9:2])

print(list3[10:2:2])

list4=list(range(20))
print(list4)
new_list = list4[5:15:3]
print(new_list)

reversed_list = list4[17:4:-4]
print(reversed_list)

#update list using slice

list5 = list(range(10))
print(list5)
#0~4까지의 값 삭제
del list5[ :5]

print(list5) 

list5[1:3] = [77,88]
print(list5)

list5[1:3]=[44,55,66]
print(list5)

list5[1:4]=[10]
print(list5)