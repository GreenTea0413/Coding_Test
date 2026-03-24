import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int col = maps.length;
        int row = maps[0].length;
        
        int[][] d = new int[][]{{0, 1}, {0, -1}, {1,0}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[col][row];
        q.offer(new int[]{0,0,1});
        v[0][0] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == col - 1 && now[1] == row - 1) {
                return now[2];
            }
            
            for(int i = 0 ; i < 4; i++){
                int nx = now[0] + d[i][0];
                int ny = now[1] + d[i][1];
                
                if(0 <= nx && nx < col && 0 <= ny && ny < row && !v[nx][ny] && maps[nx][ny] == 1){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx,ny,now[2] + 1});
                }
            }
        }
        return -1;
    }
}