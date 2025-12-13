import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
A = [[]*M for _ in range(N)]

for i in range(N) :
    words = input().strip()
    for w in words :
        A[i].append(int(w))

dx =[0,0,1,-1]
dy =[1,-1,0,0]
visited = [[False]*M for _ in range(N)]
q = deque([(0,0,1)])
visited[0][0] = True

while q :
    x,y,d = q.popleft()
    if x == N-1 and y==M-1 :
        print(d)
        exit()

    for i in range(4) :
        nx,ny = x + dx[i], y + dy[i]

        if 0<=nx<N and 0<=ny<M and visited[nx][ny] == False and A[nx][ny] == 1 :
            q.append((nx,ny,d+1))
            visited[nx][ny] =True


