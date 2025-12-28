str1 = input()
str2 = input()

n = len(str1)
m = len(str2)

dp = [[0] * (m + 1) for _ in range(n + 1)]

# 각 문자열 마다 앞에서 비교해서 얼만큼 같은지
#   A C A Y K P
# C 0 1 0 0 0 0 
# A 1 1 2
# P
# C 
# A
# K

for i in range(1, n + 1) :
    for j in range(1, m + 1) :
        if str1[i-1] == str2[j-1] :
            dp[i][j] = dp[i-1][j-1] + 1
        else :
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])

print(dp[n][m])