import java.util.*;

public class Main {
    static char[][] map = new char[5][5];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        // 0부터 24까지 인덱스에서 7개 선택
        combination(new ArrayList<>(), 0, 0);
        System.out.println(result);
    }

    // 25칸 중 7개 조합
    public static void combination(List<Integer> list, int start, int depth) {
        if (depth == 7) {
            if (isConnected(list) && countS(list) >= 4) {
                result++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            list.add(i);
            combination(list, i + 1, depth + 1);
            list.remove(list.size() - 1);
        }
    }

    // S가 몇 명인지 세기
    public static int countS(List<Integer> list) {
        int count = 0;
        for (int idx : list) {
            int x = idx / 5;
            int y = idx % 5;
            if (map[x][y] == 'S') count++;
        }
        return count;
    }

    // 연결되어 있는지 확인 (BFS)
    public static boolean isConnected(List<Integer> list) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        boolean[] selected = new boolean[25];
        for (int idx : list) selected[idx] = true;

        int start = list.get(0);
        int x = start / 5;
        int y = start % 5;
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int connectedCount = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int idx = nx * 5 + ny;

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                    if (!visited[nx][ny] && selected[idx]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        connectedCount++;
                    }
                }
            }
        }

        return connectedCount == 7;
    }
}