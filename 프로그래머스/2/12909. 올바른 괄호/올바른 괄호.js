function solution(s){
    var answer = true;

    const stack = [];

    // 일단 첫번째꺼 넣기
    for (c of s){
        if(c === '('){
            stack.push(c);
        }
        else if(c === ')'){
            if(stack.length === 0){
                return false;
            }
            else
                stack.pop();
        }
    }
    if(stack.length > 0) answer = false;
    return answer;
}