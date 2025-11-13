def solution(brown, yellow):
    answer = []
    
    s = brown + yellow
    
    for h in range(1, int(s / 2)):
        if s % h == 0 :
            w = s / h
            if  w >= h and ((w - 2) * (h - 2)  == yellow) :
                return [w, h]
            
    
    
    return answer