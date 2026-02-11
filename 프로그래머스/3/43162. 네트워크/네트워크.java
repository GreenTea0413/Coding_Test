class Solution {
    boolean [] v;
    int len;
    public void dfs(int start, int[][] com){
        for(int i = 0; i < len; i++){
            if (v[i] == false && com[start][i] == 1){
                v[i] = true;
                dfs(i, com);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        len = n;
        v = new boolean[n];

        for (int i = 0; i < n; i++){
            if(v[i] == false){
                answer += 1;
                v[i] = true;
                dfs(i, computers);
            }
        }
        return answer;
    }
}