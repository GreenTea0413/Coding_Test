import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 일단 테두리를 따라가면 안되니까 2배로 만들고 안에 비우기
        int[][] board = new int[102][102];
        
        for(int[] r : rectangle){
            int x1 = r[0] * 2; int y1 = r[1] * 2; int x2 = r[2] * 2; int y2 = r[3] * 2;
            
            for(int i = x1; i < x2 + 1; i++){
                for(int j = y1; j < y2 + 1; j++){
                    board[i][j] = 2;
                }
            }
        }
        for(int[] r : rectangle){
            int x1 = r[0] * 2; int y1 = r[1] * 2; int x2 = r[2] * 2; int y2 = r[3] * 2;
            
            for(int i = x1 + 1; i < x2; i++){
                for(int j = y1 + 1; j < y2; j++){
                    board[i][j] = 1;
                }
            }
        }
        
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{characterX * 2, characterY * 2, 0});
        boolean[][] v = new boolean[102][102];
        
        int answer = 0;
        int[][] d = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            if(now[0] == itemX * 2 && now[1] == itemY * 2) return now[2] / 2;
            
            for(int i = 0; i < 4; i ++){
                int nx = now[0] + d[i][0];
                int ny = now[1] + d[i][1];
            
                if(nx < 0 || nx > 101 || ny < 0 || ny > 101) continue;
                if(board[nx][ny] == 2 && !v[nx][ny]){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx, ny, now[2] + 1});
                }
            }
            
        }
        return answer;
    }
}