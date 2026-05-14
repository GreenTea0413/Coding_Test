import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] board = new int[102][102];
        
        // 테두리만 이렇게 칠하기
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
        
        // 구멍 뚫기
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
        int[][] d = {{1,0}, {0,1}, {0,-1},{-1,0}};
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0], y = now[1], dist = now[2];
            
            if (x == itemX * 2 && y == itemY * 2) return dist / 2;
            if (v[x][y]) continue;
            
            v[x][y] = true;
            for(int i = 0; i < 4; i++){
                int nx = x + d[i][0], ny = y + d[i][1];
                if(0 <= nx && nx < 102 && 0 <= ny && ny < 102 && board[nx][ny] == 1){
                    q.offer(new int[]{nx, ny, dist + 1});
                }
            }
            
        }
        return answer;
    }
}
