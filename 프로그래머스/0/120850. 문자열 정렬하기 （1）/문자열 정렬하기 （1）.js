function solution(my_string) {
    var answer = [];
    
    for(c of my_string){
        if('0' <= c && c <= '9'){
            answer.push(Number(c));
        }
    }
    return answer.sort((a, b) => a - b);
}