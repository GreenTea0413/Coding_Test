function solution(s1, s2) {
    var answer = 0;
    
    for(c1 of s1){
        for(c2 of s2){
            if(c1 === c2){
                answer += 1;
            }
        }
    }
    return answer;
}