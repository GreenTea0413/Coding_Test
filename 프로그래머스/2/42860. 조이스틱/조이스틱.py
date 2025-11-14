def solution(name):
    answer = 0
    l = len(name)
    
    # 각 알파벳 시작은 A
    # 1. 해당 알파벳 위 아래 움직임 계산
    for n in name :
        answer += min(ord("Z") - ord(n) + 1, ord(n) - ord("A"))
    
    move = l - 1
    for i in range(l) :
        # 2. 좌우 움직임 고려하기
        n = i + 1
        while n < l and name[n] == "A" : n += 1 
        
        move = min(move, i + i + (l - n), (l - n) * 2 + i )
        
    return answer + move