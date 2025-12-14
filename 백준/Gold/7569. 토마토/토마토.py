from collections import deque
import sys
input=sys.stdin.readline

N,M,H = map(int, input().split())

A = [[list(map(int,input().split())) for _ in range(M)] for _ in range(H)]
q = deque([])
for i in range(H) :
    for j in range(M) :
        for k in range(N):
            if A[i][j][k] == 1 :
                q.append((i,j,k))

dx = [1,-1,0,0,0,0]
dy = [0,0,1,-1,0,0]
dz = [0,0,0,0,-1,1]
answer = 0

while q :
    z, y, x = q.popleft()

    for i in range(6) :
        nx,ny,nz = x +dx[i], y+dy[i], z+dz[i]

        if  0<=nz<H and  0<=ny<M and 0<=nx<N and A[nz][ny][nx] == 0 :
            q.append((nz,ny,nx))
            A[nz][ny][nx] = A[z][y][x] + 1

for i in range(H) :
    for j in range(M) :
        for k in range(N):
            if A[i][j][k] == 0 :
                print(-1)
                exit()
            else :
                answer = max(A[i][j][k], answer)
print(answer - 1)