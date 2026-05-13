import java.util.*;

class Solution {
    int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
    
    public int solution(int[][] maps) {
        int x = maps.length;
        int y = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[x][y];
        q.offer(new int[]{0,0,1});
        v[0][0] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == x - 1 && now[1] == y - 1){
                return now[2];
            }
            
            for(int i = 0; i < 4; i++){
                int nx = d[i][0] + now[0];
                int ny = d[i][1] + now[1];
                
                if(nx < 0 || nx >= x || ny < 0 || ny >= y){continue;}
                if(maps[nx][ny] == 1 && !v[nx][ny]){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx, ny, now[2] + 1});
                }
            }
        }
        return -1;
    }
}