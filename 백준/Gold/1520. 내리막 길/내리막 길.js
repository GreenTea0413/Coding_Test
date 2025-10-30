const fs = require('fs');
const input = fs
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'index.txt')
  .toString()
  .trim()
  .split('\n');

const [N, M] = input[0].split(' ').map(Number);
const map = input.slice(1).map(line => line.split(' ').map(Number));

const dp = Array.from({ length: N }, () => Array(M).fill(-1));

function dfs(x, y) {
    if (x === N - 1 && y === M - 1) return 1; 
    if (dp[x][y] !== -1) return dp[x][y]; 

    dp[x][y] = 0; 

    for (const [dx, dy] of [[0,1],[1,0],[-1,0],[0,-1]]) {
        const nx = x + dx;
        const ny = y + dy;

        if (
            0 <= nx && nx < N &&
            0 <= ny && ny < M &&
            map[nx][ny] < map[x][y]
        ) {
            dp[x][y] += dfs(nx, ny);
        }
    }

    return dp[x][y];
}

console.log(dfs(0, 0));