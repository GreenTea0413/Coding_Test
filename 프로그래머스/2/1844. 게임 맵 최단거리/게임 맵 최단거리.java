import java.util.*;

class Solution {
    static int N, M;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean [][] visited;

    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        visited= new boolean[N][M];
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            
            if(arr[0] == N - 1 && arr[1] == M - 1) return arr[2];                             
            for(int i = 0; i < 4; i++){
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                
                if(0 <= nx && nx < N && 0<=ny && ny <M){
                    if(!visited[nx][ny] && maps[nx][ny] == 1){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny,arr[2] + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}