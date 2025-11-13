def solution(k, dungeons):
    answer = 0
    l = len(dungeons)
    visited = [False] * l
    
    def dfs(hp, c) :
        nonlocal answer 
        answer= max(answer, c)
        for i in range(l) :
            if hp >= dungeons[i][0] and visited[i] == False :
                visited[i] = True
                dfs(hp - dungeons[i][1], c + 1)
                visited[i] = False
        

    dfs(k, 0)
    return answer   