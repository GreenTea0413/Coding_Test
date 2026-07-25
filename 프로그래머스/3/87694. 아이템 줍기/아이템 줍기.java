import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] board = new int[102][102];
        int[][] d = {{0,1}, {0,-1},{1,0},{-1,0}};
        
        for(int[] rec : rectangle){
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
                
            for(int i = x1; i < x2 + 1; i++){
                for(int j = y1; j < y2 + 1; j++){
                    board[i][j] = 1;
                }
            }    
        }
        
        for(int[] rec : rectangle){
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
                
            for(int i = x1 + 1; i < x2; i++){
                for(int j = y1 + 1; j < y2; j++){
                    board[i][j] = 2;
                }
            }    
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{characterX * 2, characterY * 2, 0});
        boolean[][] v = new boolean[102][102];
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int dist = now[2];
            
            if(x == itemX * 2 && y == itemY * 2){
                return dist / 2;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                
                if(nx < 0 || nx > 101 || ny < 0 || ny > 101) continue;
                
                if(!v[nx][ny] && board[nx][ny] == 1){
                    q.offer(new int[]{nx, ny, dist + 1});
                    v[nx][ny] = true;
                }
            }
        }
        
        return answer;
    }
}