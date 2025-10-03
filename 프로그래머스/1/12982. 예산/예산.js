function solution(d, budget) {
    var answer = 0;
    d.sort((a,b)=> a-b);
    for(var i = 0; i < d.length; i++){
        budget -= d[i]
        if(budget < 0){
            break;
        }
        answer++;
    }
    
    
    return answer;
    
    
}