from collections import deque

def solution(maps):
    answer = -1
    m = len(maps)       # 세로
    n = len(maps[0])    # 가로
    
    visited = [[False] * n for _ in range(m)]
    queue = deque()
    queue.append([0,0,1])
    
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    
    while queue :
        x,y,c = queue.popleft()
        if x == m - 1 and y == n - 1 :
            return c
        
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= 0 and nx < m and ny >= 0 and ny < n :
                if visited[nx][ny] == False and maps[nx][ny] == 1:
                    visited[nx][ny] = True
                    queue.append([nx,ny,c + 1])
                
    return answer