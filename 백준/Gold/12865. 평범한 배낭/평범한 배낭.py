N, K = map(int, input().split())

dp = [[0] * (K + 1) for _ in range(N + 1)]
A = [list(map(int, input().split())) for _ in range(N)]

# 물건: [(6,13), (4,8), (3,6), (5,12)]
# 배낭 무게 제한: 7

#      0  1  2  3  4  5  6  7
# 0    0  0  0  0  0  0  0  0
# 1    0  0  0  0  0  0 13 13
# 2    0  0  0  0  8  8 13 13
# 3    0  0  0  6  8  8 13 14
# 4    0  0  0  6  8 12 13 14

for i in range(1, N + 1) :
    weight, value = A[i-1]
    for w in range(K + 1):
        # 물건을 넣을 수 없는 경우
        if weight > w:
            dp[i][w] = dp[i-1][w]
        # 물건을 넣을 수 있는 경우
        else:
            dp[i][w] = max(
                dp[i-1][w],                      # 안 넣음
                dp[i-1][w - weight] + value     # 넣음
            )

print(dp[N][K])