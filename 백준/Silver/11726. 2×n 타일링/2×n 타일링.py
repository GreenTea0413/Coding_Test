# 백준 11726 - 2×n 타일링
# https://www.acmicpc.net/problem/11726
# 난이도: 실버 3
# 알고리즘: DP (기초)

N = int(input())
# 2 * N 크기 채우기

# 1 -> 1가지
# 2 -> 2가지
# 3 -> 3가지
# 4 -> 5가지

if N == 1 :
    print(1)
    exit()
else :
    dp = [0] * (N+1)
    dp[1] = 1
    dp[2] = 2

    for i in range(3, N + 1) :
        dp[i] = dp[i-2] + dp[i-1]
        
    print(dp[N] % 10007)