/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumProduct = function(nums) {
    if(nums.length === 3) return nums[0] * nums[1] * nums[2]
    const arr = nums.sort((a,b) => a - b)
    const len = nums.length
    let answer = 0
    console.log(arr)
    if(arr[0] < 0 && arr[1] < 0 && arr[len-1] >= 0){
        answer = Math.max(arr[0] * arr[1] * arr[len-1], arr[len-1] * arr[len-2] * arr[len-3])
    }
    else if(arr[0] >= 0) {
        answer = arr[len-1] * arr[len-2] * arr[len-3]
    }
    else{
        answer = arr[len-1] * arr[len-2] * arr[len-3]
    }

    return answer
};