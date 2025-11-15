from collections import deque

def solution(maps):
    s = []
    l = []
    e = []
    m = len(maps)
    n = len(maps[0])
    
    for i in range(m) :
        for j in range(n) :
            if maps[i][j] == "S" : s = [i,j]
            if maps[i][j] == "E" : e = [i,j]
            if maps[i][j] == "L" : l = [i,j]
            
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]

    def bfs(start, end) :
        visited = [[False] * n for _ in range(m)] 
        visited[start[0]][start[1]] = True
        queue = deque()
        queue.append([start[0], start[1], 0])
        
        while queue :
            x, y, c = queue.popleft()
            
            if x == end[0] and y == end[1] :
                return c
            
            for i in range(4) :
                nx = x + dx[i]
                ny = y + dy[i]

                if 0 <= nx < m and 0 <= ny < n:
                    if visited[nx][ny] == False and maps[nx][ny] != "X":
                        visited[nx][ny] = True
                        queue.append([nx,ny,c + 1])
        return -1
    
    dist1 = bfs(s,l)
    dist2 = bfs(l,e)
    
    if dist1 == -1 or dist2 == -1:
        return -1
    
    return dist1 + dist2
        