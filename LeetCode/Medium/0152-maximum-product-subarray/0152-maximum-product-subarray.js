/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    let maxProd = nums[0];
    let minProd = nums[0];
    let result = nums[0];

    for (let i = 1; i < nums.length; i++) {
        const cur = nums[i];

        if (cur < 0) {
            [maxProd, minProd] = [minProd, maxProd];
        }

        maxProd = Math.max(cur, maxProd * cur);
        minProd = Math.min(cur, minProd * cur);

        result = Math.max(result, maxProd);
    }

    return result;
};