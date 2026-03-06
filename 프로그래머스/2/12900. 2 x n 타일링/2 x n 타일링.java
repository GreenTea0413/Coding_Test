class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        int MOD = 1000000007;
        dp[1] = 1;
        if(n >= 2){
            dp[2] = 2;
            for(int i = 3; i <= n; i++){
                dp[i] = (dp[i-2] + dp[i-1]) % MOD;
            }
        }
        // 3 -> 111 1= =1 3가지
        // 4 -> 1111 == 11= =11 1=1
        return dp[n];
    }
}