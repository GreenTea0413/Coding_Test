import sys
input = sys.stdin.readline

N, M = map(int, input().split())
r,c,a = map(int, input().split())
arr = [[0]*M for _ in range(N)]

for i in range(N) :
    arr[i] = list(map(int,input().split()))

answer = 0
dx = [-1,0,1,0]
dy = [0,1,0,-1]

while True :
    if arr[r][c] == 0 :
        arr[r][c] = 2
        answer += 1
    
    all_clean = True
    for i in range(4) :
        nx = r + dx[i]
        ny = c + dy[i]

        if 0 <= nx < N and 0 <= ny < M and arr[nx][ny] == 0 :
            all_clean = False
            break
    
    if all_clean :
        ba = (a + 2) % 4
        nx = r + dx[ba]
        ny = c + dy[ba]

        if 0 <= nx < N and 0 <= ny < M and arr[nx][ny] != 1:
            r = nx
            c = ny
        else :
            break
    else :
        a = (a + 3) % 4
        nx = r + dx[a]
        ny = c + dy[a]
        if 0 <= nx < N and 0 <= ny < M and arr[nx][ny] == 0:
            r = nx
            c = ny
print(answer)
