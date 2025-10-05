/**
 * @param {number[][]} grid
 * @return {number}
 */
var shortestPathBinaryMatrix = function(grid) {
    const n = grid.length
    const m = grid[0].length
    
    if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1

    const dx = [0,0,1,-1,-1,-1,1,1]
    const dy = [1,-1,0,0,-1,1,1,-1]

    const visited = Array.from({length: n}, () => Array.from({length: m}, () => false))    
    const queue = [[0,0,1]]

    while(queue.length > 0){
        const [x, y, dist] = queue.shift()

        if (x === n - 1 && y === m - 1){
            return dist
        }

        for(let i = 0; i < 8; i++){
            const nx = x + dx[i]
            const ny = y + dy[i]
            if(0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length){
                if(!visited[nx][ny] && grid[nx][ny] === 0){
                    visited[nx][ny] = true
                    queue.push([nx,ny,dist + 1])
                }            
            }
        }
    }

    return -1
};

