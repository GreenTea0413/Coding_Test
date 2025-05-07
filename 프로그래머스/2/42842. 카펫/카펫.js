function solution(brown, yellow) {
    var answer = [];
    
    s = brown + yellow;
    let h = 0;
    for(let w = 1; w < s + 1; w++){
        if (s % w == 0){
            h = s / w;
            if(w >= h){
                if ((w-2) * (h-2) == yellow){
                    answer.push(w);
                    answer.push(h);}
            }
        }
    }
    return answer;
}