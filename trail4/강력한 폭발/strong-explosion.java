import java.util.*;

public class Main {
    static int[][] d1 = {{0,0}, {1,0}, {2,0}, {-1,0}, {-2,0}};
    static int[][] d2 = {{0,0}, {1,0}, {-1,0}, {0,1}, {0,-1}};
    static int[][] d3 = {{0,0}, {1,1} ,{1,-1}, {-1,1}, {-1,-1}};
    static int[][][] type = {d1,d2,d3};
    static List<int[]> bomb = new ArrayList<>();
    static int answer, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        answer = 0;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1) bomb.add(new int[]{i, j});
            }
        }
        
        dfs(0, new int[bomb.size()]);
        System.out.print(answer);
        return;
    }

    public static void dfs(int depth, int[] selected){
        // 폭탄 사이즈까지 내려왔으면
        if(depth == bomb.size()){
            // 폭탄 범위 구해야함
            boolean[][] v = new boolean[n][n];

            // 폭탄 위치들에 대한 폭탄 타입까지 해서 다음 범위 구하기
            for(int i = 0; i < bomb.size(); i++){
                int x = bomb.get(i)[0];
                int y = bomb.get(i)[1];

                for(int[] d : type[selected[i]]){
                    int nx = x + d[0];
                    int ny = y + d[1];

                    if(0<= nx && nx < n && 0<= ny && ny < n){
                        if(!v[nx][ny]){
                            v[nx][ny] = true;
                        }
                    }
                }
            }

            int count = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(v[i][j]) count++;
                }
            }
            answer = Math.max(count, answer);
            return;
        }

        for(int i = 0; i < 3; i++){
            selected[depth] = i;
            dfs(depth + 1, selected);
        }
    }
}