import sys
input = sys.stdin.readline

T = int(input())

for t in range(T) :
    # 동전 가지 수
    N = int(input())
    # 동전 종류
    coins = list(map(int, input().split()))
    # 만들어야하는 돈
    M = int(input())

    dp = [0] * (M + 1)
    dp[0] = 1

    for c in coins :
        for i in range(c, M + 1) :
            dp[i] += dp[i - c]
    
    print(dp[M])
    