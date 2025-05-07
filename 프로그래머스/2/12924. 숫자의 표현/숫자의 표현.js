function solution(n) {
    var answer = 1;

    for(let i = 1; i <= n / 2; i++){
        let sum = i;
        for(let j = i + 1; j <= (n + 1) / 2; j++){
            sum += j;
            if(sum > n){
                break;
            }
            else if(sum == n){
                answer += 1;
                break;
            }
        }
    }
    
    return answer;
}