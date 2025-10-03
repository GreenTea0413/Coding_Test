function solution(participant, completion) {
    var answer = "";
    const map = new Map();
    
    for (const name of participant){
        map.set(name, (map.get(name) || 0) + 1);
    }
    
    for (const name of completion){
        map.set(name, (map.get(name) - 1));
    }
    
    for(const [name, count] of map.entries()){
        if(count > 0){
            answer = name;
        }
    }
    return answer;
}