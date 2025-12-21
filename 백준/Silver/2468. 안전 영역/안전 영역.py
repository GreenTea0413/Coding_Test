import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
A = [list(map(int,input().split())) for _ in range(N)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]
answer = 0
m = 0
for a in A :
    m = max(a)

def bfs(height) :
    count = 0
    temp = [[0] * N for _ in range(N)]
    
    for i in range(N) :
        for j in range(N) :
            if A[i][j] <= height :
                temp[i][j] = 1
    v = [[False] * N for _ in range(N)]
    for k in range(N) :
        for l in range(N) :
            if temp[k][l] == 0 and v[k][l] == False:
                q = deque([(k,l)])
                v[k][l] = True
                count += 1
                while q : 
                    x, y = q.popleft()

                    for o in range(4) :
                        nx, ny = x + dx[o], y + dy[o]

                        if 0 <= nx < N and 0 <=ny < N :
                            if v[nx][ny] == False and temp[nx][ny] == 0:
                                q.append((nx,ny))
                                v[nx][ny] = True
    return count

# 높이는 0부터 최댓값까지 다 해보기 (비가 안 올 수도 있음)
for i in range(m + 1) :
    # bfs로 i 보다 작은 수들 처리해서 영역 개수 구하기
    answer = max(bfs(i), answer)

print(answer)