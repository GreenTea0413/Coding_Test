import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] color;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());

        while (test-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v + 1];
            color = new int[v + 1];

            for (int i = 1; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            boolean check = true;

            for (int i = 1; i <= v; i++) {
                if (color[i] == 0) {
                    if (!dfsWithStack(i)) {
                        check = false;
                        break;
                    }
                }
            }

            sb.append(check ? "YES\n" : "NO\n");
        }

        System.out.print(sb);
    }

    // 재귀 DFS를 스택으로 치환
    static boolean dfsWithStack(int start) {
        Stack<Integer> stack = new Stack<>();
        color[start] = 1;
        stack.push(start);

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            for (int next : graph[cur]) {
                if (color[next] == 0) {
                    color[next] = -color[cur];
                    stack.push(next);
                } else if (color[next] == color[cur]) {
                    return false;
                }
            }
        }
        return true;
    }
}