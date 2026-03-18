class Solution {
    public long solution(int n) {
        long MOD = 1234567;
        long[] dp = new long[n + 1];
        if(n <= 2) return n;
        
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < n+1; i++){
            dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
        }
        return dp[n];
    }
}