function solution(array, commands) {
    var answer = [];

    for(const [a,b,c] of commands){
        const copy = array.slice(a - 1,b)
        copy.sort((a,b) => a - b)
        answer.push(copy[c - 1])
    }

    return answer;
}