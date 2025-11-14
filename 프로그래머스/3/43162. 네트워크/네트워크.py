def dfs(start, computers, visited) :
    visited[start] = True
    
    for i in range(len(computers)) :
        if computers[start][i] == 1 and visited[i] == False :
            dfs(i, computers, visited)
    

def solution(n, computers):
    answer = 0
    visited = [False] * n
    # 우선 i,j번째 배열에 1이 있다면 네트워크 1개
    # 추가 조건으로 i j 가 있고 j k 가 연결되어도 네트워크 1개로 취급
    for i in range(n) :
        if(visited[i]) : continue
        dfs(i, computers, visited)
        answer += 1
    
    return answer