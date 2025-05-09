function solution(s) {
    let answer = true;
    if(s.length == 4 || s.length == 6) answer = true;
    else return false;
    for(c of s){
        if(0 <= c && c <= 9){
            answer = true;
        }
        else return false;
    }
    
    return answer;
}