function solution(nums) {
    var map = new Map()
    var answer = nums.length / 2
    for(const n of nums){
        map.set(n, map.get(n) + 1 || 1)
    }
    if(map.size < answer) return map.size
    
    return answer
    
}