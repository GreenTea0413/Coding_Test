/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    const len = nums.length
    const memo = Array.from({length : len}, () => 0)
    let answer = 1
    memo[0] = 1
    
    for(let i = 1; i < len; i++){
        memo[i] = 1
        for(let j = 0; j < i; j++){
            if(nums[i] > nums[j]){
                memo[i] = Math.max(memo[i], memo[j] + 1)
            }
        }
        answer = Math.max(memo[i], answer)
    }
    
    return answer
}