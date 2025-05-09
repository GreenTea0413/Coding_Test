function solution(priorities, location) {
    var answer =0;
    let queue = priorities.map((value, index) => ({index, value}));
    
    while(queue.length > 0){
        const current = queue.shift();
        
        const max = queue.some(p => p.value > current.value);
        
        if(max) {
            queue.push(current);
        }else {
            answer ++;
            if(current.index === location){
                return answer;
            }
        }
    }
}