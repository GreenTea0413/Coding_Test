/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    const memo = Array.from({length : n}, () => 0)

    memo[0] = 1
    if(n === 2) return 2
    memo[1] = 2
    for(let i = 2; i < n; i++){
        memo[i] = memo[i - 1] + memo[i - 2]
    }
    return memo[n-1]
};