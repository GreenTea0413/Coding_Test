import java.util.*;

class Solution {
    int answer = 0;
    int len = 0;
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        // 최소 피로도 내림차순
        // 최소 피로도가 같으면 소모 피로다가 작은 순서대로
        Arrays.sort(dungeons, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        // 시작을 0,1,2으로 선택 후 시작
        for(int i = 0; i < len; i++){
            if(k >= dungeons[i][0]){
                boolean[] v = new boolean[len];
                v[i] = true;
                dfs(v, k - dungeons[i][1], dungeons, 1);    
            }
        }
        
        return answer;
    }
    
    public void dfs(boolean[] v, int k, int[][] dungeons, int count){
        answer = Math.max(answer, count);
        
        for(int i = 0; i < len; i++){
            if(!v[i]){
                if(k >= dungeons[i][0]){
                    v[i] = true;
                    dfs(v, k - dungeons[i][1], dungeons, count + 1);
                    v[i] = false;
                }
            }
        }
    }
}