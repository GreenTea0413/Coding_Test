/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    const dx = [0,0,1,-1]
    const dy = [1,-1,0,0]
    const visited = Array.from({length:grid.length}, () => 
                        Array.from({length:grid[0].length}, () => false))

    let answer = 0;

    for(let i = 0; i < grid.length; i++){
        for(let j = 0; j < grid[0].length; j++){
            if(!visited[i][j] && grid[i][j] == "1"){
                dfs(i,j)
                answer++
            }
        }
    }

    function dfs(x, y){
        visited[x][y] = true

        for(let k = 0; k < 4; k++){
            const nx = dx[k] + x
            const ny = dy[k] + y
            if(0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length){
                if(!visited[nx][ny] && grid[nx][ny] === "1"){
                    dfs(nx,ny)
                }
            }
        }
    }
    return answer
};

