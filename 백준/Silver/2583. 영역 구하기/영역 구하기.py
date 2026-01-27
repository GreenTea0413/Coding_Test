from collections import deque
import sys
input = sys.stdin.readline

m, n, k = map(int, input().split())

box = [[0] * (n) for _ in range(m)] # (5, 7)

for _ in range(k) :
    a,b,c,d = map(int, input().split())
    # 4 0 6 2 -> 0,4 2,6
    for x in range(b, d) :
        for y in range(a, c) :
            if box[x][y] == 0 :
                box[x][y] = 1

v = [[False] * n for _ in range(m)]
answer = 0
sqrs = []
dx =[0,0,1,-1]
dy =[1,-1,0,0]
for x in range(m) :
    for y in range(n) :
        if box[x][y] == 0 and v[x][y] == False :
            answer += 1
            queue= deque([(x,y)])
            s = 0
            while queue : 
                cx, cy = queue.popleft()
                v[cx][cy] = True
                s += 1

                for i in range(4) :
                    nx, ny = cx + dx[i], cy + dy[i]

                    if 0 <= nx < m and 0 <= ny < n :
                        if v[nx][ny] == False and box[nx][ny] == 0 :
                            v[nx][ny] = True
                            queue.append((nx,ny))
            sqrs.append(s)

print(answer)
sqrs.sort()
for s in sqrs :
    print(s, end=" ")
