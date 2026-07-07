class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        
        for(int[] p : puddles) dp[p[1]][p[0]] = -1;
        
        for(int i = 1; i < m + 1; i++){
            if(dp[1][i] == -1) break; 
            dp[1][i] = 1;
        }
        
        for(int i = 1; i < n + 1; i++){
            if(dp[i][1] == -1) break; 
            dp[i][1] = 1;
        }
        
        for(int i = 2; i < n + 1; i++){
            for(int j = 2; j < m + 1; j++){
                // 해당 위치가 -1이면 continue; 아니면 이제 위쪽 왼쪽에 값 더하기
                if(dp[i][j] == -1) {dp[i][j] = 0; continue;}
                int left = dp[i][j - 1] > 0 ? dp[i][j - 1] : 0;
                int up = dp[i - 1][j] > 0 ? dp[i - 1][j] : 0;
                
                dp[i][j] = (left + up) %1000000007;
            }
        }
        return dp[n][m];
    }
}