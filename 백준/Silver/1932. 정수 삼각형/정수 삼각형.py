N = int(input())
A = [list(map(int, input().split())) for _ in range(N)]

dp = [0] * N
for i in range(N) :  
    for j in range(i, -1, -1) :
        if j == 0 :
            dp[j] = dp[j] + A[i][j]
        elif j == i :
            dp[j] = dp[j-1] + A[i][j]
        else :
            dp[j] = max(dp[j], dp[j-1]) + A[i][j]

print(max(dp))