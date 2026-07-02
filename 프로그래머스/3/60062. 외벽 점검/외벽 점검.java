import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int wLen;
    public int solution(int n, int[] weak, int[] dist) {
        wLen = weak.length;
        int[] weak2 = new int[wLen * 2];
        
        for(int i = 0; i < wLen * 2; i++){
            weak2[i] = weak[i % wLen] + n * (i / wLen);
        }
        
        dfs(dist, weak2, new ArrayList<>(), new boolean[dist.length]);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public void dfs(int[] dist, int[] weak2, List<Integer> per, boolean[] v){
        if(dist.length == per.size()){
            for(int i = 0; i < wLen; i++){
                int count = check(i, per, weak2);
                
                if(count != -1){answer = Math.min(answer, count);}
            }
            return;
        }
        
        for(int i = 0; i < dist.length; i++){
            if(!v[i]){
                v[i] = true;
                per.add(dist[i]);
                
                dfs(dist, weak2, per, v);
                v[i] = false;
                per.remove(per.size() - 1);
            }
        }
    }
    
    public int check(int start, List<Integer> per, int[] weak2){
        int friend = 0;
        int loc = weak2[start] + per.get(friend);
        
        for(int i = start; i < start + wLen; i++){
            if (weak2[i] > loc) {
                friend++;
                if (friend == per.size()) {
                    return -1;
                }
                loc = weak2[i] + per.get(friend);
            }
        }
        return friend + 1;
    }
}