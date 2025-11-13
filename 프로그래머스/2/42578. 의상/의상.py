def solution(clothes):
    c = {}
    
    for n, t in clothes :
        if t in c :
            c[t] += 1
        else :
            c[t] = 1
    
    
    answer = 1
    for t in c :
        answer *= c[t] + 1
            
    return answer - 1