N = int(input())
A = [0] * (N + 1)
dp = [0] * (N + 1)
for i in range(1, N + 1) :
    A[i] = int(input())

dp[1] = A[1]

if N >= 2 :
    dp[2] = A[1] + A[2]

for i in range(3, N + 1) :
    # 0 2 3 / 1 3 / 2
    # 1 3 4 / 2 4 / 3
    # 2 4 5 / 3 5 / 4
    dp[i] = max(dp[i-3] + A[i-1] + A[i],
                dp[i-2] + A[i],
                dp[i-1])
print(dp[N])