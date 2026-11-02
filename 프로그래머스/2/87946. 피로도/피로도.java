import java.util.*;

class Solution {
    int answer = -1;
    public int solution(int k, int[][] dungeons) {
        int len = dungeons.length;
        dfs(k, 0, len, new boolean[len], dungeons);
        return answer;
    }
    
    void dfs(int k, int depth, int len, boolean[] v, int[][] dungeons){
        answer = Math.max(answer, depth);
        
        for(int i = 0; i < len; i++){
            if(!v[i] && dungeons[i][0] <= k){
                v[i] = true;
                dfs(k - dungeons[i][1], depth + 1, len, v, dungeons);
                v[i] = false;
            }
        }
    }
}