import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        boolean[] v = new boolean[n];
        
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int[] c : costs){
            graph.get(c[0]).add(new int[]{c[1], c[2] });
            graph.get(c[1]).add(new int[]{c[0], c[2] });
        }
        PriorityQueue<int[]> pq= new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[]{0,0});
        
        int count = 0;
        int answer = 0;
        
        while(!pq.isEmpty() && count < n){
            int[] now = pq.poll();
            
            if(v[now[0]]) continue;
            
            count++;
            answer += now[1];
            v[now[0]] = true;
            
            for(int[] next : graph.get(now[0])){
                if(!v[next[0]]) pq.offer(new int[]{next[0], next[1]});
            }
            
        }
        return answer;
    }
}