import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[][] d = {{0,1}, {1,0}, {0,-1}, {-1,0}};        
        int[][][] dp = new int[n][n][4];
        // 4방향 모두에 대한 값을 dp로 구하기
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
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0]; int y = now[1]; int dir = now[2]; int cost = now[3];
            
            if(x == n - 1 && y == n - 1){dp[x][y][dir] = Math.min(cost, dp[x][y][dir]);}
            
            for(int i = 0; i < 4; i++){
                int nx = x + d[i][0];
                int ny = y + d[i][1];
            
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                
                // 방향이 같을 때 0 오른쪽, 1 아래, 2 왼쪽, 3 위
                // 같으면 100원 다르면 600원
                int nextCost = cost;
                if(dir == -1 || dir == i){nextCost += 100;}
                else {nextCost += 600;}
                
                if(dp[nx][ny][i] > nextCost && board[nx][ny] == 0){    
                    q.offer(new int[]{nx,ny,i,nextCost});
                    dp[nx][ny][i] = nextCost;
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