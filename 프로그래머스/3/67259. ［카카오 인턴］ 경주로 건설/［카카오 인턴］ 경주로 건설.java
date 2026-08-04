import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int[][][] dp = new int[n][n][4];
        
        for(int i = 0; i < n; i++){
            for(int j =0; j < n; j++){
                for(int k =0; k < 4; k++){
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        for(int i = 0; i < 4; i++){
            dp[0][0][i] = 0;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,-1,0});
        int[][] d = {{0,1}, {0,-1},{1,0},{-1,0}};
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0]; int y = now[1]; int dir = now[2]; int cost = now[3];
            
            //if(dir != -1 && cost > dp[x][y][dir]) continue; 
            
            if(x == n - 1 && y == n - 1){
                dp[x][y][dir] = Math.min(dp[x][y][dir], cost);
            }
            
            for(int i = 0 ; i < 4; i++){
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                int nextCost = cost;
                if(dir == -1 || dir == i) nextCost += 100;
                else nextCost += 600;

                if(board[nx][ny] == 0 && nextCost < dp[nx][ny][i]){
                    q.offer(new int[]{nx, ny, i, nextCost});
                    dp[nx][ny][i] = nextCost;
                }
            }
        }
        
        for(int i = 0; i < 4; i++){
            answer = Math.min(answer,dp[n - 1][n - 1][i]);
        }
        
        return answer;
    }
}