# 백준 14502 - 연구소
# https://www.acmicpc.net/problem/14502
# 난이도: 골드 4
# 알고리즘: BFS + 브루트포스/백트래킹
from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
temp = [[0] * M for _ in range(N)]

dx=[0,0,1,-1]
dy=[1,-1,0,0]

# 그 후에 바이러스 감염 구하기
def bfs():
    q = deque([])
    v = [[False] * M for _ in range(N)]

    for i in range(N):
        for j in range(M):
            temp[i][j] = A[i][j]
            
    for i in range(N) :
        for j in range(M) :
            if temp[i][j] == 2 :
                v[i][j] = True
                q.append((i,j))
                while q :
                    x, y = q.popleft()             
                    for k in range(4) :
                        nx, ny = x + dx[k], y + dy[k]
                        if 0<=nx <N and 0<=ny<M and v[nx][ny]== False and temp[nx][ny] == 0 :
                            temp[nx][ny] = 2
                            v[nx][ny] = True
                            q.append((nx,ny))

    count = 0
    for l in range(N) :
        for m in range(M) :
            if temp[l][m] == 0 :
                count += 1
    return count

answer = 0
# 벽을 먼저 3개 세울 수 있는 방법 생각
def wall(count) :
    global answer
    if count == 3 :
        answer = max(answer,bfs())
        return
    
    for i in range(N) :
        for j in range(M) :
            if A[i][j] == 0 :
                A[i][j] = 1 
                wall(count+1)
                A[i][j] = 0

wall(0)
print(answer)