# 백준 16948 - 데스 나이트
# https://www.acmicpc.net/problem/16948
# 난이도: 실버 1
# 알고리즘: BFS (6방향 이동)
import sys
from collections import deque
input= sys.stdin.readline

N = int(input())
A = [[False] * N for _ in range(N)]

r1, c1, r2, c2 = map(int,input().split())
A[r1][c1] = True
q = deque([(r1,c1,0)])

dx = [-2,-2,0,0,2,2]
dy = [-1,1,-2,2,-1,1]
while q : 
    x, y, d = q.popleft()

    if x == r2 and y == c2 :
        print(d)
        exit()
    
    for i in range(6) :
        nx, ny = x + dx[i], y + dy[i]

        if 0 <=nx<N and 0<=ny<N and A[nx][ny] == False :
            A[nx][ny] = True
            q.append((nx,ny,d+1))

print(-1)