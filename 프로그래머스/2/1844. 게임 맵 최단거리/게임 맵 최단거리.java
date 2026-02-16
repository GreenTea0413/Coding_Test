import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int x_len = maps.length;
        int y_len = maps[0].length;
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        boolean [][] v = new boolean[x_len][y_len];       
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{0,0,1});
        v[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];
            if (cx == x_len-1 && cy == y_len-1){
                return dist;
            }
            
            for(int i = 0; i < 4; i ++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(0<= nx && nx < x_len && 0 <= ny && ny < y_len && !v[nx][ny] && maps[nx][ny] == 1){
                    q.offer(new int[]{nx,ny,dist+1});
                    v[nx][ny] = true;
                }
            }
        }
        return answer;
    }
}