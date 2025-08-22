function solution(numbers, target) {
    var answer = 0;
    
     return dfs(numbers, 0, 0, target)
}

function dfs (numbers, index, sum, target){
    if(index === numbers.length){
        if(sum === target) return 1;
        else return 0
    }
    
    return dfs(numbers, index + 1, sum + numbers[index], target) + dfs(numbers, index + 1, sum - numbers[index], target)
}