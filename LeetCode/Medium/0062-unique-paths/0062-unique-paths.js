/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    const dp = Array.from({length : m}, () => Array(n + 1).fill(0))

    dp[0][0] = 1
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            if(i == 0) dp[i][j] = 1
            if(j == 0) dp[i][j] = 1
            if(i > 0 && j > 0) dp[i][j] += dp[i-1][j] + dp[i][j-1]
        }
    }

    return dp[m-1][n-1]
};