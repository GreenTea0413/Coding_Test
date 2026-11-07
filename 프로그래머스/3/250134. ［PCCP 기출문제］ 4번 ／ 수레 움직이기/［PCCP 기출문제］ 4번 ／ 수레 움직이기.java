class Solution {
    int answer = Integer.MAX_VALUE;
    int n;
    int m;
    int[][] maze;
    int[][] d = {{0,1}, {0,-1},{1,0},{-1,0}};
    boolean[][] vr;
    boolean[][] vb;
    
    public int solution(int[][] maze) {
        // 동시에 같은 칸에는 못감
        // 각각의 수레는 본인의 수레가 갔던곳으로는 못감 boolean[][] v
        this.maze = maze;
        this.n = maze.length;
        this.m = maze[0].length;
        this.vr = new boolean[n][m];
        this.vb = new boolean[n][m];
        int rx = 0; int ry = 0; int bx = 0; int by = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maze[i][j] == 1) {rx = i; ry = j;}
                if(maze[i][j] == 2) {bx = i; by = j;}
            }
        }
        
        vr[rx][ry] = true;
        vb[bx][by] = true;
        
        // dfs로 백트래킹하면서 값 이동 시키고 둘 다 통과 되었을 경우의 최솟값을 구하기
        dfs(rx, ry, bx, by, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    void dfs(int rx, int ry, int bx, int by, int count){
        boolean rCheck = maze[rx][ry] == 3;
        boolean bCheck = maze[bx][by] == 4;
        
        if(rCheck && bCheck) {
            answer = Math.min(answer, count);
            return;
        }
        
        if(count >= answer) return;
        
        // 빨간거 움직이면서 동시에 파란것도 움직였을 때 되는지 안되는지
        for(int i = 0; i < 4; i++){
            int nrx = rCheck ? rx : d[i][0] + rx; int nry = rCheck ? ry : d[i][1] + ry;
            if(0 > nrx || nrx >= n || 0 > nry || nry >= m || (!rCheck && vr[nrx][nry])
               || maze[nrx][nry] == 5)
                continue;
            
            if(!rCheck) vr[nrx][nry] = true;
            
            for(int j = 0; j < 4; j++){
                int nbx = bCheck ? bx : d[j][0] + bx; int nby = bCheck ? by : d[j][1] + by;
                if(0 > nbx || nbx >= n || 0 > nby || nby >= m || (!bCheck && vb[nbx][nby])
                   || maze[nbx][nby] == 5) 
                    continue;
                // 같은 칸으로 이동 금지 (이미 있음)
                if (nrx == nbx && nry == nby) continue;
                // 서로 자리 바꾸기 금지
                if (nrx == bx && nry == by && nbx == rx && nby == ry) continue;
                
                if(!bCheck) vb[nbx][nby] = true;
                dfs(nrx, nry, nbx, nby, count + 1);
                if(!bCheck) vb[nbx][nby] = false;
            }
            if(!rCheck) vr[nrx][nry] = false;
        }
    }
}