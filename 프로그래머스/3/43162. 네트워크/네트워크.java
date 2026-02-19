class Solution {
    static int answer = 0;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if (!visited[i]){
                dfs(i, computers, n);
                answer++;
            }
        }
        return answer;
    }
    
    static void dfs(int num, int[][] computers, int n){
        visited[num] = true;
        
        for (int i = 0; i < n; i++){
            if(visited[i] == false && i != num && computers[num][i] == 1){
                visited[i] = true;
                dfs(i, computers, n);
            }
        }
    }
}