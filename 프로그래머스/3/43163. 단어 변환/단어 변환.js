function solution(begin, target, words) {    
    const visited = Array.from({length : words.length}, () => false)
    let min = Infinity
    
    function dfs(begin, answer){
        if(begin === target && min > answer){ 
            min = answer
            return
        }

        for(let i = 0; i < words.length; i++){
            let count = 0
            for(let j = 0; j < begin.length; j++){
                if(begin[j] !== words[i][j]){
                    count++
                }
            }
            if(count === 1 && !visited[i]){
                visited[i] = true
                dfs(words[i], answer + 1)
                visited[i] = false
            }
        }
    }
    
    dfs(begin, 0)
    return min === Infinity ? 0 : min
}

