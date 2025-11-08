function solution(sizes) {
    var xLen = 0;
    var yLen = 0;
    
    for(const [w,h] of sizes){
        var max = Math.max(w,h)
        var min = Math.min(w,h)
        
        if(max > xLen) xLen = max
        if(min > yLen) yLen = min
    }
    return xLen * yLen; 
}