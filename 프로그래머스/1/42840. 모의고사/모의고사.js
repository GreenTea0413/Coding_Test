function solution(answers) {
    var answer = [];
    //1, 2, 3, 4, 5
    //2, 1, 2, 3, 2, 4, 2, 5
    //3, 3, 1, 1, 2, 2, 4, 4, 5, 5
    let u1 = [1, 2, 3, 4, 5];
    let u2 = [2, 1, 2, 3, 2, 4, 2, 5];
    let u3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    
    let count = [0,0,0];
    
    for(let i = 0; i < answers.length; i++){
        if(u1[i % 5] === answers[i]) count[0] += 1;
        if(u2[i % 8] === answers[i]) count[1] += 1;
        if(u3[i % 10] === answers[i]) count[2] += 1;
    }
    
    let max = Math.max(...count);
    for(let i = 0; i < 3; i++){
        if(max == count[i])
            answer.push(i + 1);
    }
    return answer;
}