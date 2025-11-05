function solution(arr) {
    var answer = 0;
    
    for(const a of arr){
        answer += a
    }
    
    return answer / arr.length
}