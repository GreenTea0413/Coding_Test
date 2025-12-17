# 백준 1987 - 알파벳
# https://www.acmicpc.net/problem/1987
# 난이도: 골드 4
# 알고리즘: DFS + 백트래킹

import sys
from collections import deque
N, M = map(int, input().split())

A = [[''] * M for _ in range(N)]
for i in range(N) :
    words = input().strip()
    for j in range(M) :
        A[i][j] = words[j]



dx=[0,0,1,-1]
dy=[1,-1,0,0]
answer = 0
v = set([A[0][0]])

def dfs(a,b,dist,visited) :
    global answer
    answer = max(dist, answer)

    for i in range(4) :
        nx, ny = a + dx[i], b + dy[i]
        
        if 0 <= nx < N and 0 <=ny < M :
            if A[nx][ny] not in v :
                visited.add((A[nx][ny]))
                dfs(nx,ny,dist+1, v)
                visited.remove(A[nx][ny])

dfs(0,0,1,v)
print(answer)
