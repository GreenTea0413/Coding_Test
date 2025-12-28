N = int(input())
A = list(map(int,input().split()))

dp = [0] * N

# 1 100 2 50 60 3 5 6 7 8
# 1 101 3 
for i in range(N) :
    dp[i] = A[i]
    for j in range(i) :
        if A[j] < A[i] :
            dp[i] = max(dp[i], dp[j] + A[i])
print(max(dp))