import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static List<Integer>[] graph;

    // DFS 함수
    public static void dfs(int node) {
        visit[node] = true;
        sb.append(node + " ");  // 현재 값 넣기

        // 저번에 순열할 때 처럼 재귀로 계속 돌면서 숫자 넣기
        for (int num : graph[node]) {
            if (!visit[num]) {
                dfs(num);
            }
        }
    }

    // BFS 함수
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < visit.length; i++) {
            visit[i] = false;  // 배열의 모든 값을 false로 설정
        }
        queue.add(start);
        visit[start] = true;
        sb.append(start + " ");  // 현재 노드 출력
        //여기서 이제 하나씩 빼면서 방문했으면 내보내는 거에 추가
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int num : graph[node]) {
                if (!visit[num]) {
                    visit[num] = true;
                    queue.add(num);
                    sb.append(num + " ");  // 큐에서 꺼낸 노드에 연결된 노드를 출력
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 노드의 수
        int M = Integer.parseInt(st.nextToken());  // 간선의 수
        int start = Integer.parseInt(st.nextToken());  // 시작 노드

        graph = new ArrayList[N + 1];  // 노드 번호는 1부터 시작하므로 크기는 N + 1
        visit = new boolean[N + 1];  // 방문 여부 배열

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 수 만큼 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);  
        }
        // **인접 리스트 정렬**
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);  // 각 노드에 연결된 인접 노드를 오름차순 정렬
        }
        // DFS 실행
        dfs(start);
        sb.append("\n");

        // BFS 실행
        bfs(start);

        String result = sb.toString().trim();
        // 결과 출력
        bw.write(result);
        bw.flush();
        bw.close();
    }
}
