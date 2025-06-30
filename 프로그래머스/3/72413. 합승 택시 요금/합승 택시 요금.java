import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int[][] costs = new int[n+1][n+1];
        
        for(int[] f : fares){
            costs[f[0]][f[1]] = f[2];
            costs[f[1]][f[0]] = f[2];
        }
        
        int[][] dist = new int[3][n+1];
        for(int[] d : dist){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        final int[] start = {s, a, b};
        
        for(int j = 0; j < 3; j++){
            int[] d = dist[j];
            pq.add(new int[]{start[j],0});
            d[start[j]] = 0;
            
            while(!pq.isEmpty()){
                int[] cur = pq.remove();
                
                for(int i = 1; i <=n; i++){
                    if(costs[cur[0]][i] == 0) continue;
                    if(d[i] > cur[1] + costs[cur[0]][i]){
                        d[i] = cur[1] + costs[cur[0]][i];
                        pq.add(new int[]{i, cur[1] + costs[cur[0]][i]});
                    }
                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i ++){
            int sum = 0;
            for(int[] d : dist){
                sum+= d[i];
            }
            minCost = Math.min(minCost, sum);
        }
        
        return minCost;
    }
}