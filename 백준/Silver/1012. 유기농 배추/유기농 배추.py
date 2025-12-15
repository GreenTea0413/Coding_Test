# 백준 1012 - 유기농 배추
# https://www.acmicpc.net/problem/1012
# 난이도: 실버 2
# 알고리즘: DFS/BFS (연결 요소)
import sys
from collections import deque
input = sys.stdin.readline

T = int(input())
dx = [0,0,1,-1]
dy = [1,-1,0,0]

for _ in range(T):
    M, N, K = map(int, input().split())
    A = [[0] * M for _ in range(N)]
    q = deque([])
    answer = 0

    for _ in range(K) :
        x,y=map(int, input().split())
        A[y][x] = 1
    
    for i in range(N) :
        for j in range(M) :
            if A[i][j] == 1 :
                q.append((i,j))
                A[i][j] = 0 
                answer += 1

            while q :
                x, y = q.popleft()

                for l in range(4) :
                    nx, ny = x + dx[l], y + dy[l]
                    if 0<=nx < N and 0<=ny< M and A[nx][ny]== 1 :
                        q.append((nx,ny))
                        A[nx][ny] = 0
    print(answer)