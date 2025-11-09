function solution(name) {
    var answer = 0;
    
    var len = name.length
    var arr = Array(len).fill("A")
    var copy = name.split("")
    
    var a = 'A'.charCodeAt(0)
    var z = 'Z'.charCodeAt(0)
    
    for(let i = 0; i < len; i++){
        var c = copy[i].charCodeAt(0)
         answer += Math.min(z - c + 1, c - a)
    }
    
    var move = len - 1
    for(let i =0; i < len; i++){
        var next = i + 1
        while(next < len && copy[next] === 'A') next++
        
        const skip = i + len - next + Math.min(i, len - next)
        move = Math.min(skip, move)
    }
    return answer + move;
}