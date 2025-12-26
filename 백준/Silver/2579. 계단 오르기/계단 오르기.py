N = int(input())
A = [0] * (N+1)
dp = [0] * (N+1)

for j in range(1, N+1) :
    A[j] = int(input())

dp[1] = A[1]
if N >= 2 :
    dp[2] = A[1] + A[2]

for i in range(3, N+1) :
    dp[i] = max(dp[i-3] + A[i-1] + A[i], 
                dp[i-2] + A[i])

print(dp[N])