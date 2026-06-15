import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int len = sources.length;
        int[] answer = new int[len];
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){graph.add(new ArrayList<>());}
        for(int[] r : roads){graph.get(r[0]).add(r[1]); graph.get(r[1]).add(r[0]);}
        
        for(int i = 0; i < len; i++){
            Queue<int[]> q = new LinkedList<>();
            boolean[] v = new boolean[n + 1];
            q.offer(new int[]{sources[i], 0});
            v[sources[i]] = true;
            boolean isCheck = false;
            while(!q.isEmpty()){
                int[] arr = q.poll();
                int node = arr[0];
                int dist = arr[1];
                
                if(node == destination){answer[i] = dist; isCheck = true; break;}
                
                for(int next : graph.get(node)){
                    if(!v[next]){
                        v[next] = true;
                        q.offer(new int[]{next, dist + 1});
                    }
                }
            }
            
            if(!isCheck){answer[i] = -1;}
        }
        return answer;
    }
}