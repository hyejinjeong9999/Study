'''
문제 5.
표준 입력으로 물품 가격 여러 개가 문자열 한 줄로 입력되고, 각 가격은 ;(세미콜론)으로 구분되어 있습니다.
입력된 가격을 높은 가격순으로 출력하는 프로그램을 만드세요.
# 입력 예시: 300000;20000;10000
'''

prices = input('물품 가격을 입력하세요: ')

makes = prices.split(";")

#분할기준 을 ;로 잡아서 String형태의 list 출력

boxes = []
#list형식에는 append가 있다

for make in makes : 
    boxes.append(int(make))

#list >sort() 정렬 큰 수부터 정렬
boxes.sort(reverse=True)

print(boxes)
