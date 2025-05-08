function solution(number) {
    var answer = 0;
    
    for(c of number){
        answer +=Number(c);
    }
    return answer % 9;
}