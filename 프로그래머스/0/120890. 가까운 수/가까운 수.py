def solution(array, n):
    answer = 0
    m = 100
    array.sort(reverse= True)
    
    for i in array :
        if(abs(n - i) <= m) :
            m = abs(n - i)            
            answer = i
            
    return answer