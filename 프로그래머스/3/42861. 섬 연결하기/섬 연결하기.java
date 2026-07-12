import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){graph.add(new ArrayList<>());}
        
        for(int[] cost : costs){
            graph.get(cost[0]).add(new int[]{cost[1] ,cost[2]});
            graph.get(cost[1]).add(new int[]{cost[0] ,cost[2]});
        }
        Arrays.sort(costs, (a, b) -> (a[2] - b[2]));
        
        // 장소, 길이 값
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[]{0,0});
        
        boolean[] v = new boolean[n];
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            
            if(v[now[0]]) continue;
            v[now[0]] = true;
            answer += now[1];
            
            for(int[] next : graph.get(now[0])){
                if(!v[next[0]]){
                    pq.offer(next);
                }
            }
        }
        return answer;
    }
}