import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int len = sources.length;
        int[] answer = new int[len];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){graph.add(new ArrayList<>());}
        for(int[] r : roads){
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        
        for(int i = 0; i < len; i++){
            int s = sources[i];
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{s, 0});
            int[] v = new int[n + 1];
            Arrays.fill(v, -1);
            v[s] = 0;
            
            while(!q.isEmpty()){
                int[] now = q.poll();
                int w = now[0];
                int d = now[1];
                if(v[destination] != -1) break;
                
                for(int next : graph.get(w)){
                    if(v[next] == -1){
                        v[next] = d + 1;
                        q.offer(new int[]{next, d + 1});
                    }
                }
            }
            answer[i] = v[destination];
        }
        return answer;
    }
}