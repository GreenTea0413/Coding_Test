import java.io.*;
import java.util.*;

public class Main {
    static int f;
    static int s;
    static int g;
    static int u;
    static int d;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new int[f + 1];
        Arrays.fill(visited,-1);


        bfs();
    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = 0;

        while (!queue.isEmpty()){
            int cur = queue.poll();

            if (cur == g) {
                System.out.print(visited[g]);
                return;
            }
            if (cur + u <= f && visited[cur + u] == -1){
                visited[cur + u] = visited[cur] + 1;
                queue.offer(cur + u);
            }
            if (cur - d >= 1 && visited[cur - d] == -1){
                visited[cur - d] = visited[cur] + 1;
                queue.offer(cur - d);
            }
        }
        System.out.print("use the stairs");
    }
}
