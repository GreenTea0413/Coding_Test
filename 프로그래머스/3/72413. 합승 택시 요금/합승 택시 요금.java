import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int [][] costs = new int[n + 1][n+1];
        for(int[] f : fares){
            costs[f[0]][f[1]] = f[2];
            costs[f[1]][f[0]] = f[2];
        }
        
        int[][] dist = new int[3][n+1];
        for(int [] d : dist){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        int[] start = {s,a,b};
        
        for(int i = 0; i < 3; i++){
            int[] d = dist[i];
            pq.add(new int[]{start[i], 0});
            d[start[i]] = 0;
            
            while(!pq.isEmpty()){
                int[] cur = pq.remove();
                
                for(int j = 1; j <= n; j++){
                    if(costs[cur[0]][j] == 0 ) continue;
                    if(d[j] > cur[1] + costs[cur[0]][j]){
                        d[j] = cur[1] + costs[cur[0]][j];
                        pq.add(new int[]{j, cur[1] + costs[cur[0]][j]});
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int[] d : dist){
                sum += d[i];
            }
            min = Math.min(min, sum);
        }
        
        return min; 
    }
}