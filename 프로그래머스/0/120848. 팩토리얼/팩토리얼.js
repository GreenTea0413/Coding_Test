function f(num){
    let ans = 1;
    for(let i = 2; i <= num; i++){
        ans *= i;
    }
    return ans;
}

function solution(n) {
    var answer = 0;
    for(let j = 1; j <= 10; j++){
        if(f(j) <= n && n <= f(j+1)){
            answer = j;
        }
    }
    return answer;
}