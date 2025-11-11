def solution(numer1, denom1, numer2, denom2):
    answer = []
    
    
    num1 = numer1 * denom2
    num2 = numer2 * denom1
    num3 = denom1 * denom2
    
    answer = [num1 + num2, num3]
    
    for i in range(int(num3 / 2) + 1, 1,-1) :
        if(answer[0] % i == 0 and answer[1] % i == 0) :
            answer[0] = answer[0] / i
            answer[1] = answer[1] / i
    
    return answer