import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] maps = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    q.offer(new int[]{i,j});
                    maps[i][j] = num;
                }
                else if (num == -1){
                    maps[i][j] = num;
                }
            }
        }

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m){
                    if(maps[nx][ny] == 0){
                        maps[nx][ny] = maps[x][y] + 1;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }

        boolean check = true;
        int answer = 0;

        for(int[] arr : maps){
            for(int a : arr){
                if(a == 0){
                    check = false;
                    break;
                }
                answer = Math.max(answer, a);
            }
        }

        if (!check) {System.out.print(-1);}
        else {
            System.out.print(answer-1);
        }
        
    }
}
