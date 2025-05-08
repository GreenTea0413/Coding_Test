function solution(nums) {
    const arr = new Set(nums);
    const n = nums.length / 2;
    
    return Math.min(arr.size, n);
}