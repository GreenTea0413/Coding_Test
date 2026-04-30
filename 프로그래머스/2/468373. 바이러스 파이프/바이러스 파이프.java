import java.util.*;

class Solution {
    List<Integer> setList = new ArrayList<>();
    List<int[]> list = new ArrayList<>();
    public int solution(int n, int infection, int[][] edges, int k) {
        // 1 = A 2 = B, 3 = C
        // 그래프 만들면서 파이프 종류 구하기
        List<List<int[]>> graph = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i <= n; i++){ graph.add(new ArrayList<>());}
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];
            set.add(c);
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }
        setList = new ArrayList<>(set);
        
        for(int i = 1; i <= k; i++){
        // set으로 파이프 열수 있는 순열 구하기
            permute(0, i, new ArrayList<>());
        }
        
        int answer = 0; 
    
        // 순열 모아놓은걸로 하나씩 까보는거임  
        for(int[] l : list){
            // 총 감염
            List<Integer> virus = new ArrayList<>();
            virus.add(infection);
            
            for(int i = 0; i < l.length; i++){
                Queue<Integer> q = new LinkedList<>();
                boolean[] v = new boolean[n + 1];
                for(int vi : virus){
                    q.offer(vi);
                    v[vi] = true;
                }
                // l[i]를 가지고 있는 곳만 통과해서 옮길 수 있음
                while(!q.isEmpty()){
                    int now = q.poll();
                    
                    for(int[] next : graph.get(now)){
                        // 열린 파이프와 같은지 그리고 방문 안했는지
                        if(next[1] == l[i] && !v[next[0]]){
                            q.offer(next[0]);
                            v[next[0]] = true;
                            
                            if(!virus.contains(next[0])){
                                virus.add(next[0]);
                            }
                        }
                    }
                }
            }
            answer = Math.max(virus.size(), answer);
        }
        
        return answer;
    }

    public void permute(int depth, int k, List<Integer> cur){
        if(depth == k){
            list.add(cur.stream().mapToInt(i -> i).toArray());
            return;
        }
        
        for(int i = 0; i < setList.size(); i++){
            cur.add(setList.get(i));
            permute(depth + 1, k, cur);
            cur.remove(cur.size() - 1);
            
        }
    }
}