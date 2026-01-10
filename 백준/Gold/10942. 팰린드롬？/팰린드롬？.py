import sys
input = sys.stdin.readline

N = int(input())
A = [0] + list(map(int, input().split()))
dp = [[0] * (N+1) for _ in range(N+1)]

for i in range(1, N + 1) :
    dp[i][i] = 1

for i in range(1, N) :
    if A[i] == A[i+1] :
        dp[i][i+1] = 1

for length in range(3, N+1):
    for i in range(1, N-length+2):
        j = i + length - 1
        if A[i] == A[j] and dp[i+1][j-1]:
            dp[i][j] = 1

m = int(input())
for _ in range(m):
    s, e = map(int, input().split())
    print(dp[s][e])
