import java.util.*;

class Solution {
    int answer = 0;
    int[][] d;
    int l;
    public int solution(int k, int[][] dungeons) {
        d = dungeons;
        l = dungeons.length;
        int[] path = new int[l];
        Arrays.fill(path, -1);
        // 이걸로 던전 백트래킹으로 경로 어떻게 갈지 다 대비해보기
        dfs(new boolean[l], path, 0, k);
        
        return answer;
    }
    
    void dfs(boolean[] v, int[] path, int depth, int k){
        if(depth == l){
            int n = count(k, path);
            if(n != 0) answer = Math.max(answer, n);
            return;
        }
        
        for(int i = 0; i < l; i++){
            if(!v[i]){
                v[i] = true;
                path[depth] = i;
                
                dfs(v, path, depth + 1, k);
                
                v[i] = false;
                path[depth] = -1;
            }
        }
    }
    
    public int count(int k, int[] path){
        int num = 0;
        
        for(int i = 0; i < l; i++){
            int idx = path[i];
            if(k < d[idx][0]) break;
            else{
                k -= d[idx][1];
                num++;
            }
        }
        return num;
    }
}