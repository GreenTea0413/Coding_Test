function solution(n) {
    var answer = Infinity;
    
    for(let i = 0; i < n; i++){
        if(n % i === 1) answer = Math.min(answer,i)
    }
    
    return answer;
}