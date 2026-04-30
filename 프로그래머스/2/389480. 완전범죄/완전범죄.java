import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 1_000_000;
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for (int[] item : info) {
            int a = item[0];
            int b = item[1];
            
            int[] next = new int[m];
            Arrays.fill(next, INF);
            
            for (int i = 0; i < m; i++) {
                if (dp[i] == INF) continue;
                if (dp[i] + a < n) {
                    next[i] = Math.min(next[i], dp[i] + a);
                }
                
                if (i + b < m) {
                    next[i + b] = Math.min(next[i + b], dp[i]);
                }
            }
            dp = next;
        }
        
        int answer = INF;
        for (int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[i]);
        }
        
        return answer == INF ? -1 : answer;
    }
}