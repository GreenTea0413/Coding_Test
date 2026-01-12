import sys
input = sys.stdin.readline

n = int(input())
matrices = []
for _ in range(n):
    r, c = map(int, input().split())
    matrices.append((r, c))

# 행/열을 미리 분리해서 인덱싱 오버헤드 줄이기
rows = [m[0] for m in matrices]
cols = [m[1] for m in matrices]

INF = float('inf')
dp = [[0] * n for _ in range(n)]

for length in range(2, n + 1):
    for i in range(n - length + 1):
        j = i + length - 1
        min_cost = INF
        
        for k in range(i, j):
            cost = dp[i][k] + dp[k + 1][j] + rows[i] * cols[k] * cols[j]
            if cost < min_cost:
                min_cost = cost
        
        dp[i][j] = min_cost

print(dp[0][n - 1])