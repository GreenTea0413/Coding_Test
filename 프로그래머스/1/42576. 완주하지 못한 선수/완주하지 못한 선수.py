def solution(participant, completion):
    answer = ''
    arr = {}
    
    for p in participant :
        arr[p] = arr.get(p, 0) + 1
    for c in completion :
        arr[c] -= 1
    
    for name, count in arr.items() :
        if count > 0 :
            return name
        
    
    return answer