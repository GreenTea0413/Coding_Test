function solution(n) {
    var answer = 0;

    let next = n;
    let i = 1;
    while(1){
        let count_n = 0;
        let count_next = 0;
        next = n + i;
        
        let bin_n = n.toString(2);
        let bin_next = next.toString(2);
        
        for(num_n of bin_n){
            if(num_n == 1){
                count_n += 1;
            }
        }
        for(num_next of bin_next){
            if(num_next == 1){
                count_next += 1;
            }
        }
        if(count_n == count_next){
            answer = next;
            break;
        }
        i++;
    }
    return answer;
}