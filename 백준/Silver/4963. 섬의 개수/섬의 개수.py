import sys
from collections import deque
input = sys.stdin.readline

dx = [1,-1,0,0,1,1,-1, -1]
dy = [0,0,1,-1,1,-1,1, -1]

while True :
    n, m = map(int,input().split())

    if n == 0 and m == 0 :
        exit()

    maps = [] * m
    for i in range(m) :
        arr = list(map(int, input().split()))
        maps.append(arr)

    count = 0
    v = [[False] * n for _ in range(m)]
    for i in range(m) :
        for j in range(n) :
            if maps[i][j] == 1 and v[i][j] == False:
                queue = deque([(i,j)])
                count += 1
                
                while queue :
                    cx, cy = queue.popleft()
                    v[cx][cy] = True    
                    for k in range(8) :
                        nx, ny = cx + dx[k], cy + dy[k]

                        if 0 <= nx < m and 0 <= ny < n :
                            if v[nx][ny] == False and maps[nx][ny] == 1 :
                                queue.append((nx,ny))
                                v[nx][ny] = True
    print(count)