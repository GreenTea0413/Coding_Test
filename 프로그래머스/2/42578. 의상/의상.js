function solution(clothes) {
    const map = new Map();
    
    for(const [name, kind] of clothes){
        map.set(kind, (map.get(kind) || 0) + 1);
    }
    
    let count = 1;
    for(const value of map.values()){
        count *= (value + 1);
    }

    return count - 1;
}