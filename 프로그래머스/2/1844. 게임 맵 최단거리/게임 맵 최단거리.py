from collections import deque

def solution(maps):
    x = len(maps)
    y = len(maps[0])
    answer = -1

    queue = deque()
    queue.append([0,0,1])
    visited = [[False] * y for _ in range(x)]
    
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    
    while queue :
        a, b, c = queue.popleft()
        
        if(a == x-1 and b == y-1) :
            return c
        
        visited[a][b] = True
        
        for i in range(4) :
            nx = dx[i] + a
            ny = dy[i] + b
            
            if nx >= 0 and nx < x and ny >= 0 and ny < y :
                if visited[nx][ny] == False and maps[nx][ny] == 1 :
                    visited[nx][ny] = True
                    queue.append([nx,ny,c+1])
        
    return answer