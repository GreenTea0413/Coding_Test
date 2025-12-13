import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
A = [[] for _ in range(N)]

for i in range(N) :
    words = input().strip()
    for w in words :
        A[i].append(int(w))

visited = [[False] * N for _ in range(N)]
count = 0
answer = []

dx = [0,0,1,-1]
dy = [1,-1,0,0]

for i in range(N) :
    for j in range(N) :
        if visited[i][j] == False and A[i][j] == 1 :
            count += 1
            dist = 1
            queue = deque([(i,j)])
            visited[i][j] = True
            
            while queue :
                x, y = queue.popleft()
                visited[i][j] = True

                for k in range(4) :
                    nx, ny = x + dx[k], y + dy[k]
                    if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == False and A[nx][ny] == 1:
                        queue.append((nx,ny))
                        dist += 1
                        visited[nx][ny] = True
            answer.append(dist)

print(count)
answer.sort()
for a in answer :
    print(a)
            
                
