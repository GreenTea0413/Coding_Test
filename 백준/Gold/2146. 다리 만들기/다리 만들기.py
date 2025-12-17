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

# 각 섬의 경계선 찾기
islands = {}
for i in range(N):
    for j in range(N):
        if map[i][j] > 0:
            island_num = map[i][j]
            # 인접한 칸이 바다인 경우 경계선
            for k in range(4):
                ni, nj = i + dx[k], j + dy[k]
                if 0 <= ni < N and 0 <= nj < N and map[ni][nj] == 0:
                    if island_num not in islands:
                        islands[island_num] = []
                    islands[island_num].append((i, j))
                    break

# 각 섬에서 다른 섬까지의 최단 거리 구하기
def bfs_from_island(borders, island_num):
    q = deque()
    v = [[False] * N for _ in range(N)]

    # 경계선 전체를 시작점으로
    for x, y in borders:
        q.append((x, y, 0))
        v[x][y] = True

    while q:
        x, y, d = q.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < N and 0 <= ny < N and not v[nx][ny]:
                # 다른 섬 발견
                if map[nx][ny] > 0 and map[nx][ny] != island_num:
                    return d
                # 바다
                elif map[nx][ny] == 0:
                    v[nx][ny] = True
                    q.append((nx, ny, d + 1))

    return float('inf')

# 모든 섬에서 최소 거리 찾기
answer = float('inf')
for island_num, borders in islands.items():
    dist = bfs_from_island(borders, island_num)
    answer = min(answer, dist)

print(answer)