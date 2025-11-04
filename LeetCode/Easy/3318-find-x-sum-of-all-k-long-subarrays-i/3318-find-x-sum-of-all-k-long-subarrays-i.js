/**
 * @param {number[]} nums
 * @param {number} k
 * @param {number} x
 * @return {number[]}
 */
var findXSum = function(nums, k, x) {
    const result = [];

    for (let i = 0; i <= nums.length - k; i++) {
        const sub = nums.slice(i, i + k);
        const freq = new Map();

        for (const num of sub) {
            freq.set(num, (freq.get(num) || 0) + 1);
        }

        const sorted = Array.from(freq.entries()).sort((a, b) => {
            if (b[1] === a[1]) return b[0] - a[0]; 
            return b[1] - a[1]; 
        });

        const top = new Set(sorted.slice(0, x).map(([num]) => num));
        const sum = sub.filter(v => top.has(v)).reduce((a, b) => a + b, 0);

        result.push(sum);
    }

    return result;
};