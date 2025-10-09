function solution(maps) {
    
    const dx = [0,0,-1,1]
    const dy = [1,-1,0,0]
    
    const visited = Array.from({length:maps.length}, () => Array.from({length:maps[0].length}, () => false))
    
    const queue = [[0,0,1]]
    visited[0][0] = true
    
    while(queue.length > 0){
        const [x,y,dist] = queue.shift()
        
        if(x === maps.length-1 && y === maps[0].length-1){
            return dist
        }
        
        for(let i = 0; i < 4; i++){
            const nx = dx[i] + x
            const ny = dy[i] + y
            
            if(0 <= nx && nx < maps.length && 0 <= ny && ny < maps[0].length){
                if(!visited[nx][ny] && maps[nx][ny]){
                    visited[nx][ny] = true
                    queue.push([nx, ny, dist + 1])
                    
                }
            }
        }
    }
    return -1;
}