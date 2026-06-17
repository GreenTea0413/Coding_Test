import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;

        int[][][] dp = new int[n][n][4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < 4; k++){
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,-1,0});
        for(int i = 0; i < 4; i++){
            dp[0][0][i] = 0;
        }
        
        // 0 아래 1 위 2 오른쪽 3 왼쪽
        int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            int x = now[0];
            int y = now[1];
            int dir = now[2];
            int cost = now[3];
            
            if(x == n - 1 && y == n - 1){
                dp[x][y][dir] = Math.min(cost, dp[x][y][dir]);
            }
            for(int i = 0; i < 4; i++){
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                
                if(0 <= nx && nx < n && 0 <= ny && ny < n && board[nx][ny] == 0){
                    int next = 0;
                    if(dir == i || dir == -1){next = cost + 100;}
                    else{next = cost + 600;}

                    if(dp[nx][ny][i] > next){
                        q.offer(new int[]{nx, ny, i, next});
                        dp[nx][ny][i] = next;
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            answer = Math.min(answer, dp[n-1][n-1][i]);
        }
        return answer;
        
    }
}