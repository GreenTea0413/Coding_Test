import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int len = 0;
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){graph.add(new ArrayList<>());}
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        boolean[] v = new boolean[n + 1];
        v[1] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1});
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int node = arr[0];
            int dist = arr[1];
            
            // 길이가 len 보다 길면 len = dist로 바꾸고 answer =1;
            // 길이가 len이랑 같으면 answer++;
            
            if(len < dist) {len = dist; answer = 1; }
            else if(len == dist){answer++;}
            for(int next : graph.get(node)){
                if(!v[next]){
                    v[next] = true;
                    q.offer(new int[]{next, dist + 1});
                }
            }
        }
        
        
        return answer;
    }
}