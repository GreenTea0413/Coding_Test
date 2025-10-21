/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    const len = nums.length
    const answer = Array.from({length : len}, () => 1)
    
    let left = 1
    for(let i = 0; i < len; i++){
        answer[i] *= left
        left *= nums[i]
    }

    let right = 1
    for(let j = len - 1; j  >= 0; j--){
        answer[j] *= right
        right *= nums[j]
    }

    return answer
};