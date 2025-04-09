import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();  // 수를 입력받은 후 남은 줄바꿈 문자 제거

        // 미로 입력받기
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        // BFS로 최단 경로 찾기
        System.out.println(bfs(maze, n, m));
    }

    private static int bfs(int[][] maze, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        // 방문 배열도 준비
        boolean[][] visited = new boolean[n][m];
        // 네 가지 방향 정의 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 시작 위치를 큐에 추가 (0,0) 시작, 이동 거리 1로 시작
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            // 목표 위치에 도달했다면 거리 반환
            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵의 범위를 벗어나지 않고, 방문하지 않았으며, 이동할 수 있는 칸이라면
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && maze[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny, dist + 1});
                    }
                }
            }
        }

        // 경로를 찾을 수 없는 경우는 입력 조건에서 제외되어 있으므로, 항상 유효한 경로가 존재
        return -1;
    }
}
