n,k = map(int, input().split())
A = [int(input()) for _ in range(n)]

INF = float('inf')
dp = [INF] * (k + 1)
dp[0] = 0

# 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
# 0 1 0 0 0 1 0 0 0 0  0  0  1  0  0  0 

for a in A :
    for i in range(a, k + 1) :
        dp[i] = min(dp[i], dp[i - a] + 1)

if dp[k] == INF :
    print(-1)
else : 
    print(dp[k])