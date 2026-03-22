class Solution {
    int answer = 0;
    int len;
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        boolean [] v = new boolean[len];
        dfs(v, k, dungeons, 0);
        return answer;
    }
    
    public void dfs(boolean[] v, int k, int[][] dungeons, int count){
        answer = Math.max(count, answer);
        
        for(int i = 0; i < len; i++){
            if(!v[i] && k >= dungeons[i][0] ){
                v[i] = true;
                dfs(v, k - dungeons[i][1], dungeons, count + 1);
                v[i] = false;
            }
        }
    }
}