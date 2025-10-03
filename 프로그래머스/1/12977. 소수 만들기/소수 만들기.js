function solution(nums) {
    var answer = 0;
    
    for (var i = 0 ; i < nums.length-2; i ++){
        for(var j = i + 1; j < nums.length-1; j++){
            for(var k = j+1; k<nums.length; k++){
                if(isPrime(nums[i]+nums[j]+nums[k])) answer++;
            }
        }
    }
    return answer;
}

function isPrime(num){
    for(var i = 2; i <= Math.sqrt(num); i++){
        if(num % i == 0) return false
    }
    return true
}