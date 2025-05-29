import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[]{0,0,1});
        
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            
            int x = arr[0];
            int y = arr[1];
            int dist = arr[2];
        
            if(x == n - 1 && y == m - 1){
                return dist;
            }
            
            for(int i = 0 ; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(0 <= nx && nx < n && 0 <= ny && ny < m){
                    if(!visited[nx][ny] && maps[nx][ny] == 1){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny,dist + 1});
                    }
                }
            }
        }
        
        return answer;
    }
}