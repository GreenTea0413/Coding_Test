import java.util.*;

class Solution {
    
    public int solution(int[][] maps) {
        int answer = -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] v = new boolean[n][m];
        v[0][0] = true;
        
        int[][] dir = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0]; int y = now[1]; int d = now[2];
            
            if(x == n - 1 && y == m - 1) return d;
            
            for(int i = 0; i < 4; i++){
                int nx = dir[i][0] + x; int ny = dir[i][1] + y;
                
                if(0 > nx || nx >= n || 0 > ny || ny >= m) continue;
                
                if(!v[nx][ny] && maps[nx][ny] == 1) {
                    q.offer(new int[]{nx,ny,d + 1});
                    v[nx][ny] = true;
                }
            }
        }
        
        return answer;
    }
    
    
}