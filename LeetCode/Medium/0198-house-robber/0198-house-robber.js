/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    const len = nums.length
    const memo = Array.from({length : len}, () => Infinity)

    function dp(n){
        if(n === 0) return nums[0]
        if(n === 1) return Math.max(nums[1], nums[0])

        if(memo[n] === Infinity){
            memo[n] = Math.max(dp(n-1), dp(n-2) + nums[n])
        }

        return memo[n]
    }

    return dp(len-1)
};