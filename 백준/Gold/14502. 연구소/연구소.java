import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static List<int[]> viruses = new ArrayList<>();
    private static List<int[]> emptySpaces = new ArrayList<>();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int maxSafeArea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    emptySpaces.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }

        combineAndSimulate(0, 0, new int[3][2]);
        System.out.println(maxSafeArea);
    }

    private static void combineAndSimulate(int start, int depth, int[][] walls) {
        if (depth == 3) {
            simulateVirusSpread(walls);
            return;
        }

        for (int i = start; i < emptySpaces.size(); i++) {
            walls[depth] = emptySpaces.get(i);
            combineAndSimulate(i + 1, depth + 1, walls);
        }
    }

    private static void simulateVirusSpread(int[][] walls) {
        int[][] tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, tempMap[i], 0, M);
        }

        for (int[] wall : walls) {
            tempMap[wall[0]][wall[1]] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int[] virus : viruses) {
            queue.offer(new int[]{virus[0], virus[1]});
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && tempMap[nx][ny] == 0) {
                    tempMap[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        countSafeArea(tempMap);
    }

    private static void countSafeArea(int[][] tempMap) {
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }
}
