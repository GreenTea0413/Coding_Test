import java.util.*;

class Solution {
    List<List<int[]>> graph = new ArrayList<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for(int[] fare : fares){
            graph.get(fare[0]).add(new int[]{fare[1], fare[2]});
            graph.get(fare[1]).add(new int[]{fare[0], fare[2]});
        }
        
        // s에서 다른 한점을 가고 그 한점에서 각각 a와 b로 가야함
        int[] sn = dfs(s, n);
        int[] an = dfs(a, n);
        int[] bn = dfs(b, n);
        
        for(int i = 1; i <= n; i++){
            answer = Math.min(sn[i] + an[i] + bn[i], answer);
        }
        return answer;
    }
    
    int[] dfs(int start, int n){
        int[] arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[]{start, 0});
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            
            if(now[1] > arr[now[0]]) continue;
            
            for(int[] next : graph.get(now[0])){
                int nextCost = now[1] + next[1];
                if(arr[next[0]] > nextCost){
                    arr[next[0]] = nextCost;
                    pq.offer(new int[]{next[0], nextCost});
                }
            }
        }
        
        return arr;
    }
}