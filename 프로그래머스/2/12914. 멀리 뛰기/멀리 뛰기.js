
function solution(n) {
    var answer = 0;
    let dp = [];
    
    dp[1] = 1;
    dp[2] = 2;
    
    for(let i = 3; i <= n; i++){
        dp[i] = ( dp[i-2] + dp[i-1] ) % 1234567;
    }
    answer = dp[n];
    return answer;
}