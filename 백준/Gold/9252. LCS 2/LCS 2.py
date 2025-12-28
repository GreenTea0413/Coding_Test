str1 = input()
str2 = input()

n = len(str1)
m = len(str2)

dp = [[0] * (m+1) for _ in range(n+1)]

for i in range(1, n+1) :
    for j in range(1, m+1) :
        if str1[i-1] == str2[j-1] :
            dp[i][j] = dp[i-1][j-1] + 1
        else :
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])

print(dp[n][m])

if dp[n][m] != 0 :
    x, y = n, m
    lcs = []

    while x > 0 and y > 0 :
        if str1[x-1] == str2[y-1] :
            lcs.append(str1[x-1])
            x-=1
            y-=1
        else :
            if dp[x][y] == dp[x-1][y] :
                x -= 1
            elif dp[x][y] == dp[x][y-1] :
                y -= 1
    print(''.join(reversed(lcs)))

