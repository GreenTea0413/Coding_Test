# 0: 빈 칸
# 1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
# 9: 아기 상어의 위치 처음 크기는 2

from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
board = []
for i in range(n):
    row = list(map(int, input().split()))
    for j in range(n):
        if row[j] == 9:
            sx, sy = i, j
            row[j] = 0
    board.append(row)

size = 2
eat = 0
time = 0

dx = [-1,0,0,1]
dy = [0,-1,1,0]

# 지금 먹을 수 있는 물고기 거리 찾기
def bfs(x,y,size) :
    visited = [[-1] * n for _ in range(n)]
    queue = deque([(x,y)])
    visited[x][y] = 0

    fishes = []
    min_dist = float('inf')

    while queue :
        cx, cy = queue.popleft()
        dist = visited[cx][cy]

        if dist > min_dist :
            break

        for i in range(4) :
            nx, ny = cx + dx[i], cy + dy[i]

            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == -1:
                if board[nx][ny] <= size :
                    visited[nx][ny] = dist + 1
                    if 0 < board[nx][ny] < size :
                        fishes.append((dist+1, nx,ny))
                        min_dist = dist + 1
                    queue.append((nx,ny))
    if not fishes :
        return None
    fishes.sort()
    return fishes[0]

while True :
    result = bfs(sx,sy,size) 
    if result is None :
        break
    dist, nx, ny = result
    time += dist
    sx, sy = nx, ny
    board[nx][ny] = 0

    eat += 1
    if eat == size :
        size += 1
        eat = 0

print(time)