function solution(m, n, puddles) {
    var num = 1_000_000_007
    const dp = Array.from({length : n + 1}, () => Array(m + 1).fill(0))
    
    for(const [x, y] of puddles){
        dp[y][x] = -1
    }
    dp[1][1] = 1
    for(let i = 1; i < n + 1; i++){
        for(let j = 1; j < m + 1; j++){
            if(dp[i][j] === -1){
                dp[i][j] = 0
                continue
            }
            if( i > 1) dp[i][j] += dp[i-1][j] % num
            if( j > 1) dp[i][j] += dp[i][j-1] % num
            dp[i][j] %= num
        }
    }
    return dp[n][m];
}