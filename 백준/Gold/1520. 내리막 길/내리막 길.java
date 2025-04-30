import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[M][N];
        dp = new int[M][N];
        
        // Read map data
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // Initialize dp array with -1
            }
        }
        
        // Compute number of paths using DFS and memoization
        int countPaths = dfs(0, 0);
        
        System.out.println(countPaths);
    }
    
    public static int dfs(int x, int y) {
        // Base case: if we reach the bottom-right corner
        if (x == M - 1 && y == N - 1) {
            return 1;
        }
        
        // If already computed, return the stored value
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        
        dp[x][y] = 0; // Initialize this cell's path count
        
        // Explore all four possible directions
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // Check boundaries and if the next cell is lower
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] < map[x][y]) {
                dp[x][y] += dfs(nx, ny);
            }
        }
        
        return dp[x][y];
    }
}
