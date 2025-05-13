
import java.io.*;
import java.util.*;

public class Main {
    static int n = 0, d = 0, c = 0, a = 0, b = 0, s = 0;
    static int INF = 1000000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        // 2
        int test_case = Integer.parseInt(st.nextToken());
        
        // n 컴퓨터 개수, d 의존성 개수, c 해킹당한 컴퓨터 번호
        // a 컴퓨터 -> b 의존 / b 감염되면 s 초 후에 a도 감염 
        // h_n은 해킹당한 컴터 개수, h_s 는 총 감염시간
        // 해킹당한 컴퓨터까지 포함하여 총 몇 대의 컴퓨터가 감염되며 
        for(int i = 0; i < test_case; i++){
            // 3 2 2 
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            // 이건 거리 배열
            // 현재 해캉당한 컴퓨터 번호 c
            // 얘는 정점 만큼만 있으면 됨 대신 1부터 시작하려고 하니까 1 ~ n
            int [] dist = new int[n + 1];
            Arrays.fill(dist,INF);
            dist[c] = 0;

            // 우선순위 큐 만들어 주기
            PriorityQueue<int []> pq  = new PriorityQueue<>((a,b) -> a[1] - b[1]);
            pq.add(new int[]{c, 0});

            // 그래프도 각 정점마다 있어야하니까 n + 1
            List<int[]>[] graph = new ArrayList[n + 1];
            for (int k = 1; k <= n; k++) {
                graph[k] = new ArrayList<>();
            }

            // 해킹 당하는 컴퓨터 수랑 해킹 당하는 총 시간
            int h_n = 0;
            int h_s = 0;

            for(int j = 0; j < d; j++){
                // 2 1 5
                // 3 2 5
                st= new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                // 그래프를 만들어 줍니다~
                graph[b].add(new int[]{a,s});
            }

            while(!pq.isEmpty()){
                int[]cur = pq.poll();
                int now = cur[0];
                int cost = cur[1];

                if (dist[now] < cost) continue; // 이미 더 짧은 거리로 방문했으면 건너뜀

                // 자 이제 꺼냈으니 해당 위치에서 그래프가 이어져 있는 곳을 찾기
                if(graph[now] != null){
                    for(int[] next : graph[now]){
                        int nextNode = next[0];
                        int nextCost = next[1];
                        // 조건 맞으면 너 감염~ 
                        // dist[nextNode]에 대한 비용이 cost + nextCost 보다 크면
                        // 최신화 원래 같으면  1 -> 3 갈 때 8로 업뎃 시켜줬는데
                        // 디음인 2 -> 3 가는게 1 -> 2 -> 3 그래서 2 + 4 비교해서 작은 값
                        // 비교 후 최신화 되면?
                        
                        // 우선순위 큐에 넣어서 또 감염시키기
                        if(dist[nextNode] > cost + nextCost){
                            dist[nextNode] = cost + nextCost;
                            pq.add(new int[]{nextNode, cost + nextCost});
                        }
                    }
                }
            }
            // 여기서 이미 다 돌고 dist 다 최신화 시켰다면?
            // 차피 모든 간선을 통해 정ㅈ엄을 다 지났기 때문에 거기 안에서 최대 비용
            for(int l = 0; l < n + 1; l++){
                if(dist[l] != INF) {
                    h_n += 1;
                    h_s = Math.max(h_s,dist[l]);
                }
            }
            if(i == test_case - 1){
                sb.append(h_n).append(" ").append(h_s);
            }   
            else{
                sb.append(h_n).append(" ").append(h_s).append('\n');
            }
        }
        System.out.println(sb);
    }
}
