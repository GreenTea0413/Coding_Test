import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int x_len = maps.length;
        int y_len = maps[0].length;
        
        boolean[][] v = new boolean[x_len][y_len];
        int[][] d = {{0,-1}, {0,1}, {1,0}, {-1,0}};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        v[0][0] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if (now[0] == x_len - 1 && now[1] == y_len - 1){
                return now[2];
            }
            
            for(int i = 0; i < 4; i++){
                int nx = now[0] + d[i][0];
                int ny = now[1] + d[i][1];
                
                if(0 <= nx && nx < x_len && 0 <= ny && ny < y_len){
                    if(maps[nx][ny] != 0 && !v[nx][ny]){
                        q.offer(new int[]{nx, ny, now[2] + 1});
                        v[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}