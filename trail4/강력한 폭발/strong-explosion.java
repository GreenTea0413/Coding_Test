import java.util.*;

public class Main {
    static int[][] d1 = {{0,0},{1,0},{2,0},{-1,0},{-2,0}}; // 세로
    static int[][] d2 = {{0,0},{1,0},{-1,0},{0,1},{0,-1}}; // 십자
    static int[][] d3 = {{0,0},{1,1},{-1,-1},{-1,1},{1,-1}}; // 대각
    static int[][][] types = {d1, d2, d3};
    
    static List<int[]> bombs = new ArrayList<>();
    static int n, answer = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] grid = new int[n][n];
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1) bombs.add(new int[]{i, j});
            }
        
        dfs(0, new int[bombs.size()]);
        System.out.print(answer);
    }
    
    static void dfs(int idx, int[] selected) {
        if(idx == bombs.size()){
            // 선택된 폭탄 타입으로 초토화 면적 계산
            boolean[][] boom = new boolean[n][n];
            for(int i = 0; i < bombs.size(); i++){
                int x = bombs.get(i)[0];
                int y = bombs.get(i)[1];
                for(int[] d : types[selected[i]]){
                    int nx = x + d[0], ny = y + d[1];
                    if(0 <= nx && nx < n && 0 <= ny && ny < n){
                        boom[nx][ny] = true;
                    }
                }
            }
            int count = 0;
            for(boolean[] row : boom)
                for(boolean b : row)
                    if(b) count++;
            answer = Math.max(answer, count);
            return;
        }
        
        for(int t = 0; t < 3; t++){
            selected[idx] = t;
            dfs(idx + 1, selected);
        }
    }
}