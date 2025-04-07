import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] visit;
    static List<Integer>[] graph;
    static int answer = 0;
    // DFS 함수
    public static void dfs(int node) {
        visit[node] = true;

        // 저번에 순열할 때 처럼 재귀로 계속 돌면서 숫자 넣기
        for (int num : graph[node]) {
            if (!visit[num]) {
                answer += 1;
                dfs(num);
            }
        }
    }

    public static void main(String args[]) throws IOException{
        int C = Integer.parseInt(br.readLine()); // 컴터
        int L = Integer.parseInt(br.readLine()); // 선
        graph = new ArrayList[C + 1];  // 노드 번호는 1부터 시작하므로 크기는 N + 1
        visit = new boolean[C + 1];  // 방문 여부 배열

        // 그래프 초기화
        for (int i = 1; i <= C ; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 수 만큼 입력
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);  
        }

        dfs(1);

        System.out.print(answer);
    }
}
