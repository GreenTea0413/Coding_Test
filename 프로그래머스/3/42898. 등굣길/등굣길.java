class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        
        int[][] dp = new int[n+1][m+1];
        
        for (int[] p : puddles) {
            dp[p[1]][p[0]] = -1; 
        }
        
        dp[1][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) { 
                    dp[i][j] = 0;
                    continue;
                }
                
                if (i == 1 && j == 1) continue;
                
                int up = (i > 1) ? dp[i-1][j] : 0;
                int left = (j > 1) ? dp[i][j-1] : 0;
                
                dp[i][j] = (up + left) % MOD;
            }
        }
        
        return dp[n][m];
    }
}