import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[][] map;  // 지도 배열
    static boolean[][] visited;  // 방문 여부 배열
    static int[] dx = {-1, 1, 0, 0};  // 이거 2개로 2방향
    static int[] dy = {0, 0, -1, 1};  

    // DFS 탐색 함수
    public static int dfs(int x, int y) {
        // 1로 해야지 이제 한칸에 1씩 더해서 넓이 구할 수 있기 때문
        int size = 1;
        visited[x][y] = true;

        // 4방향으로 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배열 밖으로 안나가고 방문 안한거
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                size += dfs(nx, ny);  // 이어지는 1들로 DFS 호출
            }
        }
        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';  // br로 받는건 문자여서 이렇게 처리하는게 더 빠름
            }
        }

        // 단지 크기 저장 리스트
        List<Integer> sizes = new ArrayList<>();

        // 모든 칸을 돌면서, 방문하지 않은 1인 곳을 DFS로 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    // 여기서 이미 1인 애들 넣었는데
                    // 주변에서 다 처리 한 후 다음 1로 가기 때문에 중첩 걱정 ㄴㄴ
                    sizes.add(dfs(i, j));
                }
            }
        }

        // 결과 출력
        sb.append(sizes.size()).append("\n");  // 단지의 개수
        Collections.sort(sizes);  // 단지 크기 오름차순
        for (int size : sizes) {
            sb.append(size).append("\n");  // 각 단지 크기 출력
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
