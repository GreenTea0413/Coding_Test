class Solution {
    public int solution(int n) {
        if(n % 2 == 1) return 0;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 3;
        
        int MOD = 1000000007;
        for(int i = 4; i <= n; i++){
            dp[i] = (dp[i - 2] * 4 - dp[i - 4]) % MOD;
            
            if(dp[i] < 0) dp[i] += MOD;
        }
        
        return (int) dp[n];
    }
}