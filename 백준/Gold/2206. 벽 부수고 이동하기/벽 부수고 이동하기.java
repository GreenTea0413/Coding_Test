import java.io.*;
import java.util.*;

class Node {
    int x, y, dist, wall;

    public Node(int x, int y, int dist, int wall) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.wall = wall; // 0: 벽 안 부숨, 1: 벽 부숨
    }
}

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0)); // 시작 위치
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == N-1 && node.y == M-1) {
                return node.dist; // 목표에 도달한 경우
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][node.wall]) {
                        visited[nx][ny][node.wall] = true;
                        queue.add(new Node(nx, ny, node.dist + 1, node.wall));
                    } else if (map[nx][ny] == 1 && node.wall == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.add(new Node(nx, ny, node.dist + 1, 1));
                    }
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }
}
