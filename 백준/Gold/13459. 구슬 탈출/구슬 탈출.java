import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] grid;
    static int[] dx = {0, 0, 1, -1}; // 오른쪽, 왼쪽, 아래, 위
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new char[N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            grid[i] = line.toCharArray();
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[N][M][N][M];
        q.offer(new int[]{rx, ry, bx, by, 0});
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int crx = cur[0], cry = cur[1];
            int cbx = cur[2], cby = cur[3];
            int cnt = cur[4];

            if (cnt >= 10) return 0;

            for (int dir = 0; dir < 4; dir++) {
                int[] nextR = move(crx, cry, dir);
                int[] nextB = move(cbx, cby, dir);

                // 파란 구슬이 구멍에 빠지면 실패 → skip
                if (grid[nextB[0]][nextB[1]] == 'O') continue;
                // 빨간 구슬이 구멍에 빠지고 파란 구슬은 빠지지 않았으면 성공
                if (grid[nextR[0]][nextR[1]] == 'O') return 1;

                // 두 구슬이 같은 위치라면 조정
                if (nextR[0] == nextB[0] && nextR[1] == nextB[1]) {
                    int redDist = Math.abs(nextR[0] - crx) + Math.abs(nextR[1] - cry);
                    int blueDist = Math.abs(nextB[0] - cbx) + Math.abs(nextB[1] - cby);
                    if (redDist > blueDist) {
                        nextR[0] -= dx[dir];
                        nextR[1] -= dy[dir];
                    } else {
                        nextB[0] -= dx[dir];
                        nextB[1] -= dy[dir];
                    }
                }

                if (!visited[nextR[0]][nextR[1]][nextB[0]][nextB[1]]) {
                    visited[nextR[0]][nextR[1]][nextB[0]][nextB[1]] = true;
                    q.offer(new int[]{nextR[0], nextR[1], nextB[0], nextB[1], cnt + 1});
                }
            }
        }

        return 0;
    }

    static int[] move(int x, int y, int dir) {
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (grid[x][y] == '#') {
                x -= dx[dir];
                y -= dy[dir];
                break;
            }
            if (grid[x][y] == 'O') break;
        }
        return new int[]{x, y};
    }
}
