import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int[] dx ={0,0,-1,1};
        int[] dy = {1,-1,0,0};
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[n][m];
        q.add(new int[] {0,0,1});
        v[0][0] = true;
        
        while(!q.isEmpty()){
            int[] arr= q.poll();
            if(arr[0] == n- 1 && arr[1] == m-1){
                return arr[2];
            }
            
            for(int i =0; i < 4; i++){
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                
                if(0<= nx && nx < n && 0<=ny && ny < m){
                    if(!v[nx][ny] && maps[nx][ny] == 1){
                        v[nx][ny] = true;
                        q.add(new int[]{nx,ny,arr[2] + 1});
                    }
                }
            }
        }
        return answer;
    }
}