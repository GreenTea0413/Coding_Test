import sys
from collections import deque
input = sys.stdin.readline

N = int(input())

dx = [1,1,2,2,-1,-1,-2,-2]
dy = [2,-2,1,-1,2,-2,1,-1]


for _ in range(N) :
    L = int(input())
    start_x, start_y = map(int, input().split())
    end_x, end_y = map(int, input().split())

    q = deque([(start_x,start_y, 0)])
    v = [[False] * L for _ in range(L)]
    v[start_x][start_y] = True
    while q :
        x, y, d = q.popleft()
        if x == end_x and y == end_y :
            print(d)
            break

        for i in range(8) :
            nx, ny = x + dx[i], y + dy[i]

            if 0<=nx<L and 0<=ny<L and v[nx][ny] == False :
                q.append((nx,ny,d+1))
                v[nx][ny] = True