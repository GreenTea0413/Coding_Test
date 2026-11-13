import java.util.*;

class Solution {
    int answer = 0;
    int len;
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        dfs(k, dungeons, new boolean[len], new ArrayList<>());
        return answer;
    }
    
    void dfs(int k, int[][] dungeons, boolean[] v, List<Integer> path){
        if(path.size() == len){
            answer = Math.max(answer, adventure(path, dungeons, k));
            return;
        }
        
        for(int i = 0; i < len; i++){
            if(!v[i]){
                v[i] = true;
                path.add(i);
                
                dfs(k, dungeons, v, path);
                
                path.remove(Integer.valueOf(i));
                v[i] = false;
            }
        }
    }
    
    int adventure(List<Integer> path, int[][] dungeons, int k){
        int count = 0;
        for(int p : path){
            int[] now = dungeons[p];
            if(k >= now[0]) {
                k -= now[1];
                if(k >= 0){
                    count ++;    
                }
                else break;
            }
        }
        
        return count;
    }
}