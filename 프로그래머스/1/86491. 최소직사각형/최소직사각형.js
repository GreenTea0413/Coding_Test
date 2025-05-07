function solution(sizes) {
    var answer = 0;
    let maxW = 0;
    let maxH = 0;
    for(let[w,h] of sizes){
        const wLen = Math.max(w,h);
        const hLen = Math.min(w,h);
        
        if(maxW < wLen) maxW = wLen;
        if(maxH < hLen) maxH = hLen;
    }
    
    answer = maxW * maxH;
    return answer;
}