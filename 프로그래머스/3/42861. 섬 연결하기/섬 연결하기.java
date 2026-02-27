import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        for (int[] cost : costs){
            graph.get(cost[0]).add(new int[]{cost[1],cost[2]});
            graph.get(cost[1]).add(new int[]{cost[0],cost[2]});
        }
        boolean[] v = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
           return a[1] - b[1];
        });
        pq.offer(new int[]{0,0});
        
        int answer = 0;
        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int node = now[0];
            int dist = now[1];
            
            if(v[node]) continue;
            
            v[node] = true;
            answer += dist;
            
            for(int[] next : graph.get(node)){ 
                if (!v[next[0]]){
                    pq.offer(next);
                }
            }
        }
        return answer;
    }
}