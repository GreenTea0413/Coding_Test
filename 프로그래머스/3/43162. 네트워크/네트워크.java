import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){graph.add(new ArrayList<>());}
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && computers[i][j] == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                } 
            }
        }
        
        boolean[] v = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            if(!v[i]){
                answer++;
                q.offer(i);
                while(!q.isEmpty()){
                    int now = q.poll();
                    v[now] = true;
                    
                    for(int next : graph.get(now)){
                        if(!v[next]){
                            v[next] = true;
                            q.offer(next);
                        }
                    }
                }
            }
        }
        return answer;
    }
}