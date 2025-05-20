import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int maxSum = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                visited[i][j] = false;
                checkTShape(i, j);
            }
        }

        System.out.println(maxSum);
    }

    // DFS for 4 blocks except 'ㅗ' shape
    public static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + board[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    // Check T-shaped tetrominos separately
    public static void checkTShape(int x, int y) {
        int wingCount = 0;
        int minWingValue = Integer.MAX_VALUE;
        int sum = board[x][y];

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                wingCount++;
                minWingValue = Math.min(minWingValue, board[nx][ny]);
                sum += board[nx][ny];
            }
        }

        if (wingCount >= 3) {
            // If there are more than 3 wings, we must remove one to form a T
            if (wingCount == 4) {
                sum -= minWingValue;
            }
            maxSum = Math.max(maxSum, sum);
        }
    }
}
