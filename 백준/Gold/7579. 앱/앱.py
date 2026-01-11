import sys
input = sys.stdin.readline

# 앱
N, M = map(int, input().split())
A = list(map(int, input().split()))
C = list(map(int, input().split()))

max_cost = sum(C)
dp = [0] * (max_cost + 1)

for i in range(1, N+1) :
    for j in range(max_cost, C[i-1] - 1, -1) :
        dp[j] = max(dp[j], dp[j - C[i-1]] + A[i-1])

for k in range(max_cost + 1) :
    if dp[k] >= M :
        print(k)
        break