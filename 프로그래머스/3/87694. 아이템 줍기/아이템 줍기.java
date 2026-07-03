import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] board = new int[102][102];
        
        // 테두리 만들기
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
        
        // 테두리 선만 남기고 안에 없애기
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
        
        int[][] d = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == itemX * 2 && cur[1] == itemY * 2){
                return cur[2] / 2;
            }
            if(v[cur[0]][cur[1]]) continue;
            v[cur[0]][cur[1]] = true;
            
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + d[i][0];
                int ny = cur[1] + d[i][1];
                if(nx < 0 || nx > 101 || ny < 0 || ny > 101) continue;
                if(!v[nx][ny] && board[nx][ny] == 1){
                    q.offer(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }
        
        
        return answer;
    }
}