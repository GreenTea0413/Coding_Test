import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static int n;
    static int m;
    static int answer = 1;
    public static void main(String args[]) throws IOException{        
        // 한줄 4 6
        st = new StringTokenizer(br.readLine());    
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 배열 만들고나서
        int[][] arr = new int[n][m];
        for(int i =0; i < n; i ++){
            String line = br.readLine();  // 한 줄을 읽어들임
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';  // 문자 '0'을 빼서 숫자로 변환
            }
        }
        
        bfs(arr);

        System.out.println(answer);
    }

    public static void bfs(int[][] arr){
        boolean[][] visited = new boolean[n][m];

        // 시작 위치를 큐에 추가 (0,0) 시작, 이동 거리 1로 시작
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            answer = current[2];

            // 목표 위치에 도달했다면 거리 반환
            if (x == n - 1 && y == m - 1) {
                break;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵의 범위를 벗어나지 않고, 방문하지 않았으며, 이동할 수 있는 칸이라면
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && arr[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny, answer + 1});
                    }
                }
            }
        }
    
    }
}