import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && computers[i][j] == 1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        
        boolean[] v = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!v[i]){
                answer++;
                v[i] = true;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);

                while(!q.isEmpty()){
                    int now = q.poll();
                    v[now] = true;

                    for(int next : graph[now]){
                        if(!v[next]){q.offer(next);}
                    }
                }
            }
        }
        return answer;
    }
}