import java.io.*;
import java.util.*;

public class Main {
    static int V; //정점
    static int N; // 간선

    static int[][] graph;
    static long [] distance; 
    // 시작 정점부터 각 정점까지 최단 거리구하는거 
    //그래서 처음에 엄청 큰 수 넣어서 작은 값들이랑 비교해서 들어가게끔 하기 위해!
    static final int INF = 2000000000;
    static boolean bellmanFord(int start){
        Arrays.fill(distance, INF); // 숫자 큰거 넣어서 일부로 작은 값 비교하기 쉽게
        // 그러면 이제 
        distance[start] = 0; // 차피 1에서 시작하도록 고정했으니까 1은 거리 0
        //총 V - 1번 반복: 최단 거리 확정 위해
        for(int i = 0; i < V - 1; i++){
            for(int j = 0; j < N; j++){
                //  1 2 4
                //  1 3 3
                //  2 3 -1
                //  3 1 -2
                // 이거 간선에 있는거 첫 출발 지점으로 부터의 값이 INF가 아니면
                if(distance[graph[j][0]] != INF){
                    // 도착지까지 최단 거리를 구해주기
                    // 지금 각 도착 위치에 대한 길이를 구해서 더해주는 건데
                    // 제일 처음 j가 0 일때 
                    // [INF, 0, INF, INF] 현재 이 상태임
                    // 그래서 1출발 -> 2도착
                    // 최소 가는 비용 구해서 넣어주기 INF, 0 + 4가 되어서 2까지의 최소 비용이 4가 되어버림
                    distance[graph[j][1]] = Math.min(distance[graph[j][1]], distance[graph[j][0]] + graph[j][2]);  
                }
            }
        }
        // 음수 사이클 존재 여부를 확인
        boolean isCycle = false;
        for(int j = 0; j < N; j++){
            // 여전히 갱신할 수 있는 경우, 음수 사이클이 존재함을 의미
            if(distance[graph[j][0]] != INF && distance[graph[j][1]] > distance[graph[j][0]] + graph[j][2]){
                isCycle = true;
                break;
            }
        }
        return isCycle;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][3]; //이제 간선 갯수만큼 만들어줌
        distance = new long[V + 1]; 
        // 왜 정점 +1 했냐면 시작점을 1로 했기 때문에 계산하기 편하려고 
        //  1 2 4
        //  1 3 3
        //  2 3 -1
        //  3 1 -2
        // 그래프에 이 값들 다 넣어야함 ( 출발 도착 거리비용 )
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken()); // 출발
            graph[i][1] = Integer.parseInt(st.nextToken()); // 도착
            graph[i][2] = Integer.parseInt(st.nextToken()); // 거리비용
        }

        // 음수 사이클 존재 시 -1 출력
        if(bellmanFord(1)){ 
            sb.append(-1);
        } else {
            // 각 정점에 대한 최단 거리 값을 출력
            for(int i = 2; i <= V; i++){
                long result = distance[i] == INF ? -1 : distance[i];
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb); 
    }
}
