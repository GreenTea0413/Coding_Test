function solution(n, edge) {
    const graph = Array.from({length : n + 1}, () => [])
    
    for(const [a,b] of edge){
        graph[a].push(b)
        graph[b].push(a)
    }
    
    const visited = Array(n+1).fill(false)
    const queue = [[1,0]]
    visited[1] = true
    
    let maxDist = 0;
    let count = 0;
    
    while(queue.length > 0){
        const [cur, dist] = queue.shift();
        
        if(dist > maxDist){
            maxDist = dist
            count = 1
        }
        else if (dist === maxDist){
            count++
        }
        
        for(const next of graph[cur]){
            if(!visited[next]){
                visited[next] = true
                queue.push([next,dist + 1])
            }
        }
        
    }
    return count;
}