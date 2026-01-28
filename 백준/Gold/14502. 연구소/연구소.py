import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
maps = [list(map(int, input().split())) for _ in range(n)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]

def bfs() :
    copy = [map[:] for map in maps] 
    queue = deque([])

    for i in range(n) :
        for j in range(m) :
            if copy[i][j] == 2 :
                queue.append((i,j))

    while queue :
        x,y = queue.popleft()
        for k in range(4) :
            nx, ny = x + dx[k], y + dy[k]

            if 0 <= nx < n and 0<= ny < m and copy[nx][ny] == 0 :
                queue.append((nx,ny))
                copy[nx][ny] = 2

    return sum(c.count(0) for c in copy)

answer = 0
def wall(count) :
    global answer
    if count == 3 :
        answer = max(answer, bfs())
        return
    
    for i in range(n) :
        for j in range(m) :
            if maps[i][j] == 0 :
                maps[i][j] = 1
                wall(count + 1)
                maps[i][j] = 0

wall(0)
print(answer)
