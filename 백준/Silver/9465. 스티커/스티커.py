T = int(input())

for _ in range(T) :
    N = int(input())
    A = []
    A.append(list(map(int, input().split())))
    A.append(list(map(int, input().split())))

    dp = [[0] * 3 for _ in range(N)]

    # 위, 아래, 안붙히기
    dp[0][0] = A[0][0]
    dp[0][1] = A[1][0]
    dp[0][2] = 0

    for i in range(1, N) :
        dp[i][0] = max(dp[i-1][1], dp[i-1][2]) + A[0][i]
        dp[i][1] = max(dp[i-1][0], dp[i-1][2]) + A[1][i]
        dp[i][2] = max(dp[i-1][0], dp[i-1][1], dp[i-1][2])
    
    print(max(dp[N-1]))