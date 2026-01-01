# 백준 2565 - 전깃줄
# https://www.acmicpc.net/problem/2565
# DP - LIS 응용

N = int(input())

lines = []
for _ in range(N) :
    a, b = map(int, input().split())
    lines.append((a,b))

lines.sort()

dp = [1] * (N + 1)
b_values = [b for a, b in lines]

# 8 2 9 1 4 6 7 10
for i in range(N) :
    for j in range(i) :
        if b_values[j] < b_values[i] :
            dp[i] = max(dp[i], dp[j] + 1)

print(N-max(dp))