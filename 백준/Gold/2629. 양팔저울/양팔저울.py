import sys
input = sys.stdin.readline

n = int(input())
weights = list(map(int, input().split()))

m = int(input())
marbles = list(map(int, input().split()))

OFFSET = 15000
MAX_WEIGHT = 15000

dp = [[False] * (MAX_WEIGHT * 2 + 1) for _ in range(n + 1)]
dp[0][OFFSET] = True


for i in range(1, n + 1) :
    weight = weights[i - 1]

    for w in range(MAX_WEIGHT * 2 + 1):
        if not dp[i - 1][w]:
            continue

        # 1. 추를 안 쓰기
        dp[i][w] = True

        # 2. 추를 왼쪽에 놓기 (무게 증가)
        if w + weight <= MAX_WEIGHT * 2:
            dp[i][w + weight] = True

        # 3. 추를 오른쪽에 놓기 (무게 감소)
        if w - weight >= 0:
            dp[i][w - weight] = True

result = []
for marble in marbles:
    if marble > MAX_WEIGHT:
        result.append('N')
    elif dp[n][marble + OFFSET]:
        result.append('Y')
    else:
        result.append('N')

print(' '.join(result))