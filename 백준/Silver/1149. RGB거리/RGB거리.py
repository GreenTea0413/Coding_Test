N = int(input())
A = [list(map(int,input().split())) for _ in range(N)]

dp = [[0] * 3 for _ in range(N)]

dp[0][0] = A[0][0]
dp[0][1] = A[0][1]
dp[0][2] = A[0][2]

for i in range(1, N) :
    dp[i][0] = A[i][0] + min(dp[i-1][1],dp[i-1][2])
    dp[i][1] = A[i][1] + min(dp[i-1][0],dp[i-1][2])
    dp[i][2] = A[i][2] + min(dp[i-1][0],dp[i-1][1])

print(min(dp[N-1][0], dp[N-1][1], dp[N-1][2]))

