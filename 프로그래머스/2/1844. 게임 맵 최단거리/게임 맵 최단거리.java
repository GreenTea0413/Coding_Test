import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Queue<int []> queue= new LinkedList<>();
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            
            if(arr[0] == n - 1 && arr[1] == m - 1){
                answer = arr[2];
                return answer;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                
                if(0<=nx && nx<n && 0<=ny && ny < m ){
                    if(!visited[nx][ny] && maps[nx][ny] == 1){
                        queue.add(new int[]{nx, ny, arr[2] + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        return answer;
    }
}