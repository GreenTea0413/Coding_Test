import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i ++){graph.add(new ArrayList<>());}
        
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(i != j && computers[i][j] == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        // 0 -> 1
        // 1 -> 0
        // 2
        boolean[] v = new boolean[n + 1];
        for(int i = 0; i < n; i++){
            if(!v[i]){
                answer ++;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                v[i] = true;
                while(!q.isEmpty()){
                    int now = q.poll();
                    for(int next : graph.get(now)){
                        if(!v[next]){
                            q.offer(next);
                            v[next] = true;
                        }
                    }
                }
            }
        }
        
        
        return answer;
    }
}