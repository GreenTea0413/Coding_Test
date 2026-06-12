import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        
        int[][] dp = new int[n][m];
        for(int[] p : puddles){dp[p[1] - 1][p[0] - 1] = -1;}
        for(int i = 0; i < m; i++){if(dp[0][i] == -1) break; dp[0][i] = 1;}
        for(int i = 0; i < n; i++){if(dp[i][0] == -1) break; dp[i][0] = 1;}
        
        // 1111
        // 1
        // 1
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(dp[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }
                
                int left = dp[i][j - 1] > 0 ? dp[i][j - 1]: 0;
                int up = dp[i - 1][j] > 0 ? dp[i - 1][j] : 0;
                dp[i][j] = (left + up) % MOD;
            }
        }
        
        return dp[n - 1][m - 1];
    }
}