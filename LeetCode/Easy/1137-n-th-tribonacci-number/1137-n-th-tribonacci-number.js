/**
 * @param {number} n
 * @return {number}
 */
var tribonacci = function(n) {
    const memo = Array.from({length : n + 1}, () => 0)

    memo[0] = 0
    memo[1] = 1
    memo[2] = 1
    for(let i = 3; i < n + 1; i++){
        memo[i] = memo[i - 3] + memo[i - 2] + memo[i - 1]
    }

    return memo[n]
};