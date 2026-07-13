import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){graph.add(new ArrayList<>());}
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // 1부터 돌면서 다음 지점까지의 거리를 기록해놓고 젤 높은 숫자에 해당하는 값들의 수
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        
        // arr들까지의 거리를 나타내는 배열
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        arr[1] = 0;
        
        // 1부터 시작 하니까 거리0 으로 하고 하나씩 값 넣어주기
        while(!q.isEmpty()){
            int[] now = q.poll();
            int w = now[0];
            int d = now[1];
            
            for(int next : graph.get(w)){
                if(arr[next] == -1){
                    arr[next] = d + 1;
                    q.offer(new int[]{next, d + 1});
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(max, arr[i]);
        }

        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(arr[i] == max) answer++;
        }
        return answer;
    }
}