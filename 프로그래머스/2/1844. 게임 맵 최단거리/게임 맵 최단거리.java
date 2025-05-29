import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int n = maps.length;
        int m = maps[0].length;
        
        Queue <int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[n][m];
        
        q.add(new int[]{0,0,1});
        v[0][0] = true;
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            
            int x = arr[0];
            int y = arr[1];
            int d = arr[2];
            
            if(x == n - 1 && y == m - 1) return d;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(0 <= nx && nx < n&& 0<=ny && ny < m){
                    if(!v[nx][ny] && maps[nx][ny] == 1){
                        v[nx][ny]= true;
                        q.add(new int[]{nx,ny,d+1});
                    }
                }
            }
        }
        
        return answer;
    }
}