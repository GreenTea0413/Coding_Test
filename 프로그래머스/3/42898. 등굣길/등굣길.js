function solution(m, n, puddles) {
    const num = 1_000_000_007;
    const dp = Array.from({ length: n + 1 }, () => Array(m + 1).fill(0));

    for(const[x, y] of puddles){
        dp[y][x] = -1
    }
    dp[1][1] = 1
    for (let y = 1; y <= n; y++) {
        for (let x = 1; x <= m; x++) {
            if (dp[y][x] === -1) {
                dp[y][x] = 0;
                continue;
            }
            if (y > 1) dp[y][x] += dp[y - 1][x] % num;
            if (x > 1) dp[y][x] += dp[y][x - 1] % num;
            dp[y][x] %= num;
        }
    }
    return dp[n][m];
}