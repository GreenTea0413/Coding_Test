# 백준 2146 - 다리 만들기
# https://www.acmicpc.net/problem/2146
# 난이도: 골드 3
# 알고리즘: BFS (다단계)

import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
map = [list(map(int,input().split())) for _ in range(N)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]

# 각 섬마다 번호매기기
def island_number(x,y,num,visited):
    visited[x][y] = True
    q =deque([(x,y)])
    map[x][y] = num

    while q :
        a, b = q.popleft()
        for i in range(4) :
            nx, ny = a + dx[i], b + dy[i]
            if 0<=nx < N and 0<= ny < N :
                if visited[nx][ny] == False and map[nx][ny] == 1:
                    visited[nx][ny] = True
                    map[nx][ny] = num
                    q.append((nx,ny))

def island() :
    visited=[[False] * N for _ in range(N)]
    number = 1
    for i in range(N) :
        for j in range(N) :
            if map[i][j] == 1 and visited[i][j] == False:
                island_number(i,j,number,visited)
                number += 1
island()

# 섬마다 거리 구하기
def dist_island(a,b,island_num) :
    dist = float('inf')
    q = deque([(a,b,0)])
    v = [[False] * N for _ in range(N)]

    while q :
        x, y, d = q.popleft()

        for i in range(4) :
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < N and 0 <= ny < N and v[nx][ny] == False :
                if map[nx][ny] > 0 and map[nx][ny] != island_num :
                    dist = min(d, dist)
                elif map[nx][ny] == 0 :
                    v[nx][ny] = True 
                    q.append((nx,ny, d+1))

    return dist

# 섬마다 최소 거리 구하기
answer = float('inf')

for a in range(N) :
    for b in range(N) :
        if map[a][b] > 0 :
            dist = dist_island(a,b,map[a][b])
            answer = min(dist, answer) 

print(answer)