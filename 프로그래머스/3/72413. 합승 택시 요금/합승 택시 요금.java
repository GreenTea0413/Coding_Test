import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){graph.add(new ArrayList<>());}
        for(int[] f : fares){
            graph.get(f[0]).add(new int[]{f[1], f[2]});
            graph.get(f[1]).add(new int[]{f[0], f[2]});
        }
        
        // 시작은 s
        // 도착은 a, b 둘다 해야하는 상황
        // 시작점 s, a, b에 대한 모든 거리의 최소를 구하기
        int[] sn = dijkstra(s, graph, n);
        int[] an = dijkstra(a, graph, n);
        int[] bn = dijkstra(b, graph, n);
        
        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, sn[i] + an[i] + bn[i]);
        }
        
        return answer;
    }
    
    
    public int[] dijkstra(int start, List<List<int[]>> graph, int n){
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // 점, 거리
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[]{start, 0});
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int l = now[0];
            int d = now[1];
            
            if(dist[l] < d){continue;}
            
            for(int[] next : graph.get(l)){
                int nextDist = next[1] + d;
                if(dist[next[0]] > nextDist){
                    dist[next[0]] = nextDist;
                    pq.offer(new int[]{next[0], nextDist});
                }
            }
        }
        return dist;
    }
}