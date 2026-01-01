from collections import deque
import sys
input = sys.stdin.readline

dx = [0,0,1,-1]
dy = [1,-1,0,0]

R, C = map(int, input().split())
A = [list(map(str, input().strip())) for _ in range(R)]      

fq = deque([])
jq = deque([])
INF = float('inf')

F = [[INF] * C for _ in range(R)]
J = [[INF] * C for _ in range(R)]

for i in range(R) :
    for j in range(C) :
        if A[i][j] == 'J' :
            jq.append((i,j))
            J[i][j] = 0
        if A[i][j] == 'F' :
            fq.append((i,j))
            F[i][j] = 0

while fq :
    x, y = fq.popleft()

    for i in range(4) :
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < R and 0 <= ny < C :
            if A[nx][ny] != '#' and F[nx][ny] == INF :
                F[nx][ny] = F[x][y] + 1
                fq.append((nx,ny))

while jq :
    x, y = jq.popleft()

    if x == 0 or x == R - 1 or y == 0 or y == C - 1:
        print(J[x][y] + 1)
        sys.exit()
    
    for i in range(4) :
        nx, ny = x + dx[i], y + dy[i]

        if 0<= nx < R and 0 <= ny < C :
            if A[nx][ny] == '#' :
                continue
            
            if J[x][y] + 1 >= F[nx][ny] :
                continue
            
            if J[nx][ny] != INF :
                continue

            J[nx][ny] = J[x][y] + 1
            jq.append((nx, ny))

print("IMPOSSIBLE")