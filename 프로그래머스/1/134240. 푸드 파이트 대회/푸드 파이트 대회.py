def solution(food):
    answer = ''
    left = ''
    right = ''
    
    l = int(len(food))
    for i in range(1, l) :
        num = int(food[i] / 2)
        for j in range(num) :
            left = left + str(i)
            right = str(i) + right
    answer = left + '0' + right
    return answer