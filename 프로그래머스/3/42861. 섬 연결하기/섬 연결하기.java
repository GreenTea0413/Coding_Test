import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){graph.add(new ArrayList<>());}
        for(int[] c : costs){
            graph.get(c[0]).add(new int[]{c[1], c[2]});
            graph.get(c[1]).add(new int[]{c[0], c[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        pq.offer(new int[]{0, 0});
        boolean[] v = new boolean[n];
        int answer = 0;
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