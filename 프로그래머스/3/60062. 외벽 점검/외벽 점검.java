import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int wLen;
    public int solution(int n, int[] weak, int[] dist) {
        wLen = weak.length;
        int[] weak2 = new int[n * 2];
        for(int i = 0; i < wLen; i++){
            weak2[i] = weak[i];
            weak2[i + wLen] = weak[i] + n;
        }
        
        // 사람이 들어가는 순서를 다 고려해야함
        dfs(n, weak2, dist, new ArrayList<>(), new boolean[dist.length]);
        return answer == Integer.MAX_VALUE ? -1: answer;
    }
    
    public void dfs(int n, int[] weak2, int[] dist, List<Integer> friend, boolean[] v){
        if(dist.length == friend.size()){
            for(int i = 0; i < wLen; i++){
                int count = check(i, weak2, friend);
                if(count != -1) answer= Math.min(answer, count);
            }
            return;
        }
        
        for(int i = 0; i < dist.length; i++){
            if(!v[i]){
                v[i] = true;
                friend.add(dist[i]);
                
                dfs(n, weak2, dist, friend, v);
                
                v[i] = false;
                friend.remove(friend.size() - 1);
            }
        }
    }
    
    public int check(int start, int[] weak2, List<Integer> friend){
        int f = 0;
        int cur = weak2[start] + friend.get(f);
        
        for(int i = start; i < start + wLen; i++){
            if(weak2[i] > cur){
                f++;
                if(f == friend.size()) return -1;
                cur = weak2[i] + friend.get(f);
            }
        }
        
        return f + 1;
    }
}