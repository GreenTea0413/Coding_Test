import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        
        boolean[][] v = new boolean[n][m];
        v[0][0] = true;
        
        int[][] d = {{0,1}, {1,0}, {-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0]; int y = now[1]; int dist = now[2];
            if(x == n - 1 && y == m - 1) return dist;
            
            for(int i = 0 ; i < 4 ; i++){
                int nx = x + d[i][0];  int ny = y + d[i][1]; 
                
                if(nx < 0|| nx >= n || ny < 0 ||ny >= m) continue;
                
                if(!v[nx][ny] && maps[nx][ny] == 1) {
                    v[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return -1;
    }
}