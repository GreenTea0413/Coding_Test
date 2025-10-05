function solution(n, computers) {
    var answer = 0;
    
    const visited = Array(n).fill(false)
    
    
    // 110
    // 110
    // 001
    for(let i = 0; i < n; i++){
        if(visited[i]) continue
        dfs(n, computers, visited, i)
        answer++
    }    
    
    return answer;
}

function dfs(n, computers, visited, cur){
    visited[cur] = true
    
    for(let i = 0; i < n; i++){
        if(computers[i][cur] == 1 && !visited[i]){
            dfs(n, computers, visited, i)
        }
    }
    
}