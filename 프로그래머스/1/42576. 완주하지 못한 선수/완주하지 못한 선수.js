function solution(participant, completion) {
    var map = new Map()
    
    for(const name of participant){
        map.set(name, map.get(name) + 1 || 1)
    }
    
    for(const name of completion){
        map.set(name, map.get(name) - 1)
    }

    for(const [a, b] of map){
        if(b > 0){
            return a
        }
    }
}