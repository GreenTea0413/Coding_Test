function solution(n, lost, reserve) {
    var answer = 0;
    
    var map = Array(n).fill(1)
    
    for(const l of lost){
        map[l - 1] -= 1
    }
    
    for(const r of reserve){
        map[r - 1] += 1
    }
    
    for(let i = 0; i < n; i++){
        if(map[i] === 0){
            if(map[i - 1] > 1){
                map[i] += 1
                map[i - 1] -= 1
            }
            else if(map[i + 1] > 1){
                map[i] += 1
                map[i + 1] -= 1
            }
        }
    }
    
    for(let i = 0; i < n; i++){
        if(map[i] > 0) answer += 1
    }
    return answer;
}