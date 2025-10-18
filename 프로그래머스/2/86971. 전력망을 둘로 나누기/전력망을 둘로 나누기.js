function solution(n, wires) {
    var answer = Infinity;
    
    const graph = Array.from({length : n + 1}, () => [])
    
    
    for(const [a, b] of wires){
        graph[a].push(b)
        graph[b].push(a)
    }
    
    for(const [a, b] of wires){
        graph[a] = graph[a].filter((node) => node !== b)
        graph[b] = graph[b].filter((node) => node !== a)
        
        const visited = Array.from({length : n}, () => false)
        
        let num = dfs(1, graph, visited)
        
        let network = n - num
        
        answer = Math.min(answer, Math.abs(network - num))
        
        graph[a].push(b)
        graph[b].push(a)
    }
    
    return answer;
}

function dfs(root, graph, visited){
    let num = 0
    visited[root] = true
    
    for(let next of graph[root]){
        if(!visited[next]){
            num += dfs(next, graph, visited)
        }
    }
    return num + 1
}