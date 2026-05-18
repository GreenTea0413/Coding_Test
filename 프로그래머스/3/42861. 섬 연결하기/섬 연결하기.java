import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        List<List<int[]>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){graph.add(new ArrayList<>());}
        for(int[] cost : costs){
            int start = cost[0], end = cost[1], num = cost[2];
            graph.get(start).add(new int[]{end, num});
            graph.get(end).add(new int[]{start, num});
        }
        
        // 끝점이랑 거리
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        pq.offer(new int[]{0,0});
        
        boolean[] v = new boolean[n];
        int answer = 0;
        
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int node = arr[0];
            int dist = arr[1];
            
            if(v[node]) continue;
            v[node] = true;
            answer += dist;
            
            for(int[] next : graph.get(node)){
                if(!v[next[0]]){
                    pq.offer(next);
                }
            }
        }
        
        
        return answer;
    }
}