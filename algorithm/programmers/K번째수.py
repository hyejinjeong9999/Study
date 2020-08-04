array = [1,5,2,6,3,7,4]
commands = [[2,5,3],[4,4,1],[1,7,3]]
result=[]
for num in commands :
    i = num[0]-1
    k = num[1]
    j = num[2]-1
    #추출할 시작값, 끝 값 , 반환할 값
    result_append = array[i:k]
    #result_append는 i부터 k까지 자름
    result_append.sort()
    #정렬하기
    result.append(result_append[j])
    #반환할 값 
   

print(result)

