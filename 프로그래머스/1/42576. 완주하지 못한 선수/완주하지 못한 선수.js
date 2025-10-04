function solution(participant, completion) {
    var map = new Map();
    
    for (const p of participant){
        map.set(p, (map.get(p) | 0) + 1)
    }
    
    for (const c of completion){
        map.set(c, (map.get(c)) - 1)
    }
    
    for(const [name, count] of map){
        if(count > 0){
            return name
        }
    }
}