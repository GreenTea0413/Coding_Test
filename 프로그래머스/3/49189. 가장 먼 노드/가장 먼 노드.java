import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int max_dist = 0;
        int count = 0;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[] v = new boolean[n + 1];
        v[1] = true;
        q.offer(new int[]{1,0});
        
        while (!q.isEmpty()){
            int[] now = q.poll();
            
            if (now[1] > max_dist){
                max_dist = now[1];
                count = 1;
            }
            else if (now[1] == max_dist){
                count += 1;
            }
            
            for(int next : graph.get(now[0])){
                if(!v[next]){
                    v[next] = true;
                    q.offer(new int[]{next, now[1] + 1});
                }
            }
        }
        return count;
    }
}