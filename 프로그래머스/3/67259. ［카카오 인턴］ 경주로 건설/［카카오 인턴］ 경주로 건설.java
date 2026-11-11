import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int n;
    int[][] d = {{0,1}, {1,0},{0,-1},{-1,0}};
    public int solution(int[][] board) {
        this.n = board.length;
        
        // 보드, 
        bfs(board);
        return answer;
    }
    
    void bfs(int[][] board){
        // x, y, 방향, 비용
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[3] - b[3]));
        pq.offer(new int[]{0,0,-1,0});
        int[][][] cost = new int[n][n][4];
        for (int[][] a : cost) for (int[] b : a) Arrays.fill(b, Integer.MAX_VALUE);
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int x = now[0]; int y = now[1]; int dir = now[2]; int count = now[3];
        
            if(x == n - 1 && y == n - 1) {
                answer = Math.min(answer, count);
                continue;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = x + d[i][0]; int ny = y + d[i][1];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                
                int nextCost = count;
                // 방향 같은 곳
                if(i == dir || dir == -1) nextCost += 100;
                // 방향 다른곳
                else nextCost += 600;
                if(cost[nx][ny][i] > nextCost && board[nx][ny] == 0){
                    cost[nx][ny][i] = nextCost;
                    pq.offer(new int[]{nx,ny,i,nextCost});
                }
            }
        }
        
        for(int c : cost[n-1][n-1]){
            answer= Math.min(c, answer);
        }
    }
}