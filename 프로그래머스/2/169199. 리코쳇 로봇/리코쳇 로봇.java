import java.util.*;

class Solution {
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i].charAt(j) == 'R') {
                    q.offer(new int[]{i, j, 0});
                    v[i][j] = true;
                }
            }
        }
        
        int[][] d = {{1,0},{0,1},{-1,0},{0,-1}};
        
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            if(board[now[0]].charAt(now[1]) == 'G') return now[2];
            
            for(int i = 0; i < 4; i++){
                int tx = now[0], ty = now[1];               // 현재 위치에서 시작
                while (true) {
                    int nx = tx + d[i][0], ny = ty + d[i][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx].charAt(ny) == 'D') break;
                    tx = nx; ty = ny;
                }
                if((now[0] != tx || now[1] != ty) && !v[tx][ty]) {
                    q.offer(new int[]{tx, ty, now[2] + 1});
                    v[tx][ty] =true;
                }
            }
        }
        return -1;
    }
}