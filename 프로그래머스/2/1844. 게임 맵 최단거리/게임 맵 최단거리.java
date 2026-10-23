import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int xLen = maps.length;
        int yLen = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        int[][] d = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        boolean[][] v = new boolean[xLen][yLen];
        v[0][0] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();    
            
            if(now[0] == xLen - 1 && now[1] == yLen - 1) return now[2];
            
            for(int i = 0; i < 4; i++){
                int nx = now[0] + d[i][0]; int ny = now[1] + d[i][1];
                
                if(0 > nx || nx >= xLen || 0 > ny || ny >= yLen) continue;
                
                if(!v[nx][ny] && maps[nx][ny] == 1){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx, ny, now[2] + 1});
                }
            }
        }
        
        return -1;
    }
}