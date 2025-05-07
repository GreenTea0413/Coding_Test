function solution(names) {
    var answer = [];
    
    let len = names.length / 5;
    for (let i = 0; i < len; i++){
        answer.push(names[i * 5]);
    }
    
    
    return answer;
}