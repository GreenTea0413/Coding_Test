# 백준 2589 - 보물섬
# https://www.acmicpc.net/problem/2589
# 난이도: 골드 5
# 알고리즘: BFS (최장거리)
from collections import deque
N, M = map(int, input().split())
A = [[] * M for _ in range(N)]

for i in range(N):
    words = input().strip()
    for w in words :
        A[i].append(w)

dx=[0,0,1,-1]
dy=[1,-1,0,0]

def bfs(x, y) :
    v = [[False] * M for _ in range(N)]
    q = deque([(x,y,0)])
    v[x][y] = True
    max_d = 0

    while q :
        now_x, now_y, now_d = q.popleft()
        max_d = max(max_d, now_d)

        for j in range(4) :
            nx, ny = now_x + dx[j], now_y +dy[j]

            if 0<=nx<N and 0<=ny<M and v[nx][ny] == False and A[nx][ny] == 'L' :
                v[nx][ny]= True
                q.append((nx,ny, now_d+1))

    return max_d

answer = 0
for k in range(N) :
    for l in range(M) :
        if A[k][l] == 'L' :
            dist = bfs(k,l)
            answer = max(dist,answer)
print(answer)