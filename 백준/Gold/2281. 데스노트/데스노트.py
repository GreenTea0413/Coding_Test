import sys
input = sys.stdin.readline

# 데스노트
# 마지막 줄부터 채운다 생각하고 거꾸로 하기
n, m =map(int,input().split())
names = [int(input()) for _ in range(n)]
dp = [float('inf')] * (n + 1)
dp[n] = 0

# 11 20
for i in range(n-1, -1, -1) :
    length = 0
    for j in range(i, n) :
        if j == i :
            length = names[j]
        else :
            length += 1 + names[j]
        
        if length > m :
            break

        if j == n - 1 :
            cost = 0
        else :
            cost = (m - length) ** 2
        
        dp[i] = min(dp[i], cost + dp[j+1])

print(dp[0])