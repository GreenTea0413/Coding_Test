function solution(maps) {
    const n = maps.length;
    const m = maps[0].length; 
    
    const dx = [0, 0, 1, -1];
    const dy = [1, -1, 0, 0];

    const visited = Array.from(Array(n),() => Array(m).fill(false));
    const queue = [[0, 0, 1]];
    visited[0][0] = true;
    
    while (queue.length > 0){
        const [x, y, dist] = queue.shift();
        if(x == n - 1 && y == m - 1) return dist;
        
        for(let i = 0; i < 4; i++){
            const nx = x + dx[i];
            const ny = y + dy[i];
            
            if(0 <= nx && nx < n && 0 <= ny && ny < m){
                if(!visited[nx][ny] && maps[nx][ny] != 0){
                    visited[nx][ny] = true;
                    queue.push([nx,ny,dist+1]);
                }
            }
        }
    }
    
    return -1;
}