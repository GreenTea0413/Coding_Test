def solution(s):
    answer = ''
    l = int(len(s))
    arr = list(s)
    
    if(l % 2 == 0) :
        answer = arr[int(l / 2) - 1] + arr[int(l / 2)]
    else :
        answer = arr[int(l / 2)]            
    
                     
    return answer