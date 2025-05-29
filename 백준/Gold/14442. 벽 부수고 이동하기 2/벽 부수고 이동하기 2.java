import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N, M, K;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] maps = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            String s = br.readLine();
            for(int j = 1; j <= M; j++){
                maps[i][j] = s.charAt(j - 1) - '0';
            }
        }
        
        boolean[][][]v = new boolean[N+1][M+1][K+1];
        Queue<int[]> q = new LinkedList<>();

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        v[1][1][K] = true;
        q.add(new int[]{1,1,1,K});

        while(!q.isEmpty()){
            int[] arr = q.poll();

            int x = arr[0];
            int y = arr[1];
            int d = arr[2];
            int k = arr[3];

            if(x == N && y == M) {
                System.out.println(d); 
                return;
            }
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
        
                if(1 <= nx && nx <= N && 1 <= ny && ny <= M) {
                    // 벽이 있고 부술 기회가 남아있을 때
                    if(maps[nx][ny] == 1 && k > 0 && !v[nx][ny][k - 1]) {
                        v[nx][ny][k - 1] = true;
                        q.add(new int[]{nx, ny, d + 1, k - 1});
                    }
                    // 벽이 아닐 때
                    else if(maps[nx][ny] == 0 && !v[nx][ny][k]) {
                        v[nx][ny][k] = true;
                        q.add(new int[]{nx, ny, d + 1, k});
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
