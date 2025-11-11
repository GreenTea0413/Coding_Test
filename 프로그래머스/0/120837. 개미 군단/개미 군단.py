def solution(hp):
    answer = 0
    answer += int(hp / 5)
    hp = hp % 5
    
    answer += int(hp / 3)
    answer += hp % 3       
        
    return answer