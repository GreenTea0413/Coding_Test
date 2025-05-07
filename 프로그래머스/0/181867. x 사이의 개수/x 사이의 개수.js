function solution(myString) {
    var answer = [];
    let idx = 0;
    for(let i = 0; i < myString.length; i++){
        if(!answer[idx]) answer[idx] = 0;
        if(myString[i] == 'x'){
            idx += 1;
            if(!answer[idx]) answer[idx] = 0;
        }
        else{
            answer[idx] += 1;
        }
    }
    
    return answer;
}