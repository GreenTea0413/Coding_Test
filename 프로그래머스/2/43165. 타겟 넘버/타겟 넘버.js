function dfs(index, sum, numbers, target){
    if(index == numbers.length){
        if(sum == target) return 1;
        else return 0;
    }
    return dfs(index + 1, sum + numbers[index], numbers, target) + dfs(index + 1, sum - numbers[index], numbers, target)
}

function solution(numbers, target) {
    var answer = 0;
    
    
    return dfs(0,0,numbers, target);
}