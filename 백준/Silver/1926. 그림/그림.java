import java.io.*;
import java.util.*;

public class Main {
    static int [][] arr;
    static boolean [][] v;
    static int [] dx = new int[] {0,0,1,-1};
    static int [] dy = new int[] {1,-1,0,0};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        v = new boolean[n][m];
        // 배열 완성해주기
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int count = 0;
        int answer = 0;

        for(int x = 0; x < n; x++){
            for(int y = 0; y < m; y++){
                if (arr[x][y] == 1 && v[x][y] == false) {
                    count += 1;
                    answer = Math.max(bfs(x,y), answer);
                }
            }
        }

        System.out.println(count);
        System.out.println(answer);
    }

    static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});

        int sq = 1;
        v[x][y] = true;

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();

            for(int i = 0; i <4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m){
                    if(v[nx][ny] == false && arr[nx][ny] == 1){
                        sq += 1;
                        v[nx][ny] = true;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        return sq;
    }
}
