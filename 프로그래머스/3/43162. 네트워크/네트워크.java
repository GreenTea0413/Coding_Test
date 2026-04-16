import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int yLen = computers[0].length;
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){ graph.add(new ArrayList<>());}
        for(int i = 0; i < n; i++){
            for(int j = 0; j < yLen; j++){
                if(computers[i][j] == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[n + 1];
        for(int i = 0; i < n; i++){
            if(!v[i]){
                v[i] = true;
                answer++;
                q.offer(i);
                while(!q.isEmpty()){
                    int start = q.poll();
                    v[start] = true;
                    for(int next : graph.get(start)){
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

