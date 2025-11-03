/**
 * @param {number} rowIndex
 * @return {number[]}
 */
var getRow = function(rowIndex) {
    const dp = Array.from({length : rowIndex+1}, () => 0)
    dp[0] = 1

    for(let i = 1; i <= rowIndex; i++){
        for(let j = i; j >= 1; j--){
            dp[j] = dp[j] + dp[j-1]
        }
    }
    return dp
};