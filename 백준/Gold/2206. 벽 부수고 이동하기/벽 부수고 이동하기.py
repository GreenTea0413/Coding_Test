from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A =[[] * M for _ in range(N)] 

for i in range(N) :
    nums = input().strip()

    for num in nums :
        A[i].append(int(num))

dx=[0,0,1,-1]
dy=[1,-1,0,0]
v = [[[False] * 2 for _ in range(M)] for _ in range(N)]
q = deque([(0,0,1,1)])
v[0][0][1] = True
while q :
    x,y,d,j = q.popleft()

    if x == N-1 and y == M-1 :
        print(d)
        exit()

    for i in range(4) :
        nx, ny = x + dx[i], y + dy[i]

        if 0 <= nx < N and 0 <= ny < M :
            if A[nx][ny] == 1 and j > 0 and v[nx][ny][j-1] == False :
                v[nx][ny][j-1] = True
                q.append((nx,ny,d+1,j-1))
            elif A[nx][ny] == 0 and v[nx][ny][j] == False :
                v[nx][ny][j] = True
                q.append((nx,ny,d+1,j))

print(-1)