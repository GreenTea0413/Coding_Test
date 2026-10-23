import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        // 번호, 거리
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[]{1, 0});
        
        int max = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            max = Math.max(max, now[1]);
            
            if(dist[now[0]] > now[1]) continue;
            
            for(int next : graph.get(now[0])){
                int nextDist = now[1] + 1;
                
                if(dist[next] > nextDist){
                    dist[next] = nextDist;
                    pq.offer(new int[]{next, nextDist});
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++) if(dist[i] == max) answer++;
        
        return answer;
    }
}