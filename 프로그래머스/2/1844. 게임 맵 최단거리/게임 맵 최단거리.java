import java.util.*;
class Solution {
    int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        boolean[][] v = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});
        v[0][0] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0], y = now[1], count = now[2];
            
            if(x == n-1 && y == m-1) return count;
            
            for(int i = 0; i < 4; i++){
                int nx = x + d[i][0], ny = y + d[i][1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(maps[nx][ny] == 1 && !v[nx][ny]){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx, ny, count + 1});
                }
            }
        }
        return -1;
    }
}