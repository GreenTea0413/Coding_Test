import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] v = new boolean[n][m];
        v[0][0] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            if(now[0] == n - 1 && now[1] == m - 1) return now[2];
            for(int[] d : new int[][]{{0,1}, {1,0}, {0,-1},{-1,0}}){
                int nx = now[0] + d[0]; int ny = now[1] + d[1];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(!v[nx][ny] && maps[nx][ny] == 1){
                    q.offer(new int[]{nx, ny, now[2] + 1});
                    v[nx][ny] = true;
                }
            }
        }
        
        
        return -1;
    }
}