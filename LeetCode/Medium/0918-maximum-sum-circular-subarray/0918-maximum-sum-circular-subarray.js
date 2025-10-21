/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubarraySumCircular = function(nums) {
    let curMax = 0
    let curMin = 0
    let max = -Infinity
    let min = Infinity
    let total = 0

    for(const n of nums){
        total += n

        curMax = Math.max(n, curMax + n)
        max = Math.max(curMax, max)

        curMin = Math.min(n, curMin + n)
        min = Math.min(curMin, min) 
    }

    if(max < 0) return max

    return Math.max(max, total - min)
};