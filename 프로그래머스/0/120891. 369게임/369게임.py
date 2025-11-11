def solution(order):
    answer = 0
    for i in str(order) :
        if(int(i) == 3) :
            answer += 1
        if(int(i) == 6) :
            answer += 1
        if(int(i) == 9) :
            answer += 1
    return answer