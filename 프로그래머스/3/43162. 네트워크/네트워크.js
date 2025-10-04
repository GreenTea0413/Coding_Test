function solution(n, computers) {
    var answer = 0;
    const visited = Array(n).fill(false);
    
    for(let i = 0; i < n; i++){
        if(visited[i]) continue
        dfs(n, computers, visited, i)
        answer ++;
    }
    
    return answer;
}

function dfs(n, computers, visited, cur){
    visited[cur] = true
    for(let i = 0; i < n; i++){
        if(!visited[i] && computers[cur][i] == 1){
            dfs(n, computers, visited, i)
        }
    }
}

