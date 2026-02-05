import sys
input = sys.stdin.readline

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

black = []
white = []

for i in range(n) :
    for j in range(n) :
        if arr[i][j] == 1 :
            if (i+j) % 2 == 0 :
                black.append((i,j))
            else :
                white.append((i,j))

def dfs(idx, cnt, cells) :
    global best
    best = max(best,cnt)

    for i in range(idx, len(cells)):
        x, y = cells[i]
        d1 = x + y
        d2 = x - y + n -1

        if not diag1[d1] and not diag2[d2] :
            diag1[d1] = diag2[d2] = True
            dfs(i + 1, cnt + 1, cells)
            diag1[d1] = diag2[d2] = False


diag1 = [False] * (2 * n)
diag2 = [False] * (2 * n)

best = 0
dfs(0,0,black)
ans_black = best

diag1 = [False] * (2 * n)
diag2 = [False] * (2 * n)

best = 0 
dfs(0,0,white)
ans_white = best

print(ans_black + ans_white)