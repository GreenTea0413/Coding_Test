function solution(s){
    var answer = true;
    const stack = [];
    
    for(c of s){
        if(c === '('){
            stack.push(c)
        }
        else if(c === ')'){
            if(stack.length === 0 ) return false 
            else stack.pop()
        }
    }
    if(stack.length > 0) return false
    return answer;
}