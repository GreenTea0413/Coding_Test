const fs = require('fs');
const input = fs
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'index.txt')
  .toString()
  .trim()
  .split('\n');

const N = Number(input[0])
const map = input.slice(1).map(line => line.split(' ').map(Number));
const dp = Array.from({length : N}, () => Array(N).fill(0))
var answer = 0

function dfs(x,y){
    if(dp[x][y] !== 0) return dp[x][y]
    
    const dx = [0,0,1,-1]
    const dy = [1,-1,0,0]
    
    dp[x][y] = 1
    for(let i = 0; i < 4; i++){
        var nx = x + dx[i], ny = y + dy[i]

        if(nx >= 0 && nx < N && ny >= 0 && ny < N){
            if(map[nx][ny] > map[x][y]){
                dp[x][y] = Math.max(dp[x][y], dfs(nx,ny) + 1)
            }
        }
    }

    return dp[x][y]
}

for(let i = 0; i <N; i++){
    for(let j = 0; j < N; j++){
        answer = Math.max(dfs(i,j), answer)
    }
}
console.log(answer);