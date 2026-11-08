class Solution {
    int answer = Integer.MAX_VALUE;
    int[][] maze;
    int n; int m;
    boolean[][] rv; boolean[][] bv;
    
    public int solution(int[][] maze) {
        this.maze = maze;
        this.n = maze.length;
        this.m = maze[0].length;
        this.rv = new boolean[n][m];
        this.bv = new boolean[n][m];
        
        int rx, ry, bx, by; rx = ry = bx = by = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maze[i][j] == 1) {rx = i; ry = j;}
                if(maze[i][j] == 2) {bx = i; by = j;}
            }
        }
        rv[rx][ry] = true;
        bv[bx][by] = true;
        dfs(rx, ry, bx, by, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    int[][] d = {{0,1}, {1,0}, {0,-1},{-1,0}};
    void dfs(int rx, int ry, int bx, int by, int count){
        boolean rCheck, bCheck; rCheck = bCheck = false;
        
        if(maze[rx][ry] == 3) rCheck = true;
        if(maze[bx][by] == 4) bCheck = true;
        
        if(rCheck && bCheck) {answer = Math.min(answer, count); return;}
        if(count >= answer) return;
        
        for(int i = 0; i < 4; i++){
            int nrx = rCheck ? rx : rx + d[i][0]; int nry = rCheck ? ry : ry + d[i][1];
            
            // 그리고 범위 벗어나면 안되고 벽(5)면 안되고 방문했으면 안됨
            if(nrx < 0 || nrx >= n || nry < 0 || nry >= m || 
               maze[nrx][nry] == 5 || (!rCheck && rv[nrx][nry])) continue;
            
            rv[nrx][nry] = true;
            
            // 빨간거 먼저 옮겼ㅇ면 이제 파란거 옮기기
            for(int j = 0; j < 4; j++){        
                int nbx = bCheck ? bx : bx + d[j][0]; int nby = bCheck ? by : by + d[j][1];
                
                // 그리고 범위 벗어나면 안되고 벽(5)면 안되고 방문했으면 안됨
                if(nbx < 0 || nbx >= n || nby < 0 || nby >= m || 
                    maze[nbx][nby] == 5 || (!bCheck && bv[nbx][nby])) continue;
                
                // 그리고 빨간색이랑 파란색 아까 위치랑 바꾸기 안됨
                if(nbx == rx && nby == ry && nrx == bx && nry == by) continue;
                // 그리고 파란거는 늦게 움직였으니 빨간거 위치로 가면 안됨
                if(nbx == nrx && nby == nry) continue;
                
                bv[nbx][nby] = true;
                dfs(nrx, nry, nbx, nby, count + 1);
                bv[nbx][nby] = false;
             }
            rv[nrx][nry] = false;
        }
    }
}