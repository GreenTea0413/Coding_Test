def solution(X, Y):
    from collections import Counter
    
    x1 = Counter(X)
    x2 = Counter(Y)
    
    answer = []
    
    for digit in x1.keys() :
        if digit in x2 :
            count = min(x1[digit], x2[digit])
            answer.extend(digit * count)
            
    if not answer :
        return "-1"
    
    answer.sort(reverse=True)
    result = ''.join(answer)
    
    if result[0] == '0' : return "0"
    return result