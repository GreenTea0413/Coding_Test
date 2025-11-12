def solution(prices):
    l = len(prices)
    answer = [0] * l
    
    for i in range(l) :
        for j in range(i + 1, l) :
            if prices[i] <= prices[j] :
                answer[i] += 1
            else :
                answer[i] += 1
                break
    return answer