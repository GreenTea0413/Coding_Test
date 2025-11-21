test = int(input())

def check (visit, N, x, y, flag) :
    visit[x][y] += flag
   
    for dx, dy in [(0,1), (1,0), (1,1),(-1,1),(-1,-1),(1,-1),(0,-1),(-1,0)] :
        for i in range(1, N) :
            nx, ny = x + dx * i, y + dy * i
            if nx >= 0 and nx < N and ny >= 0 and ny < N :
                visit[nx][ny] += flag

def DFS(visit, N, depth) :
    global answer
    
    if N == depth :
        answer += 1
        return
    for y in range(N) :
            if visit[depth][y] == 0 :
                check(visit, N, depth, y, 1)
                DFS(visit, N, depth + 1)
                check(visit, N, depth, y, -1)

for  tc in range(1, test + 1) :
    answer = 0
    N = int(input())
    visit = [[0] * N  for _ in range(N)]
    DFS(visit, N, 0)
    print(f"#{tc} {answer}")