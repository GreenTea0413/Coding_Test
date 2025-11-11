def dfs(n) :
    if(n == 2) : return 1
    for i in range(2, int(n ** 0.5) + 1) :
        if(n % i == 0) : return 0
    return 1

def solution(n):
    answer = 0
    
    for i in range (2, n + 1) :
        answer += dfs(i)
    return answer
